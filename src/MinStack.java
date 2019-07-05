//155 最小栈

import java.util.ArrayList;
import java.util.List;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {
    /** initialize your data structure here. */
   List<Integer> stack = null;
   int min = Integer.MAX_VALUE;
    public MinStack() {
       stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        min = Math.min(min,x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int e = stack.remove(stack.size() - 1);
            if(e == min){
                min = Integer.MAX_VALUE;
                for(Integer k : stack){
                    min = Math.min(k, min);
                }
            }
        }

    }

    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return this.min;
    }
}
