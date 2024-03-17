package vissheth;

//public class test_1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("Hello world");
//
//	}
//
//}


import java.util.*;
class Employee implements Comparable<Employee>{
    int id;
    String name;
    
    Employee(int i, String n){
        id=i;
        name=n;
    }
    
    @Override
    public String toString(){
        System.out.println(id +" - "+name);
		return id+" - "+name;
    }

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
		// TODO Auto-generated method stub
	}
}
public class test_1
{

public static void main(String[] args) {
	System.out.println("Hello World");
	int[] a = {4,9,1,10};
//	Arrays.sort(a);
	System.out.println(Arrays.toString(a));
	
	Employee[] emp = new Employee[4];
	emp[0] = new Employee(4,"A");
	emp[1] = new Employee(5,"B");
	emp[2] = new Employee(1,"C");
	emp[3] = new Employee(10,"D");
	
//	Arrays.sort(emp);
//	System.out.println(Arrays.toString(emp));
	
	Comparator<Employee> NameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			
			return o1.name.compareTo(o2.name);
		}		
	};
	
	Arrays.sort(emp,NameComparator);
	System.out.println(Arrays.toString(emp));
}
}
