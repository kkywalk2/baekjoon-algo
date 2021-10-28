package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Problem3273 {
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int x = sc.nextInt();
        combinationSelect(x);
        System.out.println(count);
        sc.close();
    }

    public static void combinationSelect(int x) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            if(arr[start] + arr[end] == x){
                count++;
            }

            if(arr[start] + arr[end] > x){
                end--;
            }else if(arr[start] + arr[end] <= x){
                start++;
            }
        }
    }
}
