public class Question17 {
    public static void main(String[] args) {
        ClasseB classeB = new ClasseB();
            
        System.out.println("Valeur = " + classeB.calculer(3, 6));
    }
}

class ClassA {
            
    final public int calculer(int a, int b) {
        return 0;
    }
}

class ClasseB extends ClasseA {

	public int calculer(int a, int b) {
		return 1;
	}
}


