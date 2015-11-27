package carlspringtest;

import java.util.Random;


public class CarTest {

	public static void main(String[] args)throws Exception {
			String mytext = java.net.URLEncoder.encode("http://dengwenjun.iteye.com/blog/1961267?jodj=中国&jdong=222", "utf-8");
			String mytext2 = java.net.URLDecoder.decode(mytext, "utf-8");
		System.out.println(mytext);//http%3A%2F%2Fdengwenjun.iteye.com%2Fblog%2F1961267%3Fjodj%3D%E4%B8%AD%E5%9B%BD%26jdong%3D222
		System.out.println(mytext2);//http://dengwenjun.iteye.com/blog/1961267?jodj=中国&jdong=222
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		for(int i=0;i<20;i++){
			System.out.print(random.nextInt(10)+",");
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
	}
	   
	   

}
