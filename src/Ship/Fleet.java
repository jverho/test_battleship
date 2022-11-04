package Ship;
import java.util.ArrayList;
import Turn.*;
import Grid.*;
public class Fleet {
    public static ArrayList<Ship> playerfleet = new ArrayList<>();
    public static ArrayList<Ship> aifleet = new ArrayList<>();
    public Fleet(){}

    public static void addShip(ArrayList<Ship>fleet, Ship ship){
        fleet.add(ship);
    }

    public static void fleetSunk(Cellgrid side){
        if (side == Grid.oceancells){
            int counter = 0;
            for (Ship ship : playerfleet) {
                if (ship.isSunken()){counter++;}
            }
            if (counter == playerfleet.size()){Turn.gameLost();}
        }
        if (side == Grid.targetcells){
            int counter = 0;
            for (Ship ship : aifleet){
                if (ship.isSunken()){counter ++;}
            }
            if (counter == aifleet.size()){Turn.gameWon();}
        }
    }

    public static ArrayList<ShipType> notPlaced() {
        ArrayList<ShipType> shipList = new ArrayList<>();
        final int maxBattleship = 2;
        final int maxSubmarine = 3;
        final int maxPatrolBoat = 4;
        shipList.add(ShipType.CARRIER);
        for (int numberOfBattleships = 0; numberOfBattleships < maxBattleship; numberOfBattleships++) {
            shipList.add(ShipType.BATTLESHIP);
        }
        for (int numberOfSubmarines = 0; numberOfSubmarines < maxSubmarine; numberOfSubmarines++) {
            shipList.add(ShipType.SUBMARINE);
        }
        for (int numberOfPatrolShips = 0; numberOfPatrolShips < maxPatrolBoat; numberOfPatrolShips++) {
            shipList.add(ShipType.PATROL_BOAT);
        }
        return shipList;
    }
}

