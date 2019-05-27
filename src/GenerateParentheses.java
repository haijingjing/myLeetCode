import java.util.ArrayList;
import java.util.List;

//22 生成括号
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        generate(res, new String(), n, 0, 0);
        return res;
    }

    private void generate(List<String> res, String str, int n, int countleft, int countright) {
        if(countleft == n && countright == n){
            res.add(str);
            return;
        }
        if(countleft < n){
            generate(res, str + "(", n, countleft + 1, countright);
        }
        if(countright < countleft){
            generate(res, str + ")", n, countleft, countright + 1);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        backTrace(res, new String(), n, n);
        return res;
    }

    private void backTrace(List<String> res, String str, int left, int right) {
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        if(left > 0){
            backTrace(res, str + "(", left - 1, right);
        }
        if(right > left){
            backTrace(res, str + ")", left, right - 1);
        }
    }

}
