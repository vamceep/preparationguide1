package preparation.numberandbits;

public class NumberProblems {

    public static boolean isPalindrom(int x) {
        if(x < 0) return false;
        int div = 1;
        while(x/div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if( l != r) return false;
            x = (x % div) /10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int n= 1221;
        if(isPalindrom(n)) {
            System.out.println(n + " is palindrom");
        }else {
            System.out.println(n + " is not palindrom");
        }
    }
}
