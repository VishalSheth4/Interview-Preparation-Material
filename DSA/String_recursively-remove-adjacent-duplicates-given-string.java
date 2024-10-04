public class Main
{    // BACAACB
    static String removeDuplicates(String s){
        String S2="";
        int i=0;
        int j=0;
        int len = s.length(),l=0,r=0,flag,isRoundNeeded=0;
        while(i<len){
            j=i+1;
            flag = 0;
            while((j<len) && (s.charAt(i) == s.charAt(j))){
                j++;
                flag = 1;
                isRoundNeeded = 1;
            }
            if(flag!=1){
                // System.out.println(l+""+r);
                S2 = S2 + s.substring(j-1,j);
                // System.out.println(S2);
            }
            i=j;
        }
        if(isRoundNeeded == 0){
            return S2;
        }else{
            return removeDuplicates(S2);
        }            
    }
	public static void main(String[] args) {
		String str2 = "BACAACB";
		String str5 = "aaaacddddcappp";
        System.out.println(removeDuplicates(str5));
	}
}
