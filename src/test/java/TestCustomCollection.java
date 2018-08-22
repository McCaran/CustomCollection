import andersen.Georgiiev.CustomCollection;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;

public class TestCustomCollection {
    CustomCollection<Number> customCollection;
    @Before
    public void setUp() {
        customCollection = new CustomCollection<>();
    }

    @Test
    public void testAdd() {
        assertTrue("Adding element went wrong",customCollection.add(5));

    }

    @Test
    public void testAddByIndex() {
        customCollection.add(3);
        customCollection.add(5);
        customCollection.add(7);
        assertTrue("Adding element by index went wrong",
                customCollection.add(1, 3));
        assertFalse("Invalid index check failed",
                customCollection.add(5, 3.9));
    }

    @Test
    public void testGet() {
        customCollection.add(1);
        customCollection.add(5);
        customCollection.add(-3L);
        assertEquals("Getting element went wrong",
                5, customCollection.get(1));
        assertEquals("Invalid index check failed",
                null, customCollection.get(7));
    }

    @Test
    public void testRemove() {
        customCollection.add(4);
        customCollection.add(5);
        customCollection.add(7);
        assertTrue("Deleting an element went wrong",
                customCollection.remove(4));
        assertFalse("Invalid index check failed",
                customCollection.remove(3));
    }

    @Test
    public void testRemoveByIndex() {
        customCollection.add(4.4);
        assertTrue("Removing by index went wrong",
                customCollection.removeByIndex(0));
        assertFalse("Invalid index check failed",
                customCollection.removeByIndex(5));
    }

    @Test
    public void testContains() {
        customCollection.add(4L);
        assertTrue("Existing element not found",
                customCollection.contains(4L));
        assertFalse("Non-existing element found",
                customCollection.contains(4.0));
    }

    @Test
    public void testClear() {
        customCollection.add(4);
        customCollection.add(5);
        customCollection.add(6);
        customCollection.add(7);
        customCollection.clear();
        assertEquals("Clearing failed",
                0, customCollection.getSize());
    }

    @Test
    public void testTrimToSize() {
        for (int i = 0; i < 20; i ++) {
            customCollection.add(i);
        }
        assertTrue("Trimming went wrong",
                customCollection.trimToSize());
    }

    @Test
    public void testGetAverage() {
        customCollection.add(4);
        customCollection.add(5);
        assertEquals("Average calculation went wrong",
                4.5, customCollection.getAverage());
    }

    @Test
    public void testGetMax() {
        customCollection.add(1);
        customCollection.add(-1);
        customCollection.add(5);
        customCollection.add(-7);
        assertEquals("Wrong maximum value",
                5, customCollection.getMax());
    }

    @Test
    public void testGetMin() {
        customCollection.add(1);
        customCollection.add(-1);
        customCollection.add(5);
        customCollection.add(-7);
        assertEquals("Wrong minimal value",
                -7, customCollection.getMin());
    }

    @Test
    public void testGetSize() {
        customCollection.add(1);
        customCollection.add(0);
        customCollection.add(0);
        assertEquals("Wrong size",
                3, customCollection.getSize());
    }

    @Test
    public void testIsEmpty() {
        assertTrue("Empty collection is not empty",
                customCollection.isEmpty());
    }
}
