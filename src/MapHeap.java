//堆排序
public class MapHeap {


    public void heapAdjust(int nums[],int i, int size){
        int rc = nums[i];


    }
    public void heapSort(int nums[]){
        //调整为大顶堆
        for(int i = (nums.length - 1) / 2; i > 0; i--)
        {
            heapAdjust(nums, i, nums.length-1);
        }
        int temp;
        //将整个根节点根节点最后一个子节点进行交换

    }
}
