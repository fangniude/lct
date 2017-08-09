package com.winnertel.lct.batch.protocol;

import java.util.Arrays;

public class XmlMapper {

    public static void main(String[] args) {
        testOltBase();
//        testOnuBase();
//        testOnuProfile();
    }

    private static void testOnuProfile() {
        ProfileOnu onu = new ProfileOnu("id", "upMaxBw", "downMaxBw", "upCommitedBw", "downCommitedBw", "upFixBw", "upBurstSize", "downBurstSize", "upPriority", "address", "mask", "gateway", "cvlan", "svlan", "priority");
        ProfileOnu onu1 = new ProfileOnu("id1", "upMaxBw1", "downMaxBw1", "upCommitedBw1", "downCommitedBw1", "upFixBw1", "upBurstSize1", "downBurstSize1", "upPriority1");
        ProfileOnu onu2 = new ProfileOnu("id2", "upMaxBw2", "downMaxBw2", "upCommitedBw2", "downCommitedBw2", "upFixBw2", "upBurstSize2", "downBurstSize2", "upPriority2");

        ProfileUni uni = new ProfileUni("id", "vlanMode", "vlanTag", "vlanTpid", "policingEnable", "policingCir", "policingCbs", "policingEbs", "dsCir", "dsPir", "dsEnable", "loopDetect");
        ProfileUni uni1 = new ProfileUni("id1", "vlanMode1", "vlanTag1", "vlanTpid1", "policingEnable1", "policingCir1", "policingCbs1", "policingEbs1", "dsCir1", "dsPir1", "dsEnable1", "loopDetect1");
        ProfileUni uni2 = new ProfileUni("id2", "vlanMode2", "vlanTag2", "vlanTpid2", "policingEnable2", "policingCir2", "policingCbs2", "policingEbs2", "dsCir2", "dsPir2", "dsEnable2", "loopDetect2");

        Profile profile = new Profile(Arrays.asList(onu, onu1, onu2), Arrays.asList(uni, uni1, uni2));

        String str = profile.toXml();
        System.out.println(str);
        Profile profile1 = Profile.fromXml(str);
        System.out.println(profile1);
    }

    private static void testOnuBase() {
        OnuMac bind = new OnuMac("id", "mac", "desc");
        OnuMac bind1 = new OnuMac("id1", "mac1", "desc1");
        OnuMac bind2 = new OnuMac("id2", "mac2", "desc2");

        OnuCfg onuCfg = new OnuCfg("id", "upMaxBw", "downMaxBw", "upCommitedBw", "downCommitedBw", "upFixBw", "upBurstSize", "downBurstSize", "upPriority", "address", "mask", "gateway", "cvlan", "svlan", "priority");
        OnuCfg onuCfg1 = new OnuCfg("id1", "upMaxBw1", "downMaxBw1", "upCommitedBw1", "downCommitedBw1", "upFixBw1", "upBurstSize1", "downBurstSize1", "upPriority1");
        OnuCfg onuCfg2 = new OnuCfg("id2", "upMaxBw2", "downMaxBw2", "upCommitedBw2", "downCommitedBw2", "upFixBw2", "upBurstSize2", "downBurstSize2", "upPriority2");

        OnuUni uni = new OnuUni("id", "vlanMode", "vlanTag", "vlanTpid", "policingEnable", "policingCir", "policingCbs", "policingEbs", "dsCir", "dsPir", "dsEnable", "loopDetect");
        OnuUni uni1 = new OnuUni("id1", "vlanMode1", "vlanTag1", "vlanTpid1", "policingEnable1", "policingCir1", "policingCbs1", "policingEbs1", "dsCir1", "dsPir1", "dsEnable1", "loopDetect1");
        OnuUni uni2 = new OnuUni("id2", "vlanMode2", "vlanTag2", "vlanTpid2", "policingEnable2", "policingCir2", "policingCbs2", "policingEbs2", "dsCir2", "dsPir2", "dsEnable2", "loopDetect2");

        OnuBase onu = new OnuBase(Arrays.asList(bind, bind1, bind2), Arrays.asList(onuCfg, onuCfg1, onuCfg2), Arrays.asList(uni, uni1, uni2));
        String str = onu.toXml();
        System.out.println(str);
        OnuBase onuBase = OnuBase.fromXml(str);
        System.out.println(onuBase);
    }

    private static void testOltBase() {
        OltSystem system = new OltSystem("name", "loc", "contact", "mgtVlan", "macAgeing", "macAuth", "vlanTrans", "p2p", "mgIp");

        OltVlan oltVlan = new OltVlan("1", "name", "mem", "tag");
        OltVlan oltVlan1 = new OltVlan("2", "name1", "mem1", "tag1");
        OltVlan oltVlan2 = new OltVlan("3", "name2", "mem2", "tag2");

        OltQinQ qinq = new OltQinQ("id", "index", "startVlan", "endVlan", "etherType", "newVlan");
        OltQinQ qinq1 = new OltQinQ("id1", "index1", "startVlan1", "endVlan1", "etherType1", "newVlan1");
        OltQinQ qinq2 = new OltQinQ("id2", "index2", "startVlan2", "endVlan2", "etherType2", "newVlan2");

        OltBase olt = new OltBase(system, Arrays.asList(oltVlan, oltVlan1, oltVlan2), Arrays.asList(qinq, qinq1, qinq2));
        String str = olt.toXml();
        System.out.println(str);
        OltBase oltBase = OltBase.fromXml(str);
        System.out.println(oltBase);
    }
}
