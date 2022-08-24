package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrame extends JFrame {

    private JPanel jPanel;
    private Snake snake;
    private Timer timer;
    private Node food;


    public MainFrame() throws HeadlessException {
        intiFrame();
        intiGamePanel();
        intiSnake();
        intiTimer();
        setKeyListener();
        initFood();
    }

    private void initFood() {
        food=new Node();
        food.random();
    }

    private void setKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        if (snake.getDirecrction()!=Direcrction.DOWN) {
                            snake.setDirecrction(Direcrction.UP);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(snake.getDirecrction()!=Direcrction.UP) {
                            snake.setDirecrction(Direcrction.DOWN);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if(snake.getDirecrction()!=Direcrction.RIGHT) {
                            snake.setDirecrction(Direcrction.LEFT);
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(snake.getDirecrction()!=Direcrction.LEFT) {
                            snake.setDirecrction(Direcrction.RIGHT);
                        }

                        break;}
            }
        });
    }

    private void intiTimer() {
        timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                snake.move();
                Node head = snake.getBody().getFirst();
                if(head.getX()==food.getX()&&head.getY()== food.getY()) {
                    snake.eat(food);
                    food.random();
                }
                jPanel.repaint();

            }
        };

        timer.scheduleAtFixedRate(timerTask,0,100);

    }


    private void intiSnake() {
        snake=new Snake();


    }

    private void intiGamePanel() {
        jPanel=new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.clearRect(0,0,600,600);
                for(int i=0;i<=40;i++) {
                    g.drawLine(0,i*15,600,i*15);
                }
                for (int i=0;i<=40;i++) {
                    g.drawLine(i*15,0,i*15,600);
                }
                LinkedList<Node> body = snake.getBody();
                for (Node node : body) {
                    g.fillRect(node.getX()*15, node.getY()*15,15,15 );
                }
                g.fillRect(food.getX()*15,food.getY()*15,15,15);



            }
        };
        add(jPanel);
    }

    private void intiFrame() {
        setSize(610,640);
        setLocation(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }

}
