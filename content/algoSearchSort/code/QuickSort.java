public class QuickSort {
    public static void quickSort(int[] tab, int debut, int fin) {
        if (debut < fin) {
            int pivotIndex = partition(tab, debut, fin);
            quickSort(tab, debut, pivotIndex - 1);
            quickSort(tab, pivotIndex + 1, fin);
        }
    }

    private static int partition(int[] tab, int debut, int fin) {
        int pivot = tab[fin];
        int i = (debut - 1);
        for (int j = debut; j < fin; j++) {
            if (tab[j] <= pivot) {
                i++;
                int temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
        }
        int temp = tab[i + 1];
        tab[i + 1] = tab[fin];
        tab[fin] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] tab = {10, 7, 8, 9, 1, 5};
        quickSort(tab, 0, tab.length - 1);
        System.out.println("Tri rapide : " + java.util.Arrays.toString(tab));
    }
}
