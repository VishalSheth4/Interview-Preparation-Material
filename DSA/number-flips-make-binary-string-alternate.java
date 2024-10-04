//  Just copied bcoz I predicted the logic on paper ---
//  Need to check wheather starting from zero or 1 takes less flip...

class GFG
{
    //  Utility method to flip a character
    public static char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }
      
    //  Utility method to get minimum flips when
    //  alternate string starts with expected char
    public static int getFlipWithStartingCharcter(String str,
                                    char expected)
    {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++)
        {
            //  if current character is not expected,
            // increase flip count
            if (str.charAt(i) != expected)
                flipCount++;
      
            //  flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }
      
    // method return minimum flip to make binary
    // string alternate
    public static int minFlipToMakeStringAlternate(String str)
    {
        //  return minimum of following two
        //  1) flips when alternate string starts with 0
        //  2) flips when alternate string starts with 1
        return Math.min(getFlipWithStartingCharcter(str, '0'),getFlipWithStartingCharcter(str, '1'));
    }
      
    //  Driver code to test above method
    public static void main(String args[])
    {
        String str = "0001010111";
        System.out.println(minFlipToMakeStringAlternate(str));
    }
}
