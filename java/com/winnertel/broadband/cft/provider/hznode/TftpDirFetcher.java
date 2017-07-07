/*
* Copyright (c) 2002-2005 UTStarcom, Inc.
* All rights reserved.
*
* Created on 2005-3-18
*/
package com.winnertel.broadband.cft.provider.hznode;

import com.winnertel.broadband.cft.mounter.FetchDirFailedException;
import com.winnertel.broadband.cft.mounter.FetcherContext;
import com.winnertel.broadband.cft.mounter.IDirFetcher;
import com.winnertel.broadband.cft.util.OSFileSystem;
import com.winnertel.broadband.tftp.protocol.TFTPClient;

import java.util.MissingResourceException;

public class TftpDirFetcher implements IDirFetcher {

    private TFTPClient client;

    public TftpDirFetcher() {
        try {
            client = new TFTPClient(TFTPClient.FOR_TFTP);
            client.setSocketTimeout(2000);
        } catch (MissingResourceException e) {
            e.printStackTrace(System.err);
        }
    }

    public String fetchDir(FetcherContext context) throws FetchDirFailedException {
        return fetch(context.getMountContext().getMoIp(), context.getDir(), context.getPort());
    }

    private String fetch(String hostName, String dir, int port) throws FetchDirFailedException {
        String localDir = OSFileSystem.newTempDir(hostName, port);
        int result = client.getFile(hostName, TFTPClient.OCTET_MODE, dir, localDir, port);
    if (result != 0) {
            OSFileSystem.deleteFile(localDir);
            throw new FetchDirFailedException("Failed to fetch dir:" + dir + ", ErrorCode:" + result);
        }
        return localDir;
    }
}
