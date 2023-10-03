public class k_th_element_in_two_sorted_array {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i=0;
        int j=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                k--;
                if(k==0){
                    return arr1[i];
                }
                i++;
            }else{
                k--;
                if(k==0){
                    return arr2[j];
                }
                j++;
            }
        }
        while(i<n){
            k--;
            if(k==0){
                return arr1[i];
            }
            i++;
        }
        while(j<m){
            k--;
            if(k==0){
                return arr2[j];
            }
            j++;
        }  
        return -1;
    }

}
