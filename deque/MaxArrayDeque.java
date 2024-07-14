package deque;
import java.util.Comparator;


public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    private MaxArrayDeque<T> maxArray;

    /** Initializes a MaxArrayDeque list, and its class attributes of..
     * maxArray (a MaxArrayDeque list instance),
     * comparator (a comparator of type T),
     */
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    /** Returns the maximum element in MaxArrayDeque chosen by the previously given Comparator.
     * If empty, returns null
     * */
    public T max() {
        return max(comparator);
    }

    /** Returns the maximum element in MaxArrayDeque chosen by the parameter Comparator.
     * If empty, returns null
     * */
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        } else {
            T currentMax = get(0);
            for (int i = 1; i < size(); i++) {
                int maxChecker = c.compare(currentMax, get(i));
                if (maxChecker < 0) {
                    currentMax = get(i);
                }
            }
            return currentMax;
        }
    }

}
