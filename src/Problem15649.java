import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem15649 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int m = sc.nextInt();
        var permutation =  doPermutation(nums, m);
        Collections.sort(permutation);
        for (String str : permutation) {
            System.out.println(str);
        }
        sc.close();
    }

    public static List<String> doPermutation(List<Integer> nums , int count) {
        List<String> result = new ArrayList<>();
        if (count == 1) {
            for (int p : nums) {
                result.add(Integer.toString(p));
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> rest = new ArrayList<>(nums);
                rest.remove(i);
                List<String> temp = doPermutation(rest, count - 1);
                for (String str : temp) {
                    int p = nums.get(i);
                    str = p + " " + str;
                    result.add(str);
                }
            }
        }
        return result;
    }
}