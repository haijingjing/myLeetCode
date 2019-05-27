import java.util.HashMap;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                if(map.get(target-numbers[i]) != i){
                    result[0] = map.get(target-numbers[i]) + 1;
                    result[1] = i + 1;
                    return result;
                }
            }
            map.put(numbers[i],i);
        }
        return result;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (numbers[left] + numbers[right]  != target){
            if (numbers[left] + numbers[right]  > target){
                right --;
            }
           else left ++;
        }
        result[0] = left + 1;
        result[1] = right + 1;
        return result;
    }
}
