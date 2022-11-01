package Check;
import Grid.Grid;
import Ship.*;
import java.util.ArrayList;


public class InputCheck {
    public static boolean checkShot(String coordinate) {
        if (coordinate.length() != 2){
            System.out.println("coordinate should contain 2 characters");
            return false;
        }
        else {
            String[] arrofStrShot = coordinate.split("");
            String check_letter = arrofStrShot[0];
            String check_number = arrofStrShot[1];
            String letters = "ABCDEFGHIJ";
            String numbers = "1234567890";
            if (!letters.contains(check_letter)) {
                System.out.println("first part of coordinates must contain one of these letters: ABCDEFGHIJ");
                return false;
            }
            if (!numbers.contains(check_number)){
                System.out.println("second part of coordinates must contain one os these numbers: 0123456789");
                return false;
            } else if (Grid.targetcells.shotGet(coordinate)){
                System.out.printf("the coordinate %s has been hit already\n", coordinate);
                return false;
            }
            //also add a check for the computer depending on implementation
        }
        return true;
    }

    public static boolean checkPlacement(String from_to, int currentShipLength){
        if (from_to.length() != 5){
            System.out.println("entry should contain 5 characters");
            return false;
        }
        else{
            if (!from_to.contains(",")){
                System.out.println("entry must contain a , to separate coordinates");
                return false;
            }
            String[] arrofStrPl = from_to.split(",");
            String firstCoord = arrofStrPl[0];
            String secondCoord = arrofStrPl[1];
            char firstCoordLetter = firstCoord.charAt(0);
            String[] firstCoordList = firstCoord.split("");
            int firstCoordNumber = Integer.parseInt(firstCoordList[1]);
            char secondCoordLetter = secondCoord.charAt(0);
            String[] secondCoordList = secondCoord.split("");
            int secondCoordNumber = Integer.parseInt(secondCoordList[1]);

            //nothing has been hit, checkShot can be used to check correctness of placement coordinates
            if (!checkShot(firstCoord)){
                return false;
            }
            if (!checkShot(secondCoord)){
                return false;
            }
            //checks that the ship is not placed diagonally
            if (firstCoordLetter != secondCoordLetter && firstCoordNumber != secondCoordNumber){
                System.out.println("Ships can not be placed diagonally");
                return false;
            }
            //checks that the ship has the right length
            if (Math.abs(firstCoordLetter-secondCoordLetter) != currentShipLength &&
                    Math.abs(firstCoordNumber-secondCoordNumber) != currentShipLength){
                System.out.println("Ship does not fit into coordinates entered");
                return false;
            }
            //check if a boat is already on the coordinates
        }
        return true;
    }


    public static boolean checkPlacementShip(String from_to, Ship currentShip){
        if (from_to.length() != 5){
            System.out.println("entry should contain 5 characters");
            return false;
        }
        else{
            if (!from_to.contains(",")){
                System.out.println("entry must contain a , to separate coordinates");
                return false;
            }
            String[] arrofStrPl = from_to.split(",");
            String firstCoord = arrofStrPl[0];
            String secondCoord = arrofStrPl[1];
            char firstCoordLetter = firstCoord.charAt(0);
            String[] firstCoordList = firstCoord.split("");
            int firstCoordNumber = Integer.parseInt(firstCoordList[1]);
            char secondCoordLetter = secondCoord.charAt(0);
            String[] secondCoordList = secondCoord.split("");
            int secondCoordNumber = Integer.parseInt(secondCoordList[1]);

            //nothing has been hit, checkShot can be used to check correctness of placement coordinates
            if (!checkShot(firstCoord)){
                return false;
            }
            if (!checkShot(secondCoord)){
                return false;
            }
            //checks that the ship is not placed diagonally
            if (firstCoordLetter != secondCoordLetter && firstCoordNumber != secondCoordNumber){
                System.out.println("Ships can not be placed diagonally");
                return false;
            }
            //checks that the ship has the right length
            if (Math.abs(firstCoordLetter-secondCoordLetter) != (currentShip.getShiptype().getCells()-1) &&
                    Math.abs(firstCoordNumber-secondCoordNumber) != (currentShip.getShiptype().getCells()-1)) {
                System.out.println("Ship does not fit into coordinates entered");
                return false;
            }

            //check if there is a boat on coordinates for column
            if (firstCoordLetter == secondCoordLetter){
                int startpoint = Math.min(firstCoordNumber, secondCoordNumber);
                ArrayList<String> shipCoordinates = new ArrayList<>();
                for (int i = 0; i < currentShip.getShiptype().getCells(); i++){
                    shipCoordinates.add(String.format(firstCoordLetter+"%d", startpoint));
                    startpoint++;
                }
                for (String coord: shipCoordinates) {
                    if (Grid.targetcells.boatGet(coord)) {
                        System.out.printf("there is already a ship on %s\n", coord);
                        return false;
                    }
                }
            }
            //check if there is a boat on coordinates for row
            if (firstCoordNumber == secondCoordNumber){
                int startPoint = Math.min(firstCoordLetter, secondCoordLetter);
                ArrayList<String> shipCoordinatesRow = new ArrayList<>();
                for (int i = 0; i < currentShip.getShiptype().getCells(); i++){
                    char x = (char) startPoint;
                    shipCoordinatesRow.add(String.format("%c"+"%d", x, firstCoordNumber));
                    startPoint++;
                }
                for (String coord: shipCoordinatesRow) {
                    if (Grid.targetcells.boatGet(coord)) {
                        System.out.printf("there is already a ship on %s\n", coord);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}