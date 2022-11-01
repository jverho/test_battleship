package Turn;
import Ship.*;
import Check.InputCheck;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Turn {
    public static ArrayList<Ship> shipList(){
        ArrayList<Ship> notPlacedShips = new ArrayList<Ship>();
        Ship carrier1 = new Ship(ShipType.CARRIER, null);
        Ship battleship1 = new Ship(ShipType.BATTLESHIP, null);
        Ship battleship2 = new Ship(ShipType.BATTLESHIP, null);
        Ship submarine1 = new Ship(ShipType.SUBMARINE, null);
        Ship submarine2 = new Ship(ShipType.SUBMARINE, null);
        Ship submarine3 = new Ship(ShipType.SUBMARINE, null);
        Ship patrol_boat1 = new Ship(ShipType.PATROL_BOAT, null);
        Ship patrol_boat2 = new Ship(ShipType.PATROL_BOAT, null);
        Ship patrol_boat3 = new Ship(ShipType.PATROL_BOAT, null);
        Ship patrol_boat4 = new Ship(ShipType.PATROL_BOAT, null);
        notPlacedShips.add(carrier1);
        notPlacedShips.add(battleship1);
        notPlacedShips.add(battleship2);
        notPlacedShips.add(submarine1);
        notPlacedShips.add(submarine2);
        notPlacedShips.add(submarine3);
        notPlacedShips.add(patrol_boat1);
        notPlacedShips.add(patrol_boat2);
        notPlacedShips.add(patrol_boat3);
        notPlacedShips.add(patrol_boat4);
        return notPlacedShips;
    }

    //maybe change to create a list of Type Ship
    private static ArrayList<ShipType> notPlaced() {
        ArrayList<ShipType> shipList = new ArrayList<>();
        final int maxBattleship = 2;
        final int maxSubmarine = 3;
        final int maxPatrolBoat = 4;
        shipList.add(ShipType.CARRIER);
        for (int numberOfBallteships = 0; numberOfBallteships < maxBattleship; numberOfBallteships++) {
            shipList.add(ShipType.BATTLESHIP);
        }
        for (int numberOfSubmraines = 0; numberOfSubmraines < maxSubmarine; numberOfSubmraines++) {
            shipList.add(ShipType.SUBMARINE);
        }
        for (int numberOfPatrolShips = 0; numberOfPatrolShips < maxPatrolBoat; numberOfPatrolShips++) {
            shipList.add(ShipType.PATROL_BOAT);
        }
        return shipList;
    }

    public static void startTurn() {
        //new Grid(); depending on implementation
        ArrayList<ShipType> notPlacedShips = notPlaced();
        while (!notPlacedShips.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            String text = String.format("Enter Coordinates of %s (length: %d): ",
                    notPlacedShips.get(0), notPlacedShips.get(0).getCells());
            System.out.print(text);
            String str = sc.nextLine();
            if (!InputCheck.checkPlacement(str, notPlacedShips.get(0).getCells())) {
                continue;
            }
            notPlacedShips.remove(0);
            //System.out.println(notPlacedShips); //only to help visualize, delete later
            //place ship on the coordinates
            //print updated oceangrid
        }
    }

    public static void startTurnShips() {
        ArrayList<Ship> playerShips = shipList();
        int currentShipInt = 0;
        ArrayList<Ship> playerNotPlacedShips = shipList();
        while (!playerNotPlacedShips.isEmpty()){
            Scanner sc = new Scanner(System.in);
            String text = String.format("Enter Coordinates of %s (length: %d): ",
                    playerShips.get(currentShipInt).getShiptype(), playerShips.get(currentShipInt).getShiptype().getCells());
            System.out.print(text);
            String str = sc.nextLine();
            if (!InputCheck.checkPlacementShip(str, playerShips.get(currentShipInt))) {
                continue;
            }
            playerNotPlacedShips.remove(0);
            currentShipInt++;
            //place ship on coordinates
        }

    }

    public static void normalTurn(){
        System.out.println("normal Turn");
        //one player shoots
        //check if game is over
        //other player shoots
        //check if game is over
    }

    public static void finalTurn(){
        System.out.println("final Turn");
        //if computer wins show board of computer (Target Board)
        //otherwise just indicate winner
    }

}
