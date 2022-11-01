import java.util.ArrayList;
import java.util.Arrays;

import Check.InputCheck;
import Grid.*;
import Turn.Turn;

public class Main {
    public static void main(String[] args) {
        //checks if the coordinate has been entered correctly and if the coordinate has been hit
        //if the cell can be shot, it returns true
        new Grid();
        //starts the game, asks the user to enter coordinates of the ships, does nothing for the computer yet
        //Turn.startTurn();
        Turn.startTurnShips();


    }
}