package aufgabe08;

/**
 *
 * @author Oliver Haase
 */


public class LinkedList {
    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public LinkedList add(int value) {
        head = new Node(value, head);
        size++;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        Node p = head;
        boolean firstElement = true;
        while (p != null) {
            if (!firstElement)
                builder.append(", ");
            else
                firstElement = false;
            builder.append(p.value);
            p = p.next;
        }
        builder.append("}, size = " + size);
        return builder.toString();
    }

    public LinkedList[] split(){
        int mid = size / 2;
        Node alt = head;
        for (int i = 1; i < mid; i++) {
            alt = alt.next;
        }
        Node neu = alt.next;
        alt.next = null;

        LinkedList n = new LinkedList();
        n.head = neu;
        size = mid + (size % 2);
        n.size = mid;
        LinkedList[] out = {this, n};
        return out;
    }

    public LinkedList mergeSort() {
        // hier fehlt Ihr Code
        if(this.size == 1){
            return this;
        }

        // Teile | Divide
        LinkedList[] parts = split();
        LinkedList la = parts[0].mergeSort();
        LinkedList lb = parts[1].mergeSort();

        // Herrsche | Conquer
        return sortLists(la, lb);
    }

    private static LinkedList sortLists(LinkedList a, LinkedList b){
        Node na = a.head;
        Node nb = b.head;
        Node prev = null;
        a.size += b.size;

        while(nb != null){
            if(na == null || na.value >= nb.value){
                Node p = nb.next;
                if(prev == null){
                    Node n = a.head;
                    a.head = nb;
                    a.head.next = n;
                } else{
                    prev.next = nb;
                    nb.next = na;
                    prev = prev.next;
                }
                nb = p;
            } else{
                prev = na;
                na = na.next;
            }
        }
        System.out.println(a);
        return a;
    }

}
