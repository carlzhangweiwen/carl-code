package net;

import java.security.MessageDigest;

import org.junit.Test;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class MapTest {
	@Test
	public void test1() throws Exception{
		//HttpRequest.sendGet("", "");
		String str="test";
		MessageDigest md5=MessageDigest.getInstance("MD5");
        //加密后的字符串
        String encode = Base64.encode(md5.digest(str.getBytes("utf-8")));
        System.out.println(encode);
        
        String res = HttpRequest.sendGet("http://api.map.baidu.com/place/v2/search", "q=饭店&region=北京&output=json&ak=9RSQ0d93dDUSGGLIDstOzs9f");
        System.out.println(res);
	}

}
