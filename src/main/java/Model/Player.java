package Model;

/**
 *  This class models the player in the game
 *  Players have a Name, and a boolean flag indicating which side of the board he/she is on
 */
class Player {
    private String name;
    private boolean isInWhiteSide;


    /**
     * Creates a Player object for the game
     * @param name The name of the Player - Must Not Be NULL
     * @param isInWhiteSide boolean flag to set whether the player object is in the white side of the board or not
     */
    public Player(String name,boolean isInWhiteSide) {
        this.name = name;
        this.isInWhiteSide = isInWhiteSide;

    }

    /**
     * Get whether the player is on the white side of the board or not
     * @return Whether the player is on the white side of the board or not
     */
    public boolean getIsInWhiteSide() {
        return isInWhiteSide;
    }

    /**
     * Get the name of the Player
     * @return The name of the player
     */
    public String getPlayerName() {
        return name;
    }

    /**
     * Sets the name of the player
     * @param name The name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets whether the player is in the white side of the board or not
     * @param flag Whether the player is in white side or not
     */
    public void setIsOnWhiteSide(boolean flag) {
        this.isInWhiteSide = flag;
    }

}
