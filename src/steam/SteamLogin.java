package steam;

import javax.swing.*;

public class SteamLogin {
    public static void main(String[] args) {
        JFrame frame = new LoginFrame("Steam 登录");
        // 关闭窗口时 退出整个程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // 设置窗口大小
        frame.setSize(480,330);
        // 显示窗口
        frame.setVisible(true);
    }
}
