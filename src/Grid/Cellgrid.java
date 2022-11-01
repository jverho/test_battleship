package Grid;

import java.util.Hashtable;

public class Cellgrid {
    private final Hashtable<String, Cell> content; //prä-definierig vode inhalts variable

    //erstellig vo neue cells mit de koordinate als inhalt
    public Cellgrid(){
        content = createCellgrid();
    }

    //konstruktor fürs dictionary vode koordinate mit de bruuchte values
    //uufbau vom Dictionary isch en Dictionary mit de Koordinate als Key (z.B. "A1") und de Cell als Value
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

    //Setter für Symbol vonere Koordinate
    public  void symbolSet( String coord, String change) {
        content.get(coord).symbolSet(change);
    }

    //Setter für boat Status vonere Koordinate
    public void boatSet( String coord, boolean change){
        content.get(coord).boatSet(change);
    }

    //Setter für shot Status vonere Koordinate
    public void shotSet( String coord, boolean change){
        content.get(coord).shotSet(change);
    }

    //Getter für Symbol vonere Koordinate
    public String symbolGet(String coord) {
        return content.get(coord).symbolGet();
    }

    //Getter für boat Status vonere Koordinate
    public boolean boatGet(String coord){
        return content.get(coord).boatGet();
    }

    //Getter für shot Status vonere Koordinate
    public boolean shotGet(String coord){
        return content.get(coord).shotGet();
    }
}
