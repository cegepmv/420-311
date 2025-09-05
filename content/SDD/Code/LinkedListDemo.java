import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> liste = new LinkedList<>();

        // Ajouts
        liste.add("Alice");       // fin
        liste.addFirst("Zara");   // début
        liste.addLast("Bob");     // fin
        System.out.println("Liste : " + liste);

        // Accès
        System.out.println("Premier : " + liste.getFirst());
        System.out.println("Dernier : " + liste.getLast());
        System.out.println("Index 1 : " + liste.get(1));

        // Suppressions
        liste.removeFirst();
        liste.removeLast();
        System.out.println("Après suppressions : " + liste);

        // Utilisation comme pile
        liste.push("Charlie");
        System.out.println("Après push : " + liste);
        System.out.println("Pop → " + liste.pop());

        // Utilisation comme file
        liste.offer("David");
        System.out.println("Après offer : " + liste);
        System.out.println("Poll → " + liste.poll());
    }
}