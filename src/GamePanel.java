import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 1000;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int xAxis[] = new int[GAME_UNITS];
    final int yAxis[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLUE);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        for (int i=0; i<SCREEN_HEIGHT/UNIT_SIZE; i++){
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);

        }
        g.setColor(Color.red);
        g.fillOval(appleX,appleY, UNIT_SIZE, UNIT_SIZE);

        for (int i=0; i<bodyParts; i++){
            if (i==0){
                g.setColor(Color.green);
                g.fillRect(xAxis[i], yAxis[i], UNIT_SIZE, UNIT_SIZE);
            }
            else {
                g.setColor(new Color(45,180,0));
            }
        }
    }
    public void newApple() {
        appleX = random.nextInt((int) SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt((int) SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    public void move() {
        for (int i = bodyParts; i > 0; i--){
            xAxis[i] = xAxis[i-1];
            yAxis[i] = yAxis[i-1];
        }
        switch (direction) {
            case 'U' -> yAxis[0] = yAxis[0] - UNIT_SIZE;
            case 'D' -> yAxis[0] = yAxis[0] + UNIT_SIZE;
            case 'L' -> xAxis[0] = xAxis[0] - UNIT_SIZE;
            case 'R' -> xAxis[0] = xAxis[0] + UNIT_SIZE;
        }

    }
    public void checkApple() {

    }
    public void checkCollisions() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
