public class Question13{
	public static int param1;
	public static int param2;

	public void add(int a, int b) {
		param1 = a + b;
		param2 = param1 + b;
	}

	public static void main(String args[]) {
		Question13 obj1 = new Question13();
		Question13 obj2 = new Question13();
		int a = 2;
		obj1.add(a, a + 1);
		obj2.add(5, a);
		System.out.println(obj1.param1 + " " + obj2.param2);
	}
}