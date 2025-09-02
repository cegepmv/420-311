public class Exemple1 {
    private static int count = 0;
    private static int[] tab = {1, 2, 3};
    private String nom = "Hello";

    public Exemple1(){
        count++;
        //System.out.println(count);
    }

    public static void main(String[] args){
        Exemple1 exp1 = new Exemple1();
        System.out.println(exp1);
    }
}