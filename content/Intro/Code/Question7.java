public class Question7 {
    public static void main(String[] args) {
        
        Classe7B obj = new Classe7B();
        obj.i = 1;
        obj.j = 2;
        obj.afficheToi();
    }
}

class Classe7A {

    public int i;
}

class Classe7B extends Classe7A {

    public int j;
    public void afficheToi() {
        super.i = j + 1;
        System.out.println ( j + " " + i);
    }
}
