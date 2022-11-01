package Grid;

public class Grid {
    private static final String[] numRows = new String [10]; //brucht für x-achse nummerierig und länge bregrenzig vo 10
    public static int getRows(){    //getter zum de String private mache chönne
        return numRows.length;
    }
    public static enum Cols {A, B, C, D, E, F, G, H, I, J}  //uflistig vo de Buechstabe fürd y-achse
    public static Cellgrid targetcells;   //prä-definierig vo de Target Grid koordinate
    public static Cellgrid oceancells;    //prä-definierig vo de Ocean Grid koordinate

    //method zum es Grid erstelle
    public Grid(){
        createGrid();
    }

    //effektiver konstruktor vom Grid + grad no es zeichne devo
    public void createGrid() {
        oceancells = new Cellgrid(); //erstellig vo de koordinate
        targetcells = new Cellgrid(); //erstellig vo de koordinate
        drawGrid();
    }

    //method zum s Grid zeichne nach de erstellig
    public static void drawGrid() {
        //clearScreen();
        drawTargetGrid();
        drawDivider();
        drawOceanGrid();
    }

    //zeichnig vom chliine abstand zwüsched Target Grid und Ocean Grid
    private static void drawDivider() {
        System.out.println();
        System.out.println("-".repeat(22));
        System.out.println();
    }

    //eventuelli implementation vomene clear screen commmand, nonig usegfunde wie das gaht darum machts eifach 100 ziileumbrüch
    public static void clearScreen() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //zeichnig vom Target Grid
    private static void drawTargetGrid() {
        //Präfix
        System.out.println("===== TARGET GRID =====");

        System.out.print("  ");
        for (Grid.Cols coords : Grid.Cols.values())
            System.out.print(coords + " ");
        System.out.println();
        System.out.println(" " + "+-".repeat(10) + "+");

        //Hauptteil
        for (int i = 0; i < numRows.length; i++) {
            for (Grid.Cols coords : Grid.Cols.values()) {
                if (coords == Grid.Cols.A)
                    System.out.print(i + "|" + targetcells.symbolGet(coords+""+i));
                else if (coords == Grid.Cols.J)
                    System.out.print("|" + targetcells.symbolGet(coords+""+i) + "|" + i);
                else System.out.print("|" + targetcells.symbolGet(coords+""+i));
            }
            System.out.println();
        }

        //Suffix
        System.out.println(" " + "+-".repeat(10) + "+");
        System.out.print("  ");
        for (Grid.Cols coords : Grid.Cols.values())
            System.out.print(coords + " ");
        System.out.println();
        System.out.println("=".repeat(22));
    }

    //zeichnig vom Ocean Grid
    private static void drawOceanGrid() {
        //Präfix
        System.out.println("===== OCEAN GRID =====");

        System.out.print("  ");
        for (Grid.Cols coords : Grid.Cols.values())
            System.out.print(coords + " ");
        System.out.println();
        System.out.println(" " + "+-".repeat(10) + "+");

        //Hauptteil
        for (int i = 0; i < numRows.length; i++) {
            for (Grid.Cols coords : Grid.Cols.values()) {
                if (coords == Grid.Cols.A)
                    System.out.print(i + "|" + oceancells.symbolGet(coords+""+i));
                else if (coords == Grid.Cols.J)
                    System.out.print("|" + oceancells.symbolGet(coords+""+i) + "|" + i);
                else
                    System.out.print("|" + oceancells.symbolGet(coords+""+i));
            }
            System.out.println();
        }

        //Suffix
        System.out.println(" " + "+-".repeat(10) + "+");
        System.out.print("  ");
        for (Grid.Cols coords : Grid.Cols.values())
            System.out.print(coords + " ");
        System.out.println();
        System.out.println("=".repeat(22));
    }
}
