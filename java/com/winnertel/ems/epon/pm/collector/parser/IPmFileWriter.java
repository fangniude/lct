package com.winnertel.ems.epon.pm.collector.parser;

import com.winnertel.ems.epon.pm.collector.mo.IPmDataHeader;

import java.util.List;

public interface IPmFileWriter
{
  public void wirte(IPmDataHeader header, List datalist);
}
