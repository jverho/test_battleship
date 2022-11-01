package Ship;

public enum ShipType {
    CARRIER(6, "C"),
    BATTLESHIP(4, "B"),
    SUBMARINE(3, "S"),
    PATROL_BOAT(2, "P");

    private int cells;
    private String placeholder;

    ShipType(int cells, String placeholder){
        this.cells = cells;
        this.placeholder = placeholder;
    }

    public int getCells() {
        return cells;
    }

    public String getPlaceholder() {
        return placeholder;
    }
}
