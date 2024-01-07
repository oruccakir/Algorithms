//Brace your keyboard
//inzva community built algoleague for every algorithm enthusiast hungry for self-improvement and friendly competition. Have fun and good luck!

import java.util.*;
import java.lang.*;
import java.io.*;

class Question10 {
    public static void main (String[] args) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.con
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int arr[] = new int[n];
        String str = scan.nextLine();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == 'n'){
                arr[i] = 0;
            }
            else if(ch=='p'){
                arr[i] = 1;
            }
            else{
                arr[i] = -1;
            }
            
        }
        
        System.out.println(countSubarraysWithZeroSum(arr));

    }
    
    public static int countSubarraysWithZeroSum(int[] arr) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int count = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == 0) {
                count++;
            }

            if (prefixSumCount.containsKey(currentSum)) {
                count += prefixSumCount.get(currentSum);
            }

            if (!prefixSumCount.containsKey(currentSum)) {
                prefixSumCount.put(currentSum, 1);
            } else {
                prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) + 1);
            }
        }

        return count;
    }
    
}

