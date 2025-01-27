import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class LinkedListTest {

    /**
     * Tests for the add(T element) method in the LinkedList class.
     * This method appends the provided element to the end of the linked list.
     */

    @Test
    public void testAddSingleElement() {
        LinkedList<String> list = new LinkedList<>();
        boolean result = list.add("A");
        assertTrue(result);
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testAddMultipleElements() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(Optional.of(10), list.get(0));
        assertEquals(Optional.of(20), list.get(1));
        assertEquals(Optional.of(30), list.get(2));
    }

    /**
     * Tests for the add(int index, T element) method in the LinkedList class.
     * This method inserts the element at the specified index in the linked list.
     */

    @Test
    public void testAddAtSpecificIndex() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testAddAtZeroIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0, 10);

        assertEquals(2, list.size());
        assertEquals(Optional.of(10), list.get(0));
        assertEquals(Optional.of(20), list.get(1));
    }

    @Test
    public void testAddAtEndIndex() {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add(2, 'C');

        assertEquals(3, list.size());
        assertEquals(Optional.of('A'), list.get(0));
        assertEquals(Optional.of('B'), list.get(1));
        assertEquals(Optional.of('C'), list.get(2));
    }

    @Test
    public void testAddThrowsExceptionForInvalidIndex() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "B"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, "B"));
    }
}