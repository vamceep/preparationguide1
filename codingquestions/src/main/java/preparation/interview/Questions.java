package preparation.interview;

public class Questions {


    public static void printBits(int[] arr, int s, int e) {
        if(s==e) {
            for(int i=0;i<e;i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }
        arr[s] = 0;
        printBits(arr, s+1, e);
        arr[s]=1;
        printBits(arr, s+1, e);
    }

    public static void checkPrintBits() {
        int n = 3;
        int[] arr= new int[n];
        for(int i=0; i< n;i++) {
            arr[i]=0;
        }
        printBits(arr, 0, n);
    }

    static String swap(String str , int i , int j ) {
        StringBuilder strB = new StringBuilder(str);
        while(i < j) {
            char l = strB.charAt(i), r = strB.charAt(j);
            strB.setCharAt(i, r);
            strB.setCharAt(j, l);
            i++;
            j--;
        }
        return strB.toString();
    }

    public static void reverseSentace(String a) {
        if(a.length() == 0) {
            return;
        }
        int i =0;
        int start = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(i < a.length()) {
            if(a.charAt(i) != ' ') {
                count++;
            }else {
                if(count > 0) {
                    String ss = a.substring(start, start+count);
                    sb.append(swap(ss,0, ss.length()-1));
                    start = start+ count+1;
                    count = 0;
                }
                sb.append(' ');
            }
            i++;
        }
        if(count > 0) {
            String ss = a.substring(start, start+count);
            sb.append(swap(ss,0, ss.length()-1));
        }
        if(sb.length() > 0) {
            System.out.println(" final: " + swap(sb.toString(), 0, sb.toString().length()-1));
        }
    }
    public static void checkReverseSentance(){
        reverseSentace("the quick fox jumped on to a black box");
    }
    public static void main(String[] args) {
        //checkPrintBits();
        checkReverseSentance();
    }
}
