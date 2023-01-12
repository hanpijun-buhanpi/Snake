package draw;

import map.Map;
import map.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// 绘画类
public class Draw extends JPanel {
    private Map map;    // 地图类

    // 初始化
    public Draw(int width, int height) throws Exception {
        if (Map.getInstance() == null) {
            throw new Exception("地图类获取失败，请先创建地图类");
        }
        map = Map.getInstance();
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        drawAll(g);
    }

    // 画边界
    public void drawBorder(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 255));
        for (Point point : map.getBorder().getBorderList()) {
            graphics.fillRect(point.getX(), point.getY(), map.getW(), map.getH());
        }
    }

    // 画蛇
    public void drawSnake(Graphics graphics) {
        List<Point> list = map.getSnake().getSnake();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                graphics.setColor(new Color(255, 0, 255));
                graphics.fillRect(list.get(0).getX(), list.get(0).getY(), map.getW(), map.getH());
            }
            if (i > 0) {
                graphics.setColor(new Color(0, 255, 0));
                graphics.fillRect(list.get(i).getX(), list.get(i).getY(), map.getW(), map.getH());
            }
        }
    }

    // 画食物
    public void drawFood(Graphics graphics) {
        Point point = map.getFood().getFood();
        graphics.setColor(new Color(255, 0, 0));
        graphics.fillRect(point.getX(), point.getY(), map.getW(), map.getH());
    }

    // 画全部
    public void drawAll(Graphics graphics) {
        if (map.getBorder() != null) {
            drawBorder(graphics);
        }
        if (map.getSnake() != null) {
            drawSnake(graphics);
        }
        if (map.getFood() != null) {
            drawFood(graphics);
        }
    }
}
