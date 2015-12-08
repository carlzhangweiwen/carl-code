package net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

public class UrlTest {
	static String ENCODING_UTF_8="utf-8";
	public static void main(String[] args) {
		 //发送 GET 请求
//        String s=HttpRequest.sendGet("http://3.wxcarlsvn.sinaapp.com/index.php", "name=carl");
//        System.out.println(s);
       
        
//        String s=HttpRequest.sendGet("http://192.168.1.232/loan/#charge", "name=carl");
//        System.out.println(s);
//        
		
		
		
		
		
        
        //发送 POST 请求
//        String sr=HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
//        System.out.println(sr);
		
		
		
		try { 
			String pathUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxe6d7ae212a4d0cbe&secret=b86028a10fd5505798f047fc7d49b31e"; 
			// 建立连接 
			URL url = new URL(pathUrl); 
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection(); 

			 
			// //设置连接属性 
//			httpConn.setDoOutput(true);// 使用 URL 连接进行输出 
//			httpConn.setDoInput(true);// 使用 URL 连接进行输入 
//			httpConn.setUseCaches(false);// 忽略缓存 
//			httpConn.setRequestMethod("POST");// 设置URL请求方法 
//			String requestString = "客服端要以以流方式发送到服务端的数据..."; 

			 
			// 设置请求属性 
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致 
//			byte[] requestStringBytes = requestString.getBytes(ENCODING_UTF_8); 
//			httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length); 
			httpConn.setRequestProperty("Content-Type", "application/octet-stream"); 
			httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接 
			httpConn.setRequestProperty("Charset", "UTF-8"); 
			
			// 
//			String name = URLEncoder.encode("黄武艺", "utf-8"); 
			
			System.out.println(httpConn.getContentType());
			System.out.println(httpConn.getContentLength());
			
			InputStream inputStream = httpConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(inputStreamReader);
			String result="",line;
			while((line=br.readLine())!=null){
				result += line;
			}		
			System.out.println(result);
			JsonParser jsonParser = new JsonFactory().createJsonParser(result);
			ObjectMapper mapper = new ObjectMapper();
			

			
			} catch (Exception ex) { 
				ex.printStackTrace(); 
			} 
	}

}
