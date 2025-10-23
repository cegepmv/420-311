import java.util.*;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new ArrayList[n];

        // Création des seaux
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribution dans les seaux
        for (float v : arr) {
            int index = (int)(v * n);
            buckets[index].add(v);
        }

        // Tri dans chaque seau
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Fusion des seaux
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float v : bucket) {
                arr[index++] = v;
            }
        }
    }

    public static void main(String[] args) {
        float[] data = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
        bucketSort(data);
        System.out.println("Tri par paquets : " + java.util.Arrays.toString(data));
    }
}
