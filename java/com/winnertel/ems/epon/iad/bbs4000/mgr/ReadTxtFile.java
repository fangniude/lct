package com.winnertel.ems.epon.iad.bbs4000.mgr;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxtFile {
	@SuppressWarnings("unchecked")
	public String[] readfile(String filepath) throws Exception {
		FileReader fr = new FileReader(filepath);
		
		int c = 63;
		String errmessage = "Txt file code not GBK,can not parse";
		try {
			c = fr.read();
		} catch (Exception e) {
			try {
				fr.skip(1);
			} catch (Exception ex) {
				throw new Exception(errmessage, ex);
			}
			c = 63;
		}
		StringBuffer sb = new StringBuffer();
		List list = new ArrayList();
		while (c != -1) {
			if (c == 10) {
				list.add(sb.toString());
				sb = new StringBuffer();
				try {
					c = fr.read();
				} catch (Exception e) {
					try {
						fr.skip(1);
					} catch (Exception ex) {
						throw new Exception(errmessage, ex);
					}
					c = 63;
				}
				continue;
			}
			sb.append((char) c);
			try {
				c = fr.read();
			} catch (Exception e) {
				try {
					fr.skip(1);
				} catch (Exception ex) {
					throw new Exception(errmessage, ex);
				}
				c = 63;
			}
		}
		if (c == -1 && sb.length() > 0) {
			list.add(sb.toString());
		}
		fr.close();
		Object[] obj = list.toArray();
		String[] objs = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			objs[i] = (String) obj[i];
		}
		return objs;
	}

	public static void main(String[] args) {
		ReadTxtFile trt = new ReadTxtFile();
		try {
			String[] line = trt.readfile("d:/pm1524.txt");
			for (int i = 0; i < line.length; i++) {
				System.out.print(line[i].toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}