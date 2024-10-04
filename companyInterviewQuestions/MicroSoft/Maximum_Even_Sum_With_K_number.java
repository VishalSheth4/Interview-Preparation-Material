// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

class Solution {
    public int solution(int A[], int k) {
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
}

