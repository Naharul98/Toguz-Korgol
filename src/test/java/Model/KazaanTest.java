package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for the Kazaan class.
 */
public class KazaanTest {
    /*
    Default constructor test.
     */
    @Test
    public void defaultKazaanConstructorReturnsZeroKorgools() {
        Kazaan kazaan = new Kazaan();
        assertEquals(0, kazaan.getNumberOfKorgools());
    }

    /*
    Auxiliary constructor tests.
     */
    @Test
    public void testKazaanAuxiliaryConstructorZero() {
        Kazaan kazaan = new Kazaan(0);
        assertEquals(0, kazaan.getNumberOfKorgools());
    }

    @Test
    public void testKazaanAuxiliaryConstructorOne() {
        Kazaan kazaan = new Kazaan(1);
        assertEquals(1, kazaan.getNumberOfKorgools());
    }

    @Test
    public void testKazaanAuxiliaryConstructorMinusOne() {
        Kazaan kazaan = new Kazaan(-1);
        assertEquals(-1, kazaan.getNumberOfKorgools());
    }

    /*
    Set korgools tests.
     */
    @Test
    public void testKazaanSetKorgoolsZero() {
        Kazaan kazaan = new Kazaan();
        kazaan.setNumberOfKorgools(0);
        assertEquals(0, kazaan.getNumberOfKorgools());
    }

    @Test
    public void testKazaanSetKorgoolsOne() {
        Kazaan kazaan = new Kazaan();
        kazaan.setNumberOfKorgools(1);
        assertEquals(1, kazaan.getNumberOfKorgools());
    }

    @Test
    public void testKazaanSetKorgoolsMinusOne() {
        Kazaan kazaan = new Kazaan();
        kazaan.setNumberOfKorgools(-1);
        assertEquals(-1, kazaan.getNumberOfKorgools());
    }
}
