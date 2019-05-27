//4 两个有序数组的中位数
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int i, j , max_left, min_right;
        int imin = 0, imax = m;

        while (imin <= imax){
            i = (imin + imax)/2;
            j = (m + n + 1)/2 - i;
            if(i < m && nums2[j-1] > nums1[i]){
                imin = i + 1;
            }else if(i > 0 && nums1[i-1] > nums2[j]){
                imax = i - 1;
            }else {
                if(i == 0) max_left = nums2[j-1];
                else if(j == 0) max_left = nums1[i-1];
                else max_left = Math.max(nums1[i-1], nums2[j-1]);

                if((m + n) % 2 == 1) return max_left;

                if(i == m) min_right = nums2[j];
                else if(j == n) min_right = nums1[i];
                else min_right = Math.min(nums1[i], nums2[j]);

                return (min_right + max_left)/ 2.0;
            }
        }
        return 0.0;

    }
}
