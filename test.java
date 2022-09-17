import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] mapa = new String[7][7];  //Declaração do mapa logico do game
        String Mover; //Variável para detectar a direção
        int x = -1, y = -1, auxX, auxY, ComidaLinha = -1, ComidaColuna = -1, ok = 0, bateu = 0;
        int opcao;

        GerarMapa(mapa); //gera a matriz do mapa

        while (x < 0 || x > 6 || y < 0 || y > 6) {

            //cria uma entrada de dados para definir linha e coluna do nascimento da cobra

            System.out.println("indique a linha de nascimento da cobra de 0 até 6");
            x = sc.nextInt();
            System.out.println("Indique a coluna da nascimento da cobra de 0 até 6");
            y = sc.nextInt();

            if (x < 0 || x > 6 || y < 0 || y > 6) {
                System.out.println("Posição incorreta, digite entre 0 e 6");
            } else {
                mapa[x][y] = ">";
            }
        }

        AtualizarMapa(mapa); // atualiza o mapa para mostrar a posição da cobra


        while (ok == 0) {

            //cria uma entrada de dados para definir a linha e coluna da comida

            System.out.println("Insira a posição da comida na linha de 0 até 6");
            ComidaLinha = sc.nextInt();
            System.out.println("Insira a posição da comida na Coluna de 0 até 6");
            ComidaColuna = sc.nextInt();

            if (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6) {
                System.out.println("Posição incorreta, digite entre 0 e 6");
            } else if (ComidaLinha == x && ComidaColuna == y) {
                System.out.println("A comida não pode ocupar a mesma posição que a cobra");
            } else {
                mapa[ComidaLinha][ComidaColuna] = "o";
                AtualizarMapa(mapa);
                ok = 1;
            }
        }

        do {

            //entrada de dados para definir a direção da cobra

            System.out.println("Indique entre W, A, S, D a direção em que a cobra se move");
            Mover = sc.nextLine();

            switch (Mover) { //switch-case para mover para a direção desejada
                case "w": // move para cima
                    auxY = y;
                    auxX = x;
                    x--;
                    if (x == ComidaLinha && y == ComidaColuna) { // testa se a posição da cabeça da cobra e da comida é a mesma, caso for o algoritmo solicita uma nova posição
                        ok = 0;
                        while (ok == 0) {

                            //entrada de dados para definir a nova posição da comida

                            System.out.println("Insira a posição da comida na linha de 0 até 6");
                            ComidaLinha = sc.nextInt();
                            System.out.println("Insira a posição da comida na Coluna de 0 até 6");
                            ComidaColuna = sc.nextInt();

                            if (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6) {

                                //if de teste para não colocar a comida fora do mapa

                                System.out.println("Posição incorreta, digite entre 0 e 6");
                            } else {

                                //caso a posição seja valida, imprime a comida no mapa

                                ok = 1;
                                mapa[ComidaLinha][ComidaColuna] = "o";
                            }
                        }
                    }
                    if (x >= 7 || x < 0 && y >= 7 || y < 0) {
                        System.out.println("Perdeu!");
                        bateu++;
                    }
                    mapa[x][y] = "^";
                    mapa[auxX][auxY] = "*";
                    AtualizarMapa(mapa);
                    break;
                case "a":
                    auxY = y;
                    auxX = x;
                    y--;
                    mapa[x][y] = "<";
                    mapa[auxX][auxY] = "*";
                    if (x == ComidaLinha && y == ComidaColuna) {

                        do {
                            System.out.println("Insira a posição da comida na linha de 0 até 6");
                            ComidaLinha = sc.nextInt();
                            System.out.println("Insira a posição da comida na Coluna de 0 até 6");
                            ComidaColuna = sc.nextInt();

                            if (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6) {
                                System.out.println("Posição incorreta, digite entre 0 e 6");
                            }

                            mapa[ComidaLinha][ComidaColuna] = "o";
                        } while (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6);
                    }
                    if (x >= 7 || x < 0 && y >= 7 || y < 0) {
                        System.out.println("Perdeu!");
                        bateu++;
                    }
                    AtualizarMapa(mapa);
                    break;
                case "s":
                    auxY = y;
                    auxX = x;
                    x++;
                    mapa[x][y] = "v";
                    mapa[auxX][auxY] = "*";
                    if (x == ComidaLinha && y == ComidaColuna) {
                        do {
                            System.out.println("Insira a posição da comida na linha de 0 até 6");
                            ComidaLinha = sc.nextInt();
                            System.out.println("Insira a posição da comida na Coluna de 0 até 6");
                            ComidaColuna = sc.nextInt();

                            if (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6) {
                                System.out.println("Posição incorreta, digite entre 0 e 6");
                            }

                            mapa[ComidaLinha][ComidaColuna] = "o";
                        } while (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6);
                    }
                    if (x >= 7 || x < 0 && y >= 7 || y < 0) {
                        System.out.println("Perdeu!");
                        bateu++;
                    }
                    AtualizarMapa(mapa);
                    break;
                case "d":
                    auxY = y;
                    auxX = x;
                    y++;
                    mapa[x][y] = ">";
                    mapa[auxX][auxY] = "*";
                    if (x == ComidaLinha && y == ComidaColuna) {

                        do {
                            System.out.println("Insira a posição da comida na linha de 0 até 6");
                            ComidaLinha = sc.nextInt();
                            System.out.println("Insira a posição da comida na Coluna de 0 até 6");
                            ComidaColuna = sc.nextInt();

                            if (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6) {
                                System.out.println("Posição incorreta, digite entre 0 e 6");
                            }

                            mapa[ComidaLinha][ComidaColuna] = "o";
                        } while (ComidaColuna < 0 || ComidaColuna > 6 || ComidaLinha < 0 || ComidaLinha > 6);
                    }
                    if (x > 6 || x < 0 || y > 6 || y < 0) {
                        System.out.println("Perdeu!");
                        bateu++;
                    }
                    AtualizarMapa(mapa);
                    break;
            }
        } while (Mover != "E");
    }

    public static void GerarMapa(String[][] mapa) {  //Imprime o mapa logico do jogo na tela
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                mapa[i][j] = "*";
                System.out.print(mapa[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] AtualizarMapa(String[][] AtualizarMapa) { //Atualiza o mapa
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(AtualizarMapa[i][j] + "  ");
            }
            System.out.println();
        }
        return new int[0][];
    }

    public static int[][] aumentarCobra(int[] inputFruta, int[][] posicaoSegmentos) {
        int[][] novaPosicaoSegmentos = new int[posicaoSegmentos.length + 1][];
        System.arraycopy(posicaoSegmentos, 0, novaPosicaoSegmentos, 1, posicaoSegmentos.length);
        novaPosicaoSegmentos[0] = inputFruta;
        return novaPosicaoSegmentos;
    }
}
