package Test;

public class B extends A{
	
	/*
	 * int a; int b; B(int a, int b) { super(a, b); this.a=a; this.b=b;
	 * 
	 * }
	 */
 
	B(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*
		 * int a=543; int reverse=0; while(a!=0) {
		 * 
		 * int digit=a%10; reverse=reverse*10+digit; a=a/10;
		 * 
		 * 
		 * } System.out.println(reverse);
		 */
		
		A a11=new B(10, 20);
		//A a12=new A(30, 40);
		B a13=new B(30, 40);
		a11.a1();
		a11.b1();
	//a12.a1();
	//	a13.a1();
	}
	public void a1() {
		System.out.println("Sum Of the number B:");
	}
	
	public void b1() {
		System.out.println("Sum Of the number b1 B:");
	}
	
}
