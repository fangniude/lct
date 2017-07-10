package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;
import java.util.Arrays;

public class XmlMapper {

    public static void main(String[] args) {
        OltSystem system = new OltSystem("name", "loc", "contact", "mgtVlan", "macAgeing", "macAuth", "vlanTrans", "p2p", "mgIp");

        OltVlan oltVlan = new OltVlan("id", "name", "mem", "tag");
        OltVlan oltVlan1 = new OltVlan("id1", "name1", "mem1", "tag1");
        OltVlan oltVlan2 = new OltVlan("id2", "name2", "mem2", "tag2");

        OltQinQ qinq = new OltQinQ("id", "index", "startVlan", "endVlan", "etherType", "newVlan");
        OltQinQ qinq1 = new OltQinQ("id1", "index1", "startVlan1", "endVlan1", "etherType1", "newVlan1");
        OltQinQ qinq2 = new OltQinQ("id2", "index2", "startVlan2", "endVlan2", "etherType2", "newVlan2");

        OltBase olt = new OltBase(system, Arrays.asList(oltVlan, oltVlan1, oltVlan2), Arrays.asList(qinq, qinq1, qinq2));
        String str = OltBase.toXml(olt);
        System.out.println(str);
        OltBase oltBase = OltBase.fromXml(str);
        System.out.println(oltBase);
    }
}
