package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

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




    public static void partition(int arr[],int l,int r,int p){


        int tempArray[] = new int[ r - l +1] ;              // Time Complexity : O(n)

        int index = 0;                                      // Space Complexity : O(n)

        for(int i=l; i<=r; i++) {                           // Stable algorithm but requires auxiliary space

            if(arr[i] <= arr[p]){

                tempArray[index] = arr[i];

                index++;

            }
            
        }

        for(int i=l; i<=r; i++){

            if(arr[i] > arr[p]){

                tempArray[index] = arr[i];
                
                index++;

            }

        }

        for(int i=l; i<=r; i++) arr[i] = tempArray[i];

    }


    /*
     *  lomuto and hoares are not stable but they are in-place algorithm
     *  Naive partition is stable but not in-place due to auxiliary space
     */




    public static int lomutoPartition (int arr[], int l,int r){

        int pivot = arr[r];                                // always last element is picked as pivot in lomuto partition

        int index = l-1;

        for(int i=l; i<=r-1; i++){                        // Time Complexity : O(n);

            if(arr[i]  < pivot){                          // Auxiliary space : O(n)

                index++;                                  // Unstable algorithm

                swap(arr, index, i);

            }

        }

        swap(arr, index+1, r);                          // Last line is important because pivot is located at the end of the array

        return index+1;

    }




    

    public static int hoaresPartition(int arr[], int l, int r){

        int pivot = arr[l], i=l-1, j=r+1;            // pivot element is the first element of given parameter l

        while(true){                                 // Time complexity : O(n)

            do{ i++; } while(arr[i] < pivot);        // Auxiliary space : O(1)

            do{ j--; } while(arr[j] > pivot);        // Unstable algortihm and works better than lomuto partition

            if(i >= j) return j;

            swap(arr, i, j);

        }

    }



    /*
     *  unstable algorithm 
     *  divide and conquer algorithm
     *  in-place algorithm
     *  cache friendly
     *  tail recursive
     *  best case space complexity O(n*logn)
     * 
     *  despite O(N*N) time complexity in worst case it is considered faster because of above statements
     */

    public static void quickSortLomuto(int arr[], int l, int r){
        
        if(l < r){                                              // Time complexity in worst case O(N*N) in average case O(n*logn)

            int p = lomutoPartition(arr, l, r);                 // due to recursion calls auxiliary space O(N)

            quickSortLomuto(arr, l, p-1);                       
            quickSortLomuto(arr, p+1, r);

        }

    }



    /*
     * Hoares partition is much faster three times than lomuto
     */

    public static void quickSortHoares(int arr[],int l,int r){

        if(l < r){                                           // Time complexity in worst case O(N*N) in average case O(n*logn)

            int p = hoaresPartition(arr, l, r);              // due to recursion calls auxiliary space O(N)

            quickSortHoares(arr, l, p);
            quickSortHoares(arr, p+1, r);

        }

    }





    public static int kthSmallestElement(int arr[],int k){

        int tempArray[] = new int[k];                      // Time complexity in worst case O(N*N) in average case O(n*logn)

        quickSortHoares(arr, 0, arr.length-1);           // That code handles the problem of duplicate elements with O(N) auxiliary space

        int index = 0;

        boolean isEmpty = true;

        for(int i=0; i<arr.length-1 && index <k; i++){

            if(arr[i] != arr[i+1]) { isEmpty = false; tempArray[index] = arr[i]; index++; }

        }
 
        if(k > 0 && isEmpty == true  ) tempArray[0] = arr[0];

        return tempArray[k-1];

    }


    

    /*
     * that code better implementation of above code
     */

    public static int kthSmallestElementWithHashing(int arr[],int k){

        Set <Integer> set = new TreeSet<>();               // Time complexity : O(n*logn);

        for(int i=0; i<arr.length; i++) set.add(arr[i]);   // Space complexity : O(n);

        return (Integer) set.toArray()[k-1];   // by not using toArray but itertaing over set makes code more efficient

    }





    public static void threePartition (int array[], int a, int b){

        int n = array.length, start = 0, end = n-1, i =0;

        while(i<=end){                                 // Time Complexity O(N)

            if(array[i] < a){                          // Space Complexity O(1)

                swap(array, i,start);

                i++;

                start++;

            }
            else if(array[i] > b){

                swap(array, i,end);

                i++;

                end--;

            }

            else i++;

        }

    }





    public static int minDifference (int arr[],int n){

        if(n == 1) return arr[0];

        quickSortHoares(arr, 0, n-1);                // Time complexity O(n*logn) (worst case O(N*N) because of quick sort )

        int minDiffer = arr[1] - arr[0];               // Space Complexity : O(1)

        for(int i=1; i<n-1; i++ ){

            minDiffer = Math.min(minDiffer, arr[i+1] - arr[i]);

        }

        return minDiffer;

    }




    /*
     * in binary sort all elememts of array consist of zero and one
     */

    public static void binarySort(int arr[], int n) {

        int index = 0;

        for(int i=0; i<n; i++){                       // Time Complexity : O(N)

            if(arr[i] == 0){                          // Space Complexity : O(1)

                swap(arr, i, index);

                index++;

            }

        }

    }





    public static void segregate012(int arr[], int n){        // Time Comlexity : O(N)

        int index = 0;                                        // Space Complexity : O(1)                           

        for(int i=0; i<n; i++){

            if(arr[i] == 0){

                swap(arr, index, i);

                index++;

            }

        }


        for(int i= index; i<n; i++){

            if(arr[i] == 1){

                swap(arr, i, index);

                index++;

            }

        }


    }




    /*
     * By choosing random pivot time complexity O(n*logn) otherwise O(N*N)
     */
    
    public static void tailQuickSort(int arr[], int l, int r){

       // Begin :

       if(l<r){                                  // because of tail recursion auxiliary space : O(N)

        int b = lomutoPartition(arr, l, r);

        tailQuickSort(arr, l, b);

        l = b+1;

        //goto begin;

       }

    }



    /*
     * By choosing random pivot time complexity O(n*logn) otherwise O(N*N)
     */


    public static int kthSmallestElementWithLomutoPartition ( int arr[], int k){

        int low = 0, high = arr.length -1;

        while(low <= high){

            int p = lomutoPartition(arr, low, high);                   // Auxiliary Space : O(1)

            if(p == k-1) return arr[p];

            else if(p > k-1) high = p-1;

            else low = p+1;

        }

        return -1;

    }



    
    /*
     * By choosing random pivot time complexity O(n*logn) otherwise O(N*N)
     */


    public static int kthSmallestElementRecursive ( int arr[], int k, int left, int right){

        if( left > right) return -1;                                        // Space Complexity : O(N)

        else{

            int p = lomutoPartition(arr, left, right);

           if(p == k-1) return p;

           else if(p > k-1) return kthSmallestElementRecursive(arr, k, left, p-1);

           else return kthSmallestElementRecursive(arr, k, p+1, right);

        }
        
    }




    /*
     *  Time Complexity : O(N)
     *  Space Complexity : O(1)
     */

    public static int minShareChocolate (int arr[], int m){

        if( m > arr.length) return -1;

        mergeSort(arr, 0, arr.length-1);                         

        int minDiffer = arr[m-1] - arr[0];

        for(int i=1; i + m < arr.length-1; i++) minDiffer = Math.min(minDiffer, arr[m + i -1 ] - arr[i]);

        return minDiffer;

    }



    /*
     *  Time Complexity : O(N)
     *  Space Complexity : O(1)
     */

    public static void segregatePositiveNegative(int arr[], int n){

        int i=-1, j = n;

        while(true){

            do { i++; } while (arr[i] < 0);

            do { j--; } while (arr[j] >=0 );

            if(i >= j) return;

            swap(arr, j, i);

        }

    }



    /*
     *  Time Complexity : O(N)
     *  Space Complexity : O(1)
     */

    public static void segregate012(int arr[]){

        int low = 0, mid = 0, high = arr.length-1;        // That problem called as " Dutch national flag problem "

        while( mid <= high){

            if(arr[mid] == 0){

                swap(arr, low, mid);

                low++;
                mid++;

            }

            else if(arr[mid] == 1) mid++;

            else{

                swap(arr, mid, high);

                high--;

            }

        }

    }



    
    static class Interval implements Comparable<Interval>{

        public int end, start;

        public Interval(int start,int end) { this.start = start; this.end = end;}

        public int compareTo(Interval other){

            return -1;         // including is not important

        }

    }

    /*
     *  Time Complexity : O(N*logN)
     *  Space Complexity : O(1)
     */

    public static void mergeIntervals(Interval[] arr, int n){

        Arrays.sort(arr);

        int res = 0;

        for(int i=1; i<n; i++){

            if(arr[res].end >= arr[i].start){

                arr[res].end = Math.max(arr[i].end, arr[res].end);

                arr[res].start = Math.max(arr[i].start, arr[res].start);

            }

            else{

                res++;

                arr[res] = arr[i];

            }

        }

        for(int i=0; i<=res; i++) System.out.println(arr[i].start +" "+arr[i].end);

    } 



    /*
     *  Time Complexity : O(N*logN)
     *  Space Complexity : O(1)
     */

     public static int maxGuests(int arr[], int dep[], int n){

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0, j=0, res=0, curr=0;

        while( i<n && j<n){

            if(arr[i] <= dep[j]) { curr++; i++;}

            else { curr--; j++; }

            res = Math.max(res, curr);

        }

        return res;

     }



     /*
     *  Time Complexity : O(N*N)
     *  Space Complexity : O(1)
     */

    public static void cycleSort(int arr[], int n){

        int writes = 0;

        for(int cycleStart = 0; cycleStart <= n-2; cycleStart++){

            int item = arr[cycleStart], pos = cycleStart;

            for(int i= cycleStart+1; i<n; i++) if(arr[i] < item) pos++;

            if(pos == cycleStart) continue;

            while(item == arr[pos]) pos++;

            if(pos != cycleStart){

                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;

            }

            while (pos != cycleStart){

                pos = cycleStart;

                for(int i= cycleStart+1; i<n; i++) if(arr[i] < item) pos++;

                if(item != arr[pos]){

                 int temp = item;
                 item = arr[pos];
                 arr[pos] = temp;
                 writes++;

                }

            }
            

        }

    }



    /*
     *  Time Complexity : O(N*logN)
     *  Space Complexity : O(N)
     */

    public static void sortABS (int arr[], int n, int k){

        class Point implements Comparable<Point>{

            int num = 0;

            public Point(int num) { this.num = num; }

            public int compareTo(Point p){

                if( Math.abs(num - k)< Math.abs(p.num - k )) return -1;

                else if( Math.abs(num - k) > Math.abs(p.num - k )) return 1;

                else return 0;

            }

        }

        Point temp[] = new Point[n];

        for(int i=0; i<n; i++) temp[i] = new Point(arr[i]);

        Arrays.sort(temp);

        for(int i=0; i<n; i++) arr[i] = temp[i].num;

    }



    /*
     *  Time Complexity : O(N*logN)
     *  Space Complexity : O(N)
     */

    public static int closer(int arr[], int n, int x){

        return binarySearch(arr,0,n-1,x);

    }

    /*
     *  Time Complexity : O(N*logN)
     *  Space Complexity : O(N)
     */

    public static int binarySearch(int []arr, int l, int r, int x){

        if( l > r) return -1;

        int mid = l +( r - l ) / 2;

        if(arr[mid] == x) return mid;

        if(mid >l && arr[mid-1] == x) return mid-1;

        if(mid <r && arr[mid+1] == x) return mid+1;

        if(arr[mid] > x) return binarySearch(arr, l, mid-2, x);

        if(arr[mid] < x) return binarySearch(arr, mid+2, r, x);

        return -1;

    }



    /*
     *  Time Complexity : O(N*N)
     *  Space Complexity : O(N)
     */

    public static int findNumberOfPossibleTriangles(int arr[], int n){

        int count = 0;

        int temp[] = new int[n];

        Arrays.sort(arr);

        for(int i=n-1; i>=0; i--) temp[n-i-1] = arr[i];

        for(int i=0; i<n-2; i++){

            int l = i+1, r=n-1;

            while(l < r){

                if(temp[l] + temp[r] <= temp[i]) r--;

                else{

                    count += (r-l);

                    l++;

                }

            }

        }

        return count;

    }



    /*
     *  Time Complexity : O(N*N)
     *  Space Complexity : O(1)
     */

    public static int findNumberOfTriangles(int arr[], int n){

        int count = 0;

        Arrays.sort(arr);

        for(int i=n-1; i>=2; i--){

            int l=0, r=i-1;

            while( l < r){

                if(arr[r] + arr[l] <arr[i]) r--;

                else{

                    count += (r-l);

                    l++;

                }


            }

        }

        return count;

    }



    /*
     *  Time Complexity : O(logn)
     *  Space Complexity : O(logn)
     */

    public static void heapify(int arr[], int n, int i){

        int largest = i, l= 2*i+1, r= 2*i +2;

        if(l<n && arr[l] > arr[largest] ) largest = l;

        if(r<n && arr[r] > arr[largest] ) largest = r;

        if(largest != i){

            swap(arr, i, largest);

            heapify(arr, n, largest);

        }

    }



    /*
     *  Time Complexity : O(N*logN)
     *  Space Complexity : O(1)
     */

    public static void heapSort(int arr[], int n){

        for(int i= n / 2 -1; i>=0; i--) heapify(arr, n, i);

        for(int i=n-1; i>=0; i--){

            swap(arr, 0, i);

            heapify(arr, i, 0);

        }

    }



    /*
     *  Time Complexity : O(N +K)
     *  Space Complexity : O(K)
     * 
     *  K is the range of input
     * 
     *  naive solution can not be applied for object data types
     * 
     */

    public static void countingSortNaive(int arr[], int n, int k){

        int count[] = new int[k];

        for(int i=0; i<n; i++) count[arr[i]]++;

        int index = 0;

        for(int i=0; i<k; i++){

            for(int j=0; j<count[i]; j++){

                arr[index] = i;

                index++;

            }

        }

    }



    /*
     *  Time Complexity : O(N*N)
     *  Space Complexity : O(N)
     * 
     * That is general purpose implementation
     * 
     * Counting sort is not a comparison based algorithm
     * it is stable and uses as a subroutine in radix sort 
     * 
     */

    public static void countSort(int arr[], int n, int k){

        int count[] = new int[k];

        for(int i=0; i<n; i++) count[arr[i]]++;

        for(int i=1; i<k; i++) count[i] += count[i-1];

        int output[] = new int[n];

        for(int i=n-1; i>=0; i--){

            output[count[arr[i]] -1] = arr[i];

            count[arr[i]]--;

        }

        for(int i=0; i<n; i++) arr[i] = output[i];

    }



    /*
     * Time Complexity : O(N*LogN)
     * Auxiliary Space : O(N)
     * 
     * This is not a counting sort solution
     * 
     */

    public static String sortString(String arr){

        int n = arr.length();

        char[] temp = arr.toCharArray();

        Arrays.sort(temp);

        StringBuilder str = new StringBuilder("");

        for(int i=0; i<n; i++) str.append(temp[i]);

        return new String(str);

    }



    /*
     *  Time Complexity : O(N*N)
     *  Space Complexity : O(N)
     */

    public static String countSortString(String arr){

        int n = arr.length();

        char max = arr.charAt(0);

        for(int i=1; i<n; i++) max = (char) (Math.max((int)max, (int)arr.charAt(i)));

        int countLen = (int) max - 97 + 1;

        int count[] = new int[countLen];

        for(int i=0; i<n; i++) count[(int)arr.charAt(i)-97]++;

        StringBuilder str = new StringBuilder("");

        for(int i=0; i<countLen; i++){

            for(int j=0; j<count[i]; j++) str.append((char)(i+97));

        }

        return str.toString();

    }



    /*
     *  Time Complexity : O(N*N)
     *  Space Complexity : O(N)
     */

    public static String countStringSort(String arr){

        char seq[] = arr.toCharArray();

        int n = seq.length;

        char[] output = new char[n];

        int count[] = new int[256];

        for(int i=0; i<n; i++) count[seq[i]]++;

        for(int i=1; i<= 255; i++) count[i] += count[i-1];

        for(int i=0; i<n; i++){

            output[count[seq[i]]-1] = seq[i];

            count[seq[i]]--;

        } 

        for(int i=0; i<n; i++) seq[i] = output[i];

        StringBuilder s = new StringBuilder("");

        for(int i=0; i<n; i++) s.append(seq[i]);

        return s.toString();

    }



    /*
     *  Time Complexity : O(N + base)
     *  Space Complexity : O(N + base)
     */

    public static void countSortRadix(int arr[], int n, int exp){

        int output[] = new int[n], count[] = new int[10];

        for(int i=0; i<n; i++) count[arr[i] / exp % 10] ++;

        for(int i=1; i<10; i++) count[i] += count[i-1];

        for(int k= n-1; k>=0; k--){

            output[count[arr[k] / exp % 10 ]] = arr[k];
            
            count[arr[k] / exp % 10 ] --;

        }

        for(int i=0; i<n; i++) arr[i] = output[i];

    }



    /*
     *  Time Complexity : O( d* (N + base))
     *  Space Complexity : O(N + base)
     * 
     *  d : log maxValue base 
     * 
     */

    public static void radixSort(int arr[],int n){

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) max = Math.max(max, arr[i]);

        for(int exp = 1; max / exp > 0; exp*=10) countSortRadix(arr, n, exp);

    }



    /*
     *  Time Complexity : O(N)
     *  Space Complexity : O(N)
     */

    public static void bucketSort(int arr[], int n){

        if(n<=0) return;

        Vector<Integer>[] buckets = new Vector[n];

        for(int i=0; i<n; i++) buckets[i] = new Vector<Integer>();

        for(int i=0; i<n; i++){

            int idx = arr[i] * n;

            buckets[idx].add(arr[i]);

        }

        for(int i=0; i<n; i++) Collections.sort(buckets[i]);

        int index = 0;

        for(int i=0; i<n; i++){

            for(int j=0; j<buckets[i].size(); j++) arr[index++] = buckets[i].get(j);

        }


    }

    /*
     * Note : 
     * 
     * if all buckets have the same number of elements Time Complexity : O(N)
     * 
     * if all items go into a single bucket if we use insertion sort Time Complexity : O(N*N)
     * 
     * In place of insertion sort If we were used O(n*logn) algortihm such as merge sort
     * Time Complexity : O(N*LogN)
     * 
     */

    



    







    



    
    








    







  









        public static void main(String[] args) {

            int arr1[] = {5,15,2,3,2,1,8,9,2};
    
            System.out.println(kthSmallestElementWithHashing(arr1, 3));
    
            
            
        }


    }

    



    
   


   

    

