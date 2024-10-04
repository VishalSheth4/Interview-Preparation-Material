public class Main
{
    static boolean isPossible(int board[], int boards, int painter,int mid){
        int painterRequired = 1;
        int curr_Sum = 0;
        for(int i=0;i<boards;i++){
            if(board[i]>mid){
                return false;
            }
            if(curr_Sum+board[i] > mid){
                painterRequired++;
                curr_Sum = board[i];
                if(painterRequired > painter){
                    return false;
                }
            }else{
                curr_Sum +=board[i];
            }
        }
        return true;
    }
    static int findBoard(int board[], int boards, int painter){
        long sum = 0;
        if(boards<painter){
            return -1;
        }
        int totalSum = 0;
        for(int i=0;i<boards;i++){
            totalSum+=board[i];
        }
        int start = 0;
        int end = totalSum;
        int result = Integer.MAX_VALUE;
        while(start<=end){
            int mid = (start+end)/2;
            if(isPossible(board,boards,painter,mid)){
                result = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int board[] ={10,20,30,40};
		int painter = 2;
		System.out.println(findBoard(board,board.length,painter));
	}
}
