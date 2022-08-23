package steam;

import javax.swing.*;
import java.awt.*;

public class SteamStoreFrame extends UserFrame{

    public SteamStoreFrame(String name) {
        super(name);
        JPanel root1 = new JPanel();
        root1.setBackground(new Color(42, 45, 50));
        root1.setLayout(new FlowLayout());

        SteamButton sb = new SteamButton("asdasdasdasdasd");
        sb.setPreferredSize(new Dimension(400,300));
        root1.add(sb);
    }
}
