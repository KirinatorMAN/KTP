import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class task5 {

    public static int[] encrypt(String a){
        int[] result = new int[a.length()];
        char[] chars = a.toCharArray();
        result[0] = chars[0];
        for (int i = 1; i < chars.length; i++)
        {
            result[i] = chars[i] - chars[i - 1];
        }

        return result;
    }

    public static String decrypt(int[] arr){
        char[] chars = new char[arr.length];
        chars[0] = (char)arr[0];
        int code = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            code += arr[i];
            chars[i] = (char)(code);
        }

        return new String(chars);
    }

    public static boolean canMove(String figure, String start, String end){
        int LetterDiff = Math.abs(end.charAt(0) - start.charAt(0));
        int NumDiff = Math.abs(end.charAt(1) - start.charAt(1));
        switch (figure){
            case "Pawn":{
                if (LetterDiff != 0)
                    return false;
                if (NumDiff > 2)
                    return false;
                return start.charAt(1) == '2' || NumDiff <= 1;
            }
            case "Rook":{
                return LetterDiff == 0 || NumDiff == 0;
            }
            case "Knight":{
                return LetterDiff == 2 && NumDiff == 1 || LetterDiff == 1 && NumDiff == 2;

            }
            case "Bishop":{
                return LetterDiff == NumDiff;

            }
            case "Queen":{
                return LetterDiff == 0 || NumDiff == 0||LetterDiff == NumDiff;
            }
            case "King":{
                return NumDiff <= 1 && LetterDiff <= 1;
            }
            default:
                return false;
        }
    }

    public static boolean canComplete(String not_completed, String completed){
        int count = 0;
        for (int i = 0; i < completed.length(); i++)
        {
            if (completed.charAt(i) == not_completed.charAt(count))
            {
                count++;
                if (count == not_completed.length())
                    return true;
            }
        }
        return false;
    }

    public static int sumDigProd(int ... array){
        int result=0;
        for (int i=0; i<array.length;i++)
            result += array[i];
        while (result>=10)
        {
            int tempResult=1;
            for (char ch:String.valueOf(result).toCharArray())
                tempResult*=Integer.parseInt(String.valueOf(ch));
            result=tempResult;
        }
        if (array.length==0)
            return -1;
        else
            return result;
    }

    public static String sameVowelGroup(String[] w){
        String resultLine="";
        String vowels ="";
        for (char cChar:w[0].toCharArray())
            if ((cChar=='a' || cChar=='e' ||cChar=='i' || cChar=='o' || cChar=='u')&&vowels.indexOf(cChar)==-1)
                vowels+= cChar;
            else
                vowels+= "";
        for (String cString : w)
        {
            String tVowels="";
            boolean allVowel=true;
            for (char cChar : cString.toCharArray()) {
                if ((cChar == 'a' || cChar == 'e' || cChar == 'i' || cChar == 'o' || cChar == 'u') && tVowels.indexOf(cChar) == -1)
                    tVowels += cChar;
            }
            if (tVowels.length()==vowels.length()) {
                for (char cChar : vowels.toCharArray())
                    if (tVowels.indexOf(cChar) == -1)
                        allVowel = false;
                if (allVowel)
                    resultLine += cString + " ";
                else
                    resultLine += "";
            }
        }
        return resultLine;
    }

    public static boolean validateCard(long card){
        String s =String.valueOf(card);
        int summ = 0;
        for (int i = s.length()-2;i>=0;i--){
            if ((i + 1) % 2 == 1){
                int b = 2 * Integer.parseInt(String.valueOf(s.charAt(i)));
                while (b >= 10){
                    int tempResult = 0;
                    for (char ch : String.valueOf(b).toCharArray())
                        tempResult += Integer.parseInt(String.valueOf(ch));
                    b = tempResult;
                }
                summ += b;
            } else
                summ += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        summ = 10-(summ-10* (summ/10));
        return Integer.parseInt(String.valueOf(s.charAt(s.length()-1)))==summ;
    }

    public static String numToEng(int num){
        String res = "";
        if (num > 0 && num < 1000) {
            String[] SNumbersEng = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                    "nineteen", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
            if (num / 100 != 0)
                res += SNumbersEng[num / 100] + " hundred ";
            else
                res += "";
            if (num % 100 >= 20 || num % 100 < 10) {
                if ((num / 10) % 10 != 0)
                    res += SNumbersEng[(num / 10) % 10 + 19] + " ";
                else
                    res += "";
                res += SNumbersEng[(num % 10)];
            }
            else
                if ((num / 10) % 10 != 0)
                    res +=SNumbersEng[(num % 100)] + " ";
                else
                    res += "";
        }
        else
            res="Incorrect value";
        if (num == 0)
            return "zero";
        return res;
    }

    public static String numToRus(int num) {
        String res="";
        if (num>0&&num<1000) {
            String[] SNumbersRus = new String[]{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять","десять",
                    "одиннадцать", "двенадцать", "ринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать",
                    "девятнадцать", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто",
                    "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
            if (num / 100 != 0)
                res += SNumbersRus[num / 100 + 28] + " ";
            else
                res += "";
            if (num%100>=20||num%100<10){
                if((num / 10) % 10 != 0)
                    res += SNumbersRus[(num / 10) % 10 + 19] + " ";
                else
                    res += "";
                res += SNumbersRus[(num % 10)];
            }
            else
                if ((num / 10) % 10 != 0)
                    res += SNumbersRus[(num % 100)]+ " ";
                else res += "";
        }
        else
            res="Неверное значение";
        if (num==0)
            return "ноль";
        return res;
    }

    public static String getSha256Hash(String str){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

        StringBuffer hexString = new StringBuffer();
        for (byte h : hash){
            String hex = Integer.toHexString(0xff & h);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String correctTitle(String str){
        String[] words = str.split(" ");
        String result = "";
        for (String word : words)
        {
            if (word.toLowerCase().equals("the") || word.toLowerCase().equals("in") ||
                    word.toLowerCase().equals("and") || word.toLowerCase().equals("of"))
            {
                result += word.toLowerCase() + " ";
                continue;
            }

            if (word.contains("-"))
            {
                String firstHalf = word.substring(0, 1).toUpperCase() + word.substring(1, word.indexOf('-'));
                String secondHalf = word.substring(word.indexOf('-') + 1, word.indexOf('-') + 2).toUpperCase() +
                        word.substring(word.indexOf('-') + 2);
                result += firstHalf + "-" + secondHalf + " ";
                continue;
            }
            word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            result += word + " ";
        }
        return result;
    }

    public static String hexLattice(int n) {
        int a = -1;
        int count = 1;
        int res = 0;
        while (res < n)
        {
            res = count * 3 * (count - 1) + 1;
            if (res == n)
                a = count;
            else
            {
                count++;
            }
        }
        if (a==-1)
            return "Invaid";
        String hex = "";
        for (int i = 0; i < a; i++){
            for (int k = 0; k < a - i; k++){
                hex += " ";
            }
            for (int j = 0; j < a + i; j++ ){
                hex += "o ";
            }
            hex += "\n";
        }
        for (int i = a - 2; i >= 0; i--){

            for (int k = 0; k < a - i; k++)
                hex += " ";
            for (int j = 0; j < a + i; j++){
                hex += "o ";
            }
            hex += "\n";
        }
        return hex;
    }

        public static void main(String[] args) {
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(decrypt(new int[] {72, 33, -73, 84, -12, -3, 13, -13, -68 }));
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(sumDigProd(16, 28));
        System.out.println(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}));
        System.out.println(validateCard(1234567890123456L));
        System.out.println(numToEng(0));
        System.out.println(numToRus(0));
        System.out.println(getSha256Hash("password123"));
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(hexLattice(37));

    }
}
