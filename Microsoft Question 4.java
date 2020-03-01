public class HelloWorld{
    
    public static String valid(String s)
    {
        String ret = "";
        int n = 1;
        char prev = s.charAt(0);
        ret += s.charAt(0);
        int count = 1;
        
        while(n < s.length())
        {
            if(s.charAt(n) == prev && count == 2)
            {
                break;
            }
            if(s.charAt(n) != prev)
            {
                count = 1;
                ret += s.charAt(n);
            }
            if(s.charAt(n) == prev && count < 2)
            {
                ret += s.charAt(n);
                count++;
            }
            prev = s.charAt(n);
            n++;
        }
        
        return ret;
    }

     public static void main(String []args){
        System.out.println(valid("aabbaabbaabbaa"));
     }
}
