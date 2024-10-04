public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int a1[] = {3,5,7,9,20,25,30,40,55,56,57,60,62};
		int a2[] = {1,4,7,11,14,25,44,47,55,57,100};
		int a1Len = a1.length;
		int a2Len = a2.length;
		int sum1 = 0;
		int sum2 = 0;
		int fSum = 0;
		int i=0,j=0;
		while(i<a1Len && j<a2Len){
		    if(a1[i]<a2[j]){
		        sum1 += a1[i];
		        i++;
		    }else if(a1[i]>a2[j]){
		        sum2 += a2[j];
		        j++;
		    }else{
		        fSum = fSum + Math.max(sum1,sum2) + a1[i];
		        sum2 = 0;
		        sum1 = 0;
		        i++;
		        j++;
		    }
		}
		while(i<a1Len){
		    sum1 += a1[i++];
		}
		while(j<a2Len){
		    sum2 += a2[j++];
		}
		fSum = fSum + Math.max(sum1,sum2);
		System.out.println(fSum);
	}
}
