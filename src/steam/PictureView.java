package steam;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class PictureView extends JPanel {
    private Image image;

    public void setImage(String resourcePath) {
        try {
            InputStream res = this.getClass().getResourceAsStream(resourcePath);
            this.image = ImageIO.read(res);
            this.repaint();
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("资源路径有误" + resourcePath);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = this.getWidth();
        int height = this.getHeight();
        g.drawImage(this.image,0,0,width,height,null);
    }
}

