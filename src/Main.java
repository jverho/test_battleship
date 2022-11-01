import java.util.ArrayList;
import java.util.Arrays;
import Grid.*;
import Turn.Turn;

public class Main {
    public static void main(String[] args) {
        //checks if the coordinate has been entered correctly and if the coordinate has been hit
        //if the cell can be shot, it returns true
        new Grid();
        /*InputCheck.checkShot("A3"); //true
        Grid.targetcells.shotSet("B6",true);
        InputCheck.checkShot("B6"); //false
        Grid.targetcells.boatSet("C1", true);
        Ship carrier1 = new Ship(ShipType.CARRIER, null);
        InputCheck.checkPlacementShip("A9,A3", carrier1);
        InputCheck.checkPlacementShip("A1,F1", carrier1);
        */
        //starts the game, asks the user to enter coordinates of the ships, does nothing for the computer yet
        //Turn.startTurn();
        Turn.startTurnShips();


    }
}