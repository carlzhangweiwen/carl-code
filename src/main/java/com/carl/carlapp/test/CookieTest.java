package com.carl.carlapp.test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;

/** 
 * @author 作者 Carl Zhang. E-mail: carlzhangweiwen@sina.com
 * @version 创建时间：2016年3月2日 下午10:39:52 
 * 类说明 
 */
public class CookieTest {
	 public static void main(String args[]) throws Exception {
//		    String urlString = "http://58.215.195.18:10010/login_person.jsp";
		 	String urlString = "http://58.215.195.18:10010/jcaptcha?date="+ new Date().getTime();		 
		    
		    CookieManager manager = new CookieManager();
		    CookieHandler.setDefault(manager);
		    URL url = new URL(urlString);   
		    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection(); 
		    
		    //将得到的验证码保存下来
		    saveFile(httpConn, "E:\\tset33.jpg");
		    
//		    Object content = httpConn.getContent();
//		    String contentType = httpConn.getContentType();
//		    System.out.println(contentType);//MIME type:text/html
		    
		    //因为http已经做了请求，所以会得到cookie
		    CookieStore cookieJar = manager.getCookieStore();
		    List<HttpCookie> cookies = cookieJar.getCookies();
		    for (HttpCookie cookie : cookies) {
		      System.out.println(cookie);
		    }
		  }
	 public static void saveFile(URLConnection conn,String fullPath){
		 saveFile(conn, fullPath, 8);
	 }
	 /**
	  * 讲文件保存下来
	  * @param conn URLConnection连接
	  * @param fullPath 文件路径及文件名
	  * @param length 每次读文件字节数
	  */
	 public static void saveFile(URLConnection conn, String fullPath, int length){
		    try {
		        if(conn == null){
		            throw new Exception("Can't get URLConnection.");
		        }
		        InputStream is = conn.getInputStream();
		        FileOutputStream fos = new FileOutputStream(fullPath);
		        byte[] b = new byte[length];
		        int len = 0;
		        while((len = is.read(b)) != -1){
		            fos.write(b,0,len); 
		        }
		        fos.flush();
		        fos.close();
		        is.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

}

