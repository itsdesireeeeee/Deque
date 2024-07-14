
package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size, totalSize, lastIndex, firstPointer, lastPointer;
    private T[] arrayDequeList;

    /** Initializes an arrayDeque list, and its class attributes of..
     * totalSize (internal size of the array structure),
     * lastIndex (last index of internal array structure),
     * size (the size of the user's list)
     */
    public ArrayDeque() {
        arrayDequeList = (T[]) new Object[8];
        totalSize = 8;
        lastIndex = totalSize - 1;
        size = 0;
    }

    /** Makes the internal array larger when an item is added and the list is at capacity.
     * @param capacity The new capacity size of our larger list.
     */
    private void resizeLarger(int capacity) {
        int lengthUntilEnd = totalSize - firstPointer;
        int startingPos = firstPointer + totalSize;
        T[] newArray = (T[]) new Object[capacity];

        if (firstPointer == 0) {
            System.arraycopy(arrayDequeList, 0, newArray, 0, totalSize);
        } else {
            System.arraycopy(arrayDequeList, firstPointer, newArray, startingPos, lengthUntilEnd);
            System.arraycopy(arrayDequeList, 0, newArray, 0, totalSize - lengthUntilEnd);
            firstPointer = startingPos;
        }
        arrayDequeList = newArray;
        totalSize = capacity;
        lastIndex = totalSize - 1;

    }

    /** Makes the internal array structure smaller when less than 25% of the list is being utilized.
     * @param capacity The new capacity size of our larger list.
     */
    private void resizeSmaller(int capacity) {
        int lengthUntilEnd = totalSize - firstPointer;
        int startingPos = firstPointer - capacity;
        T[] newArray = (T[]) new Object[capacity];
        if (firstPointer == 0) {
            System.arraycopy(arrayDequeList, 0, newArray, 0, size());
        } else if (firstPointer < lastPointer) {
            System.arraycopy(arrayDequeList, firstPointer, newArray, 0, size());
            firstPointer = 0;
            lastPointer = size() - 1;
        } else {
            System.arraycopy(arrayDequeList, firstPointer, newArray, startingPos, lengthUntilEnd);
            System.arraycopy(arrayDequeList, 0, newArray, 0, size() - lengthUntilEnd);
            firstPointer = firstPointer - capacity;
        }
        arrayDequeList = newArray;
        totalSize = capacity;
        lastIndex = totalSize - 1;
    }

    /** Adds an item to the front of an arrayDeque list.
     *  Calls resizeLarger method if necessary.
     * @param item The item that is being inserted into the user's list.
     */
    public void addFirst(T item) {
        if (size == 0) {
            arrayDequeList[0] = item;
            firstPointer = 0;
            lastPointer = 0;
            size += 1;
        } else if (size() == totalSize) {
            resizeLarger(totalSize * 2);
            addFirst(item);
        } else if (lastPointer == 1 && arrayDequeList[0] == null) {
            arrayDequeList[0] = item;
            firstPointer = 0;
            size += 1;
        } else if (arrayDequeList[lastIndex] == null && firstPointer == 0) {
            arrayDequeList[lastIndex] = item;
            firstPointer = lastIndex;
            size += 1;
        } else if (firstPointer <= lastPointer) {
            arrayDequeList[firstPointer - 1] = item;
            firstPointer -= 1;
            size += 1;
        } else {
            firstPointer -= 1;
            arrayDequeList[firstPointer] = item;
            size += 1;
        }
    }

    /** Adds an item to the end of an arrayDeque list.
     * Calls resizeLarger method if necessary.
     * @param item The item that is being inserted into the user's list.
     */
    public void addLast(T item) {
        if (size == 0) {
            arrayDequeList[1] = item;
            firstPointer = 1;
            lastPointer = 1;
            size += 1;
        } else if (size() == totalSize) {
            resizeLarger(totalSize * 2);
            addLast(item);
        } else if (lastPointer == 0) {
            arrayDequeList[1] = item;
            lastPointer = 1;
            size += 1;
        } else if (arrayDequeList[0] == null && lastPointer == lastIndex) {
            arrayDequeList[0] = item;
            lastPointer = 0;
            size += 1;
        } else {
            lastPointer += 1;
            arrayDequeList[lastPointer] = item;
            size += 1;
        }
    }

    /** Removes and returns an item from the front of an arrayDeque list.
     * Calls resizeSmaller method if necessary.*/
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (firstPointer <= lastPointer) {
            T removedItem = get(0);
            arrayDequeList[firstPointer] = null;
            firstPointer += 1;
            size -= 1;
            if (totalSize == 16 && usageRatio() < .25) {
                resizeSmaller(totalSize / 2);
            }
            return removedItem;
        } else if (firstPointer == lastIndex) {
            T removedItem = get(0);
            arrayDequeList[firstPointer] = null;
            firstPointer = 0;
            size -= 1;
            if (totalSize == 16 && usageRatio() < .25) {
                resizeSmaller(totalSize / 2);
            }
            return removedItem;
        } else {
            T removedItem = get(0);
            arrayDequeList[firstPointer] = null;
            firstPointer += 1;
            size -= 1;
            if (totalSize == 16 && usageRatio() < .25) {
                resizeSmaller(totalSize / 2);
            }
            return removedItem;
        }

    }

    /** Removes and returns an item from the back of an arrayDeque list.
     *  Calls resizeSmaller method if necessary.*/
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if (lastPointer == 0) {
            T removedItem = get(size() - 1);
            arrayDequeList[lastPointer] = null;
            lastPointer = lastIndex;
            size -= 1;
            if (totalSize == 16 && usageRatio() < .25) {
                resizeSmaller(totalSize / 2);
            }
            return removedItem;
        } else {
            T removedItem = get(size() - 1);
            arrayDequeList[lastPointer] = null;
            lastPointer -= 1;
            size -= 1;
            if (totalSize == 16 && usageRatio() < .25) {
                resizeSmaller(totalSize / 2);
            }
            return removedItem;
        }
    }

    /** Prints the items in an arrayDeque list, excludes null values.
     * If list is null, nothing is printed.*/
    public void printDeque() {
        if (!isEmpty()) {
            int pointer = firstPointer;
            for (int counter = 0; counter < totalSize; counter++) {
                if (pointer == lastIndex && arrayDequeList[pointer] != null) {
                    System.out.print(arrayDequeList[pointer] + " ");
                    pointer = 0;
                } else if (arrayDequeList[pointer] != null) {
                    System.out.print(arrayDequeList[pointer] + " ");
                    pointer += 1;
                }
            }
            System.out.println();
        }
    }

    /** Returns a integer indicating the size of an arrayDeque list.*/
    public int size() {
        return size;
    }

    /** Returns a given index from an arrayDeque list. If no such index exits, null is returned.
     * @param i The requested index of the list.
     */
    public T get(int i) {
        int distanceFromEnd = lastIndex - firstPointer;
        if (i >= size()) {
            return null;
        } else if (i > distanceFromEnd) {
            return arrayDequeList[i - distanceFromEnd - 1];
        } else {
            return arrayDequeList[i + firstPointer];
        }
    }

    /** Returns a boolean indicating whether an object is equal to the user's arrayDeque list.
     * @param o The object that is being compared to the user's arrayDeque list.
     */
    public boolean equals(Object o) {
        if (o instanceof Deque) {
            return helperEquals(o);
        } else {
            return false;
        }
    }

    /** A helper method to the equals method.
     * Returns a boolean indicating whether an object is equal to the user's arrayDeque list.
     * @param o The object that is being compared to the user's arrayDeque list.
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

    /** Returns a double indicating the ratio of items being used in an arrayDeque list.*/
    private double usageRatio() {
        double amountUsed = size();
        double total = totalSize;
        return amountUsed / total;
    }

    /**  A private class that makes an ArrayDeque an iterable.*/
    private class ArrayDequeIterator implements Iterator<T> {
        private int positionTraveled, pos;

        /**  Initializes the iterable.*/
        ArrayDequeIterator() {
            positionTraveled = 0;
            pos = firstPointer;
        }
        /**  Returns a boolean indicating if there is a next item in the iterable.*/

        public boolean hasNext() {
            return positionTraveled < size();
        }
        /**  Returns the next item in the iterable.*/
        public T next() {
            if (pos == lastIndex && hasNext()) {
                T returnItem = arrayDequeList[pos];
                pos = 0;
                positionTraveled += 1;
                return returnItem;

            } else if (hasNext()) {
                T returnItem = arrayDequeList[pos];
                pos += 1;
                positionTraveled += 1;
                return returnItem;
            } else {
                return null;
            }
        }
    }

    /**  Returns an iterator.*/
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }


}
