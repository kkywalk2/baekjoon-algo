package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2470 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] liquid = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        twoPointer(liquid);
    }

    public static void twoPointer(int[] liquid) {
        int left = 0;
        int right = liquid.length - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int sum = liquid[left] + liquid[right];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = liquid[left];
                result[1] = liquid[right];

                if (min == 0)
                    break;
            }

            if (sum < 0)
                left++;
            else
                right--;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
