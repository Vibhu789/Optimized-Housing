public class HousingBruteForce {

    public static int solveRecursively(int capacity, int[] spaceRequired, int[] utilityScore, int n) {
        // Base Case: No more items or no more room capacity
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // If the current item's space is more than the remaining capacity, skip it
        if (spaceRequired[n - 1] > capacity) {
            return solveRecursively(capacity, spaceRequired, utilityScore, n - 1);
        } else {
            // Try including the item vs excluding it (Checking every possible path)
            int includeItem = utilityScore[n - 1] + solveRecursively(capacity - spaceRequired[n - 1], spaceRequired, utilityScore, n - 1);
            int excludeItem = solveRecursively(capacity, spaceRequired, utilityScore, n - 1);

            return Math.max(includeItem, excludeItem);
        }
    }

    public static void main(String[] args) {
        // Sample Housing Data: (Space in sq ft, Utility/Comfort Score)
        int[] spaceRequired = {12, 5, 30, 4, 8, 10, 15, 7, 20, 3};
        int[] utilityScore = {80, 90, 70, 85, 60, 95, 75, 50, 80, 40};
        int roomCapacity = 40;
        int n = spaceRequired.length;

        System.out.println("--- UNOPTIMIZED HOUSING LOGIC (BRUTE FORCE) ---");
        long startTime = System.nanoTime();

        int result = solveRecursively(roomCapacity, spaceRequired, utilityScore, n);

        long endTime = System.nanoTime();
        System.out.println("Maximized Comfort Score: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        System.out.println("Status: Slow for large inputs due to O(2^n) complexity.");
    }
}
