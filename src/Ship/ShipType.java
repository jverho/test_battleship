package Ship;

public enum ShipType {
    CARRIER(6, "C"),
    BATTLESHIP(4, "B"),
    SUBMARINE(3, "S"),
    PATROL_BOAT(2, "P");

    private final int  length;
    private final String placeholder;

    ShipType(int length, String placeholder){
        this.length = length;
        this.placeholder = placeholder;
    }

    public int getLength() {
        return length;
    }

    public String getPlaceholder() {
        return placeholder;
    }
}

