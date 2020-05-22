import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task4 {

    public static String textEditor(int n, int k, String a){
        String[] essay = a.split(" ");
        if (essay.length>n)
            return "Слов больше 100";
        String s="";
        int b=0;
        for (int i =0;i<essay.length;i++) {
//            b -= i;
            if (b + essay[i].length() <= k) {
                s+=essay[i]+" ";
                b+=essay[i].length();
            }
            else {
                s += "\n" + essay[i]+" ";
                b=essay[i].length();
            }

        }
        return s;
    }

    public static List<String> split(String a){
        char[] c= a.toCharArray();
        List<String> res = new ArrayList<>();
        a="";
        int m=0;
        for (int i=0; i<c.length;i++)
            if (c[i]=='('){
                a+=c[i];
                m++;
            }
            else{
                a+=c[i];
                m--;
                if (m==0) {
                    res.add(a);
                    a = "";
                }
            }
        return res;
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

    public static boolean same(int[] arr1, int[] arr2){
        int uniqueValue=0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int maxLength = Math.max(arr1.length - 1, arr2.length - 1);
        for (int i = 0; i<maxLength;i++){
            if (i<arr1.length-1)
                if (Arrays.binarySearch(arr1,i+1,arr1.length-1,arr1[i])<0)
                    uniqueValue++;
            if (i<arr2.length-1)
                if (Arrays.binarySearch(arr2,i+1,arr2.length-1,arr2[i])<0)
                    uniqueValue--;
        }
        uniqueValue += arr1.length==1 ? 1 : arr1[arr1.length-2]!=arr1[arr1.length-1] ? 1:0;//checks last element
        uniqueValue -= arr2.length==1 ? 1 : arr2[arr2.length-2]!=arr2[arr2.length-1] ? 1:0;
        return uniqueValue==0;
    }

    public static boolean isKaprekar(int a){
        String s1 = Integer.toString(a * a).substring(0, Integer.toString(a * a).length() / 2);
        int a2 = Integer.parseInt(Integer.toString(a * a).substring(Integer.toString(a * a).length() / 2));

        if (s1.length() == 0)
            return a2 ==a;
        else
            return Integer.parseInt(s1)+ a2 ==a;
    }

    public static String longestZero(String a){
        StringBuilder result=new StringBuilder();
        while (a.indexOf(result+"0")!=-1)
            result.append("0");
        return result.toString();
    }

    public static int nextPrime(int a){
        for(int i=a;true;){
            for(int j=2;j<i;j++){
                if(i%j==0) {
                    i++;
                    j = 2;
                }
            }
            return i;
        }
    }

    public static boolean rightTriangle(int x, int y, int z){
        int max = Math.max(x,Math.max(y,z));
        int m1=0;
        int m2=0;
        if (max==x)
            m1=y;
        else if (max==y)
            m1=z;
        else
            m1=x;
        m2=x+y+z-max-m1;
        return max*max==m1*m1+m2*m2;
    }



    public static void main(String[] args) {
        System.out.println(textEditor(10,7, "hello my name is Bessie and this is my essay"));
        System.out.println(split("((())())(()(()()))"));
        System.out.println(checkPerfect(6));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(new int[] {1, 3, 4, 4, 4},new int[] {2, 5, 7}));
        System.out.println(isKaprekar(3));
        System.out.println(longestZero("01100001011000"));
        System.out.println(nextPrime(12));
        System.out.println(rightTriangle(3, 4, 5));

    }
}
