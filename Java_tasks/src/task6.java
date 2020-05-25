import java.util.ArrayList;
import java.util.Arrays;

public class task6 {


    public static int bell(int a){
        int[][] array = new int[a+2][a+2];
        for (int i = 0;i<a;i++)
            for (int j = 0;j<a;j++)
                array[i][j]=-1;
        array[0][0]=1;
        int currentLast=0;
        for (int i = 1;i<a;i++)
        {
            array[i][0]=array[i-1][currentLast];
            currentLast=0;
            for (int j = 1;j<a;j++)
                if (array[i-1][j-1]!=-1)
                {
                    array[i][j] = array[i][j - 1] + array[i - 1][j - 1];
                    currentLast++;
                }
        }
        return array[a-1][currentLast];
    }

    public static String translateWord(String word){
        String result = "Not word";
        String c="";
        boolean isLetter = false;
        if(word.length()!=0){
            for (char cChar : word.toCharArray())
                if (Character.isLetter(cChar)){
                    c += Character.toLowerCase(cChar);
                    isLetter = true;
                }
                else
                    c += cChar;
            isLetter = Character.isLetter(c.charAt(0)) && isLetter;
        }
        if (!word.contains(" ")&&(word.length()>1||isLetter)){
            if (c.charAt(0)=='a'||c.charAt(0)=='e'||c.charAt(0)=='o'||c.charAt(0)=='i'||c.charAt(0)=='u')
                result=word+"yay";
            else{
                int vowelPos = 0;
                while (vowelPos<c.length()&&c.charAt(vowelPos)!='a'&&c.charAt(vowelPos)!='e'&&c.charAt(vowelPos)!='o'&&c.charAt(vowelPos)!='i'&&c.charAt(vowelPos)!='u')
                    vowelPos++;
                result = word.substring(vowelPos) + word.substring(0,vowelPos) + "ay";
            }
        }
        if (isLetter)
            return result;
        else
            return word;
    }

    public static String translateSentence(String sentence){
        StringBuilder result = new StringBuilder();
        if ((sentence.charAt(sentence.length()-1)=='.'&&sentence.indexOf(".")==sentence.length()-1)||(sentence.charAt(sentence.length()-1)=='!'&&sentence.indexOf("!")==sentence.length()-1)||(sentence.charAt(sentence.length()-1)=='?'&&sentence.indexOf("?")==sentence.length()-1)){
            sentence=sentence.substring(0,sentence.length()-1);
            for (String cString : sentence.split(" ")){
                char ch = 0;
                if (cString.length()!=0)
                    if (cString.charAt(cString.length()-1)==','){
                        cString = cString.substring(0, cString.length() - 1);
                        ch=',';
                    }
                if (!translateWord(cString).equals("Not word"))
                    if (ch == 0)
                        result.append(translateWord(cString)).append(" ");
                    else
                        result.append(translateWord(cString)+ch+" ");
            }
            result.replace(0,result.length(), result.substring(0,result.length()-1));
        }
        else
            result.replace(0,result.length(),"Incorrect line");
        return result+".";
    }

    public static boolean validColor(String color){
        if (!color.contains("rgb"))
            return false;
        String value = color.substring(color.indexOf("(") + 1, color.indexOf(")"));
        String[] numbers = value.split(",");

        if (color.contains("rgba") && numbers.length != 4)
            return false;
        if (color.contains("rgb") && !color.contains("rgba") && numbers.length != 3)
            return false;
        for (int i = 0; i <= 2; i++)
        {
            try{
            if (Integer.parseInt(numbers[i]) < 0 || Integer.parseInt(numbers[i]) > 255 )
                return false;
            }
            catch (NumberFormatException e){
                return false;
            }
        }

        if (numbers.length == 4)
        {
            if (Double.parseDouble(numbers[3]) < 0 || Double.parseDouble(numbers[3]) > 1)
                return false;
        }
        return true;
    }

    public static String stripUrlParams(String url, String ... p){
        String PLine ="";
        if (url.contains("?")){
            PLine = url.substring(url.indexOf("?") + 1) + "&";
            url = url.substring(0, url.indexOf("?"));
        }
        String PRes ="?";
        String PTemp="";
        int i = 0;
        while (i<PLine.length()){
            if (PLine.charAt(i)!='&')
                PTemp+=PLine.charAt(i);
            else if (PLine.indexOf(PTemp.split("=")[0],i+1)==-1){
                if (p.length!=0) {
                    if (!Arrays.asList(p).contains(PTemp.split("=")[0]))
                        PRes += PTemp + "&";
                }
                else
                    PRes += PTemp + "&";
                PTemp="";
            }
            else
                PTemp="";
            i++;
        }
        PRes=PRes.substring(0,PRes.length()-1);
        return url+PRes;
    }

