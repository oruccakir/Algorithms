package Arrays;

import java.security.Identity;

public class Arrays {

    public static void write(int []arr){
        for(int item : arr)
           System.out.print(item+" ");
    }

    public static int largestSumSubarray(int []arr, int n){

        int max_so_far=Integer.MIN_VALUE;                      // Time Complexity : O(n)
        int max_end_here=0;                                    // Auxiliary Space : O(1)

        for(int i=0; i<n; i++){
            max_end_here+=arr[i];
            if(max_so_far < max_end_here)
               max_so_far=max_end_here;
            if(max_end_here<0)
               max_end_here=0;
        }
        return max_so_far;
    }



    public static int secondLargest(int []arr, int n){

        int max = Integer.MIN_VALUE, secondMax=max;

        for(int i=0; i<n; i++){                      // Time Complexity : O(n)
            if(arr[i] > max){                        // Auxiliary Space : O(1)
                secondMax=max;
                max=arr[i];
            }
            if(arr[i]<max && arr[i]>secondMax)
               secondMax=arr[i];
        }
        if(secondMax == Integer.MIN_VALUE || secondMax ==max)
           secondMax=-1;
        
        return secondMax;
    }



    public static int removeDuplicates(int[]arr, int n){

        int index=1;                                    // Time Complexity : O(n) 
        for(int i=1; i<n; i++){                         // Auxiliary Space : O(1) 
            if(arr[index-1]!=arr[i]){
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }



    public static void moveZeros(int []arr){

        int count=0;

        for(int i=0; i<arr.length; i++){  // Time Complexity : O(n)  
            if(arr[i]!=0){                // Auxiliary Space : O(1) 
                int temp = arr[i];
                arr[i]=arr[count];
                arr[count]=temp;
                count++;
            }
        }
    }



    public static void leftRotateOne(int arr[]){
        
        int temp=arr[0];                         // Time Complexity : O(n) 
        for(int i=1; i<arr.length; i++)          // Auxiliary Space : O(1)
            arr[i-1]=arr[i];
        
        arr[arr.length-1]=temp;
    }



    public static void leftRotate(int []arr, int k){
        reverse(arr,0,k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr,0,arr.length-1);
    }



    public static void reverse(int arr[],int l, int r){

                                                
        while(l<r){                              // Time Complexity : O(n)  
            int temp=arr[l];                     // Auxiliary Space : O(1)
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }



    public static void leadersInArray(int arr[]){

        int leader=arr[arr.length-1];
        System.out.print(leader+" ");

        for(int i=arr.length-2; i>=0; i--){       // Time Complexity : O(n)  
            if(arr[i]>leader){                    // Auxiliary Space : O(1)
                leader=arr[i];
                System.out.print(leader+" ");
            }
        }
    }



    public static int maxDiffer(int arr[]){
        
        int dif=arr[1]-arr[0], min=arr[0];

        for(int i=1; i<arr.length; i++){        // Time Complexity : O(n)
            dif= Math.max(dif,arr[i]-min);      // Auxiliary Space : O(1)
            min=Math.min(min,arr[i]);
        }
        return dif;
    }



    public static void frequencySorted(int []arr){

        int freq=1;
        for(int i=1; i<arr.length; i++){                   // Time Complexity : O(n) 
            if(arr[i]==arr[i-1])                           // Auxiliary Space : O(1)
               freq++;
            else{
                System.out.print(" "+arr[i]+" frequency "+freq);
                freq=1;
            }
        }
    }



    public static int maxIndexDiffere(int arr[],int n){

        if(n==1) return 0;

        int Rmax[]=new int[n];                            // Time Complexity : O(n) 
        int Lmin[]=new int[n];                            // Auxiliary Space : O(1)

        Lmin[0]=arr[0];

        for(int i=1; i<n; i++)
           Lmin[i]=Integer.min(arr[i],Lmin[i-1]);

        Rmax[n-1]=arr[n-1];

        for(int i=n-2; i>=0; i--)
           Rmax[i]=Integer.max(arr[i], Rmax[i+1]);

        int i=0, j=0, maxDiffer=-1;

        while(j<n && i<n){
            if(Lmin[i] <= Rmax[i]){
                maxDiffer = Integer.max(maxDiffer, j-i);
                j++;
            }
            else i++;
        }

        return maxDiffer;
    }



    public static int maxProfit(int price[], int n){

        int profit=0;

        for(int i=1; i<n; i++){                         // Time Complexity : O(n) 
            if(price[i]>price[i-1])                     // Auxiliary Space : O(1)

               profit+=(price[i] - price[i-1]);
        }
        return profit;
    }



    public static int trainWater(int arr[], int n){

        int result=0;

        for(int i=1; i<n-1; i++){

            int left=arr[i];                       // Time Complexity : O(n**2) 
            for(int j=0; j<i; j++)                 // Auxiliary Space : O(1)
                left=Math.max(left, arr[j]);

            int right=arr[j];
            for(int j=i+1; j<n; j++)
                right=Math.max(right,arr[j]);
            
            result+=Math.min(left, right)-arr[i];
        }
        return result;
    }



    public static int efficientTrainWater(int arr[], int n){

        int left[] = new int[n];                               // Time Complexity : O(n) 
        int right[] = new int[n];                              // Auxiliary Space : O(n)

        int water=0;
        left[0]=arr[0];
        right[n-1]=arr[n-1];

        for(int i=1; i<n; i++)
           left[i]=Math.max(left[i-1], arr[i]);
        
        for(int i=n-2; i>=0; i--)
           right[i]=Math.max(right[i+1], arr[i]);
        
        for(int i=0; i<n; i++)
           water+=Math.min(left[i], right[i])-arr[i];

        return water;
    }



    public static int maximumConsecutiveOne(int arr[]){

        int result=0, current=0;
        
        for(int i=0; i<arr.length; i++){

            if(arr[i]==0)                              // Time Complexity : O(n) 
               current=0;                              // Auxiliary Space : O(1)
            else{
                current++;
                result = Math.max(result,current);
            }
        }
        return result;
    }



    public static int maximumSubarray(int []arr, int n){

        if(n == 0) return 0;                                 // Time Complexity : O(n)
        if(n == 1) return arr[0];                            // Auxiliary Space : O(1)

        int result=arr[0], maxEnding=arr[0];

        for(int i=1; i<n; i++){
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            result = Math.max(maxEnding, result);
        }
        return result;
    }



    public static int maxEvenOdd(int arr[], int n){

        int result=1, current=1;

        for(int i=1; i<n; i++){                                                                  // Time Complexity : O(n)
            if(arr[i-1] % 2 !=0 && arr[i] % 2 ==0 || arr[i-1] % 2 ==0 && arr[i] % 2!=0){         // Auxiliary Space : O(1)
               current++;
                result=Math.max(current, result);
            }
            else
               current=1;
        } 
        return result;
    }



    public static int maximumCircularArray(int arr[], int n){

        int max_normal = maximumSubarray(arr, n);

        if(max_normal<0) return max_normal;

        int arrSum=0;

        for(int i=0; i<n; i++){
            arrSum+=arr[i];                                      // Time Complexity : O(n)
            arr[i]=-arr[i];                                      // Auxiliary Space : O(1)
        }

        int max_circular = arrSum + maximumSubarray(arr, n);

        return Math.max(max_normal, max_circular);
    }






    public static void main(String[] args) {

        int []arr={0,0,0,4,1,1,2,3,25,8,0,0,04,505,40,5,5,222,0,02,0};
        moveZeros(arr);
        leftRotateOne(arr);
        write(arr);
        
    }




    
}
