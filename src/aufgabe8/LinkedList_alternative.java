package aufgabe8;

/**
 *
 * @author Oliver Haase
 */

public class LinkedList_alternative {
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

    public LinkedList_alternative() {
        head = null;
        size = 0;
    }

    public LinkedList_alternative add(int value) {
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

    public LinkedList_alternative[] split() {
        int mid = size / 2;
        Node alt = head;
        for (int i = 1; i < mid; i++) {
            alt = alt.next;
        }
        Node neu = alt.next;
        alt.next = null;

        LinkedList_alternative n = new LinkedList_alternative();
        n.head = neu;
        size = mid + (size % 2);
        n.size = mid;
        LinkedList_alternative[] out = { this, n };
        return out;
    }

    public LinkedList_alternative mergeSort() {
        // hier fehlt Ihr Code
        if (this.size == 1) {
            return this;
        }

        // Teile | Divide
        LinkedList_alternative[] parts = split();
        LinkedList_alternative la = parts[0].mergeSort();
        LinkedList_alternative lb = parts[1].mergeSort();

        // Herrsche | Conquer
        LinkedList_alternative merged = sortLists(la, lb);
        this.head = merged.head;
        this.size = merged.size;
        return this;
    }

    private static LinkedList_alternative sortLists(LinkedList_alternative a, LinkedList_alternative b) {
        LinkedList_alternative c = new LinkedList_alternative();
        c.head = new Node(0, null);
        c.size = a.size + b.size;
        Node na = a.head;
        Node nb = b.head;
        Node nc = c.head;
        Node result = c.head;

        while (na != null && nb != null) {
            if (na.value <= nb.value) {
                nc.next = new Node(na.value, null);
                na = na.next;
                nc = nc.next;

            } else {
                nc.next = new Node(nb.value, null);
                nb = nb.next;
                nc = nc.next;
            }
        }

        if (nb == null) {
            while (na != null) {
                nc.next = new Node(na.value, null);
                na = na.next;
                nc = nc.next;
            }
        } else {
            while (nb != null) {
                nc.next = new Node(nb.value, null);
                nb = nb.next;
                nc = nc.next;
            }
        }
        c.head = result.next;
        return c;

    }

}
