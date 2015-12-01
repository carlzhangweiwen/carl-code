package com.carl.carlapp.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

	/**
	 * 对于RSA产生的公钥、私钥，我们可以有两种方式可以对信息进行加密解密。私钥加密-公钥解密 和 公钥加密-私钥解密
	 * 
	 * RSA公钥加密算法是1977年由罗纳德·李维斯特（Ron Rivest）、阿迪·萨莫尔（Adi Shamir）和伦纳德·阿德曼（Leonard Adleman）一起提出的。当时他们三人都在麻省理工学院工作。RSA就是他们三人姓氏开头字母拼在一起组成的。
	
	    RSA是目前最有影响力的公钥加密算法，它能够抵抗到目前为止已知的绝大多数密码攻击，已被ISO推荐为公钥数据加密算法。
	
	    RSA算法是一种非对称密码算法，所谓非对称，就是指该算法需要一对密钥，使用其中一个加密，则需要用另一个才能解密。
	
	    关于RSA算法的原理，这里就不再详加介绍，网上各种资源一大堆。下面就开始介绍RSA加密解密JAVA类的具体实现。
	 * 
	 * 关于数字签名，先了解下何为数字签名。数字签名，就是只有信息的发送者才能产生的别人无法伪造的一段数字串，这段数字串同时也是对信息的发送者发送信息真实性的一个有效证明。数字签名是非对称密钥加密技术与数字摘要技术的应用。简单地说,所谓数字签名就是附加在数据单元上的一些数据,或是对数据单元所作的密码变换。这种数据或变换允许数据单元的接收者用以确认数据单元的来源和数据单元的完整性并保护数据,防止被人(例如接收者)进行伪造。
	
	    数字签名的主要功能如下：
	
	
	    保证信息传输的完整性、发送者的身份认证、防止交易中的抵赖发生。
	
	    数字签名技术是将摘要信息用发送者的私钥加密，与原文一起传送给接收者。接收者只有用发送者的公钥才能解密被加密的摘要信息，然后用对收到的原文产生一个摘要信息，与解密的摘要信息对比。如果相同，则说明收到的信息是完整的，在传输过程中没有被修改，否则说明信息被修改过，因此数字签名能够验证信息的完整性。
	
	    数字签名是个加密的过程，数字签名验证是个解密的过程。
	
	     数字签名算法依靠公钥加密技术来实现的。在公钥加密技术里，每一个使用者有一对密钥：一把公钥和一把私钥。公钥可以自由发布，但私钥则秘密保存；还有一个要求就是要让通过公钥推算出私钥的做法不可能实现。
	    普通的数字签名算法包括三种算法：
	    1.密码生成算法；
	    2.标记算法；
	   3.验证算法。
	
	    通过RSA加密解密算法，我们可以实现数字签名的功能。我们可以用私钥对信息生成数字签名，再用公钥来校验数字签名，当然也可以反过来公钥签名，私钥校验
	 * @author Admin
	 *
	 */
public class RSAUtils {
	public static final String KEY_ALGORITHM = "RSA";//加密算法

	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";//签名算法

	private static final String PUBLIC_KEY = "RSAPublicKey";//公钥

	private static final String PRIVATE_KEY = "RSAPrivateKey";//私钥

