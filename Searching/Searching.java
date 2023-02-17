package Searching;

import Arrays.Arrays;

public class Searching {



    public static int linearSearch(int arr[], int n, int x){

        for(int i=0; i<n; i++)                              // Time Complexity : O(n)
           if(arr[i] == x)                                  // Auxiliary Space : O(1)
              return i;
        
        return -1;
    }



    public static int recursiveLinearSearch(int []arr, int n, int x){

        if(n == 0 && arr[n]!=x) return -1;                       // Time Complexity : O(n)
        if(arr[n-1] == x) return n-1;                            // Auxiliary Space : O(n)
        return recursiveLinearSearch(arr, n-1, x);          
    }



    public static int binarySearch(int arr[], int n, int x){

        int l=0, r=n-1;                                         // Time Complexity : O(log(n))

        while(l <= r){                                          // Auxiliary Space : O(1)

            int mid= l +( r - l ) / 2;

            if(arr[mid] == x) return mid;

            else if(arr[mid] > x) r=mid-1;

            else l=mid+1;

        }
        
        return -1;
    }



    public static int recursiveBinarySearch(int []arr, int n, int x,int l, int r){

        if(l > r) return -1;                                                // Time Complexity : O(log(n)) 

        int mid = l + (r - l) / 2;                                          // Auxiliary Space : O(log(n))

        if(arr[mid] == x) return mid;

        else if(arr[mid] > x) return recursiveBinarySearch(arr, n, x, l, mid-1);

        else return recursiveBinarySearch(arr, n, x, mid+1, r);
    }



    public static int firstOccurence(int []arr, int n, int x){

        int l=0, r=n-1;                                        // Time Complexity : O(log(n))

        while(l <= r){                                         // Auxiliary Space : O(1)

            int mid = l + (r -l)/2;

            if(arr[mid] > x) r=mid-1;

            else if(arr[mid] < x) l=mid+1;

            else{

                if(mid == 0 || arr[mid-1]!=x) return mid;
                
                r=mid-1;
            }
        }

        return -1;
    }



    public static int lasttOccurence(int []arr, int n, int x){

        int l=0, r=n-1;                                        // Time Complexity : O(log(n))

        while(l <= r){                                         // Auxiliary Space : O(1)

            int mid = l + (r -l)/2;

            if(arr[mid] > x) r=mid-1;

            else if(arr[mid] < x) l=mid+1;

            else{

                if(mid == n-1 || arr[mid+1]!=x) return mid;
                
                l=mid+1;
            }
        }

        return -1;
    }



    public static int findFloor(long []arr, int n, long x){

        if(arr[0] > x ) return -1;                         // Time Complexity : O(log(n)) 

        int l=0, r=n-1;                                    // Auxiliary Space : O(1)

        while(l <= r){

            int mid = l + (r -l)/2;

            if(arr[mid] > x) r=mid-1;

            else if(arr[mid] == x) return mid;

            else{

                if(mid == n-1 || arr[mid+1] > x) return mid;

                l=mid+1;
            }

        }
        return -1;
    }



    public static int countOccurence(int arr[], int n, int x){

        int first = firstOccurence(arr, n, x);                // Time Complexity : O(log(n))

        if(first == -1) return 0;                             // Auxiliary Space : O(1)

        int last = lasttOccurence(arr, n, x);

        return last - first + 1;
    }



    public static int countOnes(int arr[], int n){

        int first = firstOccurence(arr, n, 1);     // Time Complexity : O(log(n))

        if(first == -1) return 0;                    // Auxiliary Space : O(1)

        return arr.length-first;
    }



    public static int squareRootFloor(int x){

        int i=1;                               // Time Complexity : O(n**1/2)

        while(i*i <= x)                        // Auxiliary Space : O(1)
           i++;
        
        return i-1;
    }



    public static int efficientSquareRootFloor(int x){

        int l=1, r=x, answer=0;

        while(l <= r){

            int mid = l +(r-l)/2;                    // Time Complexity : O(log(n)) 
            int mySquare=mid*mid;                    // Auxiliary Space : O(1)

            if(mySquare == x) return mid;            

            else if(mySquare > x) r=mid-1;

            else{
                l=mid+1;
                answer=mid;
            }
        }
        
        return answer;
    }



    public static double squareRootExact(double number){

        if(number == 0) return 0;                      // Time Complexity : O(log(n)) 

        double x1 = 0, x2=number/2;                    // Auxiliary Space : O(1)

        do{                                            // Newtoon Method
            x1 = x2;

            x2=(x1 + (number / x1)) / 2;

        } while(x2 - x1 !=0);

        return x2;
    }



