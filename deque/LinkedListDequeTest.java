package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
        lld1.addFirst(9);
        lld1.addFirst(8);
		// should not be empty
		assertFalse("lld1 should contain 2 items", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertFalse("lld1 should not be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertNull("Should return null when removeFirst is called on an empty Deque,", lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    //MY TESTS HERE
    @Test
    /** Adds 10 items, and ensures that the first item in the list is the last item added */
    public void addFirstTenTimesTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        for(int i =1; i<= 10; i++){
            lld1.addFirst(i);
        }
        // should not be empty
        assertFalse("lld1 should contain 10 items", lld1.isEmpty());

        // first item should be 10, size should be 9
        assertEquals("The first item of lld1 should be 10", 10, (int) lld1.removeFirst());
        assertEquals("The size should now be 9.", 9, lld1.size());

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addLastRemoveTest() {

        //System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addLast(10);
        lld1.addLast(9);
        lld1.addLast(8);
        // should not be empty
        assertEquals("lld1 should contain 3 items", 3, lld1.size());

        int check = lld1.removeFirst();
        // should be 10
        assertEquals("the item removed should of been 10", 10, check);

        int check2 = lld1.removeFirst();
        // should be 10
        assertEquals("the item removed should of been 10", 9, check2);

    }

    @Test
    /** Adds 10 items, and ensures that the first item in the list is the last item added, repeat for new first item */
    public void addLastRemoveFirst() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        for(int i =1; i<= 10; i++){
            lld1.addLast(i);
        }
        // should not be empty
        assertFalse("lld1 should contain 10 items", lld1.isEmpty());

        // first item should be 1, size should be 9
        assertEquals("The first item of lld1 should be 1", 1, (int) lld1.removeFirst());
        assertEquals("The size should now be 9.", 9, lld1.size());

        // first item should now be 2, size should be 8
        assertEquals("The first item of lld1 should be 2", 2, (int) lld1.removeFirst());
        assertEquals("The size should now be 8.", 8, lld1.size());

    }

    @Test
    /** Prints a deck after some alternations,  */
    public void printDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        for(int i =5; i <= 11; i++) { //adds numbers 5 -10
            lld1.addLast(i);
        }
        System.out.println("here is the deck now..");
        lld1.printDeque();

        for(int i =4; i >= 0; i--){ //adds numbers 0 -4 to deck
            lld1.addFirst(i);
        }
        System.out.println("we have added the numbers 0-4 to the front now..");
        lld1.printDeque();  // should be increasing from 0-10

        lld1.removeLast(); //removes the number 11
        lld1.removeFirst(); // removes the number 0

        System.out.println("after removing 0 and 11, we should have a list from 1-10 increasing!");
        lld1.printDeque(); // should be a list with numbers 1-10
    }

    @Test
    /** Prints a deck with nothing in it,  */
    public void printDequeTestNo2() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());
        System.out.println("This deque is empty, we should not be printing anything out..");
        System.out.print("Our deque looks like: " );
        lld1.printDeque();
    }

    @Test
    /** gets a index from a list */
    public void getTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        for(int i =1; i<= 10; i++){
            lld1.addLast(i);
        }
        System.out.print("Our list is: ");
        lld1.printDeque();
        assertEquals("the list should be of size 10", 10, lld1.size());

        int actual =lld1.get(4);
        assertEquals("the 4th index should be the number 5", 5, actual);

        System.out.print("Our list should remain unchanged. Right now it looks like: ");
        lld1.printDeque();
    }

    @Test
    /** gets a index from a list, numbers are removed, a new index is chosen */
    public void getTest2() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        for(int i =1; i<= 10; i++){
            lld1.addFirst(i);
        }
        System.out.print("Our list is: ");
        lld1.printDeque();
        assertEquals("the list should be of size 10", 10, lld1.size());

        int actual =lld1.get(9);
        System.out.println("We want to get the 9th index of our list. Expected: 1   Actual: "+ actual);
        assertEquals("the 9th index should be the number 1", 1, actual);

        System.out.print("Our list should remain unchanged. Right now it looks like: ");
        lld1.printDeque();

        for (int i = 1; i <=5; i++){
           lld1.removeFirst();
        }
        System.out.print("We removed half the list. Right now it looks like: ");
        lld1.printDeque();

        int secondActual = lld1.get(0);
        System.out.println("We want to get the 0th index of our list. Expected: 5   Actual: "+ secondActual);
        assertEquals("the 0th index should be the number 5", 5, secondActual);

        System.out.print("Our list should remain unchanged. Right now it looks like: ");
        lld1.printDeque();
    }

    @Test
    /** gets a index from unattainable indexes */
    public void getTest3() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.get(1);
        assertNull("We should expect null back because the list is empty.", lld1.get(1));

        for(int i =1; i<= 1000; i++){
            lld1.addLast(i);
        }
        lld1.get(1001);
        assertNull("We should expect null back because 1001 is an unattainable index.", lld1.get(1001));
    }


    @Test
    /** gets a index from a list using recursion */
    public void getRecursiveTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        for(int i =1; i<= 10; i++){
            lld1.addLast(i);
        }
        System.out.print("Our list is: ");
        lld1.printDeque();
        assertEquals("the list should be of size 10", 10, lld1.size());

        int actual =lld1.getRecursive(4);
        assertEquals("the 4th index should be the number 5", 5, actual);

        System.out.print("Our list should remain unchanged. Right now it looks like: ");
        lld1.printDeque();
    }



    @Test
    /** gets a index from a list, numbers are removed, a new index is chosen */
    public void getRecursiveTest2() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        for(int i =1; i<= 10; i++){
            lld1.addFirst(i);
        }
        System.out.print("Our list is: ");
        lld1.printDeque();

        int actual =lld1.getRecursive(9);
        System.out.println("We want to get the 9th index of our list. Expected: 1   Actual: "+ actual);
        assertEquals("the 9th index should be the number 1", 1, actual);

        System.out.print("Our list should remain unchanged. Right now it looks like: ");
        lld1.printDeque();

        for (int i = 1; i <=5; i++){
            lld1.removeFirst();
        }
        System.out.print("We removed half the list. Right now it looks like: ");
        lld1.printDeque();

        int secondActual = lld1.getRecursive(0);
        System.out.println("We want to get the 0th index of our list. Expected: 5   Actual: "+ secondActual);
        assertEquals("the 0th index should be the number 5", 5, secondActual);

        System.out.print("Our list should remain unchanged. Right now it looks like: ");
        lld1.printDeque();
    }

    @Test
    /** gets a index from unattainable indexes */
    public void getRecursiveTest3() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.getRecursive(1);
        assertNull("We should expect null back because the list is empty.", lld1.get(1));

        for(int i =1; i<= 1000; i++){
            lld1.addLast(i);
        }
        lld1.getRecursive(1001);
        assertNull("We should expect null back because 1001 is an unattainable index.", lld1.get(1001));
    }

    @Test
    /** checks to see if an object is equal to our LLD list*/
    public void equalsTest() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        for(int i =1; i<= 5; i++){
            lld1.addLast(i);
        }
        boolean b = lld1.equals(lld2);
        assertFalse(b);
    }

    @Test
    /** checks to see if an object is equal to our LLD list*/
    public void equalsTest2() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();

        for(int i =1; i<= 5; i++){
            lld1.addLast(i);
            lld2.addLast(i);
        }
        boolean b = lld1.equals(lld2);
        assertTrue(b);
    }

    @Test
    /** checks to see if an object is equal to our LLD list*/
    public void equalsTest3() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();

        for(int i =1; i<= 5; i++){
            lld1.addLast(i);
            lld2.addFirst(i);
        }
        boolean b = lld1.equals(lld2);
        assertFalse(b);
    }


    }
