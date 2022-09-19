import java.util.Scanner;

public class Cobra {

    public static void main(String[] args) {

        //Cria a matriz para o mapa
        String [][] mapa = new String [9][9];
        //Cria o vetor que representa a cobra
        String [] cobra = new String [49];
        //Define a cabeca da cobra
        cobra[0] = "4";
        //Define o formato da fruta
        String fruta = "O";
        //valor para inicializar o comando de mover
        String mover = "";
        //vetor que armazena a posicao x da cobra
        int [] cobraX = new int [49];
        //vetor que armazena a posicao y da cobra
        int [] cobraY = new int [49];
        //vetor que armazena a posicao x da fruta
        int [] frutaX = new int [1];
        //vetor que armazena a posicao y da fruta
        int [] frutaY = new int [1];
        //tamanho do corpo
        int corpo = 1;

        //chama a funcao que cria e apresenta o mapa pela primeira vez
        GerarMapa(mapa);
        //cria a cobra
        Cobra(cobra);
        //define a posicao inicial da cobra
        AtualizarCobra(cobraY, cobraX, mapa, cobra);
        //coloca a fruta no mapa
        ColocarFruta(fruta, frutaX, frutaY,mapa);
        //faz a cobra andar
        andarCobra(cobra, corpo, mover, fruta, frutaX, frutaY, mapa, cobraY, cobraX);

    }

