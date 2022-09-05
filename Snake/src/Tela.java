import java.awt.*;  // importa a biblioteca do canvas (que cria a tela do jogo)
import java.util.LinkedList;
import javax.swing.*;  // importa a biblioteca swing (que possui objetos basicos como botoes, por exemplo)

public class Tela extends JFrame{
    static final int telaHorizontal = 480; // tamanho horizontal da tela
    static final int telaVertical = 480;  // tamanho vertical da tela
    static final int tamanhoUnidade = 80; // tamanho da celula na tela
    static final int unidadeDeJogo = (telaHorizontal*telaVertical)/tamanhoUnidade; //
    static final int delay = 250;

    Tela() // Construtor da tela
    {
        super("canvas"); // Cria um frame

        LinkedList <Point> snake;

        // Cria um novo canvas
        Canvas c = new Canvas() {

            // Pinta a tela
            public void paint(Graphics g)
            {

                //Cria o grid na tela
                for(int i=0; i<telaVertical/tamanhoUnidade;i++){
                    g.drawLine(i*tamanhoUnidade, 0, i*tamanhoUnidade, telaVertical);
                    g.drawLine(0, i*tamanhoUnidade, telaHorizontal, i*tamanhoUnidade);
                }

            }
        };

        // Define a cor de fundo
        c.setBackground(Color.gray);

        // Define o tamanho da janela a ser aberta
        add(c);
        setSize(500, 520);
        show();
    }

    // metodo main
    public static void main(String args[])
    {
        Tela c = new Tela();
    }
}
