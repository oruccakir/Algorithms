package Sorting;

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




    


   

    
}
