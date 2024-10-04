class Solution {
    public  int triUtil(int a[], int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 1;
        }else if(a[n] != -1){
            return a[n];
        }else{
            a[n] = triUtil(a, n-3) + triUtil(a, n-1) + triUtil(a, n-2);
            return a[n];
        }
    }
    public int tribonacci(int n) {
        if(n <= 0){
            return 0;
        }
        n=n+1;
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = -1;
        }
        return triUtil(a,--n);
    }
}
