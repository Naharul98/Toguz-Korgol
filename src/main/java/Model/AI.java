package Model;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public final class AI {
    /**
     * Picks a random move.
     *
     * @param korgoolHoles All korgools holes in the game.
     * @return int optimal move
     */
    public static int easyMove(final List<KorgoolHole> korgoolHoles) {
        return Lists.reverse(korgoolHoles)
                .stream()
                .filter(korgoolHole -> korgoolHole.getNumberOfKorgools() > 0 && korgoolHole.getId() >= 9)
                .mapToInt(korgoolHole -> korgoolHole.getId())
                .findFirst()
                .orElse(-1);
    }

    /**
     * Finds optimal move based on max number of korgools.
     *
     * @param korgoolHoles All korgools holes in the game.
     * @return int optimal move
     */
    public static int mediumMove(final List<KorgoolHole> korgoolHoles) {
        return Lists.reverse(korgoolHoles)
                .stream()
                .filter(korgoolHole -> korgoolHole.getNumberOfKorgools() > 0 && korgoolHole.getId() >= 9)
                .sorted(Comparator.comparing(KorgoolHole::getNumberOfKorgools).reversed())
                .mapToInt(korgoolHole -> korgoolHole.getId())
                .findFirst()
                .orElse(-1);
    }

    /**
     * Finds optimal move based on collecting tuz, or collecting korgools in final position.
     *
     * @param korgoolHoles All korgools holes in the game.
     * @return int optimal move
     */
    public static int hardMove(final List<KorgoolHole> korgoolHoles) {
        return korgoolHoles.stream()
                .filter(korgoolHole -> korgoolHole.getNumberOfKorgools() > 0 && korgoolHole.getId() >= 9)
                .max(Comparator.comparing(korgoolHole -> findNumberOfKorgoolsCollected((KorgoolHole) korgoolHole, korgoolHoles)))
                .get()
                .getId();
    }

    /**
     * Finds weight of move from current korgool.
     *
     * @param currentKorgoolHole Position to check weight for.
     * @param korgoolHoles All korgools holes in the game.
     * @return weight of move.
     */
    private static int findNumberOfKorgoolsCollected(KorgoolHole currentKorgoolHole, List<KorgoolHole> korgoolHoles) {
        int finalIndex;

        int numberOfKorgools = currentKorgoolHole.getNumberOfKorgools();

        if (numberOfKorgools == 1) {
            finalIndex = currentKorgoolHole.getId() + 1;
        } else {
            finalIndex = (currentKorgoolHole.getId() + numberOfKorgools) % 18;
        }

        if (finalIndex >= 9) {
            return 0;
        }

        int finalIndexNumberOfKorgools = korgoolHoles.get(finalIndex).getNumberOfKorgools();

        return finalIndexNumberOfKorgools % 2 == 1 ?
                numberOfKorgools + finalIndexNumberOfKorgools : 0;
    }
}
