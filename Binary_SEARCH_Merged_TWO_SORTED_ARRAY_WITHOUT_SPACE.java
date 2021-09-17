class Solution {

    public void swap(int arr1[], int arr2[], int i ,int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    public void merge(int arr1[], int arr2[], int n, int m) {
        int i = 0;
	    int j = 0;
	    while(i<n && j<m){
	        if(arr1[i]<arr2[j]){
	            i++;
	        }else{
	            swap(arr1,arr2,n-1,j);
	            j++;
	            n--;
	            
	        }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
