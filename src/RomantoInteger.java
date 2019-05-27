import java.util.HashMap;

//13 罗马数字转化为数字
public class RomantoInteger {
    public int romanToInt(String s) {
        int sum = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int n = s.length();

        for(int i=0;i< n - 1;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                sum -= map.get(s.charAt(i));
            else
                sum += map.get(s.charAt(i));
        }
        return sum + map.get(s.charAt(n-1));
//        int n = s.length();
//        if(n == 1) return map.get(s.charAt(0));
//        for(int i = 0 ; i < n - 1; i ++){
//            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
//                sum += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
//                i++;
//            }else {
//                sum += map.get(s.charAt(i));
//            }
//        }
//        if(map.get(s.charAt(n-2)) >= map.get(s.charAt(n-1))){
//            sum += map.get(s.charAt(n-1));
//        }
//        return sum;
    }
}
