//55  跳跃游戏
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 0) return true;
        int max = 0,temp = 0;

        for(int i = 0; i <= max; i++){
            max = Math.max(max, i + nums[i]);
            if(max >= n - 1) return true;
        }
        return false;
    }
}
