class Solution {
    public int tribonacci(int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return tribonacci(n-3) + tribonacci(n-1) + tribonacci(n-2);
    }
}
