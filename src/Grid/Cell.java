package Grid;

public class Cell {

    private String symbol = " ";
    private boolean boat = false;
    private boolean shot = false;

    public Cell (){

    }

    public String symbolGet(){return symbol;}
    public void symbolSet(String symbol){this.symbol = symbol;}

    public boolean boatGet() {
        return boat;
    }
    public void boatSet(boolean boat) {this.boat = boat;}

    public boolean shotGet() {
        return shot;
    }
    public void shotSet(boolean shot) {
        this.shot = shot;
    }
}
