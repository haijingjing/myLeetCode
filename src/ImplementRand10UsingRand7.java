//470. 用 Rand7() 实现 Rand10()
//https://www.cnblogs.com/grandyang/p/9727206.html 解题思路
public class ImplementRand10UsingRand7 {
    public int rand7(){
        return 1;
    }
    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) return num % 10 + 1;
        }
    }
}
