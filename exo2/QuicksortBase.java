import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class QuicksortQueue {

    public static <K> void quickSort(Queue<K> s, Comparator<K> comp) {
        int n = s.size();
        if (n < 2) return;

        K pivot = s.peek();
        Queue<K> l = new LinkedList<>();
        Queue<K> e = new LinkedList<>();
        Queue<K> g = new LinkedList<>();

        while (!s.isEmpty()) {
            K element = s.poll();
            int c = comp.compare(pivot, element);

            if (c < 0) {
                g.add(element);
            } else if (c == 0) {
                e.add(element);
            } else {
                l.add(element);
            }
        }

        quickSort(l, comp);
        quickSort(g, comp);

        while (!l.isEmpty()) {
            s.add(l.poll());
        }
        while (!e.isEmpty()) {
            s.add(e.poll());
        }
        while (!g.isEmpty()) {
            s.add(g.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> s = new LinkedList<>();
        s.add(4);
        s.add(2);
        s.add(7);
        s.add(1);
        s.add(3);

        quickSort(s, Integer::compareTo);
        System.out.println(s);
    }
}
