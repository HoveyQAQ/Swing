package com.swing0215;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// 添加一个类SimpleLayout 实现LayoutManager2
// 重点关注
    // void addLayoutComponent(Component comp, Object constraints)、
    // void removeLayoutComponent(Component comp)
    // void layoutContainer(Container parent)
public class SimpleLayout extends LayoutAdapter {
    List<Component> list = new ArrayList<>();

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        list.add( comp );
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        list.add( comp );
    }

    @Override
    public void layoutContainer(Container parent) {
        int width = parent.getWidth();
        int height = parent.getHeight();
        Component[] children = parent.getComponents();
        int x = 0;
        int y = 0;
        for (int i = 0; i < list.size(); i ++)
        {
            Component c = list.get(i);
            c.setBounds(x, y, 100, 100);
            x += 100;
            if (x > width)
            {
                x = 0;
                y += 100;
            }
        }
    }
}
