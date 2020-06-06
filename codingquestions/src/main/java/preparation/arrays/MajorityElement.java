package preparation.arrays;

import javafx.util.Pair;

import java.util.HashMap;

public class MajorityElement {
    /**
     * Find majority element in give array. (n/2 + times element repeats)
     *https://www.techiedelight.com/find-majority-element-in-an-array-boyer-moore-majority-vote-algorithm/
     * Best liner time is -Boyer - Moore majority vote algirthm
     * which returns majority element only if it present.
     * Otherwise it returns some value.
     */
    public int find(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        for(Integer key: map.keySet()) {
            if(map.get(key) > arr.length/2) {
                return key;
            }
        }
        return -1;
    }

    public int BoyersMoorFind(int[] arr) {
        int c = 0;
        int res = 0;
        for(int i=0;i<arr.length;i++) {
            if(c ==0) {
                c =1;
                res = arr[i];
            }else if(res == arr[i]) {
                c +=1;
            }else {
                c -=1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,3,5,5,6,8,5,5};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.find(arr));
        System.out.println(majorityElement.BoyersMoorFind(arr));
    }
}
