package SnakeGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{


    /**
     *
     */

    // private static final long serialVersionUID = 1L;
    static final int SCREEN_WIDTH = 280;
    static final int SCREEN_HEIGHT = 280;
    static final int UNIT_SIZE = 40;
    static final int GAME_UNIT = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 250;

    final int x[] = new int[GAME_UNIT];
    final int y[]  =new int[GAME_UNIT];

    int bodyParts = 3;
    int foodAte;
    int foodX;
    int foodX2;
    int foodY;
    int foodY2;
    char direction = 'R';
    boolean running = false;

    Timer timer;
    Random random;

    GamePanel(){
        random  = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.GRAY);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame() {
        newFood();
        running = true;
        timer =new Timer(DELAY, this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        if (running) {
            for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE;i++){
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }
            g.setColor(Color.ORANGE);
            g.fillOval(foodX, foodY, UNIT_SIZE, UNIT_SIZE);
            g.fillOval(foodX2, foodY2, UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i < bodyParts; i++){
                if(i == 0){
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }else{
                    g.setColor(new Color(45, 100, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink FREE", Font.BOLD, 15));
            FontMetrics metrics  =getFontMetrics(g.getFont());
            g.drawString("PONTOS: "+foodAte, (SCREEN_WIDTH-metrics.stringWidth("PONTOS: "+foodAte))/2, g.getFont().getSize());
        }
        else{
            gameOver(g);
        }
    }
    public void move() {
        for(int i = bodyParts; i>0; i--){
            x[i] = x[i-1]; 
            y[i] = y[i-1]; 
        }
        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    public void newFood(){
        foodX =random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        foodY =random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
        foodX2 =random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
        foodY2 =random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    public void checkFood(){
        if((x[0]==foodX) && (y[0]==foodY)){
            bodyParts++;
            foodAte++;
            newFood();
            }
            if((x[0]==foodX2) && (y[0]==foodY2)){
                bodyParts++;
                foodAte++;
                newFood();
        }

    }
    public void checkCollision() {
        //check the collesion with body
        for(int i= bodyParts; i>0; i--){
            if((x[0] == x[i]) && y[0] == y[i]){
                running = false;
            }
        }
        //check if the head touchs left border
        if(x[0]<0){
            running = false;
        }
        //check if the head touches right border[]
        if(x[0] > SCREEN_WIDTH-UNIT_SIZE){
            running = false;
        }
        //check if the head touches the top border
        if(y[0]<0){
            running =false;
        }
        //check if the head touches the bottom border
        if(y[0] > SCREEN_HEIGHT-UNIT_SIZE){
            running =false;
        }
        if(!running) {
            timer.stop();
        }

    }
    public void gameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink FREE", Font.BOLD, 20));
        FontMetrics metrics  =getFontMetrics(g.getFont());
        g.drawString("Perdeu!!", (SCREEN_WIDTH-metrics.stringWidth("Perdeu!!"))/2, SCREEN_HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkFood();
            checkCollision();
        }
        repaint();

    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction!='R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction!='L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction!='D'){
                        direction = 'U';
                    }
                case KeyEvent.VK_DOWN:
                    if(direction!='U'){
                        direction = 'D';
                    }
            
                default:
                    break;
            }
        }
    }
}
