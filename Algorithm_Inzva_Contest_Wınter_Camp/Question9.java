import java.util.Scanner;

public class Question9 {
    
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int pred = 0;
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scan.nextInt();
        for(int i=0; i<m; i++){
            pred= scan.nextInt();
            if(subsetSumExists(arr,pred))
                System.out.println("yes");
            else
                System.out.println("no");
        }
        
        
        

    }
    

    public static boolean subsetSumExists(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }


}
