package bcc.battleship;

public class Location {
    // Instance variables
    boolean hasShip;
    int status;

    // Constructor. Initializes with no ship and status UNGUESSED.
    public Location() {
        hasShip = false;
        status = Constants.UNGUESSED;
    }

    // Was this Location a hit?
    public boolean checkHit() {
        if (status == Constants.HIT)
        {
            return true;
        }
        return false;
    }

    // Was this location a miss?
    public boolean checkMiss() {
        if (status == Constants.MISSED)
        {
            return true;
        }
        return false;
    }

    // Was this location unguessed?
    public boolean isUnguessed() {
        if (status == Constants.UNGUESSED)
        {
            return true;
        } 
        return false;
    }

    // Mark this location as a hit.
    public void markHit() {
        status = Constants.HIT;
    }

    // Mark this location as a miss.
    public void markMiss() {
        status = Constants.MISSED;
    }

    // Return whether or not this location has a ship.
    public boolean hasShip() {
        return hasShip;
    }

    // Set whether this location has a ship.
    public void setShip(boolean val) {
        hasShip = val;
    }

    // Set the status of this Location.
    public void setStatus(int status) {
        this.status = status;
    }

    // Get the status of this Location.
    public int getStatus() {
        return status;
    }
}