	public static void main(String[] args) {

		Map<String, Object> keyMap;

		try {

			keyMap = initKey();

			String publicKey = getPublicKey(keyMap);

			System.out.println(publicKey);

			String privateKey = getPrivateKey(keyMap);

			System.out.println(privateKey);
			
			
			System.out.println("\n=============================");
			String t = "carlzhang";
			
			for(byte b :t.getBytes()){
				System.out.print("["+b+"]");
			}
			System.out.println();
			//私钥加密
			byte[] result = encryptByPrivateKey(t.getBytes(),privateKey);
			for(byte b :result){
				System.out.print("["+b+"]");
			}
			System.out.println();
			//公钥解密
			byte[] r2 = decryptByPublicKey(result,publicKey);
			for(byte b :r2){
				System.out.print("["+b+"]");
			}
			System.out.println();
			System.out.println(new String(r2));
			
			
			System.out.println("\n==================================");
			String sign = sign(t.getBytes(),privateKey);
			System.out.println(verify(t.getBytes(),publicKey,sign));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
     * 用私钥加密
     * @param data  加密数据
     * @param key   密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data,String key)throws Exception{
        //解密密钥
        byte[] keyBytes = decryptBASE64(key);
        //取私钥
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
         
        //对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
         
        return cipher.doFinal(data);
    }
    
    /**
     * 用私钥解密<span style="color:#000000;"></span> * @param data  加密数据
     * @param key   密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data,String key)throws Exception{
        //对私钥解密
        byte[] keyBytes = decryptBASE64(key);
         
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
         
        return cipher.doFinal(data);
    }
    /**
     * 用公钥加密
     * @param data  加密数据
     * @param key   密钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data,String key)throws Exception{
        //对公钥加密
        byte[] keyBytes = decryptBASE64(key);
        //取公钥
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
         
        //对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
         
        return cipher.doFinal(data);
    }
    /**
     * 用公钥解密
     * @param data  加密数据
     * @param key   密钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data,String key)throws Exception{
        //对私钥解密
        byte[] keyBytes = decryptBASE64(key);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
         
        //对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
         
        return cipher.doFinal(data);
    }
    
    /**
     *  用私钥对信息生成数字签名
     * @param data  //加密数据
     * @param privateKey    //私钥
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data,String privateKey)throws Exception{
        //解密私钥
        byte[] keyBytes = decryptBASE64(privateKey);
        //构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        //指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //取私钥匙对象
        PrivateKey privateKey2 = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey2);
        signature.update(data);
         
        return encryptBASE64(signature.sign());
    }
    
    /**
     * 校验数字签名
     * @param data  加密数据
     * @param publicKey 公钥
     * @param sign  数字签名
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data,String publicKey,String sign)throws Exception{
        //解密公钥
        byte[] keyBytes = decryptBASE64(publicKey);
        //构造X509EncodedKeySpec对象
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        //指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //取公钥匙对象
        PublicKey publicKey2 = keyFactory.generatePublic(x509EncodedKeySpec);
         
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey2);
        signature.update(data);
        //验证签名是否正常
        return signature.verify(decryptBASE64(sign));
         
    }
    
	public static String getPublicKey(Map<String, Object> keyMap)
			throws Exception {

		Key key = (Key) keyMap.get(PUBLIC_KEY);

		byte[] publicKey = key.getEncoded();

		return encryptBASE64(key.getEncoded());

	}

	public static String getPrivateKey(Map<String, Object> keyMap)
			throws Exception {

		Key key = (Key) keyMap.get(PRIVATE_KEY);

		byte[] privateKey = key.getEncoded();

		return encryptBASE64(key.getEncoded());

	}

	public static byte[] decryptBASE64(String key) throws Exception {

		return (new BASE64Decoder()).decodeBuffer(key);

	}

	public static String encryptBASE64(byte[] key) throws Exception {

		return (new BASE64Encoder()).encodeBuffer(key);

	}

	public static Map<String, Object> initKey() throws Exception {

		KeyPairGenerator keyPairGen = KeyPairGenerator
				.getInstance(KEY_ALGORITHM);
		/*
		 *  从代码中可以看出密钥的初始化长度为1024位，密钥的长度越长，安全性就越好，但是加密解密所用的时间就会越多。而一次能加密的密文长度也与密钥的长度成正比。
		 *  一次能加密的密文长度为：密钥的长度/8-11。所以1024bit长度的密钥一次可以加密的密文为1024/8-11=117bit。
		 *  所以非对称加密一般都用于加密对称加密算法的密钥，而不是直接加密内容。对于小文件可以使用RSA加密，但加密过程仍可能会使用分段加密。
		 * */
		keyPairGen.initialize(1024);

		KeyPair keyPair = keyPairGen.generateKeyPair();

		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		Map<String, Object> keyMap = new HashMap<String, Object>(2);

		keyMap.put(PUBLIC_KEY, publicKey);

		keyMap.put(PRIVATE_KEY, privateKey);

		return keyMap;

	}

}
