package steam;
// 封装完成
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.InputStream;

public class PictureView extends JPanel {

    private Image image;
    private Color bgColor;

    public PictureView()
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
    // 重载三个版本
    public void setImage (Image image)
    {
        this.image = image;
        this.repaint();
    }
    // 文件路径
    public void setImage ( File file)
    {
        try {
            this.image = ImageIO.read(file);
            this.repaint();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 资源路径
    public void setImage (String resourcePath)
    {
        try {
            InputStream res = this.getClass().getResourceAsStream( resourcePath );
            this.image = ImageIO.read( res );
            this.repaint();
        }catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException( "资源路径有误" + resourcePath );
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = this.getWidth();
        int height = this.getHeight();
        if (bgColor != null)
        {
            g.setColor( new Color(42, 45, 50) );
            g.fillRect(0, 0 , width, height);
        }
        else
        {

            g.setColor( Color.WHITE );
            g.fillRect(0, 0 , width, height);
        }
        if (true)
        {
            g.setColor(new Color(42, 45, 50));
            g.drawRect(1,1,width-1,height-1);
            g.drawRect(3,3,width-1,2);
            g.drawRect(0,0,width-1,height-1);
            g.drawLine(2,-3,0,110);
            g.setColor(Color.WHITE);
            g.drawLine(148,-3,148,110);
        }
        if ( image != null)
        {
            // 获取图片大小
            int imgW = image.getWidth(null);
            int imgH = image.getHeight(null);

            Rectangle rect = new Rectangle(0,0,width,height);
            // 调用方式grow 向外扩展
            rect.grow(-2,-2);

            Rectangle fit = fitCenter(rect, imgW, imgH);
            g.drawImage(this.image, fit.x, fit.y, fit.width, fit.height, null);
        }
    }
    private Rectangle fitCenter (Rectangle rect, int imgW, int imgH)
    {
        // fitW, fitH 保持长宽比
        int fitW = rect.width;
        int fitH = rect.width * imgH / imgW;
        if (fitH > rect.height)
        {
            fitH = rect.height;
            fitW = rect.height * imgW / imgH;
        }
        // 绘制图片
        int fitX = rect.x + (rect.width - fitW) / 2;
        int fitY = rect.y + (rect.height - fitH) / 2;

        return new Rectangle(fitX, fitY, fitW, fitH);
    }
}
