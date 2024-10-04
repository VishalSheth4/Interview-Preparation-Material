public class Main
{
    public static boolean isValidString(String str){
        int a[] = new int[26];
		
        // count the frequency -----
		for(int i=0;i<str.length();i++){
		    a[str.charAt(i) -'a']++;
		}
		
        // Find first character with non-zero frequency
        int freq1=0, count_freq1=0;
        int i;
        for(i=0;i<26;i++){
            if(a[i]!=0){
                freq1 = a[i];
                count_freq1 = 1;
                break;
            }
        }

        // Find a character with frequency different from freq1
        int freq2=0, count_freq2=0;
        int j; 
        for(j=i+1;j<26;j++){
            if(a[j]!=0){
                if(a[j] == freq1){
                    count_freq1++;
                }else{
                    freq2 = a[j];
                    count_freq2 = 1;
                    break;
                }
            }
        }
        
        // If we find the non-zero frequncy
        // OR 
        // Count of both frequencies become more than 1, then return false;
        for(int k=j+1;k<26;k++){
            if(a[k]!=0){
                if(a[k]==freq1){
                    count_freq1++;
                }
                else if(a[k]==freq2){
                    count_freq2++;
                }else{
                    return false;
                }
            }
            if(count_freq1 > 1 && count_freq2 > 1){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String str = "aaabb";
		System.out.println(isValidString(str));
		
	}
}
