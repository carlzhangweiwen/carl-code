package carlspringtest;

public class CT {
	private static int x=100;
	public static void main(String[] args) {
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 =Integer.valueOf(59);
		Integer i04 = new Integer(59);
		
		System.out.println(i01 == i02);
		System.out.println(i01 == i03);
		System.out.println(i03 == i04);
		System.out.println(i02 == i04);
		System.out.println(i01 == i04);
		
		CT hs1=new CT();
		   hs1.x++;
		   CT  hs2=new CT();
		          hs2.x++;
		          hs1=new CT();
		          hs1.x++;
		          CT.x--;
		        System.out.println("x="+x);
	}

}
