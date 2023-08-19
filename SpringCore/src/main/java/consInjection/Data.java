package consInjection;

public class Data {
	
	private int a;
	private int b;
	
	
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Data(int a, int b) {
		super();
		System.out.println("int cons");
		this.a = a;
		this.b = b;
	}
	
	public Data(String a , String b) {
		System.out.println("String cons");
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
	}
	public Data(double a , double b) {
		System.out.println("Double cons");
		this.a = (int)a;
		this.b = (int)b;
		
	}
	public Data(String a, int b) {
		System.out.println("Sting int cons");
		this.a = Integer.parseInt(a);
		this.b = b;
	}

	@Override
	public String toString() {
		return "Data [a=" + a + ", b=" + b + "]";
	}
	
	
}
