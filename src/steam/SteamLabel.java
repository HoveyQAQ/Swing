package steam;

import javax.swing.*;
import java.awt.*;

public class SteamLabel extends JLabel {
    public SteamLabel (String text)
    {
        this.setFont(Font.getFont("等线"));
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        this.setText( text );
        this.setForeground( Color.GRAY );
    }
}
