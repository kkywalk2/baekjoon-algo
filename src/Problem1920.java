import java.util.Arrays;
import java.util.Scanner;

public class Problem1920 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        for(int i = 0; i < m; i++) {
            binarySearch(b[i], a);
        }
        sc.close();
    }

    public static void binarySearch(int v, int[] arr) {
        int mid = 0;
        int left = 0;
        int right = arr.length - 1;

        while(right >= left) {
            mid = (left + right) / 2;

            if(arr[mid] == v) {
                System.out.println("1");
                return;
            }

            if(arr[mid] < v) {
                left = mid + 1;
            }else { 
                right = mid - 1;
            }
        }

        System.out.println("0");
    }
}
