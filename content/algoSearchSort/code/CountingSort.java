public class CountingSort {
    public static void countingSort(int[] tab, int max) {
        int[] compte = new int[max + 1];

        // Compter les occurrences
        for (int num : tab) compte[num]++;

        // Reconstruire le tableau
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (compte[i]-- > 0) {
                tab[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        countingSort(data, 8);
        System.out.println("Tri par comptage : " + java.util.Arrays.toString(data));
    }
}
