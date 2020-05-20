public class task2 {


    public static String repeat(String a, int n){
        String result="";
        for(char c:a.toCharArray())
            result+=Character.toString(c).repeat(n);
        return result;
    }

    public static int differenceMaxMin(int[] arr){
        int min = arr[0];
        int max = min;
        for (int cValue:arr) {
            max = cValue>max ? cValue : max;
            min = cValue<min ? cValue:min;
        }
        return max-min;
    }

    public static boolean isAvgWhole(int[] arr){
        int result = 0;
        for (int cValue:arr) 
            result+=cValue;
            return result%arr.length==0;
    }

    public static int[] cumulativeSum(int[] arr){
        int summ=0;
        for (int i = 0; i< arr.length;i++){
            summ+=arr[i];
            arr[i]=summ;
        }
        return arr;
    }

    public static int getDecimalPlaces(String a){
        return a.length() - a.indexOf('.') - 1;
    }

    public static int Fibonacci(int a){
        if (a==1) return 1;
        if (a==2) return 2;
        return Fibonacci(a - 1) + Fibonacci(a - 2);
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
        System.out.println(repeat("mice", 5));
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(isAvgWhole(new int[]{1, 3}));
        int[] arr = cumulativeSum(new int[] {1, 2, 3});
        for (int a : arr)
            System.out.print(a + " ");
        System.out.println();
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(Fibonacci(3));
        System.out.println(isValid("59001"));
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(0));

    }
}
