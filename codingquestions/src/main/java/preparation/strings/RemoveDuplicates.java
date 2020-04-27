package preparation.strings;

public class RemoveDuplicates {

    public static void removeDupes(String s) {
        if(s.length() < 1) {
            return;
        }
        char[] res = new char[s.length()];
        int k = 0;

        for(int i=0; i< s.length();i++) {
            boolean found = false;
            for(int j=0;j <k;j++) {
                if(res[j] == s.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                res[k++] = s.charAt(i);
            }
        }
        for(int i=0;i < k;i++) {
            System.out.print(res[i]);
        }
    }

    public static void main(String[] args) {
        String s = "hello how are you";
        removeDupes(s);
    }
}
