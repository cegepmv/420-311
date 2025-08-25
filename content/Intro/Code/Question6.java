public class Question6 {
    public static void main(String[] args) {
	   
        ClasseB obj = new ClasseB();
        obj.i = 1;
        obj.j = 2;
        obj.afficheToi();
    }
}

class ClasseA {

    public int i;
    public int j;
}

class ClasseB extends ClasseA {

    public int j;
    public void afficheToi() {
        super.j = 3;
        System.out.println(i + " " + j);
    }
}

