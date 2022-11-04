package User;
import Ship.*;
import Grid.*;
import Check.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final static Cellgrid ownSide = Grid.oceancells;
    private static final Cellgrid targetSide = Grid.targetcells;
    private static final ArrayList<Ship> ownFleet = Fleet.playerfleet;
    private static final ArrayList<Ship> enemyFleet = Fleet.aifleet;
    private static final boolean ai = false;

    public static void start() {
        ArrayList<ShipType> notPlacedShips = Fleet.notPlaced();
        while (!notPlacedShips.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            String text = String.format("Enter Coordinates of %s (length: %d): ",
                    notPlacedShips.get(0), notPlacedShips.get(0).getLength());
            System.out.print(text);
            String str = sc.nextLine();
            if (InputCheck.checkPlacement(str, notPlacedShips.get(0).getLength(), ownSide, ai)) {
                continue;
            }
            Ship ship = new Ship(notPlacedShips.get(0), InputCheck.getallCoordinates(str));
            Fleet.addShip( ownFleet, ship);
            notPlacedShips.remove(0);
            Ship.placeShip(ship, ownSide);
            Grid.drawGrid();
        }
    }

    public static void shot(){
        boolean valid = false;
        String str = "";
        while (!valid) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Coordinate to shoot: ");
            str = sc.nextLine();
            if(InputCheck.checkShot(str, ai, targetSide)){
                valid = true;
            }
        }
        Cellgrid.shotSet(str, targetSide, true);
        if (Cellgrid.boatGet(str, targetSide)){
            Cellgrid.symbolSet(str,targetSide,"X");
            boolean sunk = Ship.checkHits(str, enemyFleet, targetSide);
            Grid.drawGrid();
            System.out.println("You hit!");
            if (sunk){
                System.out.println("You sunk a Ship!");
            }
        }
        else {
            Cellgrid.symbolSet(str,targetSide,"O");
            Grid.drawGrid();
            System.out.println("You missed!");
        }
    }
}
