public class MergeSort {
    public static void mergeSort(int[] tab) {
        if (tab.length > 1) {
            int mid = tab.length / 2;
            int[] gauche = new int[mid];
            int[] droite = new int[tab.length - mid];

            System.arraycopy(tab, 0, gauche, 0, mid);
            System.arraycopy(tab, mid, droite, 0, tab.length - mid);

            mergeSort(gauche);
            mergeSort(droite);
            fusion(tab, gauche, droite);
        }
    }

    private static void fusion(int[] tab, int[] gauche, int[] droite) {
        int i = 0, j = 0, k = 0;
        while (i < gauche.length && j < droite.length) {
            if (gauche[i] <= droite[j]) tab[k++] = gauche[i++];
            else tab[k++] = droite[j++];
        }
        while (i < gauche.length) tab[k++] = gauche[i++];
        while (j < droite.length) tab[k++] = droite[j++];
    }

    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(data);
        System.out.println("Tri par fusion : " + java.util.Arrays.toString(data));
    }
}
