/*
 * Created on 2004-8-4
 */
package com.winnertel.ems.epon.iad.util.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author hz03530
 *  
 */
public class FileService {

	public FileService() {
		super();
	}
	public static boolean saveTextAsFile(String text,String filename){
		FileWriter writer;
		try {
			writer = new FileWriter(filename);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		try {
			writer.write(text);
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/*
	 *  directory  a full directory name;
	 * filename  a short filename
	 * */
	public static boolean saveTextAsFile(String text,String directory,String filename){
		File td = new File(directory);
		if (!td.mkdir()) {
		 System.out.println("create directory fail!");	
		}
		return saveTextAsFile(text,directory+"\\"+filename);
	}
	public  static String getFileString(String fileName) {
		StringBuffer fileString = new StringBuffer(8*1024);
		String line = "";
		FileReader isr = null;
		java.io.BufferedReader br;
		try {
			isr = new FileReader(fileName);/*(ClassLoader.getSystemResource(fileName)).getFile()*/
			br = new BufferedReader(isr);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}

		do {
			try {
				line = (String) br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			};
			if (line!=null)
				fileString.append(line+"\n");
		} while (line != null);
		try {
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return fileString.toString();
	}
	/**
	 * <String key="SNR Chart" value="SNR(f)ͼ��"/>
	 *  <String\\s*key\\s*\\=\\s*\"([ \\w]+)\"
	 * 
	 * @param xmlResourceName
	 * @param filteTextRet
	 * @return matchset
	 */
	public static Map filter(String[] fileName, Map filterTextSet, String pattern) {
		Map matchset = new HashMap();
		Pattern p = Pattern.compile(pattern, Pattern.DOTALL);
		for (int i = 0; i < fileName.length; i++) {
			String fileString = getFileString(fileName[i]);
			Matcher m = p.matcher(fileString);
			while (m.find()) {
				String match = m.group(1);
				if (filterTextSet.containsKey(match)) {
					filterTextSet.remove(match);
					matchset.put(match,fileName[i]);
				}
			}
		}
		return matchset;
	}

	public static Map search(String pathName, String pattern,String fileNamePattern) {
		FileSearch fs = new FileSearch(pathName);
        List l = fs.search(fileNamePattern);
        
        HashMap result = new HashMap();
        for (Iterator i = l.iterator(); i.hasNext(); ) {
        	String aFile  = ((File) i.next()).getPath();
        	Map  h = searchAFile(aFile,pattern);
        	Iterator ir = h.keySet().iterator();
        	while (ir.hasNext()){
        		String key = (String)ir.next();
        	     if (!result.containsKey(key)){
                    result.put(key,h.get(key));      	     	
        	     };	
        	}
        	
            }
        return result;    
   }
	
	/*
	 * fStringMap.getString("tftp client")
	 * "\\.getString\\(\\s*\"([ \\w]+)\"\\s*\\)"
	 * 
	 * label\\s*=\\s*\"([ \\w]+)\"
	 * <Field name="grEoAIfIndex" label="Interface Index"></Field>
	 * 
	 * <Panel name="PM of Ethernet"
	 * <Panel\\s*name\\s*=\\s*\"([ \\w]+)\"
	 * 
	 * <TabbedPane id="ADSL_DELT_PORT_ID">
	 * <TabbedPane\\s*id\\s*=\\s*\"([ \\w]+)\"
	 * 
	 * <Entry value="1" display="false"/>
	 * display\\s*=\\s*\"([ \\w]+)\"
	 * @see com.utstar.easydvm.service.text.SearchTextSI#Search(java.lang.String, java.lang.String)
	 */	
	public static Map searchAFile(String fileName,String pattern)	
	{
		HashMap result = new HashMap();
		String fileString = getFileString(fileName);
		if (fileString == null)
			return result;
		Pattern p = Pattern.compile(pattern, Pattern.DOTALL);
		Matcher m = p.matcher(fileString);
		while (m.find()) {
			String key = m.group(1);
			if (!result.containsKey(key)){			
				result.put(key,fileName);
			}
		}
		return result;
	}
	public static Map searchAFile(String fileName,String[] patterns)	
	{
		HashMap result = new HashMap();
		Pattern p;
		Matcher m;
		String fileString = getFileString(fileName);
		if (fileString == null)
			return result;
		for (int i = 0; i < patterns.length; i++) {
            p = Pattern.compile(patterns[i], Pattern.DOTALL);
            m = p.matcher(fileString);
            while (m.find()) {
                String key = m.group(1);
                if (!result.containsKey(key)) {
                    result.put(key, fileName);
                }
            }
        }
		return result;
	}
	
	
	

}