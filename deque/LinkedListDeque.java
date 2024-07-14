package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private TypeNode sentinel;
    private TypeNode first, last;

    /** Class creates the nodes which the linkedListDeque list will be using. */
    private class TypeNode {
        private T item;
        private TypeNode next, prev;

        /** Creates the node structure that will be used.
         * @param p The previous node.
         * @param i The item being added.
         * @param n The next node.
         */
        TypeNode(TypeNode p, T i, TypeNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** Initializes an LinkedListDeque list, beginning with the sentinel node.
     * Its class attributes are set...
     * sentinel.next (points to the sentinel)
     * sentinel.prev (points to the sentinel)
     * size (the size of the user's list)
     */
    public LinkedListDeque() {
        sentinel = new TypeNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Adds an item to the front of an LinkedListDeque list.
     * @param item The item that is being inserted into the user's list.
     */
    public void addFirst(T item) {
        if (size() == 0) {
            first = new TypeNode(sentinel.prev, item, sentinel.next);
            last = first;
        } else {
            first.prev = new TypeNode(sentinel.prev, item, first);
            first = first.prev;
        }
        size += 1;
    }

    /** Adds an item to the end of an LinkedListDeque list.
     * @param item The item that is being inserted into the user's list.
     */
    public void addLast(T item) {
        if (size() == 0) {
            last = new TypeNode(sentinel.prev, item, sentinel.next);
            first = last;
        } else {
            last.next = new TypeNode(last, item, sentinel.next);
            last = last.next;
        }
        size += 1;
    }

    /** Removes and returns an item from the front of an LinkedListDeque list. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T oldFirstValue = first.item;
            first = first.next;
            size -= 1;
            return oldFirstValue;
        }
    }

    /** Removes and returns an item from the back of an LinkedListDeque list. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T oldLastValue = last.item;
            last = last.prev;
            size -= 1;
            return oldLastValue;
        }
    }

    /** Prints the items in an LinkedListDeque list, excludes null values.
     * If list is null, nothing is printed.*/
    public void printDeque() {
        TypeNode pointer = first;
        for (int i = 0; i < size(); i++) {
            System.out.print(pointer.item + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    /** Returns a integer indicating the size of an LinkedListDeque list.*/
    public int size() {
        return size;
    }

    public T get(int index) {
        TypeNode pointer = first;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                T amount = pointer.item;
                return amount;
            }
            pointer = pointer.next;
        }
        return null;
    }

    public T getRecursive(int index) {
        TypeNode pointer = first;
        return helperGetRecursive(pointer, index, 0);
    }

    private T helperGetRecursive(TypeNode pointer, int index, int counter) {
        if (counter >= size()) {
            return null;
        } else if (counter == index) {
            return pointer.item;
        } else {
            return helperGetRecursive(pointer.next, index, counter += 1);
        }
    }

    /** Returns a boolean indicating whether an object is equal to the user's LinkedListDeque list.
     * @param o The object that is being compared to the user's LinkedListDeque list.
     */
    public boolean equals(Object o) {
        if (o instanceof Deque) {
            return helperEquals(o);
        } else {
            return false;
        }
    }

    /** A helper method to the equals method.
     * Returns a boolean indicating whether an object is equal to the user's LinkedListDeque list.
     * @param o The object that is being compared to the user's LinkedListDeque list.
     */
    private boolean helperEquals(Object o) {
        if (size() != ((Deque<T>) o).size()) {
            return false;
        } else {
            for (int i = 0; i < size(); i++) {
                if (!get(i).equals(((Deque<T>) o).get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    /**  A private class that makes an LinkedListDeque an iterable.*/
    private class LinkedListDequeIterator implements Iterator<T> {
        private int positionTraveled;
        private TypeNode position;

        /**  Initializes the iterable.*/
        LinkedListDequeIterator() {
            positionTraveled = 0;
            position = first;
        }
        /**  Returns a boolean indicating if there is a next item in the iterable.*/
        public boolean hasNext() {
            return positionTraveled < size();
        }
        /**  Returns the next item in the iterable.*/
        public T next() {
            if (position != null && hasNext()) {
                T returnItem = position.item;
                position = position.next;
                positionTraveled += 1;
                return returnItem;
            } else {
                return null;
            }
        }
    }

    /**  Returns an iterator.*/
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

}



