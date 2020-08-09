package util;

import java.io.File;

final public class Constants {
    public static final File FULL_DIRECTORY;
    public static final File GAME_SAVE_FILE;
    public static final File LABELS_FILE;

    /**
     * Sets the values for project wide cconstants.
     */
    static {
        File PROJECT_DIRECTORY = new File(".");
        String DIRECTORY_NAME = "src/main/java/.app";

        FULL_DIRECTORY = new File(PROJECT_DIRECTORY + File.separator + DIRECTORY_NAME);

        GAME_SAVE_FILE = new File( FULL_DIRECTORY + File.separator + "game.save");
        LABELS_FILE = new File(FULL_DIRECTORY + File.separator + "korgool-hole-labels");
    }

    private Constants(){}
}