    public static void GerarMapa(String[][] mapa){
        //cria o layout do mapa na tela
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                if( i == 0 || i == 8){
                    System.out.print(mapa[i][j] = "8");
                }else if (j == 0 || j == 8){
                    System.out.print(mapa[i][j] = "8");
                }else{
                    System.out.print(mapa[i][j] = "*");
                }
            }
        }
    }

    public static void Cobra(String [] snake){
        //define o formato da cauda da cobra
        for (int i = 1; i < 49; i++) {
            snake[i] = "5";
        }
    }

    public static void AtualizarMapa(String [][] mapa){
        //atualiza  as informacoes do mapa na tela
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(mapa[i][j]);
            }
        }
    }

    public static void AtualizarCobra(int []cobraY, int [] cobraX, String[][] mapa, String [] cobra){
        Scanner sc = new Scanner(System.in);
        //pula uma linha
        System.out.println();
        //Pede ao jogador que incira as coordenadas iniciais da cobra
        System.out.println("Incira as posicao X inicial da cobra (1-7)");
        cobraX[0] = sc.nextInt();
        System.out.println("Incira as posicao Y inicial da cobra (1-7)");
        cobraY[0] = sc.nextInt();
        //verifica se o valor de X da cobra é valido
        while(cobraX[0] < 1 || cobraX[0] > 7){
            System.out.println("Valor invalido, incira o valor para X (1-7)");
            cobraX[0] = sc.nextInt();
        }
        //verifica se o valor de Y da cobra é valido
        while(cobraY[0] < 1 || cobraY[0] > 7){
            System.out.println("Valor invalido, incira o valor para Y (1-7)");
            cobraY[0] = sc.nextInt();
        }

        //Incere a cobra no mapa
        mapa[cobraX[0]][cobraY[0]] = cobra[0];
        AtualizarMapa(mapa);
    }

    public static void ColocarFruta(String fruta, int [] frutaX, int [] frutaY, String [][] mapa){
        Scanner sc = new Scanner(System.in);
        //pula uma linha
        System.out.println();
        //Pede ao jogador que incira as coordenadas iniciais da comida
        System.out.println("Incira a posicao X da fruta (1-7)");
        frutaX[0] = sc.nextInt();
        System.out.println("Incira a posicao Y da fruta (1-7)");
        frutaY[0] = sc.nextInt();
        //verifica se o valor de X da comida é valido
        while(frutaX[0] < 1 || frutaX[0] > 7){
            System.out.println("Valor invalido, incira o valor para X (1-7)");
            frutaX[0] = sc.nextInt();
        }
        //verifica se o valor de Y da comida é valido
        while(frutaY[0] < 1 || frutaY[0] > 7){
            System.out.println("Valor invalido, incira o valor para y (1-7)");
            frutaY[0] = sc.nextInt();
        }
        //Incere a comida no mapa
        mapa[frutaX[0]][frutaY[0]] = fruta;
        AtualizarMapa(mapa);
    }

    public static void andarCobra(String [] cobra, int corpo, String mover,String fruta, int [] frutaX, int [] frutaY,
                                  String [][] mapa, int []cobraY, int [] cobraX){
        Scanner sc = new Scanner(System.in);
        //Verifica se a cobra comeu a fruta
        while(cobraX[0] != frutaX[0] || cobraY[0] != frutaY[0] ){
            //apaga aonde a cobra nao esta mais
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (mapa[i][j].equals("5")) {
                        mapa[i][j] = "*";
                    }
                }
            }
            //Pula uma linha
            System.out.println();
            //Recebe do jogador a direcao que quer andar
            System.out.println("para se mover use w a s d");
            mover = sc.nextLine();

            switch(mover){
                //move a cobra para cima
                case "w":
                    //apaga a posicao inicial da cobra
                    mapa[cobraX[0]][cobraY[0]] = "*";

                    //move a cobra
                    for (int i = corpo; i >= 1; i--) {
                        cobraX[i] = cobraX[(i-1)];
                        cobraY[i] = cobraY[(i-1)];
                    }

                    cobraX[0]--;
                    mapa[cobraX[0]][cobraY[0]] = cobra[0];

                    //imprime a cobra na tela
                    for (int i = 1; i < corpo; i++) {
                        mapa[cobraX[i]][cobraY[i]] = cobra[i];
                    }
                    break;
                //move a cobra para baixo
                case "s":
                    //apaga a posicao inicial da cobra
                    mapa[cobraX[0]][cobraY[0]] = "*";

                    //move a cobra
                    for (int i = corpo; i >= 1; i--) {
                        cobraX[i] = cobraX[(i-1)];
                        cobraY[i] = cobraY[(i-1)];
                    }



                    cobraX[0]++;
                    mapa[cobraX[0]][cobraY[0]] = cobra[0];
                    //imprime a cobra na tela
                    for (int i = 1; i < corpo; i++) {
                        mapa[cobraX[i]][cobraY[i]] = cobra[i];
                    }

                    break;
                //move a cobra para a esquerda
                case "a":
                    //apaga a posicao inicial da cobra
                    mapa[cobraX[0]][cobraY[0]] = "*";

                    //move a cobra
                    for (int i = corpo; i >= 1; i--) {
                        cobraX[i] = cobraX[(i-1)];
                        cobraY[i] = cobraY[(i-1)];
                    }
                    cobraY[0]--;
                    mapa[cobraX[0]][cobraY[0]] = cobra[0];

                    //imprime a cobra na tela
                    for (int i = 1; i < corpo; i++) {
                        mapa[cobraX[i]][cobraY[i]] = cobra[i];
                    }
                    break;
                //move a cobra para a direita
                case "d":
                    //apaga a posicao inicial da cobra
                    mapa[cobraX[0]][cobraY[0]] = "*";

                    //move a cobra
                    for (int i = corpo; i >= 1; i--) {
                        cobraX[i] = cobraX[(i-1)];
                        cobraY[i] = cobraY[(i-1)];
                    }
                    cobraY[0]++;
                    mapa[cobraX[0]][cobraY[0]] = cobra[0];

                    //imprime a cobra na tela
                    for (int i = 1; i < corpo; i++) {
                        mapa[cobraX[i]][cobraY[i]] = cobra[i];
                    }
                    break;
            }
            AtualizarMapa(mapa);
            bateuCabeca(cobraX, cobraY);
            bateuCorpo(cobraX, cobraY, mapa);
        }

        comeuFruta(cobra, mover, cobraX, cobraY, corpo, fruta, frutaX, frutaY, mapa);
    }

    public static void comeuFruta(String [] cobra, String mover, int [] cobraX, int [] cobraY,int corpo, String fruta,
                                  int [] frutaX, int [] frutaY, String [][] mapa){
        System.out.println();
        System.out.println("Comeu a fruta");
        corpo++;
        ColocarFruta(fruta, frutaX, frutaY,mapa);
        andarCobra(cobra, corpo, mover, fruta, frutaX, frutaY, mapa, cobraY, cobraX);
    }

    public static void bateuCabeca(int [] cobraX, int [] cobraY){
        //verifica se a cobra bateu na parede
        if(cobraX[0] == 0 || cobraY[0] == 0 || cobraX[0] == 8 || cobraY[0] == 8 || cobraX[0] == 8 ||
                cobraY[0] == 0 || cobraX[0] == 0 || cobraY[0] == 8 ){
            System.out.println();
            System.out.println();
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    public static void bateuCorpo(int [] cobraX, int [] cobraY, String [][] mapa){
        //verifica se a cobra trombou no corpo
        if (mapa[cobraX[0]][cobraY[0]].equals("5")){
            System.out.println();
            System.out.println();
            System.out.println("Game Over");
            System.exit(0);

        }
    }


}
