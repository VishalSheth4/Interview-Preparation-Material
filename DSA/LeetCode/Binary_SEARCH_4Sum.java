import java.util.*;
class Solution {
    Set<List<Integer>> s = new HashSet<List<Integer>>(); 
     void ThreeSum(int i,int a[], int target){
        for(int j=i+1;j<a.length;j++){
            TwoSum(i,j,a,target);
        }
    }
     void TwoSum(int i,int j, int a[], int target){
        int start = j+1;
        int end = a.length-1;
        while(start < end){
            int sum = a[start] + a[end] + a[i] + a[j];
            if(sum == target){
                s.add(Arrays.asList(a[start], a[i], a[j], a[end]));
                start++;
                end--;
            }else if(sum < target){
                start++;
            }else{
                end--;
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
         for(int i =0;i<nums.length;i++){
            ThreeSum(i,nums,target);
        }
        return s.stream().collect(Collectors.toList());
    }
}
