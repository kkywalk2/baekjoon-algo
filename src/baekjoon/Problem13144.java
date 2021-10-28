package baekjoon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem13144 {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(caculateCase(arr));
    }

    public static long caculateCase(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int right = -1;
        long ans = 0;
        for (int left = 0; left < arr.length; left++) {

            while ((right + 1) < arr.length && (hash.get(arr[right + 1]) == null || hash.get(arr[right + 1]) == 0)) {
                Integer count = hash.putIfAbsent(arr[right + 1], 1);
                if (count != null) {
                    hash.replace(arr[right + 1], count + 1);
                }
                right++;
            }

            int count = hash.get(arr[left]);
            hash.replace(arr[left], count - 1);
            ans += right - left + 1;
        }
        return ans;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