    public static ArrayList<String> getHashTags(String head){
        String[] val = { "", "", ""};
        String[] words = head.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for(String word : words) {
            if (!Character.isLetter(word.charAt(word.length() - 1)))
                word = word.substring(0, word.length() - 1);
            if (word.length() > val[0].length()){
                val[2] = val[1];
                val[1] = val[0];
                val[0] = word;
            }
            else if (word.length() > val[1].length()){
                val[2] = val[1];
                val[1] = word;
            }
            else if (word.length() > val[2].length()){
                val[2] = word;
            }
        }
        for (int i = 0; i < val.length; i++){
            if (val[i]!="")
                res.add("#" + val[i].toLowerCase());

        }
        return res;
    }

    public static int ulam(int a){
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        for (int i = 3; i < 2000; i++){
            int count = 0;
            for (int j = 0; j < values.size() - 1; j++){
                for (int k = j + 1; k < values.size(); k++){
                    if (values.get(j) + values.get(k) == i)
                        count++;

                }
            }
            if (count == 1)
                values.add(i);
            if (values.size() == a)
                return i;
        }
        if(a==1||a==2)
            return a;
        return -1;
    }

    public static String longestNonrepeatingSubstring(String a){
        String res = "";
        String temp = "";
        for (int i = 0; i < a.length(); i++){
            if (!temp.contains(a.substring(i, i + 1))){
                temp += a.substring(i, i + 1);
            }
            else{
                if (temp.length() > res.length())
                    res = temp;

                temp = temp.substring(temp.indexOf(a.charAt(i)));
            }
        }
        if (temp.length() > res.length())
            res = temp;
        return res;
    }

    public static String convertToRoman(int a){
        StringBuilder result = new StringBuilder();
        if (a>0&&a<4000){
            String[] array = new String[]{"I", "X", "C", "M", "V", "L", "D"};
            String v = String.valueOf(a);
            int pos = 0;
            for (int j = v.length() - 1; j > -1; j--){
                int cValue = Integer.parseInt(String.valueOf((char) v.charAt(j)));
                if (cValue < 4)
                    result.insert(0, array[pos].repeat(cValue));
                else if (cValue == 4)
                    result.insert(0, array[pos] + array[pos + 4]);
                else if (cValue == 5)
                    result.insert(0, array[pos + 4]);
                else if (cValue == 9)
                    result.insert(0, array[pos] + array[pos + 1]);
                else{
                    result.insert(0, array[pos + 4] + array[pos].repeat(cValue - 5));
                }
                pos++;
            }
        }
        return result.toString();
    }

    public static String mathResult(String v1,String v2,char move)
    {
        int fValue = Integer.parseInt(v1);
        int result=-1;
        if (!v2.equals("")){
            int sValue = Integer.parseInt(v2);
            switch (move){
                case '+':
                    result = fValue + sValue;
                    break;
                case '-':
                    result = fValue - sValue;
                    break;
                case '*':
                    result = fValue * sValue;
                    break;
                case '/':
                    result = fValue / sValue;
                    break;
            }
        }
        else
            result=fValue;
        return String.valueOf(result);
    }
    public static boolean formula(String line){
        boolean isCorrect = true;
        while (line.contains(" "))
            line=line.substring(0,line.indexOf(" "))+line.substring(line.indexOf(" ")+1);
        int pValue=0;
        int cValue=0;
        int i =0;
        for (String cPart : line.split("=")){
            pValue=cValue;
            if (isCorrect){
                StringBuilder v1 = new StringBuilder();
                StringBuilder v2 = new StringBuilder();
                char move = 0;
                for (char c : cPart.toCharArray()){
                    if (Character.isDigit(c)){
                        if (move == 0)
                            v1.append(c);
                        else
                            v2.append(c);
                    }
                    else if (c=='+'||c=='*'||c=='/'||c=='-'){
                        if (move==0)
                            move = c;
                        else{
                            v1.replace(0,v1.length(),mathResult(v1.toString(),v2.toString(),move));
                            v2.delete(0,v2.length());
                            move=c;
                        }
                    }
                    else
                        isCorrect=false;
                }
                v1.replace(0,v1.length(),mathResult(v1.toString(),v2.toString(),move));//
                v2.delete(0,v2.length());
                cValue=Integer.parseInt(v1.toString());
            }
            else
                break;
            if (i!=0)
                isCorrect = pValue==cValue;
            else
                i++;
        }
        return isCorrect;
    }

    public static boolean palindromedescendant(int n){
        String SNumber = Integer.toString(n);
        StringBuilder SBInput = new StringBuilder();
        SBInput.append(SNumber);
        while (SBInput.length() > 1){
            if (SBInput.toString().equals(SBInput.reverse().toString()))
                return true;
            if (SBInput.length() % 2 != 0)
                return false;
            String temp ="";
            String num=SBInput.reverse().toString();
            for (int i=0;i<num.length()-1;i+=2){
                int sum = Character.digit(num.charAt(i), 10) + Character.digit(num.charAt(i + 1), 10);
                temp += Integer.toString(sum);
            }
            SBInput.setLength(0);
            SBInput.append(temp);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(bell(3));
        System.out.println(translateWord("button"));
        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println(ulam(4));
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(convertToRoman(2));
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(palindromedescendant(11211230));

    }
}
