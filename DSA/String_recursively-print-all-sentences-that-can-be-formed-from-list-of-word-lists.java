public class Main
{
    static final int R= 3;
    static final int C =3;
    
    static void printUtil(int m, int n, String output[], String a[][]){
        //1) store the current word in output
        //2) exit condition
        //3) DFS approach
        output[m] = a[m][n];
        
        if(m==R-1){
            for(int i=0;i<C;i++){
                System.out.print(output[i]);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<C;i++){
            if(a[m+1][i]!="" && m<C){
                printUtil(m+1,i,output,a);
            }
        }
        
    }
    static void print(String a[][]){
        String output[] = new String[R];
        // pass only first row variables...
        for(int i=0;i<C;i++){
            if(a[0][i] != ""){
                printUtil(0,i,output,a);
            }
        }
        
    }
	public static void main(String[] args) {
// 		System.out.println("Hello World");
		String [][]arr  = {{"you", "we", ""},
                           {"have", "are", ""},
                           {"sleep", "eat", "drink"}};
        print(arr);
	}
}
