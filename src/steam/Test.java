package steam;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new SteamStoreFrame("Steam");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时关闭整个程序
        frame.setSize(1000,600);//设置窗口大小（长、宽）
        frame.setVisible(true);//使窗口可见
    }
}
