package draw;

import javax.swing.*;
import java.awt.*;

// 窗口类
public class Frame extends JFrame {

    // 初始化
    public Frame(int width, int height, JPanel panel) {
        setTitle("Snake");
        int w = width + 16;
        int h = height + 39;
        setSize(w, h);
        int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
        int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((sw-w)/2, (sh-h)/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        setContentPane(panel);
        try {
            Thread.sleep(100);  // 此处是为了等待画笔加载完成
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
