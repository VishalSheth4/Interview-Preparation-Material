
import java.util.*;
class Solution
{
    long countTriplets(long arr[], int n,int sum){
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n - 2; i++)
        {
            int j = i + 1, k = n - 1;
            while (j < k)
            {
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;
                else
                {
                    ans += (k - j);
                    j++;
                }
            }
        }
        return ans;
    }
}
