import java.util.Scanner;

public class Problem1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMinSize(arr, s));
        sc.close();
    }

    public static int findMinSize(int[] arr, int s) {
        int right = 0;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        for (int left = 0; left < arr.length; left++) {
            if(left != 0) {
                sum -= arr[left - 1];
                sum -= arr[right];
            }

            for (; right < arr.length; right++) {
                sum += arr[right];

                if (sum >= s) {
                    if ((right - left + 1) < size) {
                        size = right - left + 1;
                    }
                    break;
                }

                if(right == arr.length - 1)
                    break;
            }
        }

        if(size == Integer.MAX_VALUE)
            return 0;
            
        return size;
    }
}
