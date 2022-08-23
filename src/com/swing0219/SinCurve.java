package com.swing0219;

import javax.swing.*;
import java.awt.*;

public class SinCurve extends JPanel {
    public int grain = 3; // 线条精细度
    public int radius = 50; // 高度(振幅)
    public int period = 100; // X轴, 每100像素表示一个周期(2PI)

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = this.getWidth();
        int height = this.getHeight();
        g.setColor( Color.WHITE);
        g.fillRect(0, 0 , width, height);
        // 中线
        int center = height / 2;
        g.setColor(Color.BLUE);
        g.drawLine(0, center, width, center);

        // 正弦曲线
        int x1 = 0;
        int y1 = 0;
        for (int i = 0; i < width; i += grain)
        {
            int x2 = i;
            // 把横坐标换算成弧度值
            double angle = 2 * Math.PI * x2 / period;
            // 计算得到y坐标
            int y2 = (int) (radius * Math.sin( angle ));

            g.drawLine(x1, center + y1, x2, center + y2);

            x1 = x2;
            y1 = y2;
        }
    }
}
