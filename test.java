
import java.util.*;
    class Employee implements Comparable{
        int id;
        String name;
        
        Employee(int i, String n){
            id=i;
            name=n;
        }
        
        @Override
        public void toString(){
            System.out.println(id +" - "+name);
        }
        @Override
        public int compareTo(Employee e){
            return this.id - e.id;
        }
    }
public class test{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] a = {4,9,1,10};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		Employee[] emp = new Employee[4];
		emp[0] = new Employee(4,"A");
		emp[1] = new Employee(5,"b");
		emp[2] = new Employee(1,"C");
		emp[3] = new Employee(10,"D");
		
		Arrays.sort(emp);
		System.out.println(Arrays.toString(emp));
	}
}