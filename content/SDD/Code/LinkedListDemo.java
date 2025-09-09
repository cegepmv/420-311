import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<>();

        // Ajouts
        cars.add("Audi");       // fin
        cars.addFirst("Toyota");   // début
        cars.addLast("Ford");     // fin
        System.out.println("Liste : " + cars);

        // Accès
        System.out.println("Premier : " + cars.getFirst());
        System.out.println("Dernier : " + cars.getLast());
        System.out.println("Index 1 : " + cars.get(1));

        // Suppressions
        cars.removeFirst();
        cars.removeLast();
        System.out.println("Après suppressions : " + cars);

        // Utilisation comme pile
        cars.push("Honda");
        System.out.println("Après push : " + cars);
        System.out.println("Pop → " + cars.pop());

        // Utilisation comme file
        cars.offer("Opel");
        System.out.println("Après offer : " + cars);
        System.out.println("Poll → " + cars.poll());
    }
}