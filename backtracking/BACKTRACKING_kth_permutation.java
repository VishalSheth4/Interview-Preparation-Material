import java.util.*;
public class Main
{
    public static String getPermutation(int n,int k){
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<n;i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while(true){
            ans = ans + numbers.get(k/ fact);
            numbers.remove(k/fact);
            if(numbers.size()==0){
                break;
            }
            k = k%fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println(getPermutation(4,17));
	}
}