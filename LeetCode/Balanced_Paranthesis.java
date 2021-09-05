class Solution {
    
    /* 3 Condition ---
    1. - close == n : then print.add
    2. - open > close : then add closee in the output string
    3. - open < n : then add open in the output string
    
    Note : remove lastcharacter from output string ----
    */
    
    List paran(List l, int n,StringBuilder output, int close, int open)
    {
        if(close == n){
          l.add(output.toString());  
          return l;  
        }else{
            if(open > close){
                output.append(')');
                paran(l,n,output,close+1, open);
                output.deleteCharAt(output.length() - 1);
            }
            if(open < n){
                output.append('(');
                paran(l,n,output,close, open+1);
                output.deleteCharAt(output.length() - 1);
            }
        }
        return l;
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<String>();
        // StringBuilder output;
            if(n==0){
                return l;
            }
        paran(l,n,new StringBuilder(),0,0);
        return l;
    }
}
