import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {



    public static int solutions(int a, int b, int c){
        int d = b*b-4*a*c;
        if(d<0) return 0;
        else if(d>0) return 2;
        else return 1;
    }

    public static int findZip(String a){
        return a.indexOf("zip", a.indexOf("zip")+1);
    }

    public static boolean checkPerfect(int a){
        int result=0;
        for (int i=a-1; i>0; i--){
            if (a%i==0) result+=i;
        }
        return result==a;
    }

    public static String flipEndChars(String a){
//        a.charAt(a.length()-1)==b.charAt(0) && b.charAt(b.length()-1)==a.charAt(0)
        if(a.length()<2) return"Incompatible.";
        if(a.charAt(a.length()-1)==a.charAt(0)) return "Two's a pair.";
        return a.charAt(a.length()-1)+a.substring(1,a.length()-1)+a.charAt(0);
    }

    public static boolean isValidHexCode(String a){
        Pattern p =Pattern.compile("(^[#][a-y[A-Y][0-9]]{6})");
        Matcher m = p.matcher(a);
        return m.matches();
    }

    public static int same(int[] arr1, int[] arr2){
//        int dick=0;
//        for(int i=0;i<arr1.length;i++)
//            if (arr1[i]==)
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count=0;
        for(int i=0; i<arr1.length-1;i++){
            for (int j=i+1;j<arr1.length-1;j++){
                if (arr1[i]==arr1[j]){
                    count+=1;
                    if (arr1[i]==arr1[j+1]){

                        if(j+1==arr1.length-1){
                            count+=1;
                        }
                        i=j+1;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isValid(String a){
        if (a.length() > 5)
            return false;
        for (int i = 0; i < a.length(); i++){
            if (!Character.isDigit(a.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean isStrangePair(String a, String b){
        return a.charAt(a.length()-1)==b.charAt(0) && b.charAt(b.length()-1)==a.charAt(0);
    }

    public static boolean isPrefix(String word, String pr){
        return word.startsWith(pr.substring(0, pr.length() - 2));
    }

    public static boolean isSuffix(String word, String su){

        return word.endsWith(su.substring(1));
    }

    public static int boxSeq(int n){
        if (n%2==0)
            return n;
        else
            return n+2;
    }

    public static void main(String[] args) {
        System.out.println(solutions(1, 0, -1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(6));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(new int[] {4,5,6,4,8,9,4}));
        System.out.println(isValid("59001"));
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(0));

    }
}
