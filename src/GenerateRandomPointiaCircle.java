//478. 在圆内随机生成点
public class GenerateRandomPointiaCircle {
    double r, x, y;
    public GenerateRandomPointiaCircle(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        while (true){
            double dx = (2 * Math.random() - 1) * r;
            double dy = (2 * Math.random() - 1) * r;
            if(dx * dx + dy * dy <= r * r){
                return new double[]{x + dx, y + dy};
            }
        }
    }
}
