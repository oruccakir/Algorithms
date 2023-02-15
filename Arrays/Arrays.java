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



    






    public static void main(String[] args) {

        int []arr={0,0,0,4,1,1,2,3,25,8,0,0,04,505,40,5,5,222,0,02,0};
        moveZeros(arr);
        leftRotateOne(arr);
        write(arr);
        
    }




    
}
