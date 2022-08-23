package swing;
// 封装完成
import javax.swing.*;
import java.awt.*;

public class PictureView1 extends JPanel {

    private Image image;
    private Color bgColor;

    public PictureView1()
    {
//        try {
//            // 加载图片对象 (应放在构造方法中)
//            File file = new File("data/1.JPG");
//            this.image = ImageIO.read(file);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public void setBackgroundColor (Color color)
    {
        this.bgColor = color;
        this.repaint(); // 重新绘制
    }
    public void setImage (Image image)
    {
        this.image = image;
        this.repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = this.getWidth();
        int height = this.getHeight();
        if (bgColor != null)
        {
            g.setColor( bgColor );
            g.fillRect(0, 0 , width, height);
        }
        else
        {

            g.setColor( Color.WHITE );
            g.fillRect(0, 0 , width, height);
        }

    }
}
