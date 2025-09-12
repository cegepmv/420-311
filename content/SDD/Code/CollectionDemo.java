import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
//        demoVector();
        demoHashSet();
//        demoTreeSet();
//        demoHashMap();
//        demoTreeMap();
        demoLinkedHashSet();
    }

    public static void demoVector(){
        Vector<String> vector = new Vector<>();

        vector.add("Bob");
        vector.add("Alice");
        vector.add("Alex");

        System.out.println(vector.get(1));
        System.out.println(vector);
    }

    public static void demoHashSet(){
        HashSet<String> noms = new HashSet<>();

        noms.add("Alice");
        noms.add("Bob");
        noms.add("Alice");

        System.out.println(noms);
    }

    public static void demoTreeSet(){
        TreeSet<Integer> notes = new TreeSet<>();

        notes.add(85);
        notes.add(90);
        notes.add(75);

        System.out.println(notes);
    }

    public static void demoHashMap(){
        HashMap<String, Integer> notesEtudiants = new HashMap<>();

        notesEtudiants.put("Alice", 80);
        notesEtudiants.put("Bob", 90);
        notesEtudiants.put("Alex", 75);

        System.out.println(notesEtudiants);

        // Parcours des clés/valeurs
        for (Map.Entry<String, Integer> e : notesEtudiants.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }
    }

    public static void demoTreeMap(){
        TreeMap<String, Integer> notesEtudiants = new TreeMap<>();

        notesEtudiants.put("Alice", 80);
        notesEtudiants.put("Bob", 90);
        notesEtudiants.put("Alex", 75);

        Integer val = notesEtudiants.get("Bob");
        System.out.println(val);

        val = notesEtudiants.get("Alain");
        System.out.println(val);

        Integer val2 = notesEtudiants.remove("Alex");
        System.out.println(val2);

        System.out.println(notesEtudiants);

        val2 = notesEtudiants.remove("Ali");

        System.out.println(val2);

        System.out.println(notesEtudiants.containsKey("Alain"));

        // Parcours des clés/valeurs
        for (Map.Entry<String, Integer> e : notesEtudiants.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }

        System.out.println(notesEtudiants);
    }

    public static void demoLinkedHashSet(){
        LinkedHashSet<String> noms = new LinkedHashSet<>();

        noms.add("Alice");
        noms.add("Bob");
        noms.add("Alice");

        System.out.println(noms);
    }
}
