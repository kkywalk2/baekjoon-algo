package baekjoon;
import java.io.*;
import java.util.*;

public class Problem17435 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int queryCount = Integer.parseInt(br.readLine());
        int[][] queryTable = new int[queryCount + 1][21];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= queryCount; i++) {
            queryTable[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < 20; j++)
            for (int i = 1; i <= queryCount; i++)
                queryTable[i][j + 1] = queryTable[queryTable[i][j]][j];

        int calculationCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < calculationCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            int startNum = Integer.parseInt(st.nextToken());
            combinationFunction(count, startNum, queryTable);
        }
        br.close();
    }

    public static void combinationFunction(int count, int startNum, int[][] queryTable) {
        int current = startNum;
        for (int i = 19; i >= 0; i--) {
            int log = (1 << i);
            if ((log & count) > 0) {
                current = queryTable[current][i];
                count = count - log;
            }
        }
        System.out.println(current);
    }
}
