package map;

import type.Type;

import java.util.List;
import java.util.Random;

// 食物类
public class Food {
    private List<Point> nullList;   // 空点
    private Point food; // 食物

    // 初始化
    public Food(List<Point> nullList) {
        food = null;
        this.nullList = nullList;
    }

    // 创建食物
    public Point createFood() {
        int a = new Random().nextInt(1);
        switch (a) {
            case 0:
                food = createFood1();
                break;
        }
        nullList.remove(food);  // 移除空点
        food.setType(Type.FOOD);    // 更改类型
        return food;
    }
    // 创建食物1，完全随机
    private Point createFood1() {
        int a = new Random().nextInt(nullList.size());
        return nullList.get(a);
    }

    // 获取食物
    public Point getFood() {
        return food;
    }
}
