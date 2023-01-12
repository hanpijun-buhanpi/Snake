package map;

import type.Type;

import java.util.ArrayList;
import java.util.List;

// 地图类
public class Map {
    private static Map map;

    private List<List<Point>> mapList;  // 全点
    private List<Point> nullList;   // 空点
    private Border border;  // 边界
    private Snake snake;    // 蛇
    private Food food;  // 食物

    // 行列
    private int row;
    private int col;

    // 宽高
    private int w;
    private int h;

    private Map() {

    }

    // 初始化——起始点x，起始点y，窗口宽高，准备弄多少行列，是否开启边界
    public static Map createMap(int width, int height, int col, int row, boolean enableBorder) {
        map = createMap(0, 0, width, height, col, row, enableBorder);
        return map;
    }
    public static Map createMap(int startX, int startY, int width, int height, int col, int row, boolean enableBorder) {
        // 初始化本类
        map = new Map();

        // 创建全点和空点
        map.mapList = new ArrayList<>();
        map.nullList = new ArrayList<>();
        // 每个点的宽高
        map.w = width / col;
        map.h = height / row;
        // 创建点
        for (int i = 0; i < row; i++) {
            List<Point> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                // 创建点，并添加到全点和空点
                Point point = new Point(startX + j * map.w, startY + i * map.h, j, i, Type.NULL);
                list.add(point);
                map.nullList.add(point);
                // 判断是否开启了边界
                if (enableBorder) {
                    // 初始化边界类
                    if (map.border == null) {
                        map.border = new Border(new ArrayList<>());
                    }
                    // 判断边界点，向边界类添加数据，并移除空点
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        point.setType(Type.BORDER);
                        map.border.getBorderList().add(point);
                        map.nullList.remove(point);
                    }
                }
            }
            // 添加数据到全点
            map.mapList.add(list);
        }

        // 初始化蛇类
        // 判断地图中心点
        int x = col % 2 == 0 ? col / 2 : col / 2 +1;
        int y = row % 2 == 0 ? row / 2 : row / 2 + 1;
        map.snake = new Snake(getPoint(x, y), map.nullList);

        // 初始化食物类
        map.food = new Food(map.nullList);

        // 保存行列数据
        map.row = row;
        map.col = col;

        // 返回创建好的map
        return map;
    }

    // 获取点
    public static Point getPoint(int x, int y) {
        if (map.mapList == null) {
            return null;
        }
        return map.mapList.get(y).get(x);
    }

    // 返回实例
    public static Map getInstance() {
        return map;
    }

    public List<Point> getNullList() {
        return nullList;
    }

    public Border getBorder() {
        return border;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
