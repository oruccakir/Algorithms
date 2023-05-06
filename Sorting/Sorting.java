package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Sorting {

    public static void swap(int arr[], int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    

    public static void bubbleSort(int arr[], int n){

        for(int i=0; i<n-1; i++){                     // Time Complexity : O(N**2) 

            for(int k=0; k<n-1; k++){                 // Auxiliary Space : O(1)

                if(arr[k] > arr[k+1]){

                    swap(arr, k, k+1);

                }
            }
        }
    }



    public static void efficientBubbleSort(int arr[], int n){

        for(int i=0; i<n-1; i++){                     // Time Complexity : O(N**2) 

            for(int k=0; k<n-1-i; k++){               // Auxiliary Space : O(1)

                if(arr[k] > arr[k+1]){                // That algorithm efficient because we know that in every iteration the largest element is placed the end of the array (n-1-i) index

                    swap(arr, k, k+1);

                }
            }
        }
    }



    public static void moreEfficientBubbleSort(int arr[], int n){

        for(int i=0; i<n-1; i++){                       

            boolean isSwapped = false;                // Time Complexity : O(N**2) 

            for(int k=0; k<n-1-i; k++){               // Auxiliary Space : O(1)

                if(arr[k] > arr[k+1]){                // That algorithm efficient because we know that in every iteration the largest element is placed the end of the array (n-1-i) index

                    swap(arr, k, k+1);                // If array is already sorted It is not necessary to iterate more so if array is sorted extracted from outer loop

                    isSwapped = true;                 // Bubble sort is stable and in-place algorithm

                }
            }

            if(!isSwapped) break;

        }

    }



    public static void selectionSort(int arr[], int n){

        for(int i=0; i<n-1; i++){                      // Time Complexity : O(N**2)

            int min_index = i;                         // Auxiliary Space : O(1)

            for(int k=i+1; k<n; k++){                  // Note that selection sort always takes O(N**2) time even if array is sorted or sorted in reverse order

                if(arr[k] < arr[min_index])            // Selection sort uses less memory as it is compared to other sorting algorithms 
                  
                   min_index = k;                      // Cycling sort is use less memory than selection sort because it is improved from selection sort
            }

            swap(arr, i, min_index);                   // Selection sort is in-place and is not stable and selection sort is basic idea for heap sort

        }

    }




    public static void myInsertionSort(int arr[], int n){

        for(int i=1; i<n; i++){                            // Time complexity : O(N)

            int index = 0;                                 // Auxiliary Space : O(1)

            for(int k=index; k<i; k++){

                if(arr[i] <arr[k])
                   swap(arr, i, k);

            }

            index++;

        }

    }



    public static void insertionSort(int arr[], int n){

        for(int i=1; i<n; i++){                      // Time Complexity : O(N)

            int key = arr[i];                        // Auxiliary Space : O(1)

            int j = i-1;                             // Insertion sort is in-place and stable algorithm

            while(j>=0 && arr[j] > key){             // Used in Timsort which use internally merge and insertion sort and used in IntroSort which use internally heap quick and insertion sort in Python

                arr[j+1] = arr[j];
                j--;

            }

            arr[j+1] = key;

        }

    }




    public static void merge(int arr[], int l, int mid, int r){

        int n1 = mid-l+1, n2 = r-mid;

        int left[] = new int[n1], right[] = new int[n2];                 // Time Complexity : O(N)

        for(int i=0; i<n1; i++)  left[i] = arr[l+i];                     // Auxiliary Space : O(N)

        for(int i=0; i<n2; i++)  right[i] = arr[mid+1+i];

        int i=0, j=0, k=l;

        while(i<n1 && j<n2){

            if(left[i] <= right[j]){            // <= sign stands for stability of merge sort
                arr[k] = left[i];
                i++;
                k++;
            }
            else{
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        while(i<n1) {
            arr[k] = left[i];
             i++;
             k++;
        }                                 // The last two while loop always one of them will work without exception
        

        while(j<n2)
        {
            arr[k] = right[j];                      
            j++; 
            k++;
        } 

    }



    public static void mergeSort(int arr[], int l, int r){

        if(l<r){                                      // Merge sort is suitable for linked list

            int mid = l + (r - l) / 2;                // Time Complexity : O(n * log(n))

            mergeSort(arr, l, mid);                   // Auxiliary Space : O(N)
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);                    // Divide, Conquer and merge algorithm and stable algorithm
                                                     
        }                                             // Well suited for linked list works in constant amount of memory O(1)
        
    }                                                 // Time complexity always same in best, average and worst cases
 



    public static void intersectionOfTwoSortedArrays(int arr1[], int arr2[]){

        for(int i=0; i<arr1.length; i++){                    // Time Complexity : O(n*m);

            if(i>0 && arr1[i] == arr1[i-1]) continue;        // Auxiliary Space : O(1)

            for(int k=0; k<arr2.length; k++){                // That algorithm works also for unsorted algorithms

                if(arr1[i] == arr2[k]){
                    System.out.println(arr1[i]);
                    break;
                }

            }

        }

    }



    public static void efficientIntersectionOfTwoSortedArrays(int arr1[], int arr2[]){

        int n=arr1.length, m = arr2.length, i=0, j=0;

        while(i<n && j<m){                                         // Time Complexity : O(Min(n,m))

            if(i > 0 && arr1[i] == arr1[i-1]){                     // Auxiliary Space : O(1)
                i++;
                continue;
            }

            if(arr1[i] < arr2[j]) i++;

            else if(arr1[i] > arr2[j]) j++;

            else{
                System.out.println(arr1[i]);
                i++;
                j++;
            }

        }
    }

    public static int [] merge(int arr1[],int arr2[]){

        int arr[] = new int[arr1.length + arr2.length];        // Time Complexity : O(N)
    
        int i=0, j=0, k=0;                                     // A uxiliary Space : O(N)

        int n1 = arr1.length, n2 = arr2.length;

        while( i< n1 && j<n2){

            if(arr1[i] <= arr2[j]) { arr[k] = arr1[i]; i++; k++; }

            else { arr[k] = arr2[j]; j++; k++; }

        }
        
        while(i < n1){ arr[k] = arr1[i]; k++; i++;}

        while(j< n2){ arr[k] = arr2[j]; k++; j++;}

        return arr;

    }

    public static int [] threeMerge(int arr1[], int arr2[], int arr3[]){

        int arr[] = null;

        arr = merge(arr1, arr2);                // Time Complexity : O(N)

        arr = merge(arr, arr3);                // Auxiliary Space : O(N)

        return arr;

    }


    public static void mergeWithoutAuxiliarySpace (int arr1[], int arr2[]){

        int n = arr1.length, m = arr2.length, i=0, j=0, k = n-1;

        int min = 0, index = 0;

        while(i <n && j< m){                                               // Time Complexity : O(N)

            boolean isAtBelow = false;                                     // Auxiliary Space : O(N)

            if(arr1[i] <= arr2[j]) {  min = arr1[i]; i++; } 

            else { min = arr2[j]; index = j; j++; isAtBelow = true; }

            if(isAtBelow){

                int temp = arr1[k];

                arr1[k] = min;

                arr2[index] = temp;

                k--;
            }

        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    public static LinkedList<Integer> getUnion (int arr1[], int arr2[]){

        LinkedList <Integer> list = new LinkedList<>();                     // Time Complexity : O(N)

        int tempArray[] = merge(arr1, arr2);                                // Auxiliary Space : O(N)

        for(int i=0; i<tempArray.length; i++){                              // it is significant to note that two arrays should be sorted

            if( i == 0 || tempArray[i] != tempArray[i-1]) list.add(tempArray[i]);

        }

        return list;

    }

    public static LinkedList<Integer> efficientGetUnion(int arr1[], int arr2[]){

        LinkedList <Integer> list = new LinkedList<>();                            // Time Complexity : O(N)

        int n = arr1.length, m = arr2.length, i=0, j=0;                            // Auxiliary Space : O(N)

        while(i < n && j< m){                                                      // it is significant to note that two arrays should be sorted

            if(i > 0 && arr1[i] == arr1[i-1]){ i++; continue; }

            if(j > 0 && arr2[j] == arr2[j-1]) { j++; continue; }
            
            if(arr1[i] < arr2[j]){  list.add(arr1[i]);  i++;  }

            else if(arr2[j] < arr1[i]){  list.add(arr2[j]);  j++;  }

            else{  list.add(arr1[i]);  i++;  j++;  }

        }

        while( i< n){

            if( i> 0 && arr1[i] != arr1[i-1]){ list.add(arr1[i]);}

            i++;
            
            
        }

        while( j< m){

            if( j> 0 && arr2[j] != arr2[j-1]){ list.add(arr2[j]);}

            j++;

        }

        return list;

    }


    public static int countInversions ( int arr[], int n){

        int count = 0;

        for(int i=0; i<n-1; i++){                             // Time Complexity : O(N * N)
 
            for(int k= i+1; k<n; k++){                        // Auxiliary Space : O(1)

                if(arr[i] > arr[k]) count++;

            }

        }

        return count;

    }


    public static int countInversionMerge( int arr[], int l, int r){


        int result = 0;

        if(l<r){                                                  // Time Complexity : O(n*log(n))

            int mid = l +(r-l)/2;                                 // Space Complexity : O(n)

            result += countInversionMerge(arr, l, mid);

            result += countInversionMerge(arr, mid+1, r);

            result += countAndMerge(arr,l,mid,r);

        }

        return result;


    }


    public static int countAndMerge(int arr[], int l,int mid, int r){


        int n1 = mid -l +1, n2 = r-mid, left[] = new int[n1], right[] = new int[n2];

        for(int i=0; i<n1; i++) left[i] = arr[l+i];

        for(int i=0; i<n2; i++) right[i] = arr[mid +1 +i];                         // Time Complexity : O(n*log(n))

        int i=0, j=0, k=l, result = 0;                                             // Space Complexity : O(n)

        while(i<n1 && j<n2){

            if(left[i] <= right[j]) {

                arr[k] = left[i];

                i++;

                k++;

            }

            else{

                arr[k] = right[j];

                j++;

                result += n1-i;

                k++;

            }

        }

        while(i<n1) { arr[k] = left[i]; i++; k++; }

        while(j<n2) { arr[k] = right[j]; j++; k++; }

        return result;

    }



    public static boolean findTripletWithZero(int arr[], int n){

        mergeSort(arr,0,n-1);

        for(int i=0; i<n-2; i++){                              // Time Complexity : O(n*n)

            int l = i+1, r=n-1;                                // Space Complexity : O(1)

            while ( l< r){

                int sum = arr[i] +arr[l] + arr[r];

                if(sum == 0) return true;

                else if(sum < 0) l++;

                else r --;

            }

        }

        return false;

    }









        public static void main(String[] args) {

            int arr1[] = {1,5,15,2,3,2,1,8,9,5,2};
    
           
            System.out.println(countInversionMerge(arr1,0,arr1.length-1));
    
            
    
            
            
        }


    }

    



    
   


   

    

