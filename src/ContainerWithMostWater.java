//11 盛最多水的容器
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int area = 0;
        for(int i =0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(area,max);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int result = Integer.MIN_VALUE;
        for(int i=0, j=height.length-1;i<j;) {
            result = Math.max(result, (j-i) * Math.min(height[i], height[j]));
            if(height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
