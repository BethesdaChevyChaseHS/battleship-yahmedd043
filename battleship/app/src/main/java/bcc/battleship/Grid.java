package bcc.battleship;

public class Grid {
    private Location[][] grid;
    
    // Create a new Grid and initialize each Location.
    public Grid() {
        grid = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                grid[i][j] = new Location();
            }
        }
    }
    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
       grid[row][col].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        grid[row][col].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        grid[row][col].setStatus(status);
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return grid[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        if (grid[row][col].getStatus() != Constants.UNGUESSED)
        {
            return true;
        }
        return false;
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        grid[row][col].setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return grid[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return grid[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return Constants.NUM_ROWS;
    }
    
    // Return the number of columns.
    public int numCols() {
        return Constants.NUM_COLS;
    }

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        if (s.getDirection() == Constants.HORIZONTAL && s.getCol() + s.getLength() < grid[0].length)
        {
            for (int i = s.getCol(); i < s.getCol() + s.getLength(); i++)
            {
                if (grid[s.getRow()][i].hasShip())
                {
                    return false;
                }
            }
            for (int i = s.getCol(); i < s.getCol() + s.getLength(); i++)
            {
                grid[s.getRow()][i].setShip(true);
            }
            return true;
        }
        else if (s.getDirection() == Constants.VERTICAL && s.getRow() + s.getLength() < grid.length)
        {
            for (int i = s.getRow(); i < s.getRow() + s.getLength(); i++)
            {
                if (grid[i][s.getCol()].hasShip())
                {
                    return false;
                }
            }
            for (int i = s.getRow(); i < s.getRow() + s.getLength(); i++)
            {
                grid[i][s.getCol()].setShip(true);
            }
            return true;
        }
        return false;
    }

    public boolean allShipsSank(){
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j].hasShip() && !grid[i][j].checkHit())
                {
                    return false;
                }
            }
        }
        return true;
    }
}
