package carlspringtest;


import java.security.InvalidKeyException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;


public class TokenGTest {
	
	@Test
	public void test1() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);// 选择DES算法,密钥长度必须为56位
		SecretKey key = keyGenerator.generateKey();
		
		
		Cipher c = Cipher.getInstance("DES");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = c.doFinal("carlzhang".getBytes("utf-8"));
		System.out.println(new String(result));
		String encode = Base64.encodeBase64String(result);
		System.out.println(encode);
		System.out.println(new String(Base64.decodeBase64(encode)));
	}
	
	@Test
	public void test2() {
		try {
			//DES 8bit
			DESKeySpec keySpec = new DESKeySpec("testddds".getBytes());
			
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(keySpec);
			
			Cipher c = Cipher.getInstance("DES");
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = c.doFinal("carl".getBytes());
			System.out.println(new String(result));
			
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] r2 = c.doFinal(result);
			System.out.println(new String(r2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		try {
			//DESede 24bit
			DESedeKeySpec keySpec = new DESedeKeySpec("cde5ghightadsdccdeddDDss".getBytes());
			
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			SecretKey key = keyFactory.generateSecret(keySpec);
			
			Cipher c = Cipher.getInstance("DESede");
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = c.doFinal("carl".getBytes());
			System.out.println(new String(result));//��'�~W^
			
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] r2 = c.doFinal(result);
			System.out.println(new String(r2));//carl
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getToken() throws Exception{
		String token = "";
		String secret = "cde5ghightadsdccdeddDDss";
		//DESede 24bit
		DESedeKeySpec keySpec = new DESedeKeySpec(secret.getBytes());
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyFactory.generateSecret(keySpec);
		
		Cipher c = Cipher.getInstance("DESede");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = c.doFinal("carl".getBytes());
		System.out.println(new String(result));//��'�~W^
		
		System.out.println(token);
	}

}
