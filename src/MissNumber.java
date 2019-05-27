public class MissNumber {
   /* public int missingNumber(int[] nums) {
        int len = nums.length;
        int[] a = new int[len+1];
        for(int i = 0; i <= len; i++){
            a[i] = 0;
        }
        for(int i = 0; i < len; i++){
            a[nums[i]]=1;
        }
        for(int i = 0; i <= len; i++){
            if(a[i]==0){
                return i;
            }
        }
        return 0;
    }*/
   //求和，然后减去所有，剩下的就是缺的数字
   /*public int missingNumber(int[] nums) {
       int len = nums.length;
       int sum = len*(len+1)/2;
       for(int i = 0; i< len; i++){
           sum -= nums[i];
       }
       return sum;
   }*/
   //异或

    /**
     * 异或的原理简单介绍下，比如vector是[0,1,3]，那么我们把[0,3]之间的数都跟vector中的数[0,1,3]做异或，结果是0^1^2^3^0^1^3=2，也就能出现那个只出现一次的值。

     为什么能这样，因为异或支持交换律和结合律，上面的式子，我们其实能重新写成(0^0)^(1^1)^2^(3^3)。

     同时，异或的规则是两个相同的数异或结果为0，两个不同的数异或结果是1（二进制的表示方法）

     所以(0^0)结果肯定是0，(1^1)也就是0001^0001=0000=0，(3^3)=0011^0011=0000=0，所以0^2=0000^0010=0010=2。所以最终结果为2。

     我们可以用异或来找到那个只出现一次的数字。
     * @param nums
     * @return
     */
   public int missingNumber(int[] nums) {
       int sum = nums.length;
       for (int i = 0; i < sum; ++i) {
           sum = sum ^ nums[i] ^ i;
       }
       return sum;
   }
}
