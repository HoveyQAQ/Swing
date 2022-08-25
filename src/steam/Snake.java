package steam;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Node> body;
    private  Direcrction direcrction=Direcrction.UP;
    private boolean isLiving=true;


    public Snake() {
        initSnake();
    }

    private void initSnake() {
        body=new LinkedList<>();
        body.add(new Node(16,20));
        body.add(new Node(17,20));
        body.add(new Node(18,20));
        body.add(new Node(19,20));
        body.add(new Node(20,20));
        body.add(new Node(21,20));

    }

    public void move() {
        if(isLiving){
        Node head = body.getFirst();
        switch (direcrction) {
            case UP:
                body.addFirst(new Node(head.getX(), head.getY() - 1));
                break;
            case DOWN:
                body.addFirst(new Node(head.getX(), head.getY() + 1));
                break;
            case LEFT:
                body.addFirst(new Node(head.getX() - 1, head.getY()));
                break;
            case RIGHT:
                body.addFirst(new Node(head.getX() + 1, head.getY()));
                break;
        }
        body.removeLast();

        head=body.getFirst();

        if(head.getX()<0||head.getY()<0||head.getX()>=40||head.getY()>=40) {
            isLiving=false;
        }
        for (int i = 1; i < body.size(); i++) {
                Node node = body.get(i);
                if(head.getX()==node.getX()&&head.getY()==node.getY()){
                    isLiving=false;
                }
            }

        }
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    public void setBody(LinkedList<Node> body) {
        this.body = body;
    }

    public Direcrction getDirecrction() {
        return direcrction;
    }

    public void setDirecrction(Direcrction direcrction) {
        this.direcrction = direcrction;
    }

    public void eat(Node food) {
        Node head = body.getFirst();
        switch (direcrction) {
            case UP:
                body.addFirst(new Node(head.getX(), head.getY() - 1));
                break;
            case DOWN:
                body.addFirst(new Node(head.getX(), head.getY() + 1));
                break;
            case LEFT:
                body.addFirst(new Node(head.getX() - 1, head.getY()));
                break;
            case RIGHT:
                body.addFirst(new Node(head.getX() + 1, head.getY()));
                break;
        }
    }
}
