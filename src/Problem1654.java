import java.util.Scanner;

public class Problem1654 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int lineCount = sc.nextInt();
        long targetCount = sc.nextInt();
        long maxLength = 0;
        long[] lineLength = new long[lineCount];
        for (int i = 0; i < lineCount; i++) {
            lineLength[i] = sc.nextInt();

            if (maxLength < lineLength[i])
                maxLength = lineLength[i];
        }
        binarySearch(targetCount, maxLength + 1, lineLength);
        sc.close();
    }

    public static void binarySearch(long target, long max, long[] lines) {
        long mid = 0;
        long min = 0;

        while (min < max) {
            mid = (max + min) / 2;

            long count = 0;
            for (long l : lines) {
                count += l/mid;
            }

            if (count < target) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
