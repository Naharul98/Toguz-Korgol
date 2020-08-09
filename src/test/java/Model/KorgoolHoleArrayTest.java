package Model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class KorgoolHoleArrayTest {
    @Test
    public void testKorgoolHolesLength() {
        assertEquals(18, (new KorgoolHoleArray()).size());
    }

    @Test
    public void testDefaultNumberOfKorgoolsInArray() {
        for (KorgoolHole korgoolHole : new KorgoolHoleArray()) {
            assertEquals(9, korgoolHole.getNumberOfKorgools());
        }
    }

    @Test
    public void testKorgoolHoleArrayBuilder() {
        List<Integer> korgoolCount = new ArrayList<>(18);
        for (int i = 0; i <= 17; i++) {
            korgoolCount.add(new Random().nextInt());
        }
        KorgoolHoleArray korgoolHoleArray = new KorgoolHoleArray.Builder().build(korgoolCount);
        for (int i = 0; i < korgoolHoleArray.size(); i++) {
            assertArrayEquals(korgoolCount.toArray(),
                    korgoolHoleArray.stream()
                        .map(korgoolHole -> korgoolHole.getNumberOfKorgools())
                        .toArray());
        }
    }

    @Test
    public void testPersonTuzAndAiTuzAreSet() {
        int personTuz = ThreadLocalRandom.current().nextInt(0, 8),
                aiTuz = ThreadLocalRandom.current().nextInt(8, 18);

        KorgoolHoleArray korgoolHoleArray = new KorgoolHoleArray.Builder()
                .setPersonTuz(personTuz)
                .setAiTuz(aiTuz)
                .build();
        assertEquals(true, korgoolHoleArray.get(personTuz).isTuz());
        assertEquals(true, korgoolHoleArray.get(aiTuz).isTuz());
    }
}
