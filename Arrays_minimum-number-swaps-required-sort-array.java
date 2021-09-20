import java.util.*;
public class Main
{
    static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = { 101, 758, 315, 730, 472,619, 460, 479 };
		int n = a.length;
		int temp[] = Arrays.copyOfRange(a,0,n);
		Arrays.sort(temp);
		HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
		    hmap.put(a[i],i);
		}
		int ans = 0;
		for(int i=0;i<n;i++){
		    if(a[i]!=temp[i]){
		        ans++;
		        int index = a[i];
		        swap(a,i,hmap.get(temp[i]));
		        hmap.put(index,hmap.get(temp[i]));
		        hmap.put(temp[i],i);
		    }
		}
		System.out.println(ans);
	}
}
