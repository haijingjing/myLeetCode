import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 */
public class MajorNum2 {
   /* public List<Integer> majorityElement(int[] nums) {
        List<Integer> a = new ArrayList<Integer>();
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int n:nums) {
            if(!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.put(n,map.get(n)+1);
            }
            if(map.get(n) > len/3 && !a.contains(n)){
                a.add(n);
            }
        }
        return a;
    }*/
    /**
     * 【笔记】摩尔投票法。该算法用于1/2情况，它说：“在任何数组中，出现次数大于该数组长度一半的值只能有一个。”

     那么，改进一下用于1/3。可以着么说：“在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。”

     于是，需要定义两个变量。空间复杂度为O(1)。

     摩尔投票法：https://mabusyao.iteye.com/blog/2223195

     算法1/3改进：https://blog.csdn.net/weixin_42768679/article/details/81567231
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> a = new ArrayList<Integer>();
        int len = nums.length;
        int x = 0;
        int y = 0;
        int scorex = 0;
        int scorey = 0;
        for(int i = 0;  i < len; i++){
            if(x == nums[i]){
                scorex++;
            }else if(y == nums[i]){
                scorey++;
            }else if(scorex == 0){
                x = nums[i];
                scorex++;
            }else if(scorey == 0){
                y = nums[i];
                scorey++;
            }else {
                scorex--;
                scorey--;
            }
        }
        //验证
        scorex =0; scorey=0;
        for(int i = 0; i < len; i++){
            if(nums[i] == x) scorex++;
            else if(nums[i] == y) scorey++;
        }
        if(scorex > len/3){
            a.add(x);
        }
        if(scorey > len/3){
            a.add(y);
        }
        return a;
    }
}
