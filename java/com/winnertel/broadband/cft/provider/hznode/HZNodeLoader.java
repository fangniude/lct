/*
* Copyright (c) 2002-2004 UTStarcom, Inc.
* All rights reserved.
*
* Created on 2004-11-3
*/
package com.winnertel.broadband.cft.provider.hznode;

import com.winnertel.broadband.cft.client.ServiceAccessor;
import com.winnertel.broadband.cft.config.Configuration;
import com.winnertel.broadband.cft.loader.INodeLoader;
import com.winnertel.broadband.cft.loader.LoadContext;
import com.winnertel.broadband.cft.loader.LoaderFactory;
import com.winnertel.broadband.cft.loader.NodeLoader;
import com.winnertel.broadband.cft.server.ILoadService;
import com.winnertel.broadband.cft.util.NetUtil;
import com.winnertel.broadband.cft.util.ThreadUtil;
import com.winnertel.broadband.cft.workers.impl.Process;
import com.winnertel.broadband.cft.workers.impl.ProgressSimulator;
import com.winnertel.broadband.tftp.protocol.ITFTPProgressNotify;
import com.winnertel.inms.topoui.UTopoUIContext;

import java.rmi.RemoteException;


public class HZNodeLoader implements INodeLoader {

    protected NodeLoader loader;

    private ITFTPProgressNotify callBack;

    public HZNodeLoader() {
        loader = new NodeLoader();
    }

    /* (non-Javadoc)
     * @see com.winnertel.broadband.cft.loader.INodeLoader#injectProcessCallBack(com.winnertel.broadband.tftp.protocol.ITFTPProgressNotify)
     */
    public void injectProcessCallBack(ITFTPProgressNotify callBack) {
        //UTSrd61384: Compliant to SRS. For HZ Node, user cannot interrupt one file transfer.
        //loader.injectProcessCallBack(callBack);
        this.callBack = callBack;
    }

    public int upload(LoadContext context) {
        ILoadService loadService = null;
        String fileInProxy = null;
        int result = -1;
        ProgressSimulator ps = new ProgressSimulator((Process) callBack, getLoadID());
        ps.start();
        try {
            loadService = ServiceAccessor.getLoadService();
            fileInProxy = loadService.createProxyFile(context.getSrcPath());
            LoadContext newContext = new LoadContext(context.getMo(), context.getIp(), context.getSrcPath(), fileInProxy, context.getPort(), context.getProps());

            result = loadService.upload2Proxy(getLoadHandlerClassName(context), newContext);
            if (result == 0) {
                ThreadUtil.waitForAWhile(100);
                newContext = new LoadContext(context.getMo(), NetUtil.getTFTPProxyHost(), fileInProxy, context.getDestPath(), context.getPort());
                //Fix Bug: UTSrd52997 and UTSrd52805.
                newContext.setProperty(Configuration.ROUTE, Configuration.ROUTE_LOCAL);
                result = loader.upload(newContext);
            }
        } catch (Exception e) {
            result = -1;
            e.printStackTrace();
        } finally {
            ps.cancel();
            if (fileInProxy != null) {
                try {
                    ThreadUtil.waitForAWhile(100);
                    loadService.deleteProxyFile(fileInProxy);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }

    public int download(LoadContext context) {
        ILoadService loadService = null;
        String fileInProxy = null;
        int result = -1;
        ProgressSimulator ps = new ProgressSimulator((Process) callBack, getLoadID());
        ps.start();
        try {
            loadService = ServiceAccessor.getLoadService();
            fileInProxy = loadService.createProxyFile(context.getSrcPath());
            LoadContext newContext = new LoadContext(context.getMo(), NetUtil.getTFTPProxyHost(), context.getSrcPath(), fileInProxy, context.getPort());
            //Fix Bug: UTSrd52997 and UTSrd52805.
            newContext.setProperty(Configuration.ROUTE, Configuration.ROUTE_LOCAL);
            result = loader.download(newContext);
            if (result == 0) {
                ThreadUtil.waitForAWhile(100);
                newContext = new LoadContext(context.getMo(), context.getIp(), fileInProxy, context.getDestPath(), context.getPort(), context.getProps());
                result = loadService.downloadFromProxy(getLoadHandlerClassName(context), newContext);
            }
        } catch (Exception e) {
            result = -1;
            e.printStackTrace();
        } finally {
            ps.cancel();
            if (fileInProxy != null) {
                try {
                    ThreadUtil.waitForAWhile(100);
                    loadService.deleteProxyFile(fileInProxy);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }

    private String getLoadHandlerClassName(LoadContext context) {
        return LoaderFactory.getLoadHandlerClassName(context.getMo().getObjType());
    }

    private String getLoadID() {
        return UTopoUIContext.getInstance().getClientIP() + "||" +
                System.currentTimeMillis();
    }
}
