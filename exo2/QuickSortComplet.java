import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuicksortComplet {

    private static final Random RANDOM = new Random();

    public static void randomInit(ArrayList<Integer> input, int size) {
        input.clear();
        for (int i = 0; i < size; i++) {
            input.add(RANDOM.nextInt(100_000));
        }
    }

    public static int partition(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public static void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
    }

    public static void quickSortRandom(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int r = low + RANDOM.nextInt(high - low + 1);
            Collections.swap(list, r, high);
            int p = partition(list, low, high);
            quickSortRandom(list, low, p - 1);
            quickSortRandom(list, p + 1, high);
        }
    }

    public static void quickSortMedian3(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            ArrayList<Integer> idx = new ArrayList<>();
            idx.add(low);
            idx.add(mid);
            idx.add(high);
            idx.sort((a, b) -> Integer.compare(list.get(a), list.get(b)));
            Collections.swap(list, idx.get(1), high);

            int p = partition(list, low, high);
            quickSortMedian3(list, low, p - 1);
            quickSortMedian3(list, p + 1, high);
        }
    }

    public static void quickSortMedian5(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int len = high - low + 1;
            if (len >= 5) {
                ArrayList<Integer> idx = new ArrayList<>();
                for (int k = 0; k < 5; k++) {
                    idx.add(low + (k * (len - 1)) / 4);
                }
                idx.sort((a, b) -> Integer.compare(list.get(a), list.get(b)));
                Collections.swap(list, idx.get(2), high);
            }

            int p = partition(list, low, high);
            quickSortMedian5(list, low, p - 1);
            quickSortMedian5(list, p + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000};
        System.out.println("taille,algorithme,temps_ms");

        for (int n : sizes) {
            ArrayList<Integer> base = new ArrayList<>();
            randomInit(base, n);

            ArrayList<Integer> c1 = new ArrayList<>(base);
            long t0 = System.nanoTime();
            quickSort(c1, 0, c1.size() - 1);
            long t1 = System.nanoTime();
            System.out.printf("%d,classique,%.3f%n", n, (t1 - t0) / 1_000_000.0);

            ArrayList<Integer> c2 = new ArrayList<>(base);
            t0 = System.nanoTime();
            quickSortRandom(c2, 0, c2.size() - 1);
            t1 = System.nanoTime();
            System.out.printf("%d,randomise,%.3f%n", n, (t1 - t0) / 1_000_000.0);

            ArrayList<Integer> c3 = new ArrayList<>(base);
            t0 = System.nanoTime();
            quickSortMedian3(c3, 0, c3.size() - 1);
            t1 = System.nanoTime();
            System.out.printf("%d,mediane_3,%.3f%n", n, (t1 - t0) / 1_000_000.0);

            ArrayList<Integer> c4 = new ArrayList<>(base);
            t0 = System.nanoTime();
            quickSortMedian5(c4, 0, c4.size() - 1);
            t1 = System.nanoTime();
            System.out.printf("%d,mediane_5,%.3f%n", n, (t1 - t0) / 1_000_000.0);
        }
    }
}
