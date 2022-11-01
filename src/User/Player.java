package User;

import Check.InputCheck;
import Grid.Grid;
import Ship.Ship;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static void placeShip(String from_to, Ship currentShip){
        //only for targetcells at the moment
        char firstCoordLetter = from_to.charAt(0);
        char secondCoordLetter = from_to.charAt(3);
        int firstCoordNumber = Integer.parseInt(String.valueOf(from_to.charAt(1)));
        int secondCoordNumber = Integer.parseInt(String.valueOf(from_to.charAt(4)));
        //place ship on a column
        if (from_to.charAt(0) == from_to.charAt(3)) {
            //generate list with the coordinates
            int startPointColumn = Math.min(firstCoordNumber, secondCoordNumber);
            ArrayList<String> shipCoordinatesColumn = new ArrayList<>();
            for (int i = 0; i < currentShip.getShiptype().getCells(); i++) {
                shipCoordinatesColumn.add(String.format(from_to.charAt(0) + "%d", startPointColumn));
                startPointColumn++;
            }
            //place the ship on the coordinates
            for (String coord: shipCoordinatesColumn) {
                Grid.oceancells.boatSet(coord, true);
                Grid.oceancells.symbolSet(coord, currentShip.getShiptype().getPlaceholder());
            }
        }
        //place ship on a row
        else if (from_to.charAt(1) == from_to.charAt(4)){
            int startPointRow = Math.min(firstCoordLetter, secondCoordLetter);
            ArrayList<String> shipCoordinatesRow = new ArrayList<>();
            for (int i = 0; i < currentShip.getShiptype().getCells(); i++){
                char x = (char) startPointRow;
                shipCoordinatesRow.add(String.format("%c"+"%d", x, firstCoordNumber));
                startPointRow++;
            }
            //place the ship on the coordinates
            for (String coord: shipCoordinatesRow) {
                Grid.oceancells.boatSet(coord, true);
                Grid.oceancells.symbolSet(coord, currentShip.getShiptype().getPlaceholder());
            }
        }
    }
    public static void shootAt(String coord){
        if (InputCheck.checkShot(coord)){
            System.out.println("somehow reset the thing");
        }
        Grid.targetcells.shotSet(coord,true);
        Grid.targetcells.symbolSet(coord,"X");
    }
}
