/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static boolean isPossible(int book[], int books, int students,int mid){
        int studentsRequired = 1;
        int curr_Sum = 0;
        for(int i=0;i<books;i++){
            if(book[i]>mid){
                return false;
            }
            if(curr_Sum+book[i] > mid){
                studentsRequired++;
                curr_Sum = book[i];
                if(studentsRequired > students){
                    return false;
                }
            }else{
                curr_Sum +=book[i];
            }
        }
        return true;
    }
    static int findPages(int book[], int books, int students){
        long sum = 0;
        if(books<students){
            return -1;
        }
        int totalSum = 0;
        for(int i=0;i<books;i++){
            totalSum+=book[i];
        }
        int startPage = 0;
        int endPage = totalSum;
        int result = Integer.MAX_VALUE;
        while(startPage<=endPage){
            int mid = (startPage+endPage)/2;
            if(isPossible(book,books,students,mid)){
                result = mid;
                endPage = mid-1;
            }else{
                startPage = mid+1;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int books[] ={12,34,67,90};
		int student = 2;
		System.out.println(findPages(books,books.length,student));
	}
}
