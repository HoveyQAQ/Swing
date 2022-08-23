package com.swing0215;

import javax.swing.*;
import java.awt.*;

public class ColorLabel extends JLabel
{
    public ColorLabel(String text, Color bgColor)
    {
        this.setText(text);
        this.setOpaque(true);
        this.setBackground( bgColor );
        this.setPreferredSize(new Dimension(60, 30));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}