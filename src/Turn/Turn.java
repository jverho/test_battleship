package Turn;
import java.util.Random;
import User.*;
import Grid.*;
import java.util.Random;

public class Turn {
    static boolean gameOver = false;
    static boolean aiWon = false;


    public static void startTurn() {
        new Grid();
        Computer.start();
        Player.start();
    }

    public static void playTurn(){
        Random random = new Random();
        if(random.nextBoolean()) {
            System.out.println("You have the first shot!");
            Player.shot();
        }
        else{System.out.println("The Computer has the first shot!");}
        while (!gameOver){
            Computer.shot();
            Player.shot();
        }
    }

    public static void endTurn(){
        if(aiWon){
            Grid.showAiShips();
            Grid.drawGrid();
            System.out.println("Oh no, you lost!");
        }
        else{
            Grid.drawGrid();
            System.out.println("Congratulations, you won!");
        }
    }


    public static void gameWon(){
        gameOver = true;
    }
    public static void gameLost(){
        gameOver = true;
        aiWon = true;
    }
}