    public static int searchInInfinite(int[]arr, int x){

        int i=0;                                        // Time Complexity : O(position) 

        while(true){                                    // Auxiliary Space : O(1) 

            if(arr[i] == x) return i;

            if(arr[i] > x) return -1;

            i++;
        }
    }



    public static int efficientSerchInfinite(int[]arr, int x){     

        if(arr[0] == x) return 0;                                // Time Complexity : O(log(position))

        int i=1;                                                 // Auxiliary Space : O(log(n))

        while(arr[i] < x) i*=2;

        if(arr[i] == x) return i;                               // Becuause suitability for parameters recursive binary search was used if iterative was used the auxiliary space would have been O(1)

        return recursiveBinarySearch(arr, arr.length, x, i/2+1, i-1);   
    }



    public static int getPeak(intarr[], int n){

        if(n == 1) return arr[0];                // Time Complexity : O(n)

        if(arr[0] > arr[1]) return arr[0];       // Auxiliary Space : O(1)

        if(arr[n-1] > arr[n-2]) return arr[n-1];

        for(int i=1; i<n-1; i++)
           if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
              return arr[i];
        
        return -1;                              // Never reachs because every array at least has one peak point
    }



    public static int efficientGetPeak(int arr[], int n){

        int l=0, r=n-1;                                  // Time Complexity : O(log(n))

        while(l <= r){                                   // Auxiliary Space : O(1)

            int mid = l + (r - l) / 2;

            if( (mid == 0 || arr[mid] >= arr[mid-1]) && (mid==n-1 || arr[mid] >= arr[mid+1])) return mid;

            if(mid > 0 && arr[mid-1] > arr[mid])
               r=mid-1;
            else
               l=mid+1;
        }

        return -1;                                      // Never reachs because every array at least has one peak point
    }



    public static int searchRotatedSortedArray(int[] arr, int n, int x){

        int l=0, r=n-1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(arr[mid] == x) return mid;                               // Time Complexity : O(log(n))

            if(arr[l] < arr[mid]){                                      // Auxiliary Space : O(1)

                if(x > arr[l] && x < arr[mid])
                   r=mid-1;
                else
                   l=mid+1;

            }
            else{

                if(x > arr[mid] && x > arr[r])
                   l=mid+1;
                else
                   r=mid-1;

            }
        }
        
        return -1;
    }



    public static boolean isPair(int arr[], int n, int x){

        for(int i=0; i<n-1; i++)                               // Time Complexity : O(n ** 2)

           for(int k=i+1; k<n; k++)                          // Auxiliary Space : O(1)

              if(arr[i] + arr[k] == x) return true;
        
        return false;
    }



    public static boolean efficientIsPair(int arr[], int n, int x){

        int l=0, r=n-1;

        while(l < r){                                    // Time Complexity : O(n)

            if(arr[l] + arr[r] == x) return true;        // Auxiliary Space : O(1)

            if(arr[l] +arr[r] > x) r--;                 // array is sorted 

            else l++;                                   // Two pointers approach 

        }

        return false;                                  // Whenever such a thing is asked with unsorted arrays first sort the array then use that method
    }



    public static boolean isTriplet(int []arr, int n, int x){

        for(int i=0; i<n-2; i++)                                  // Time Complexity : O(n ** 3)
           
           for(int j=i+1; j<n-1; j++)                             // Auxiliary Space : O(1)

              for(int k=j+1; k<n; k++)
                 
                 if(arr[i] + arr[j] + arr[k] == x) return true;

        return false;
    }



    public static boolean efficientIsTriplet(int arr[], int n, int x){

        for(int i=0; i<n-2; i++){
            
            int l=i+1, r=n-1;

            while(l < r){                                     // Time Complexity : O(n ** 2)
 
                int sum = arr[i] +arr[l] +arr[r];             // Auxiliary Space : O(1)

                if(sum == x) return true;                     // array is sorted

                if(sum > x) r--;                              // Whenever array is unsorted use merge sort with O(n*log(n)) then time complexity still is O(n ** 2)

                else l++;

            }
    
        }

        return false;
    }











    public static void main(String[] args) {

        int arr[] ={1,2,3,4,5,6,7};
        Arrays.write(arr);
        System.out.println();
        System.out.println(binarySearch(arr, arr.length, 5));
        System.out.println(recursiveBinarySearch(arr, arr.length, 42,0,arr.length-1));
        
    }















    
}
