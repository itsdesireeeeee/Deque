package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic array deque tests. */
public class ArrayDequeTests {
    @Test
    /** Adds 8 items to the front, checks looping. */
    public void addFirstEightTimes() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization.", ad1.isEmpty());

        for (int i = 1; i <= 8; i++) {
            ad1.addFirst(i);
        }
        // size should be 8
        assertEquals("The size should now be eight.", ad1.size(), 8);

    }

    @Test
    /** Adds 8 items to the end of array deque checks looping.*/
    public void addLastEightTimes() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization.", ad1.isEmpty());

        for (int i = 1; i <= 8; i++) {
            ad1.addLast(i);
        }

        assertEquals("The size should now be eight.", ad1.size(), 8);

    }

    @Test
    /** Adds 3 items to the front of the list, and three to the back,
     * checks to see if both work in unison.
     * Also checks to see if different types van be passed in, ie a boolean. */
    public void addFirstThreeAddLastThree() {
        ArrayDeque<Boolean> ad1 = new ArrayDeque<Boolean>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization.", ad1.isEmpty());

        for (int i = 1; i <= 3; i++) {
            ad1.addFirst(true);
            ad1.addLast(false);
        }
        //Size should be 6.
        assertEquals("The size should now be six.", ad1.size(), 6);
    }


    @Test
    /** Adds 3 items to the front of the list, and three to the back,
     * checks to see if both work in unison.
     * Also checks to see if different types van be passed in, ie a string. */
    public void addFirstEightAddLastEight() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization.", ad1.isEmpty());

        ad1.addFirst("hi!");
        for (int i = 1; i <= 5; i++) {
            ad1.addLast("hello!");
        }
        ad1.addFirst("stop");
        ad1.addLast("ok.");
        // Size should be 8.
        assertEquals("The size should now be eight.", ad1.size(), 8);
    }

    @Test
    /** Prints items in a full deque. */
    public void printFullDequeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization.", ad1.isEmpty());

        for (int i = 1; i <= 8; i++) {
            ad1.addLast(i);
        }
        // Size should be 8.
        assertEquals("The size should now be eight.", ad1.size(), 8);

        System.out.println("Your output should look like this...");
        System.out.println("1 2 3 4 5 6 7 8 ");
        System.out.print("This is your output: ");
        ad1.printDeque();
    }

    @Test
    /** Prints items in a empty deque. */
    public void printEmptyDequeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        System.out.println("Your output should look like this...");
        System.out.println(" ");
        System.out.print("This is your output: ");
        ad1.printDeque();
    }

    @Test
    /** Prints items in a deque that has null boxes at the first and last index. */
    public void printHarderDequeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        for (int i = 1; i <= 6; i++) {
            ad1.addLast(i);
        }
        // Size should be 6.
        assertEquals("The size should now be six", ad1.size(), 6);

        System.out.println("Your output should look like this...");
        System.out.println("1 2 3 4 5 6 ");
        System.out.print("This is your output: ");
        ad1.printDeque();
    }

    @Test
    /** Gets items in a full array. */
    public void getFullTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization.", ad1.isEmpty());

        for (int i = 1; i <= 8; i++) {
            ad1.addLast(i);
        }
        assertEquals("The size should now be eight.", ad1.size(), 8);

        int desiredIndex = ad1.get(7);
        assertEquals("The 7th index should be 8.", 8, desiredIndex);

        int desiredIndex2 = ad1.get(3);
        assertEquals("The 3rd index should be 4.", 4, desiredIndex2);

        int desiredIndex3 = ad1.get(0);
        assertEquals("The 0th index should be 1.", 1, desiredIndex3);
    }

    @Test
    /** Gets an items in an array deque that is not completely full. */
    public void getNotFullTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        for (int i = 1; i <= 4; i++) {
            ad1.addFirst(i);
        }
        assertEquals("The size should now be four", ad1.size(), 4);

        int desiredIndex = ad1.get(1);
        assertEquals("The 1st index should be 3", 3, desiredIndex);

        int desiredIndex2 = ad1.get(3);
        assertEquals("The 3th index should be ", 1, desiredIndex2);
    }

    @Test
    /** Gets an items in a more complex array deque.*/
    public void trickyGetTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        assertNull("There is nothing is this lis so, we should return null.", ad1.get(1));

        for (int i = 1; i <= 4; i++) {
            ad1.addFirst(i);
        }
        assertEquals("The size should now be four", ad1.size(), 4);

        assertNull("The 5th index is out of bounds, we should return null", ad1.get(5));

        ad1.addLast(0);
        assertEquals("The size should now be five", ad1.size(), 5);

        int lastIndex = ad1.get(4);
        assertEquals("The 4th index should be 0", 0, lastIndex);
    }

    @Test
    /** Checks to see if an object is equal to our array deque list, sizes differ here. */
    public void equalsTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        for (int i = 1; i <= 5; i++) {
            ad1.addLast(i);
        }
        boolean b = ad1.equals(ad2);
        assertFalse(b);
    }

    @Test
    /** Checks to see if an object is equal to our array deque list, same objects here.*/
    public void equalsTest2() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        for (int i = 1; i <= 5; i++) {
            ad1.addLast(i);
            ad2.addLast(i);
        }
        boolean b = ad1.equals(ad2);
        assertTrue(b);
    }

    @Test
    /** Checks to see if an object is equal to our array deque list
     * same size lists, different order of objects*/
    public void equalsTest3() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        for (int i = 1; i <= 5; i++) {
            ad1.addLast(i);
            ad2.addFirst(i);
        }
        boolean b = ad1.equals(ad2);
        assertFalse(b);
    }

    @Test
    /** Checks to see if an object is equal to our array deque list,
     * checking the type of objects here
     */
    public void equalsTestTypeChecking() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        for (int i = 1; i <= 5; i++) {
            ad1.addFirst(i);
            lld1.addFirst(i);
        }
        boolean b = ad1.equals(lld1);
        assertTrue(b);
    }

    @Test
    /** Checks to see if item can be removed from the front of a list. */
    public void easyRemoveFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        for (int i = 1; i <= 8; i++) {
            ad1.addFirst(i);
        }

        int removed = ad1.removeFirst();
        assertEquals("The size should now be 7", 7, ad1.size());
        assertEquals("The item removed should be the number 8", 8, removed);


        int newFirst = ad1.get(0);
        assertEquals("The 0th index should now be the number 7", 7, newFirst);
    }

    @Test
    /** Checks to see if item can be removed from the front of a list
     *  when the item is at the internal index 7.*/
    public void circularRemoveFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        for (int i = 1; i <= 2; i++) {
            ad1.addFirst(i);
        }
        int removed = ad1.removeFirst();
        assertEquals("The size should now be 1", 1, ad1.size());
        assertEquals("The item removed should be the number 2", 2, removed);

        int newFirst = ad1.get(0);
        assertEquals("The 0th index should now be the number 1", 1, newFirst);
    }

    @Test
    /** Checks to see if item can be removed from the front of a list when the list is null.*/
    public void removeFirstTestNullList() {
        ArrayDeque<Double> ad1 = new ArrayDeque<Double>();

        ad1.addFirst(1.5);
        double firstItem = ad1.get(0);
        assertEquals("The 0th index should now be the number 1.5.", 1.5, firstItem, 0.0);

        ad1.removeFirst();
        assertNull("The size should now be 0 so nothing can be removed.", ad1.removeFirst());

        assertNull("The list is empty so the 0th index should be null.", ad1.get(0));
    }

    @Test
    /** Checks to see if item can be removed from the end of a list. */
    public void lastRemoveFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization.", ad1.isEmpty());

        for (int i = 1; i <= 8; i++) {
            ad1.addFirst(i);
        }

        int removed = ad1.removeLast();
        assertEquals("The size should now be 7.", 7, ad1.size());
        assertEquals("The item removed should be the number 1.", 1, removed);


        int newLast = ad1.get(6);
        assertEquals("The 6th index should now be the number 2.", 2, newLast);

        int removed2 = ad1.removeLast();
        assertEquals("The size should now be 6.", 6, ad1.size());
        assertEquals("The item removed should be the number 2.", 2, removed2);

    }

    @Test
    /** Checks to see if item can be removed from the end of a list when the list is null. */
    public void addFirstAddLastRemoveLastRemoveFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 3; i > 0; i--) {
            ad1.addFirst(i);
        }
        assertEquals("The size should now be 3.", 3, ad1.size());
        for (int i = 4; i < 7; i++) {
            ad1.addLast(i);
        }
        assertEquals("The size should now be 6.", 6, ad1.size());

        int removed = ad1.removeLast();
        assertEquals("The size should now be 5.", 5, ad1.size());
        assertEquals("The item removed should be the number 6.", 6, removed);

        int removed2 = ad1.removeFirst();
        assertEquals("The size should now be 4.", 4, ad1.size());
        assertEquals("The item removed should be the number 1.", 1, removed2);
    }

    @Test
    /** This method checks to see if the resizeLarger method works correctly,
     * by making the arrayDeque list larger to fit more items. */
    public void resizeLargerTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 1; i <= 9; i++) {
            ad1.addFirst(i);
        }
        assertEquals("The size should now be 9.", 9, ad1.size());
        int first = ad1.get(0);
        assertEquals("Your array should have 9 at its 0th index.", 9, first);
    }

    @Test
    /** This method checks to see if the resizeLarger method works correctly
     * but in a more difficult instance. */
    public void harderResizeLargerTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addFirst(1);
        for (int i = 2; i <= 9; i++) {
            ad1.addLast(i);
        }
        assertEquals("The size should now be 9.", 9, ad1.size());
        int first = ad1.get(0);
        assertEquals("Array should have 1 at its 0th index.", 1, first);

        ad1.addLast(10);
        ad1.addFirst(0);
        ad1.addFirst(-1);

        assertEquals("The size should now be 12.", 12, ad1.size());
        int newFirst = ad1.get(0);
        assertEquals("Your array should have -1 at its 0th index.", -1, newFirst);

        ad1.removeFirst();
        int newerFirst = ad1.get(0);
        assertEquals("Your array should have 0 at its 0th index.", 0, newerFirst);
    }

    @Test
    /** This method checks to see if the resizeLarger method works more than once. */
    public void resizeLargerMoreThanOnceTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addFirst(1);
        for (int i = 2; i <= 1000; i++) {
            ad1.addLast(i);
        }
        assertEquals("The size should now be 1000.", 1000, ad1.size());
    }

    @Test
    /** This method checks to see if the resizeSmaller method works in a simple case. */
    public void resizeSmallerTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 1; i <= 16; i++) {
            ad1.addLast(i);
        }
        for (int i = 1; i <= 13; i++) {
            ad1.removeFirst();
        }
        int newerFirst = ad1.get(0);
        assertEquals("Your array should have 0 at its 0th index.", 14, newerFirst);
    }

    @Test
    /** This method checks to see if the resizeSmaller method works in a simple case. */
    public void testAuto() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        ad1.addFirst(0);
        ad1.addLast(1);
        ad1.addLast(1);
        ad1.addFirst(1);
        ad1.addFirst(1);
        ad1.removeFirst();
        ad1.addLast(6);
        ad1.addFirst(7);
        ad1.removeFirst();
        ad1.addLast(9);
        ad1.addFirst(10);
        ad1.addFirst(11);
        ad1.addFirst(12);
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();
        ad1.addFirst(19);
    }

}
