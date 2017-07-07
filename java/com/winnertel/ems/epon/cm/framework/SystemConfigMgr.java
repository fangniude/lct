package com.winnertel.ems.epon.cm.framework;

import java.rmi.Remote;

/**
 * <p>
 * SystemConfigMgr is the super remote interface of all system level managers
 * that do not belong to either logical or physical managers. For example,
 * SystemBootGroupMgr, FtpConfGroupMgr and FileSystemGroupMgr are subclasses of
 * SystemConfigMgr. In SystemConfigMgr, we do not define any common operations.
 * All the operations are defined in subclasses. SystemConfigMgr is used by
 * ObjectFactory to create instances of system level managers easily.
 * </p>
 *
 */
public interface SystemConfigMgr extends Remote {}