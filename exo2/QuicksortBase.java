import java.util.LinkedList;
import java.util.Queue;

public class QuicksortQueue {

    public static void partition(Queue<Integer> q, int pivot, Queue<Integer> petits, Queue<Integer> egaux, Queue<Integer> grands) {
        while (!q.isEmpty()) {
            int val = q.poll();
            if (val < pivot) {
                petits.add(val);
            } else if (val == pivot) {
                egaux.add(val);
            } else {
                grands.add(val);
            }
        }
    }

    public static void quickSort(Queue<Integer> q) {
        if (q.size() <= 1) {
            return;
        }

        int pivot = q.peek();
        Queue<Integer> petits = new LinkedList<>();
        Queue<Integer> egaux = new LinkedList<>();
        Queue<Integer> grands = new LinkedList<>();

        partition(q, pivot, petits, egaux, grands);

        quickSort(petits);
        quickSort(grands);

        q.addAll(petits);
        q.addAll(egaux);
        q.addAll(grands);
    }
}
