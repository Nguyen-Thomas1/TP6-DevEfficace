public class BubbleSortDoublyLinked {

    
    public static void bubbleSort(DNode head) {
        if (head == null) return;

        boolean swapped;
        DNode current;
        DNode last = null; 
        do {
            swapped = false;
            current = head;

            while (current.getNext() != last) {
           
                if (current.getElement().compareTo(current.getNext().getElement()) > 0) {
                    
                    String temp = current.getElement();
                    current.setElement(current.getNext().getElement());
                    current.getNext().setElement(temp);
                    
                    swapped = true;
                }
                current = current.getNext();
            }
            last = current
        } while (swapped);
    }

    public static void main(String[] args) {
 
        DNode n4 = new DNode("Cerise", null, null);
        DNode n3 = new DNode("Abricot", null, n4);
        n4.setPrev(n3);
        DNode n2 = new DNode("Pomme", null, n3);
        n3.setPrev(n2);
        DNode head = new DNode("Banane", null, n2);
        n2.setPrev(head);

        System.out.println("Avant le tri :");
        printList(head);

  
        bubbleSort(head);

        System.out.println("Après le tri :");
        printList(head);
    }


    public static void printList(DNode head) {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.getElement() + " <-> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }
}
