public class Main
{
    
    // charAt(i)==charAt(j)
    // j == pattern_len
    // i<text_len && charAt(i)!=charAt(j) : j!=0 ? j==0
    
    public static void KMP(String text, String pattern){
        int text_len = text.length();
        int pattern_len = pa.length();
        int LPS[] = new int[pattern_len];
        computeLPSArray(pattern,pattern_len,LPS);
        
        int j=0;
        int i=0;
        while(i<text_len){
            if(pattern.charAt(j)==text.charAt(i)){
                i++;
                j++;
            }
            if(j==pattern_len){
                System.out.println("Found at Indx"+(i-j));
                j=LPS[j-1];
            }else if(i<text_len && (pattern.charAt(j)!=text.charAt(i))){
                if(j!=0){
                    j = LPS[j-1];
                }else{
                    i++;
                }
            }
        }
    }
    
    // Four checkpoints :
    // charAt(i)==charAt(j)
    // i!=j : j!=0 ? j==0
    public static void computeLPSArray(String pattern, int n, int LPS[]){
        int j=0;
        int i=1;
        LPS[0]=0;
        while(i<n){
            if(pattern.charAt(i)==pattern.charAt(j)){
                // 
                j++;
                LPS[i]=j;
                i++;
            }else{
                // 
                if(j!=0){
                //   
                    j=LPS[i-1];
                }else{
                // 
                    LPS[i]=j;
                    i++;
                }
            }
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMP(txt,pat);
	}
}
