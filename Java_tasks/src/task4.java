import java.util.ArrayList;
import java.util.List;

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
            else{
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

    public static String toCamelCase(String camel){
        String[] massiveOfSnakeCase = camel.split("_");
        StringBuilder result= new StringBuilder(massiveOfSnakeCase[0]);
        for (String cWord:massiveOfSnakeCase)
            if (!result.toString().equals(cWord))
                result.append(Character.toUpperCase(cWord.charAt(0))).append(cWord.substring(1));
        return result.toString();
    }

    public static String toSnakeCase(String snake){
        String result="";
        for (char cChar:snake.toCharArray()) {
            if ((cChar!= ' ')&&(cChar!= '\t')&&(cChar!= '\n'))
                if (Character.isLetter(cChar))
                    if (Character.isUpperCase(cChar))
                        result+="_"+Character.toLowerCase(cChar);
                    else
                        result+=cChar;
                else
                    result+=cChar;
        }
        return result;
    }

    public static String overTime(double[] a){
        double res= 0;
        if(a[0]<=17){
            if (a[1]>17)
                res+=(17-a[0])*a[2]+(a[1]-17)*a[2]*a[3];
            else
                res+=(a[1]-a[0])*a[2];
        }
        else
            res+=(a[1]-a[0])*a[2]*a[3];
        return "$"+String.format("%.2f", res);
    }

    public static String BMI(String w, String h){
        String[] we=w.split(" ");
        String[] hi=h.split(" ");
        double k=0;
        double m=0;
        if (we[1].equals("pounds"))
            k=Double.parseDouble(we[0])*0.45;
        else
            k=Double.parseDouble(we[0]);
        if (hi[1].equals("inches"))
            m=Double.parseDouble(hi[0])*0.025;
        else
            m=Double.parseDouble(hi[0]);
        double res=k/(m*m);
        if (res<18.5)
            return String.format("%.1f",res)+" Underweight";
        if (res>=25)
            return String.format("%.1f",res)+" Overweight";
        return String.format("%.1f",res)+" Normal weight";
    }

    public static int  bugger(int a){
        int count = 0;
        while(a>=10){
            int rValue = 1;
            for (char cChar:String.valueOf(a).toCharArray())
                rValue*= Integer.parseInt(String.valueOf(cChar));
            a=rValue;
            count++;
        }
        return  count;
    }

    public static String toStarShorthand(String a){
        int count = 1;
        String result = "";
        for (int i = 0; i<a.length()-1;i++){
            if(a.charAt(i)==a.charAt(i+1))
                count++;
            else{
                result += count == 1 ? a.charAt(i) :a.charAt(i) + "*" + count;
                count=1;
            }
        }
        if (a.length()!=0)
            result+=count!=1 ?a.charAt(a.length()-1)+"*"+count : a.charAt(a.length()-1);
        return  result;
    }

    public static boolean  doesRhyme(String str1, String str2){
        String[] words1 = str1.split(" ");
        String[] words2 = str2.split(" ");

        String vowels = "AEIYUOaeiyuo";
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < words1[words1.length - 1].length(); i++){
            if (vowels.contains(Character.toString(words1[words1.length - 1].charAt(i))))
                result1 += words1[words1.length - 1].charAt(i);
        }
        for (int i = 0; i < words2[words2.length - 1].length(); i++){
            if (vowels.contains(Character.toString(words2[words2.length - 1].charAt(i))))
                result2 += words2[words2.length - 1].charAt(i);
        }
        return result1.toLowerCase().equals(result2.toLowerCase());
    }

    public static boolean trouble(long a, long b){
        for (int i = 1; i < 10; i++){
            if (Long.toString(a).contains(Integer.toString(i) + i + i)){
                if (Long.toString(b).contains(Integer.toString(i) + i))
                    return true;
            }

        }
        return false;
    }

    public static int countUniqueBooks(String text, char end){
        String  uniquebooks = "";
        while ((text.indexOf(end)!=-1)&&(text.indexOf(end,text.indexOf(end)+1)!=-1)){
            String tempLine = text.substring(text.indexOf(end)+1,text.indexOf(end,text.indexOf(end)+1));
            text=text.substring(text.indexOf(end,text.indexOf(end)+1)+1);
            for (char cChar:tempLine.toCharArray()){
                uniquebooks += uniquebooks.indexOf(cChar)==-1 ? cChar : "";
            }
        }
        return uniquebooks.length();
    }

    public static void main(String[] args) {
        System.out.println(textEditor(10,7, "hello my name is Bessie and this is my essay"));
        System.out.println(split("()()()"));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(overTime(new double[] {9, 17, 30, 1.5}));
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(bugger(39));
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(trouble(666789, 12345667));
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));

    }
}
