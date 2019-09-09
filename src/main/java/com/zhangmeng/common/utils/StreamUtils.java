package com.zhangmeng.common.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** 
 * @author ����:zhangmeng
 * @version ����ʱ�䣺2019��7��8�� ����10:13:56 
 * �๦��˵�� 
 */
public class StreamUtils {

	/**
	 * �ر���
	 * @param closeables
	 * @throws IOException 
	 */
	public static void closeStream(Closeable ...closeables) throws IOException {
		for (Closeable closeable : closeables) {
			closeable.close();
		}
		
	}
	
	/**
	 * 
	 * @param is
	 * @param os
	 * @throws IOException 
	 */
	public static void copyStream(InputStream is,OutputStream os) throws IOException {
		
		byte b[] = new byte[1024];
		while(is.read(b)>0) {
			os.write(b);
		}
		//ˢ��
		os.flush();
		
	}
}
