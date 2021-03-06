package com.zhangmeng.common.utils;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;


/** 
 * @author 作者:zhangmeng
 * @version 创建时间：2019年7月8日 上午10:13:56 
 * 类功能说明 
 */
public class FileUtil {

	public static Logger log=Logger.getLogger(FileUtil.class);
	
	/**
	 * 获取文件扩展名
	 * 
	 * @param fileName
	 * @return
	 */
	public  static String getSuffix(String fileName){
		int dotIndex=fileName.lastIndexOf('.');
		if (dotIndex<0) {
			return "";
					
		}
		//最后一位
		if (dotIndex>=fileName.length()) {
			return "";
		}
		return fileName.substring(dotIndex+1);
		
	}
	
	
	/**
	 * 如果是目录，则下面的文件和所有子目录Hon过的文件都要删除
	 * 使用递归，涉及内容，判断目录的存在性，判断是否为目录或文件，删除
	 * @param fileName
	 * 
	 */
	public static void delFilePath(String fileName){
	 
		File file = new File(fileName);
		//文件不存在则直接返回
		if (!file.exists()) {
			return;
			
		}
		//如果是文件，则删除后返回
		if (file.isFile()) {
			log.info("删除文件"+fileName);
			file.delete();
			return;
		}
		//如果是目录
		if (file.isDirectory()) {
			//列出目录下所有的子目录和文件
			String[] list = file.list();
			//针对每一项
			for (String subPath : list) {
				//调用删除功能
				delFilePath(fileName+"/"+subPath);
			}
			log.info("-------删除文件夹"+fileName);
			file.delete();
			
		}
	}
	
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getSystemProp(String key) {
		
		String propValue = System.getProperty(key);
		return propValue;
		
	}
	
	/**
	 * 返回文件以指定单位大小表示
	 */
	public long  getSize(String fileName,FileUnit fileUnit) {
		File file = new File(fileName);
		
		
		long  size = file.length();
		switch (fileUnit) {
			case B:
				return size;
			case KB:
				return size/1024;
			case MB:
				return size/1024/1024;
			case GB:
				return size/1024/1024/1024;
			case TB:
				return size/1024/1024/1024/1024;
			case PB:
				return size/1024/1024/1024/1024/1024;
			default:
				return 0;
		}
		
	}
	
	
	
	
}
