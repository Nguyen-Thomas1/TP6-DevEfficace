import java.util.LinkedList;
import java.util.Queue;

public class QuicksortQueue {



    public static void quickSort(Queue<K> s) {
        int n = s.size();
        if (n < 2) return;
        
        K pivot = s.first();
        Queue<K> l,g,e;
            
        while (!s.isEmpty())
            k element = s.dequeue();
        int c = comp.compare(pivot,element);

        if (c < 0) {
            l.enqueue(element);
        else if (c == 0){
            e.enqueue(element);
        else {
            g.enqueue(element);

        quickSort(l,comp);
        quickSort(g,comp);

        while (!l.isEmpty()
            s.enqueue(l.dequeue());
        
    }
}
