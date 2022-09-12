import java.util.Scanner;

public class Mapa {



    public static void main(String[] args) {
        String[][] mapa = new String[7][7];  //Declaracao do mapa logico do game
        String Comida;
        int i = 2;

        GerarMapa(mapa);
        while (i > 1){
            GerarComida(mapa);
            AtualizarMapa(mapa);
        }

    }

    public static void GerarMapa(String [][]mapa){

        for (int i = 0; i < 7; i++){  //Imprime o mapa logico do jogo na tela
            for (int j = 0; j < 7; j++){
                mapa[i][j] = "*";
                System.out.print(mapa[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public static void AtualizarMapa(String[][] AtualizarMapa){
        for (int i = 0; i < 7; i++){  //Imprime o mapa logico do jogo na tela
            for (int j = 0; j < 7; j++){
                System.out.print(AtualizarMapa[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public static void GerarComida(String [][]comida){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira a posição da comida na linha");
        int ComidaLinha = sc.nextInt();
        System.out.println("Insira a posição da comida na Coluna");
        int ComidaColuna = sc.nextInt();

        comida[ComidaLinha][ComidaColuna] = "o";
    }
}
