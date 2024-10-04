/*
 Algorithm:
 
   Step 1: sort the numbers and select the k largest numbers from the sorted list
   Step 2: if the sum of those is odd, you will have to replace one even number with an odd number, or vice versa
   Step 3: find the smallest even/odd number from the selection, and the largest odd/even number from the remaining numbers (if any)
           see which of those two possible replacements produces the larger sum
*/

public class MaximumEvenSumWithKElements {
	static int findMaximumEvenSumWithKElements(int A[], int k) {
		if (k > A.length)
			return -1;
		Arrays.sort(A);
		int n = A.length;
		int sum = 0;
		for (int i = n - 1, j = k; j >= 1; i--, j--) {
			sum += A[i];
		}
		if (sum % 2 == 0)
			return sum;
		if (n == k)
			return -1;
		int minOdd = -1, minEven = -1;
		for (int i = n - k; i < n; i++) {
			if (minOdd == -1 && A[i] % 2 == 1)
				minOdd = A[i];
			if (minEven == -1 && A[i] % 2 == 0)
				minEven = A[i];
			if (minOdd != -1 && minEven != -1)
				break;
		}
		int maxOdd = -1, maxEven = -1;
		for (int i = n - k - 1; i >= 0; i--) {
			if (maxOdd == -1 && A[i] % 2 == 1)
				maxOdd = A[i];
			if (maxEven == -1 && A[i] % 2 == 0)
				maxEven = A[i];
			if (maxOdd != -1 && maxEven != -1)
				break;
		}
		int diff1 = -1;
		if (maxOdd != -1 && minEven != -1)
			diff1 = minEven - maxOdd;
		int diff2 = -1;
		if (maxEven != -1 && minOdd != -1)
			diff2 = minOdd - maxEven;
		if (diff1 == -1 && diff2 == -1)
			return -1;
		if (diff1 == -1)
			return sum - diff2;
		if (diff2 == -1)
			return sum - diff1;
		return sum - Math.min(diff1, diff2);
	}
	
	public static void main(String[] args) {
		System.out.println(findMaximumEvenSumWithKElements(new int[] {4,9,8,2,6}, 3));
		System.out.println(findMaximumEvenSumWithKElements(new int[] {5,6,3,4,2}, 5));
		System.out.println(findMaximumEvenSumWithKElements(new int[] {7,7,7,7,7}, 1));
		System.out.println(findMaximumEvenSumWithKElements(new int[] {10000}, 2));
		System.out.println(findMaximumEvenSumWithKElements(new int[] {2,3,3,5,5}, 3));
	}
}
