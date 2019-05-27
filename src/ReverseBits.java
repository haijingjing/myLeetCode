public class ReverseBits {
    public int reverseBits1(int n) {
        int mask32 = 0x0000ffff;
        int mask16 = 0x00ff00ff;
        int mask8 = 0x0f0f0f0f;
        int mask4 = 0x33333333;
        int mask2 = 0x55555555;

         n = ((n & mask32) << 16) + ((n >> 16) & mask32);
         n = ((n & mask16) << 8) + ((n >> 8) & mask16);
         n = ((n & mask8) << 4) + ((n >> 4) & mask8);
         n = ((n & mask4) << 2) + ((n >> 2) & mask4);
         n = ((n & mask2) << 1) + ((n >> 1) & mask2);
        return n;
    }

    public int reverseBits2(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i ++){
            ans <<= 1;
            if( (1 & n) == 1){
                ans ++;
            }
            n >>= 1;
        }
        return ans;
    }
}
