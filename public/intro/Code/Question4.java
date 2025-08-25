public class Question4 {

    public static void main(String[]args) {
        try {
            int a, b;
            b = 0;
            a = 5 / b;
            System.out.print("A");
        } catch (Exception e) {
            System.out.print("B");
        } finally {
            System.out.print("C");
        }	
    }
}