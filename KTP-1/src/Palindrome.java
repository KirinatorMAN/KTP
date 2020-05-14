public class Palindrome {
    public static void main(String[]args){
        for(int i=0; i<args.length; i++){
            String s=args[i];
            System.out.println (isPalindrome(s));
        }
    }
    public static String reverseString(String str){
        String s1="";
        for(int i=str.length()-1; i>=0; i--){
            s1+=str.charAt(i);
        }
        return s1;
    }
    public static boolean isPalindrome(String s){
        return (reverseString(s).equals(s));
    }

}

