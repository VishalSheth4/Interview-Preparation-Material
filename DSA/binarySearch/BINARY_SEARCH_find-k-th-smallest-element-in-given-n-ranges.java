/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Intervals{
    int start;
    int end;
    Intervals(int a, int b){
        start = a;
        end = b;
    }
}
public class Main
{
    static void mergeInterval(Intervals a[], int n){
        // Sorting
        Arrays.sort(a, new Comparator<Intervals>(){
            public int compare(Intervals i1, Intervals i2){
                return i1.start - i2.start;
            }
        });
        
        // Merging Overlapping intervals
        int index = 0; 
        for (int i=1; i<a.length; i++)
        {
            if (a[index].end >=  a[i].start)
            {
                a[index].end = Math.max(a[index].end, a[i].end);
                a[index].start = Math.min(a[index].start, a[i].start);
            }
            else {
                index++;
                a[index] = a[i];
            }   
        }
        // Searching in Intervals --------
        // Let X = 7
        int k = 7;
        int ans = -1;
        for(int i=0;i<index;i++){
            if(a[i].end - a[i].start+1  >= k){
                ans = a[i].start+k-1;
                break;
            }else{
                k = k - a[i].end - a[i].start+1 ;
            }
        }
        
        // print 
        System.out.println(ans);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int n = 3;
		Intervals a[] = new Intervals[n];
		a[0] = new Intervals(1,5);
		a[1] = new Intervals(3,7);
		a[2] = new Intervals(10,15);
//		a[3] = new Intervals(4,7);
		mergeInterval(a,n);
	}
}
