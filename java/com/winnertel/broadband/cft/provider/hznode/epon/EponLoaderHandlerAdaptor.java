package com.winnertel.broadband.cft.provider.hznode.epon;

import com.winnertel.broadband.cft.loader.NodeLoader;
import com.winnertel.broadband.cft.provider.hznode.HZNodeLoader;
import com.winnertel.broadband.cft.config.Configuration;
import com.winnertel.broadband.cft.loader.ILoadHandler;
import com.winnertel.broadband.cft.loader.INodeLoader;
import com.winnertel.broadband.cft.loader.LoadContext;

/**
 * Created by Li Pengpeng.
 * User: barton
 * Date: 2013-02-22
 */
public class EponLoaderHandlerAdaptor implements ILoadHandler {

    private INodeLoader loader;

    public EponLoaderHandlerAdaptor() {
        this.loader = new NodeLoader();
    }

    /* (non-Javadoc)
     * @see ILoadHandler#upload2Proxy(LoadContext)
     */
    public int upload2Proxy(LoadContext context) throws Exception {
        changeRoute(context);
        return loader.upload(context);
    }

    /* (non-Javadoc)
     * @see ILoadHandler#downloadFromProxy(LoadContext)
     */
    public int downloadFromProxy(LoadContext context) throws Exception {
        changeRoute(context);
        return loader.download(context);
    }

    private void changeRoute(LoadContext context) {
        context.setProperty(Configuration.ROUTE, Configuration.ROUTE_LOCAL);
    }
}
