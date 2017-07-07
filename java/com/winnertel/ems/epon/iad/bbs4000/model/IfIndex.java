package com.winnertel.ems.epon.iad.bbs4000.model;

public class IfIndex implements Comparable{
  String ifIndex = null;
  public IfIndex(String ifIndex)
  {
    this.ifIndex = ifIndex;
  }

  public String getIfIndex()
  {
    return ifIndex;
  }

  public int compareTo(Object o) {
    //
    if(!(o instanceof IfIndex))
    {
      return -1;
    }

    String ifIndex2 = ((IfIndex)o).ifIndex;

    if(ifIndex == null && ifIndex2 == null)
    {
      return 0;
    }
    else if(ifIndex == null) //null less than everything.
    {
      return -1;
    }
    else if(ifIndex2 == null)
    {
      return 1;
    }

    String[] split1 = ifIndex.split("/");
    String[] split2 = ((IfIndex)o).ifIndex.split("/");

    int count = split1.length > split2.length ? split1.length : split2.length;

    for(int i = 0; i < count; i++)
    {
      if(i >= split1.length || i >= split2.length)
      {
        return split1.length > split2.length ? 1 : -1;
      }

      if(Integer.parseInt(split1[i]) > Integer.parseInt(split2[i]))
      {
        return 1;
      }
      else if(Integer.parseInt(split1[i]) < Integer.parseInt(split2[i]))
      {
        return -1;
      }
    }

    return 0;
  }

  public String toString()
  {
    return ifIndex;
  }
}
