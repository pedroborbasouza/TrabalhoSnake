public class Mapa {
    public static void main(String[] args) {
        int[][] mapa = new int[10][10];  //Declaracao do mapa logico do game

        for (int i = 0; i < 10; i++){  //Imprime o mapa logico do jogo na tela
            for (int j = 0; j < 10; j++){
                System.out.print(mapa[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
