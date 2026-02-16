public class HousingOptimized {

    public static int solveWithDP(int capacity, int[] spaceRequired, int[] utilityScore) {
        int n = spaceRequired.length;
        // Memory Table: dp[items][capacity]
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill the table in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base condition
                } else if (spaceRequired[i - 1] <= j) {
                    // DAA OPTIMIZATION: Check the table for a previously solved sub-problem
                    dp[i][j] = Math.max(utilityScore[i - 1] + dp[i - 1][j - spaceRequired[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] spaceRequired = {12, 5, 30, 4, 8, 10, 15, 7, 20, 3};
        int[] utilityScore = {80, 90, 70, 85, 60, 95, 75, 50, 80, 40};
        int roomCapacity = 40;

        System.out.println("--- OPTIMIZED HOUSING LOGIC (DYNAMIC PROGRAMMING) ---");
        long startTime = System.nanoTime();

        int result = solveWithDP(roomCapacity, spaceRequired, utilityScore);

        long endTime = System.nanoTime();
        System.out.println("Maximized Comfort Score: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        System.out.println("Status: Fast and Scalable due to DAA Optimization.");
    }
}
