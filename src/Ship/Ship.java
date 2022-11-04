package Ship;
import Grid.*;
import java.util.ArrayList;
import java.util.Objects;

public class Ship {

    private final String[] coordinates;
    private final ShipType shiptype;
    private boolean sunken = false;

    public Ship(ShipType shiptype, String[] coordinates) {
        this.shiptype = shiptype;
        this.coordinates = coordinates;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public ShipType getShiptype() {
        return shiptype;
    }

    public boolean isSunken() {
        return sunken;
    }

    public void setSunken(boolean sunken) {
        this.sunken = sunken;
    }

    public static void placeShip(Ship ship, Cellgrid side) {
        for (int i = 0; i < ship.getShiptype().getLength(); i++) {
            if (side == Grid.oceancells){Cellgrid.symbolSet(ship.getCoordinates()[i], side, ship.getShiptype().getPlaceholder());}
            side.boatSet(ship.getCoordinates()[i], true);
        }
    }

    public static void sinkShip(Ship ship, Cellgrid side) {
        ship.setSunken(true);
        for (int i = 0; i < ship.getCoordinates().length; i++) {
            if (side == Grid.targetcells){
                Cellgrid.symbolSet(ship.getCoordinates()[i], side, ship.getShiptype().getPlaceholder());
            }
        }
        Fleet.fleetSunk(side);
    }

    public static boolean checkHits(String shot, ArrayList<Ship> fleet, Cellgrid side){
        for (Ship ship : fleet) {
            for (int j = 0; j < ship.getCoordinates().length; j++) {
                if (Objects.equals(shot, ship.getCoordinates()[j])) {
                    int counter = 0;
                    for (int k = 0; k < ship.getCoordinates().length; k++) {
                        if (side.shotGet(ship.getCoordinates()[k], side)) {
                            counter++;
                        }
                    }
                    if (counter == ship.getCoordinates().length) {
                        sinkShip(ship, side);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


