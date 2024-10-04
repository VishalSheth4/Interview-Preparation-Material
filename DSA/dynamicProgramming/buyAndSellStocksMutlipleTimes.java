import java.util.*;
public class Main
{
    static int f(int prices[], int index, int n, int buyFlag, int times){
        if(times==0){
            return 0;
        }        
        if(index == n){
            return 0;
        }
        int profit = 0;
        if(buyFlag == 0){
            profit = Math.max(-prices[index]+f(prices,index+1,n,1,times),f(prices,index+1,n,0,times));
        }else{
            profit = Math.max(prices[index]+f(prices,index+1,n,0,times-1),f(prices,index+1,n,1,times));        
        }
        return profit;
    }
    
    static int maxtwobuysell(int prices[], int n, int times){
        return f(prices, 0, n, 0, times);
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
    int timesTransactionOfStocksTimes = 2;
		int arr[] = { 2, 30, 15, 10, 8, 25, 80 };
    int size = arr.length;
    System.out.println(maxtwobuysell(arr, size,timesTransactionOfStocksTimes));
	}
}
