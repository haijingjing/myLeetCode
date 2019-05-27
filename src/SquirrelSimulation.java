//573 松鼠模拟


/**
 * 如果小松鼠本身就在树的位置，那么把所有的栗子运回树的步数就是一个定值，为每个粟子距树的距离总和乘以2。
 * 那么只有当小松鼠不在树的位置时候，它首先要走到一个粟子的位置，然后再去树那儿。而且一旦小松鼠到了树那，
 * 再出发，之后的步数就是定值了。所以关键就在于决定小松鼠首先去哪个粟子那。
 * 这道题很容易犯的一个错误，就是在选起始粟子的时候的判定条件是松鼠到该粟子的距离加上该粟子到树的距离之和最小当作判定条件，
 * 举个简单的反例，比如此时有两个粟子A和B，小松鼠到粟子A的距离为2，粟子A到树的距离为1，小松鼠到粟子B的距离为2，
 * 粟子B到树的距离为2。那么按照博主之前的选择方法，会选先去粟子A，因为小松鼠到粟子A再到树的距离之和为3，
 * 小于先去粟子B再去树的距离之和(为4)。然而小松鼠先去粟子A的话，总距离就是7，而如果先去粟子B的话，总距离为6，
 * 这就说明之前的判定条件不对。
 * 那么正确思路应该是，假设小松树最先应该去粟子i，那么我们假设粟子i到树的距离为x，小松鼠到粟子i的距离为y
 * ，那么如果小松鼠不去粟子i，累加步数就是2x，如果小松鼠去粟子i，累加步数就是x+y，
 * 我们希望x+y尽可能的小于2x，那么就是y尽可能小于x，即x-y越大越好。这样我们遍历每个粟子，找出x-y最大的那个，让小松鼠先去捡就好了。
 */
public class SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int res = 0, maxDiff = Integer.MIN_VALUE, idx = 0;
        for(int[] nut: nuts){
            int distance = Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);//坚果到树的距离
            res += 2 * distance;
            maxDiff = Math.max(maxDiff, distance - Math.abs(squirrel[0] - nut[0]) - Math.abs(squirrel[1] - nut[1]));
        }
        return res - maxDiff;
    }
}
