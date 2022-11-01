package Turn;
import Grid.Grid;
import Ship.*;
import Check.InputCheck;
import User.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Turn {
    //*******************************************************************
    //instead of this make a fleet class and use it to define two fleets
    public static ArrayList<Ship> shipList(){
        ArrayList<Ship> notPlacedShips = new ArrayList<>();
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
    //*************************************************
    public static void startTurnShips() {
        ArrayList<Ship> playerShips = shipList();
        int currentShipInt = 0;
        ArrayList<Ship> playerNotPlacedShips = shipList();
        while (!playerNotPlacedShips.isEmpty()){
            Scanner sc = new Scanner(System.in);
            String text = String.format("Enter Coordinates of %s (length: %d): ",
                    playerShips.get(currentShipInt).getShiptype(), playerShips.get(currentShipInt).getShiptype().getCells());
            System.out.print(text);
            String inputCoord = sc.nextLine();
            if (InputCheck.checkPlacement(inputCoord, playerShips.get(currentShipInt))) {
                continue;
            }
            Player.placeShip(inputCoord, playerShips.get(currentShipInt));
            playerNotPlacedShips.remove(0);
            currentShipInt++;
            Grid.drawGrid();
        }
    }

    public static void normalTurn(){
        ArrayList<Ship> playerShips = shipList();
        //ask where to shoot at
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Coordinates to fire at: ");
        String inputCoord = sc.nextLine();
        //shoot at the position
        Player.shootAt(inputCoord);
        //check if boat has been sunk, update visual
        /*for (Ship currentShip: playerShips){
            for (String currentCoord: currentShip.getCoordinates())
            if (Grid.targetcells.shotGet(currentCoord){
                currentShip.setSunken(true);
            }
        }*/
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
