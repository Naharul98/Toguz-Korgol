package Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit test class for the KorgoolHole class.
 */
public class KorgoolHoleTest {
    /*
    Default constructor test.
     */
    @Test
    public void defaultConstructorReturnsNonTuzNineKorgools() {
        KorgoolHole korgoolHole = new KorgoolHole(-1);
        assertEquals(9, korgoolHole.getNumberOfKorgools());
        assertFalse(korgoolHole.isTuz());
    }

    /*
    Auxiliary constructor tests.
     */
    @Test
    public void testAuxiliaryConstructorZeroFalse() {
        KorgoolHole korgoolHole = new KorgoolHole(0,-1, false);
        assertEquals(0, korgoolHole.getNumberOfKorgools());
        assertFalse(korgoolHole.isTuz());
    }

    @Test
    public void testAuxiliaryConstructorOneTrue() {
        KorgoolHole korgoolHole = new KorgoolHole(1, -1, true);
        assertEquals(1, korgoolHole.getNumberOfKorgools());
        assertTrue(korgoolHole.isTuz());
    }

    @Test
    public void testAuxiliaryConstructorMinusOneFalse() {
        KorgoolHole korgoolHole = new KorgoolHole(-1, -1, false);
        assertEquals(-1, korgoolHole.getNumberOfKorgools());
        assertFalse(korgoolHole.isTuz());
    }

    @Test
    public void testAuxiliaryConstructorMaxIntTrue() {
        KorgoolHole korgoolHole = new KorgoolHole(Integer.MAX_VALUE, -1, true);
        assertEquals(Integer.MAX_VALUE, korgoolHole.getNumberOfKorgools());
        assertTrue(korgoolHole.isTuz());
    }

    /*
    Set number of korgools tests.
     */
    @Test
    public void testKorgoolHoleSetKorgoolsToZero() {
        KorgoolHole korgoolHole = new KorgoolHole(-1);
        korgoolHole.setNumberOfKorgools(0);
        assertEquals(0, korgoolHole.getNumberOfKorgools());
    }

    @Test
    public void testKorgoolHoleSetKorgoolsToOne() {
        KorgoolHole korgoolHole = new KorgoolHole(-1);
        korgoolHole.setNumberOfKorgoolsToOne();
        assertEquals(1, korgoolHole.getNumberOfKorgools());
    }

    @Test
    public void testKorgoolHoleSetKorgoolsToMinusOne() {
        KorgoolHole korgoolHole = new KorgoolHole(-1);
        korgoolHole.setNumberOfKorgools(-1);
        assertEquals(-1, korgoolHole.getNumberOfKorgools());
    }

    @Test
    public void testKorgoolHoleClearKorgools() {
        KorgoolHole korgoolHole = new KorgoolHole(-1);
        korgoolHole.clearKorgools();
        assertEquals(0, korgoolHole.getNumberOfKorgools());
    }

    /*
    Set tuz tests.
     */
    @Test
    public void testKorgoolHoleSetTuz() {
        KorgoolHole korgoolHole = new KorgoolHole(-1);
        korgoolHole.setTuz();
        assertTrue(korgoolHole.isTuz());
    }
}
