class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    static long mergeandCount(int a[],int l,int mid,int r){
        int left[] = Arrays.copyOfRange(a,l,mid+1);
        int right[] = Arrays.copyOfRange(a,mid+1,r);
        int i=0, j=0, k=l, swaps=0;
        // 1) steps 
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                a[k++] = left[i++];
            }else{
                a[k++] = right[i++];
                swaps = swaps+ (mid+1)-(l+i);
            }
        }
        while(i<left.length){
            a[k++]=left[i++];
        }
        while(j<right.length){
            a[k++]=right[j++];
        }
        return swaps;
    }
    static long mergeSortandcount(int[] a, int l, int r){
        int count = 0;
        if(l<r){
            int mid = (l+r)/2;
            count += mergeSortandcount(a,l,mid);
            count += mergeSortandcount(a,mid+1,r);
            count += mergeandCount(a,l,mid,r);
        }
        return count;
    }
