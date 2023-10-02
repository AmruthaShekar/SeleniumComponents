public class ComparisionOperatorOnObjects {
		
	int a;
	public static void main(String[] args) {
		
		String s1 = "hello";
		String s2 = "hello";
	    System.out.println(s1 == s2);
	    
	    StringBuilder sb = new StringBuilder("java");
	    StringBuilder sb1 = new StringBuilder("java"); 
	    System.out.println(sb1 == sb);
	    
	    ComparisionOperatorOnObjects  co1 = new ComparisionOperatorOnObjects();
	    co1.a = 100;
	    
	    ComparisionOperatorOnObjects  co2 = new ComparisionOperatorOnObjects();
	    co2.a = 100;
	    
	    System.out.println(co1 == co2);
	    System.out.println(co1.equals(co2));
	}

}
