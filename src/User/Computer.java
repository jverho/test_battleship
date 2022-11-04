package User;
import Grid.*;
import Ship.*;
import Check.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Computer {
    private final static Cellgrid ownSide = Grid.targetcells;
    private static final Cellgrid targetSide = Grid.oceancells;
    private static final ArrayList<Ship> ownFleet = Fleet.aifleet;
    private static final ArrayList<Ship> enemyFleet = Fleet.playerfleet;
    private static final boolean ai = true;

    public static void start() {
        ArrayList<ShipType> notPlacedShips = Fleet.notPlaced();
        while (!notPlacedShips.isEmpty()) {
            String str = randomcoord() +","+randomcoord();
            if (InputCheck.checkPlacement(str, notPlacedShips.get(0).getLength(), ownSide, ai)) {
                continue;
            }
            Ship ship = new Ship(notPlacedShips.get(0), InputCheck.getallCoordinates(str));
            Fleet.addShip(ownFleet, ship);
            notPlacedShips.remove(0);
            Ship.placeShip(ship, ownSide);
        }
        Grid.drawGrid();
    }

    public static void shot(){
        boolean valid = false;
        String str = "";
        System.out.println("The Computer is aiming");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        while (!valid) {
            str = randomcoord();
            if(InputCheck.checkShot(str, ai, targetSide)){
                valid = true;
            }
        }
        Cellgrid.shotSet(str, targetSide, true);
        if (Cellgrid.boatGet(str, targetSide)){
            Cellgrid.symbolSet(str,targetSide,"X");
            Grid.drawGrid();
            System.out.println("The Computer hit your Ship!");
            boolean sunk = Ship.checkHits(str, enemyFleet, targetSide);
            if (sunk){
                System.out.println("The Computer sunk one of your ships!");
            }
        }
        else {
            Cellgrid.symbolSet(str,targetSide,"O");
            Grid.drawGrid();
            System.out.println("The Computer missed!");
        }
    }

    public static String randomcoord() {
        final String Letters = "ABCDEFGHIJ";
        int ch = (int) (Letters.length() * Math.random());
        char Letter = Letters.charAt(ch);
        int Number = (int) (Math.random() * 10);
        return Letter + Integer.toString(Number);
    }

}

