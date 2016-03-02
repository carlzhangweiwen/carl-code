package com.carl.carlapp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;


public class TokenG {
	 // 24位密钥
    public static final String  SECRET = "a60e73ec8c752ac89b521777";
	public static String getToken(String appid) throws Exception{
		// Digest
		//Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 11, 11);
		Date now = calendar.getTime();
	
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orgToken = "company=carl;appType=SINGER;appid=" + appid
					+ ";currentTime=" + d1.format(now);
		
		//DESede 24bit
		DESedeKeySpec keySpec = new DESedeKeySpec(SECRET.getBytes());
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyFactory.generateSecret(keySpec);
		
		Cipher c = Cipher.getInstance("DESede");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = c.doFinal(orgToken.getBytes("utf-8"));
		return 	Base64.encodeBase64String(result);
	}
	
	public static void authToken(String token, String appid) throws Exception{
		//DESede 24bit
		DESedeKeySpec keySpec = new DESedeKeySpec(SECRET.getBytes());
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyFactory.generateSecret(keySpec);
		
		Cipher c = Cipher.getInstance("DESede");
		c.init(Cipher.DECRYPT_MODE, key);
		
		String text = new String(c.doFinal(Base64.decodeBase64(token)));//company=carl;appType=SINGER;appid=car;currentTime=2016-01-04 15:24:08
		
		System.out.println(text);
		
		String[] textsVals = text.split(";");
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < textsVals.length; i++) {
			String[] t = textsVals[i].split("=");
			map.put(t[0], t[1]);
		}
		System.out.println(map);
		
		String currTime = map.get("currentTime");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse(currTime);
		
		Date now = new Date();
		if((now.getTime()-date.getTime()) > 7*24*60*60*1000){//检测是否登录时间超过7天
			System.out.println("no, the time is to long...");
		}
		if(!appid.equals(map.get("appid"))){//检测是否相同
			System.out.println("no, the appid cannot matched...");
		}
		System.out.println(now.getTime()-date.getTime());
	}
	
	public static void main(String[] args) throws Exception {
		String token = getToken("car");
		authToken(token,"car");
	}
	

}
