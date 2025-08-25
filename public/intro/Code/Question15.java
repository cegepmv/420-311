public class Question15{
	public static int param1;

	public void increment() {
		param1++;
	}

	public static void main(String args[]) {

		Question15 obj1 = new Question15();
		Question15 obj2 = new Question15();
		obj1.param1 = 0;
		obj1.increment();
		obj2.increment();
		System.out.println(obj1.param1 + " " + obj2.param1);
	}
}