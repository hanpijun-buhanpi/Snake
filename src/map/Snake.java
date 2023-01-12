package map;

import type.Type;

import java.util.ArrayList;
import java.util.List;

// 蛇类
public class Snake {
    private List<Point> nullList;   // 空点
    private List<Point> list;   // 蛇数据

    // 初始化，添加蛇头
    public Snake(Point point, List<Point> nullList) {
        list = new ArrayList<>();
        list.add(point);
        this.nullList = nullList;
    }

    // 身体变化-无增长
    public void update(Point point) {
        // 增加头部，移除尾部
        point.setType(Type.SNAKE);
        list.add(0, point);
        Point p = list.get(list.size()-1);
        p.setType(Type.NULL);
        list.remove(p);
        // 移除空点，加入空点
        nullList.remove(point);
        nullList.add(p);
    }

    // 身体变化-增长
    public void updateAdd(Point point) {
        // 增加头部
        point.setType(Type.SNAKE);
        list.add(0, point);
        // 移除空点
        nullList.remove(point);
    }

    // 获取头部
    public Point getHead() {
        return list.get(0);
    }

    public List<Point> getSnake() {
        return list;
    }
}
