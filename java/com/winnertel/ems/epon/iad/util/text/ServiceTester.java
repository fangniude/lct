/*
 * Created on 2004-8-4
 *
 */
package com.winnertel.ems.epon.iad.util.text;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ServiceTester {

	/**
	 *  
	 */
	public ServiceTester() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Map  search(String pattern,String fileNamePattern){
		Map m = FileService.search(
				"D:\\eclipse31\\workspace\\onu200A\\ccsrc",
				pattern,fileNamePattern);
		/*Iterator i = v.iterator();
		while (i.hasNext()) {
			System.out.println("      "+i.next());
		}*/
		return m;
    }
	public static void main(String[] args) {
		 TreeMap allmatch = new TreeMap();
		 allmatch.putAll( search("getString\\(\\s*\"([ _\\.!,:\\w]+)\"",".*\\.java"));
		 String [] filerset = new String[]{
		 		"Z:\\nms_bbs\\src\\com\\utstar\\gepon\\preconfigtool\\resource\\StringMap_en_US.xml"
		 };
        //Map  matchset = FileService.filter(filerset, allmatch, "<String\\s*key\\s*\\=\\s*\"([ \\.,!:\\w]+)\"");

		 Iterator i = allmatch.keySet().iterator();
			while (i.hasNext()) {
				String key =(String) i.next();
				System.out.println("    <String key=\""+key+"\" value=\""+key+"\" />");
			}
     	System.out.println("over");
		 /*System.out.println(".getString(\"\")");
		 TreeMap allmatch = new TreeMap();
		 allmatch.putAll( search("\\.getString\\(\\s*\"([ !\\w]+)\"\\s*\\)",".*\\.java"));
         System.out.println("label = \" \"");
		 allmatch.putAll(search( "label\\s*=\\s*\"([ \\w]+)\"",".*\\.xml"));
		 System.out.println("<Panel name=\"\"");
		 allmatch.putAll(search("<Panel\\s*name\\s*=\\s*\"([ \\w]+)\"" ,".*\\.xml"));
		 System.out.println("<TabbedPane id=\"\"");
		 allmatch.putAll(search("<TabbedPane\\s*id\\s*=\\s*\"([ \\w]+)\"",".*\\.xml"));
		 System.out.println("display =\"\"");
		 allmatch.putAll(search("display\\s*=\\s*\"([ \\w]+)\"",".*\\.xml"));
		 String [] filerset = new String[]{
		 		"Z:\\BBNetMan_SRCnew\\JavaSrc\\com\\utstar\\em\\broadband\\adsl_1u\\r2_0\\r0\\resource\\StringMap_en_US.xml",
				"Z:\\BBNetMan_SRCnew\\JavaSrc\\com\\utstar\\em\\broadband\\common\\res\\CommonStringMap_en_US.xml"
		 };
        Map  matchset = FileService.filter(filerset, allmatch, "<String\\s*key\\s*\\=\\s*\"([ \\w]+)\"");

		Iterator i = allmatch.keySet().iterator();
		while (i.hasNext()) {
			String key =(String) i.next();
			//System.out.println("    <String key=\""+key+"\" value=\""+key+"\" />");
			System.out.println("    <String key=\""+key+"\" value=\"\" />");
			
			//System.out.println(allmatch.get(key));
		}
		System.out.println("over");*/
	}
}