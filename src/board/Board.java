package board;

public class Board {
    public void drawBoard(){
        String text_target = "===== TARGET GRID =====";
        String text_abc = "  A B C D E F G H I J  ";
        String text_plus_minus = " +-+-+-+-+-+-+-+-+-+-+ ";
        System.out.println(text_target);
        System.out.println(text_abc);
        System.out.println(text_plus_minus);
        /*for (int i = 0; i<10; i++) {
            System.out.print(i);
            for (int j = 0; j < 10; j++) {
                System.out.print("| ");
            }
            System.out.print("|");
            System.out.println(i);
        }*/
        System.out.println(text_plus_minus);
        System.out.println(text_abc);



    }
}
