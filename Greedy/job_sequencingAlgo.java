/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    static class Job{
        char id;
        int deadLine;
        int profit;
        
        Job(char id, int deadline, int profit){
            this.id = id;
            this.deadLine = deadline;
            this.profit = profit;
        }
    }
    
    static void JobScheduling(ArrayList<Job> l, int jobs){
        int n = l.size();
        Collections.sort(l,(a,b) -> b.profit-a.profit);
        for (Job jb : l) 
        {
            System.out.print(jb.id + " ");
        }
        System.out.println();

        char job[] = new char[jobs];
        boolean result[] = new boolean[jobs];
        
        for(int i=0;i<n;i++){
            for (int j = Math.min(jobs- 1, l.get(i).deadLine - 1);j >= 0; j--) {
                // Free slot found
                if (result[j] == false) 
                {
                    result[j] = true;
                    job[j] = l.get(i).id;
                    break;
                }
            }
        }
        for (char jb : job) 
        {
            System.out.print(jb + " ");
        }
        System.out.println();
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		ArrayList<Job> l = new ArrayList<>();
		l.add(new Job('a', 2,100));
		l.add(new Job('b', 1, 19));
        l.add(new Job('c', 2, 27));
        l.add(new Job('d', 1, 25));
        l.add(new Job('e', 3, 15));
        
        int noofjobSchedule = 3;
        JobScheduling(l,noofjobSchedule);
	}
}
