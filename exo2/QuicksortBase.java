import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class QuicksortQueue {

    public static <K> void partition(Queue<K> s, K pivot, Queue<K> l, Queue<K> e, Queue<K> g, Comparator<K> comp) {
        while (!s.isEmpty()) {
            K element = s.poll();
            int c = comp.compare(element, pivot);
            if (c < 0) {
                l.add(element);
            } else if (c == 0) {
                e.add(element);
            } else {
                g.add(element);
            }
        }
    }

    public static <K> void quickSort(Queue<K> s, Comparator<K> comp) {
        int n = s.size();
        if (n < 2) return;

        K pivot = s.peek();
        Queue<K> l = new LinkedList<>();
        Queue<K> e = new LinkedList<>();
        Queue<K> g = new LinkedList<>();

        partition(s, pivot, l, e, g, comp);

        quickSort(l, comp);
        quickSort(g, comp);

        while (!l.isEmpty()) s.add(l.poll());
        while (!e.isEmpty()) s.add(e.poll());
        while (!g.isEmpty()) s.add(g.poll());
    }
}
