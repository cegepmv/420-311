package content.ComplexAlgo.Code;

public class ComplexityAlgo {
    public static void main(String[] args) {
        int[] tableau = {5, 2, 3, 6, 18, 13, 22, 55, 9, 14, 88, 51, 42, 6, 9, 17, 5, 71};
//        affiche1(tableau);
//        affiche2(tableau);
//        afficheTableau(tableau);
//        afficheN(tableau);
//        afficheTableau2D(tableau);
//        afficheTableau2N(tableau);
//        afficheTableau2D(tableau);
//        afficheTableau2D(tableau);
//        afficheTableau2Dn(tableau);
//        afficheTableau3D(tableau);
//        afficheTableauSpace(tableau);
    }

    public static void affiche1(int[] tab) {
        // O(1)
        System.out.println(tab[0]);
    }

    public static void affiche2(int[] tab) {
        // O(2) qui sera simplifée à O(1)
        System.out.println(tab[0]);
        System.out.println(tab[1]);
    }

    public static void afficheTableau(int[] tab) {
        // O(n) temporelle
        // O(1) spaciale
        for (int num : tab) {
            System.out.println(num);
        }
    }

    public static void afficheN(int[] tab) {
        // O(1 + n + 1) -> simplifiée à O(2 + n) -> simplifiée à O(n)
        System.out.println(tab[0]);
        for (int num : tab) {
            System.out.println(num);
        }
        System.out.println(tab[tab.length - 1]);
    }

    public static void afficheTableau2N(int[] tab) {
        // O(2n) on ignore la constante -> simplifiée à O(n)
        for (int num : tab) {
            System.out.println(num);
        }

        for (int num : tab) {
            System.out.println(num);
        }
    }

    public static void afficheTableauNM(int[] tab, String[] names) {
        // O(n + m) -> simplifiée à O(n) car ça évolue linéairement
        for (int num : tab) { // O(n)
            System.out.println(num);
        }

        for (String name : names) { // O(m)
            System.out.println(name);
        }
    }

    public static void afficheTableau2D(int[] tab) {
        // O(n ^ 2)
        for (int num1 : tab) {
            for (int num2 : tab) {
                System.out.println(num1 * num2);
            }
        }
    }

    public static void afficheTableau2Dn(int[] tab) {
        // O(n + n ^ 2) -> siplifiée à O(n ^ 2) car n ^ 2 > n
        for (int num : tab) { // O(n)
            System.out.println(num);
        }

        for (int num1 : tab) {
            for (int num2 : tab) {
                System.out.println(num1 * num2);
            }
        }
    }

    public static void afficheTableau3D(int[] tab) {
        // O(n ^ 2)
        for (int num1 : tab) {
            for (int num2 : tab) {
                for (int num3 : tab) {
                    System.out.println(num1 * num2 * num3);
                }
            }
        }
    }

    public static void afficheTableauSpace(int[] tab) {
        // O(n) space
        int[] tabCopy = new int[tab.length];

        for (int num : tab) {
            System.out.println(num);
        }
    }

    public static int factoriel(int n) {
        // O(n) space
        if (n == 0) return 1;
        return n * factoriel(n - 1);
    }

}

