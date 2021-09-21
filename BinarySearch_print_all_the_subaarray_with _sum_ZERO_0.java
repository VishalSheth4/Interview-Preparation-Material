/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Pair{
    int first,second;
    Pair(int a, int b){
        first = a;
        second = b;
    }
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int n = arr.length;
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum == 0){
                out.add(new Pair(0,i));
            }
            ArrayList<Integer> al = new ArrayList<>();
            if(hmap.containsKey(sum)){
                al = hmap.get(sum);
                for(int j=0;j<al.size();j++){
                    out.add(new Pair(al.get(j)+1,i));
                }
            }
            al.add(i);
            hmap.put(sum,al);
        }
        System.out.println(out);
	}
}
