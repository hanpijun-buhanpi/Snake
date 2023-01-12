package move;

import map.*;
import type.Direction;
import type.Type;

// 移动类
public class Move {
    private Map map;    // 地图类
    private Border border;  // 边界类
    private Snake snake;    // 蛇类
    private Food food;  // 食物类
    private Direction direction;    // 方向
    private boolean enableBorder;   // 是否开启边界
    private boolean run;    // 是否运行

    // 初始化
    public Move() throws Exception {
        map = Map.getInstance();
        if (map == null) {
            throw new Exception("地图类获取失败，请先创建地图类");
        }
        border = map.getBorder();
        snake = map.getSnake();
        food = map.getFood();
        direction = Direction.UP;
        enableBorder = map.getBorder() != null;
        run = true;
    }

    public boolean run() {
        switch (direction) {
            case UP:
                return up();
            case DOWN:
                return down();
            case LEFT:
                return left();
            case RIGHT:
                return right();
        }
        return false;
    }

    public boolean up() {
        Point point = snake.getHead();
        if (enableBorder) {
            if (point.getR() == 1) return false;
        }
        Point p;
        if (point.getR() == 0) {
            p = Map.getPoint(point.getC(), map.getRow() - 1);
        } else {
            p = Map.getPoint(point.getC(), point.getR() - 1);
        }
        return equalsType(p);
    }

    public boolean down() {
        Point point = snake.getHead();
        if (enableBorder) {
            if (point.getR() == map.getRow() - 2) return false;
        }
        Point p;
        if (point.getR() == map.getRow() - 1) {
            p = Map.getPoint(point.getC(), 0);
        } else {
            p = Map.getPoint(point.getC(), point.getR() + 1);
        }
        return equalsType(p);
    }

    public boolean left() {
        Point point = snake.getHead();
        if (enableBorder) {
            if (point.getC() == 1) return false;
        }
        Point p;
        if (point.getC() == 0) {
            p = Map.getPoint(map.getCol() - 1, point.getR());
        } else {
            p = Map.getPoint(point.getC() - 1, point.getR());
        }
        return equalsType(p);
    }

    public boolean right() {
        Point point = snake.getHead();
        if (enableBorder) {
            if (point.getC() == map.getCol() - 2) return false;
        }
        Point p;
        if (point.getC() == map.getCol() - 1) {
            p = Map.getPoint(0, point.getR());
        } else {
            p = Map.getPoint(point.getC() + 1, point.getR());
        }
        return equalsType(p);
    }

    // 判断目标点
    public boolean equalsType(Point point) {
        Type type = point.getType();
        if (type == Type.BORDER) return false;
        if (type == Type.SNAKE) return false;
        if (type == Type.NULL) snake.update(point);
        if (type == Type.FOOD) {
            snake.updateAdd(point);
            food.createFood();
        }
        return true;
    }

    // 获取当前方向
    public Direction getDirection() {
        return direction;
    }

    // 设置当前方向
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean getRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
