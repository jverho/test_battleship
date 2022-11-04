package Grid;
import java.util.Hashtable;
public class Cellgrid {

    public final Hashtable<String, Cell> content;

    public Cellgrid(){
        content = createCellgrid();
    }

    private static Hashtable<String, Cell> createCellgrid(){
        Hashtable<String, Cell> name = new Hashtable<>();
        for (Grid.Cols coords : Grid.Cols.values()) {
            for (int j = 0; j < Grid.getRows(); j++) {
                Cell values = new Cell();
                name.put(coords + "" + j, values);
            }
        }
        return name;
    }
    public static void symbolSet( String coord, Cellgrid side, String change) {
        side.content.get(coord).symbolSet(change);
    }

    public void boatSet( String coord, boolean change){
        content.get(coord).boatSet(change);
    }

    public static void shotSet( String coord, Cellgrid side, boolean change){
        side.content.get(coord).shotSet(change);
    }

    public static String symbolGet(String coord, Cellgrid side) {
        return side.content.get(coord).symbolGet();
    }

    public static boolean boatGet(String coord, Cellgrid side){
        return side.content.get(coord).boatGet();
    }

    public boolean shotGet(String coord,Cellgrid side){
        return side.content.get(coord).shotGet();
    }
}


