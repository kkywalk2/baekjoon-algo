package leetcode;

public class LongestPalindromic {
    public String longestPalindrome(String s) {
        int max = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                result = s.substring(i, i + 2);
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = i - 2; j >= 0; j--) {
                if (dp[j + 1][i - 1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = true;
                    if (max < (i - j + 1)) {
                        max = i - j + 1;
                        result = s.substring(j, i + 1);
                    }
                }
            }
        }
        return result;
    }
}
