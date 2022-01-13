public class Main{
    static String lookAndSay(int n) {
		if(n==1) return "1";
		if(n==2) return "11";

		char arr[] = lookAndSay(n-1).toCharArray();
		String str="";
		for(int ptr=0;ptr<arr.length;ptr++){
        	System.out.print(arr[ptr]);		    
		}
    System.out.println();
		int i=0;
		while(i < arr.length) {
			int count=i;
			while(count<arr.length-1 && arr[count]==arr[count+1])
				count++;

			str=str+Integer.toString(count-i+1)+Character.toString(arr[i]);
			i=count+1;
		}
		return str;
	}
        
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println( lookAndSay(8) );
	}
}
