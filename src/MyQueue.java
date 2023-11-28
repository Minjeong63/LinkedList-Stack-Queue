import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void add(T element) {
        list.add(element);
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = list.get(0).value;
        list.delete(0);
        return element;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
