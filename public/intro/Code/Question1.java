public class Question1 {
    public static void main(String[] args) {
        methode1();
        int j = 12;
        j = methode1();
        System.out.println(j);
    }

	public static int methode1() {
		int i = 0;
		i++;
		return i;
	}
}