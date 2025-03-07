package bcc.battleship;
import bcc.battleship.Constants;

public class Player {
    private Ship[] playerShips = new Ship[5];
    private Grid myGrid = new Grid();
    private Grid opponentGrid = new Grid();

    // Constructor: Initialize the grids and the ships.
    public Player() {
        for (int i = 0; i < playerShips.length; i++)
        {
            playerShips[i] = new Ship(Constants.SHIP_LENGTHS[i]);
        }
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        playerShips[index].setLocation(row, col);
        playerShips[index].setDirection(direction);
        return myGrid.addShip(playerShips[index]);
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        if (myGrid.hasShip(row, col))
        {
            myGrid.markHit(row, col);
            return true;
        }
        myGrid.markMiss(row, col);
        return false;
    }
    
    public Grid getMyGrid() {
        return myGrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}