class Solution {
    public int[] countBits(int n) {
        int index=0;
        int a[] = new int[n+1];
        while(index<=n){
            int temp = index;
            int result=0;
            while(temp>0){
                int F = 1;
                result = result + (temp&F);
                temp = temp>>1;
            }
            a[index] = result;
            index++;
        }
     return a;   
    }
}
