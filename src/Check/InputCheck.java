package Check;
import Grid.*;

public class InputCheck {
    public static boolean checkShot(String coordinate, boolean ai, Cellgrid side) {
        if (coordinate.length() != 2){
            if  (!ai) System.out.println("Coordinate should contain 2 characters");
            return false;
        }
        else {
            String[] arrofStrShot = coordinate.split("");
            String check_letter = arrofStrShot[0];
            String check_number = arrofStrShot[1];
            String letters = "ABCDEFGHIJ";
            String numbers = "1234567890";
            if (!letters.contains(check_letter)) {
                if  (!ai)System.out.println("First part of coordinates must contain one of these letters: ABCDEFGHIJ");
                return false;
            }
            if (!numbers.contains(check_number)){
                if  (!ai)System.out.println("Second part of coordinates must contain one os these numbers: 0123456789");
                return false;
            } else if (side.shotGet(coordinate, side)){
                if  (!ai)System.out.printf("The coordinate %s has been hit already\n", coordinate);
                return false;
            }
        }
        return true;
    }

    public static boolean checkPlacement(String from_to, int currentShipLength, Cellgrid side, boolean ai){
        if (from_to.length() != 5){
            if  (!ai)System.out.println("Entry should contain 5 characters");
            return true;
        }
        else{
            if (!from_to.contains(",")){
                if  (!ai)System.out.println("Entry must contain a , to separate coordinates");
                return true;
            }
            String[] arrofStrPl = from_to.split(",");
            String firstCoord = arrofStrPl[0];
            String secondCoord = arrofStrPl[1];
            if (!checkShot(firstCoord, ai, side)){return true;}
            if (!checkShot(secondCoord, ai, side)){return true;}
            char firstCoordLetter = firstCoord.charAt(0);
            String[] firstCoordList = firstCoord.split("");
            int firstCoordNumber = Integer.parseInt(firstCoordList[1]);
            char secondCoordLetter = secondCoord.charAt(0);
            String[] secondCoordList = secondCoord.split("");
            int secondCoordNumber = Integer.parseInt(secondCoordList[1]);

            if (firstCoordLetter != secondCoordLetter && firstCoordNumber != secondCoordNumber){
                if  (!ai)System.out.println("Ships can not be placed diagonally");
                return true;
            }
            if (Math.abs(firstCoordLetter - secondCoordLetter) != currentShipLength -1  &&
                    Math.abs(firstCoordNumber -secondCoordNumber) != currentShipLength - 1){
                if  (!ai)System.out.println("Ship does not fit into coordinates entered");
                return true;
            }
            String [] allCoordinates = getallCoordinates(from_to);
            for (String allCoordinate : allCoordinates) {
                if (Cellgrid.boatGet(allCoordinate, side)) {
                    if  (!ai)System.out.println("There is already a ship placed in that spot.");
                    return true;
                }
            }
        }
        return false;
    }
    public static String[] getallCoordinates(String str){
        StringBuilder coords = new StringBuilder();
        String[] arrofStrPl = str.split(",");
        String firstCoord = arrofStrPl[0];
        String secondCoord = arrofStrPl[1];
        char firstCoordLetter = firstCoord.charAt(0);
        String[] firstCoordList = firstCoord.split("");
        int firstCoordNumber = Integer.parseInt(firstCoordList[1]);
        char secondCoordLetter = secondCoord.charAt(0);
        String[] secondCoordList = secondCoord.split("");
        int secondCoordNumber = Integer.parseInt(secondCoordList[1]);
        String letters = "ABCDEFGHIJ";

        if (firstCoordLetter == secondCoordLetter){
            if (firstCoordNumber < secondCoordNumber){
                for (int i = 0; i < Math.abs(firstCoordNumber -secondCoordNumber); i++) {
                    coords.append(firstCoordLetter).append(firstCoordNumber+i).append(",");}
                coords.append(secondCoord);
                return coords.toString().split(",");
            }

            if (firstCoordNumber > secondCoordNumber){
                for (int i = 0; i < Math.abs(firstCoordNumber -secondCoordNumber); i++) {
                    coords.append(firstCoordLetter).append(secondCoordNumber+i).append(",");}
                coords.append(firstCoord);
                return coords.toString().split(",");
            }
        }

        if (firstCoordNumber == secondCoordNumber){
            if (letters.indexOf(firstCoordLetter) < letters.indexOf(secondCoordLetter)) {
                for (int i = 0; i < Math.abs(firstCoordLetter - secondCoordLetter); i++)
                    coords.append(letters.charAt(letters.indexOf(firstCoordLetter) + i)).append(firstCoordNumber).append(",");
                coords.append(secondCoord);
                return coords.toString().split(",");
            }
            if (letters.indexOf(firstCoordLetter) > letters.indexOf(secondCoordLetter)) {
                for (int i = 0; i < Math.abs(firstCoordLetter - secondCoordLetter); i++)
                    coords.append(letters.charAt(letters.indexOf(secondCoordLetter) + i)).append(firstCoordNumber).append(",");
                coords.append(firstCoord);
                return coords.toString().split(",");
            }
        }
        coords.append(secondCoord);
        return coords.toString().split(",");
    }
}
