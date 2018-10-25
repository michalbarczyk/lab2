package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void toStringTest() {

        Vector vector = new Vector(4,6);
        assertEquals("(4, 6)", vector.toString());
    }

    @Test
    public void testSmaller() {

        Vector vect1 = new Vector(4,4);
        Vector vect2 = new Vector(6,9);

        assertTrue(vect1.smaller(vect2));
        assertFalse(vect2.smaller(vect1));
    }

    @Test
    public void larger() {

        Vector vect1 = new Vector(4,4);
        Vector vect2 = new Vector(6,9);

        assertTrue(vect2.larger(vect1));
        assertFalse(vect1.larger(vect2));
    }

    @Test
    public void upperRight() {

        Vector vect1 = new Vector(4,4);
        Vector vect2 = new Vector(6,9);
        assertEquals(new Vector(6, 9), vect1.upperRight(vect2));

        Vector vect3 = new Vector(18,4);
        Vector vect4 = new Vector(6,12);
        assertEquals(vect3.upperRight(vect4), new Vector(18, 12));
        assertEquals(vect4.upperRight(vect3), new Vector(18, 12));
    }

    @Test
    public void lowerLeft() {

        Vector vect1 = new Vector(4,4);
        Vector vect2 = new Vector(6,9);
        assertEquals(new Vector(4, 4), vect1.lowerLeft(vect2));

        Vector vect3 = new Vector(18,4);
        Vector vect4 = new Vector(6,12);
        assertEquals(vect3.lowerLeft(vect4), new Vector(6, 4));
        assertEquals(vect4.lowerLeft(vect3), new Vector(6, 4));
    }

    @Test
    public void add() {

        Vector vect1 = new Vector(4,4);
        Vector vect2 = new Vector(6,9);
        assertEquals(new Vector(10, 13), vect1.add(vect2));
    }

    @Test
    public void equals() {

        Vector vect1 = new Vector(17,-4);
        Vector vect2 = new Vector(17,-4);
        Vector vect3 = new Vector(17,4);

        assertTrue(vect1.equals(vect2));
        assertTrue(vect2.equals(vect1));
        assertFalse(vect1.equals(vect3));
        assertFalse(vect3.equals(vect2));
    }
}