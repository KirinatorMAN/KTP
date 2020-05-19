
public class task1 {
    public static int remainder(int a, int b){
        return a%b;
    }
    public static int triArea(int a, int b){
        return a*b/2;
    }
    public static int animals(int a, int b, int c){
        return a*2+b*4+c*4;
    }
    public static boolean profitableGamble(double a, int b, int c){
        return a*b>c;
    }
    public static String operation(int n, int a, int b){
        if (a+b==n) return "added";
        else if (a-b==n) return "subtracted";
        else if (a/b==n) return "multiply";
        else if (a*b==n) return "divide";
        else return "none";
    }
    public static int ctoa(char a){
        return (int)a;
    }
    public static int addUpTo(int a){
        int result=0;
        for (a=a;a>0;a--)
            result+=a;
            return result;
    }
    public static int nextEdge(int a, int b){
        return a+b-1;
    }
    public static int sumOfCubes(int[] arr){
        int result=0;
        for (int i:arr)
            result+=i*i*i;
        return result;
    }
    public static boolean abcmath(int a, int b, int c){
        for (int i=b; i>0; i--)
            a+=a;
        return a%c==0;

    }

    public static void main(String[] args) {
        System.out.println(remainder(1, 3));
        System.out.println(triArea(3, 2));
        System.out.println(animals(2, 3, 5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(operation(24, 15, 9));
        System.out.println(ctoa('A'));
        System.out.println(addUpTo(3));
        System.out.println(nextEdge(8, 10));
        System.out.println(sumOfCubes(new int[]{1, 5, 9}));
        System.out.println(abcmath(42, 5, 10));
    }
}
