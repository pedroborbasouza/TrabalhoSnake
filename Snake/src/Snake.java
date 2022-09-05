import javax.swing.*;

public class Snake {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setSize(750, 750);
        frame.setVisible(true);

        int[][] mapa = new int[10][10];  //Declaracao do mapa logico do game

        for (int i = 0; i < 10; i++){  //Imprime o mapa logico do jogo na tela
            for (int j = 0; j < 10; j++){
                System.out.print(mapa[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
