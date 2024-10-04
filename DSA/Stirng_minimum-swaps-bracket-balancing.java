public class Main
{
    static int swapCount(char a[] ){
        int n = a.length;
        int ans=0;
        int open = 0;
        int close =0;
        int fault =0;
        for(int i=0;i<n;i++){
            if(a[i] == '['){
                open++;
                if(fault > 0){
                    ans += fault;
                    fault--;
                }
            }else{
                close++;
                fault = close - open;
            }
        }

        return ans;
    }
	public static void main(String[] args) {
	    
		System.out.println("Hello World");
		String s = "[]][][";
		char a[] = s.toCharArray();
        System.out.println(swapCount(a));

	}
}
