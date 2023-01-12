import draw.Draw;
import draw.Frame;
import map.Map;
import move.Move;
import move.MyKeyListener;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        int width = 500;    // 画布宽
        int height = 500;   // 画布高
        int col = 25;   // 地图列
        int row = 25;   // 地图行

        int speed = 100;    // 运行间隔，越小速度越快

        Map map = Map.createMap(width, height, row, col, false);    // false不开启边界，true开启边界
        Draw draw = new Draw(width, height);
        Frame frame = new Frame(width, height, draw);
        Move move = new Move();
        MyKeyListener myKeyListener = new MyKeyListener(move);
        frame.addKeyListener(myKeyListener);
        map.getFood().createFood();

        Thread thread = new Thread(() -> {
            while (true) {
                Long time = System.currentTimeMillis();
                while (move.getRun()) {

                    if (!move.run()) {
                        move.setRun(false);
                        JOptionPane.showMessageDialog(
                                null,
                                "您当前长度: " + map.getSnake().getSnake().size() + "，" +
                                "用时: " + ((System.currentTimeMillis() - time) / 1000) + " 秒",
                                "成绩",
                                JOptionPane.OK_OPTION);
                    }
                    draw.repaint();
                    frame.requestFocus();
                    try {
                        Thread.sleep(speed);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}