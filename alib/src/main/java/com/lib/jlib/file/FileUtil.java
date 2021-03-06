package com.lib.jlib.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import com.lib.jlib.marks.MARKS;

public class FileUtil {
	
	/**
	 * 获取默认路径
	 * @return
	 */
	public static String getDefaultPath() {
		return new File("").getAbsolutePath();
	}
	
	/**
	 * 获取classpath
	 * @return
	 */
	public static String getSystemPath() {
		return ClassLoader.getSystemResource("").getFile();
	}
	
	/**
	 * 通过类名获取路径
	 * @param clazz
	 * @return
	 */
	public static String getPackagePath(Class<?> clazz) {
		try {
			String dir = clazz.getPackage().getName().replaceAll(MARKS.POINT.getValue(), MARKS.SLASH.getValue());
			ClassLoader loader = clazz.getClassLoader();
			Enumeration<URL> urls = loader.getResources(dir);
			if (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				return url.getFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getSystemPath();
	}

}
