package map;

import java.util.List;

// 边界类
public class Border {
    private List<Point> borderList; // 边界

    public Border(List<Point> borderList) {
        this.borderList = borderList;
    }

    // 获取边界
    public List<Point> getBorderList() {
        return borderList;
    }
}
