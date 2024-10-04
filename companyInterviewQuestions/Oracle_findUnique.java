// Two pointer problem
public class Main
{
     static void findunnique(int[] a) {
    	 int n=a.length;
    	 int id=0,i=1;
    	 
    	 while(i<n)
    	 {
    		 if(a[id]==a[i])
    		 {
    			 i++;
    		 }
    		 else if(a[id]!=a[i])
    		 {
    			 a[id+1]=a[i];
    			 id++;
    			 i++;
    		 }
    			  
    	 }
    	 // add -1 in the end
    	 for(int j=id+1;j<n;j++)
    	 {
    		 a[j]=-1;
    	 }
	}
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = {1,2,2,2,3,3,4};
		findunnique(a);
		for(int i=0;i<a.length;i++){
		    System.out.println(a[i]);
		}
	}
}
