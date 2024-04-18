import java.util.Arrays;

class program {
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        int ans = editDistance(s1, s2, s1.length(), s2.length(), dp);
        System.err.println(ans);
    }

    public static int editDistance(String s1, String s2, int m, int n, int dp[][]) {
        if (m == 0)
            return n; // if first string is empty then we have to insert every character in s1
        if (n == 0)
            return m; // if second string is empty then we have to delete every character in s1
        if (dp[m][n] != -1)
            return dp[m][n]; // if the solution of subproblem is already computed
        else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1))
                return dp[m][n] = editDistance(s1, s2, m - 1, n - 1, dp); // no need to do operation
            int replace = 1 + editDistance(s1, s2, m - 1, n - 1, dp);
            int insert = 1 + editDistance(s1, s2, m, n - 1, dp);
            int delete = 1 + editDistance(s1, s2, m - 1, n, dp);
            return dp[m][n] = Math.min(Math.min(replace, insert), delete);
            // minimum of all operations
        }
    }
}
