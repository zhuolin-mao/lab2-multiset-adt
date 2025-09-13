import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListMultiSetTest {

    @Test
    public void testIsEmptyTrue() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        assertTrue(b.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(5);
        assertFalse(b.isEmpty());
    }

    @Test
    public void testInsertEmpty() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(4);
        assertTrue(b.contains(4));
    }

    @Test
    public void testInsertNonEmpty() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(10);
        b.add(4);
        assertTrue(b.contains(4));
    }

    @Test
    public void testRemoveRoot() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(10);
        b.remove(10);
        assertFalse(b.contains(10));
        assertTrue(b.isEmpty());
    }

    @Test
    public void testRemoveNonRoot() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(10);
        b.add(4);
        b.remove(4);
        assertFalse(b.contains(4));
    }
    @Test
    public void testSizeEmpty() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        assertEquals(0, b.size());
    }

    @Test
    public void testSizeOne() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(10);
        assertEquals(1, b.size());
    }

    @Test
    public void testSizeNonEmpty() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(10);
        b.add(4);
        b.add(12);
        b.add(13);
        assertEquals(4, b.size());
    }

    @Test
    public void testCountEmpty() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        assertEquals(0, b.count(10));
    }

    @Test
    public void testCountOne() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(11);
        assertEquals(1, b.count(11));
    }

    @Test
    public void testCountNonEmpty() {
        LinkedListMultiSetSol b = new LinkedListMultiSetSol();
        b.add(10);
        b.add(10);
        b.add(12);
        b.add(10);
        b.add(4);
        b.add(10);
        assertEquals(4, b.count(10));
    }


}