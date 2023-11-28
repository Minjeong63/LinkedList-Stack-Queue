import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int size = 0;

    public int size() {
        return size;
    }

//    public void addFirst(Object value) {
//        Node node = new Node(value);
//        node.next = head;
//        head = node;
//        size++;
//        if (head.next == null) {
//            tail = head;
//        }
//    }
//
//    public void addLast(Object value) {
//        Node node = new Node(value);
//
//        if (size == 0) {
//            addFirst(value);
//            return;
//        }
//        tail.next = node;
//        tail = node;
//        size++;
//    }

    public void add(T data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public Node get(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private boolean isNodeValid(Node node) {
        return node != null && node.next != null;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return;
        }

        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }

        if (!isNodeValid(node)) {
            throw new NoSuchElementException("No node to delete at index: " + index);
        }

        Node deletedNode = node.next;
        if (deletedNode == tail) {
            tail = node;
        }

        node.next = node.next.next;
        size--;

    }

    public class Node {
        public final T value;
        private Node next;

        public Node(T input) {
            this.value = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            T data = current.value;
            current = current.next;
            return data;
        }
    }
}
