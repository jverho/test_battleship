package Grid;
import Ship.*;

import java.util.Hashtable;

public class Grid {
    private static final String[] numRows = new String [10];
    public static int getRows(){
        return numRows.length;
    }
    public static enum Cols {A, B, C, D, E, F, G, H, I, J}
    public static Cellgrid targetcells;
    public static Cellgrid oceancells;

    public Grid(){
        createGrid();
    }

    private void createGrid() {
        oceancells = new Cellgrid();
        targetcells = new Cellgrid();
    }

    public static void drawGrid() {
        clearScreen();
        drawTargetGrid();
        drawDivider();
        drawOceanGrid();
    }

    private static void drawDivider() {
        System.out.println();
        System.out.println("-".repeat(22));
        System.out.println();
    }

    private static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }catch(Exception E){
            System.out.println(E);
        }
    }

    private static void drawTargetGrid() {

        System.out.println("===== TARGET GRID =====");
        drawUpperBorder();
        drawMainGrid(targetcells);
        drawLowerBorder();
    }

    private static void drawOceanGrid() {
        System.out.println("===== OCEAN GRID =====");
        drawUpperBorder();
        drawMainGrid(oceancells);
        drawLowerBorder();
    }

    private static void drawUpperBorder(){
        System.out.print("  ");
        for (Grid.Cols coords : Grid.Cols.values())
            System.out.print(coords + " ");
        System.out.println();
        System.out.println(" " + "+-".repeat(10) + "+");

    }

    private static void drawMainGrid(Cellgrid side){
        for (int i = 0; i < numRows.length; i++) {
            for (Grid.Cols coords : Grid.Cols.values()) {
                if (coords == Grid.Cols.A)
                    System.out.print(i + "|" + Cellgrid.symbolGet(coords + "" + i, side));
                else if (coords == Grid.Cols.J)
                    System.out.print("|" + Cellgrid.symbolGet(coords + "" + i, side) + "|" + i);
                else
                    System.out.print("|" + Cellgrid.symbolGet(coords + "" + i, side));
            }
            System.out.println();
        }
    }

    private static void drawLowerBorder(){
        System.out.println(" " + "+-".repeat(10) + "+");
        System.out.print("  ");
        for (Grid.Cols coords : Grid.Cols.values())
            System.out.print(coords + " ");
        System.out.println();
        System.out.println("=".repeat(22));
    }

    public static void showAiShips() {
        for (Ship ship : Fleet.aifleet) {
            for (int i = 0; i < ship.getShiptype().getLength(); i++) {
                Cellgrid.symbolSet(ship.getCoordinates()[i], Grid.targetcells, ship.getShiptype().getPlaceholder());
            }
        }
    }

}