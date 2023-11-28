import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T element) {
        list.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = list.get(list.size() - 1).value;
        list.delete(list.size() - 1);
        return element;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
