/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */

import java.util.HashMap;
import java.util.Map;

public class MajorNum {
    //1.map统计
    /*public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int n:nums) {
            if(!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.put(n,map.get(n)+1);
            }
            if(map.get(n) > len/2){
                return n;
            }
        }
        return 0;
    }*/
    /**2.摩尔投票法
     * 摩尔投票法的基本思想很简单，在每一轮投票过程中，从数组中找出一对不同的元素，将其从数组中删除。
     * 这样不断的删除直到无法再进行投票，如果数组为空，则没有任何元素出现的次数超过该数组长度的一半。
     * 如果只存在一种元素，那么这个元素则可能为目标元素。
     */
    public int majorityElement(int[] nums){
        int count = 0;
        int maj = nums[0];
        for(int i = 0; i < nums.length;i++){
            if(maj == nums[i]){
                count++;
            }else {
                count--;
                if(count==0){
                    maj = nums[i+1];
                }
            }
        }
        return maj;
    }
}
