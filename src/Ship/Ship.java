package Ship;

public class Ship {

    private String[] coordinates;
    private ShipType shiptype;
    private boolean sunken = false;

    public Ship(ShipType shiptype, String[] coordinates){
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
}
