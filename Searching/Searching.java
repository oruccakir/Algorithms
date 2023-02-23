package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import Array.Array;

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



    public static int getPeak(int arr[], int n){

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



    public static double getMedianOfSortedArrays(int arr1[], int arr2[]){

        int n1=arr1.length, n2=arr2.length;                                // Time Complexity : O(log(n))                             

        int begin1=0, end1=n1;                                             // Auxiliary Space : O(1)

        while(begin1 < end1){                                              // Assume that n1 <= n2 and the arrays are sorted 

            int i1 = (begin1 + end1) / 2;                                  // That can be done using merging with O(n) time complexity and O(n) auxiliary space
            int i2 = (n1 + n2 + 1) - i1;

            int min1 = (i1 == n1) ? Integer.MAX_VALUE : arr1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : arr1[i1-1];
            int min2 = (i2 == n2) ? Integer.MAX_VALUE : arr2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : arr2[i2-1];

            if(max1 <= min1 && max2 <= min1){

                if((n1 + n2) % 2 == 0) 
                   return (double)(Math.max(max2, max1) + Math.min(min1, min2)) / 2;
                else
                   return (double) Math.max(max2, max1);

            }
            else if(max1 > min2) end1=i1-1;

            else begin1 = i1+1;
        }
        return 0.0;
    }



    public static int findRepeat(int arr[], int n){

        for(int i=0; i<n-1; i++)                        // Time Complexity : O(n ** 2) 
           
           for(int j=i+1; j<n; j++)                     // Auxiliary Space : O(1)        
             
              if(arr[i] == arr[j]) return arr[i];

        return -1;
    }



    public static int findRepeating(int arr[], int n){

        Arrays.sort(arr);                                 // Time Complexity : O(n * log(n)) 

        for(int i=0; i<n-1; i++)                          // Auxiliary Space : O(1)

           if(arr[i] == arr[i+1]) return arr[i];

        return -1;
    }



    public static int findRepeated(int arr[], int n){

        boolean visited[] = new boolean[n];             // Time Complexity : O(n) 

        for(int i=0; i<n; i++){                         // Auxiliary Space : O(n)

            if(visited[i]) return arr[i];               // for last three methods n>=2 only one element repeats and all elements from 0 to max(arr)

            visited[i] = true;
        }
        return -1;
    }



    public static int efficientfindRepeatingWithoutZero(int arr[], int n){

        int slow = arr[0], fast = arr[0];

        do{                                                    // Time Complexity : O(n) 
            slow=arr[slow];                                    // Auxiliary Space : O(1)

            fast=arr[arr[fast]];

        }while(slow !=fast);

        slow = arr[0];

        while(slow != fast){

            slow = arr[slow];

            fast = arr[fast];
        }

        return slow;
    }



    public static int efficientfindRepeatingWithZero(int arr[], int n){

        int slow = arr[0]+1, fast = arr[0]+1;

        do{                                                         // Time Complexity : O(n) 
            slow=arr[slow] + 1;                                     // Auxiliary Space : O(1)

            fast=arr[arr[fast] + 1] + 1;

        }while(slow !=fast);

        slow = arr[0] + 1;

        while(slow != fast){

            slow = arr[slow] + 1;

            fast = arr[fast] + 1;
        }

        return slow - 1;
    }



    public static int findMinRotatedSortedArray(int arr[], int n){

        int l = 0, r = n-1;                                         // Time Complexity : O(log(n))

        while(l <= r){                                              // Auxiliary Space : O(1)

            int mid = (l+r) / 2;

            if(mid == 0 || arr[mid-1] > arr[mid]) return arr[mid];

            else if(arr[mid] > arr[r]) l=mid+1;

            else r=mid-1;
        }

        return -1;                                                  // never reachs
    }



    public static int maxStep(int arr[], int n){

        int step=0, maxStep=0;                       // Time Complexity : O(n)

        for(int i=1; i<n; i++){                      // Auxiliary Space : O(1)

            if(arr[i-1] < arr[i])
               step++;
            
            else{
                maxStep = Math.max(maxStep, step);
                step=0;
            }
        }

        maxStep = Math.max(maxStep, step);

        return maxStep;

    }



    public static int maxWter(int arr[], int n){

        int maxWater = 0;                                // Time Complexity : O(n ** 2)

        for(int i=0; i<n; i++){                          // Auxiliary Space : O(1)

            int water = 0;

            for(int j=n-1; j>=i+1; j--){

                water = Math.min(arr[i],arr[j]) * ( j - i -1);

                maxWater = Math.max(water, maxWater);

            }

        }

        return maxWater;
         
    }



    public static int efficientMaxWater(int[]arr, int n){

        int l=0, r=n-1;

        int water = 0, maxWater  = 0;                                // Time Complexity : O(n)           

        while(l <= r){                                               // Auxiliary Space : O(1)
             
            water = Math.min(arr[l],arr[r]) * ( r - l - 1);          // Two pointers approach

            maxWater = Math.max(water, maxWater);

            if(arr[l] < arr[r]) l++;

            else r--;

        }

        return maxWater;
    }



    public static int[] findRepeatingElement(int arr[], int n){

        int res[] = {-1, -1};

        int repeated = -1;                                           // Time Complexity : O(n)

        int l = 0, r = n-1;                                          // Auxiliary Space : O(1)

        while(l <= r){                                               // Array consists of positive elements and array are consecutive sorted

            int mid = (r+l) / 2;

            if(arr[mid] >= mid + arr[0]) l = mid + 1;

            else r = mid - 1;

        }

        if(l <= n-1)
           repeated = arr[l];

        if(repeated != -1){

            res[0] = repeated;

            res[1] = n - (arr[n-1] - arr[0]);

        }

        return res;
    }



    public static int sum(int arr[],int start,int end){

        int sum=0;                                         // Time Complexity : O(n)

        for(int i=start; i<=end; i++)                      // Auxiliary Space : O(1)
           sum+=arr[i];

        return sum;

    }


    public static int minPages(int arr[], int n, int k){

        if(k == 1) return sum(arr, 0 ,n-1);        // Time Complexity : O(n)

        if(n == 1) return arr[0];                        // Auxiliary Space : O(1)                                   

        int result = Integer.MAX_VALUE;

        for(int i=1; i<n; i++)
           result = Math.min(result, Math.max(minPages(arr, i, k-1), sum(arr,i,n-1)));

        return result;

    }



    public static boolean isFeasible(int arr[], int n, int k, int answer){

        int sum=0, studentsRequired=1;

        for(int i=0; i<n; i++){                                 // Time Complexity : O(n ** k)

            if(arr[i]+sum > answer){                            // Auxiliary Space : O(1) 

                studentsRequired++;
                sum=arr[i];

            }

            else{

                sum+=arr[i];

            }
        }

        return studentsRequired <= k;

    }



    public static int efficientMinPages(int arr[], int n, int k){

        int sum=0, max=0;

        for(int i=0; i<n; i++){                                 // Time Complexity : O( n * log(sum - max))

            sum+=arr[i];
            max = Math.max(max, arr[i]);                        // Auxiliary Space : O(1) 

        }

        int l = max, r = sum, result=0;

        while(l <= r){

            int mid = (l + r) / 2;
            
            if(isFeasible(arr, n, k, mid)){

                result = mid;

                r = mid-1;

            }

            else{

                l = mid + 1;

            }
        }

        return result;
    }



    public static int ternarySearch(int arr[], int n, int x){

        int l=0, r=n-1;

        while(l <= r){
                                
            int mid1 = l +(r-l)/3;
            int mid2 = r -(r-l)/3;

            if(arr[mid1] == x) return mid1;              // Time Complexity : O( log3(n))
            
            if(arr[mid2] == x) return mid2;              // Auxiliary Space : O(1)

            else if (arr[mid1] > x) r=mid1-1;
            
            else if(arr[mid2] < x) l=mid2+1;

            else{
                l=mid1+1;
                r=mid2-1;
            }
        }

        return -1;
    }



    public static int recursiveTernarySearch(int[] arr, int l, int r, int x){

        if(l > r) return -1;

        int mid1=l+(r-l)/3, mid2=r-(r-l)/3;                                  // Time Complexity : O( log3(n))

        if(arr[mid1] == x ) return mid1;                                     // Auxiliary Space : O(log3(n))

        if(arr[mid2] == x) return mid2;

        else if(arr[mid1] > x) return recursiveTernarySearch(arr, l, mid1-1, x);

        else if(arr[mid2] < x) return recursiveTernarySearch(arr, mid2+1, r, x);

        else return recursiveTernarySearch(arr, mid1+1, mid2-1, x);

    }



    public static int[] findElements(int arr[], int n){

        Arrays.sort(arr);

        int array[] = new int[2];                     // Time Complexity : O( n * log(n))   

        for(int i=1; i<n; i++){                       // Auxiliary Space : O(1)

            if(arr[i-1] == arr[i]) array[0] = arr[i];    // array[0] = repeating number

            if(arr[i] != i+1) array[1] = i+1;            // array[1] = missing number
        }

        return array;                                  // Auxiliary Space can be defined as O(log(n)) beacuse the Arrays.sort() usesu quick sort which is a recursive method 
    }                                                  // but for now I do not know implementatin of that method



    public static void findElementsWithAuxiliarySpace(int arr[], int n){

        int count[] = new int[n+1];

        int repeating = 0, missing = 0;                               // Time Complexity : O(n)

        for(int i=0; i<n; i++)                                        // Auxiliary Space : O(n)
            count[arr[i]]++;

        for(int i=1; i<n+1; i++){
            
            if(count[i] == 0) missing = i;

            if(count[i] == 2) repeating = i;

        }

        System.out.println("Mising : "+missing+" Repeating : "+repeating);

    }



    public static void repeating_missing(int arr[], int n){

        int temp = 0, repeating = 0, missing = 0;

        for(int i=0; i<n; i++){                          // Time Complexity : O(n)

            temp = arr[Math.abs(arr[i]-1)];              // Auxiliary Space : O(1)

            if(temp < 0){
                repeating = Math.abs(arr[i]);
                break;
            }

            arr[Math.abs(arr[i]-1)] = -arr[Math.abs(arr[i]-1)];

        }


        for(int i=0; i<n; i++){

            if(arr[i] > 0){

                missing = i+1;
                break;

            }
        }

        System.out.println("Mising : "+missing+" Repeating : "+repeating);

    }



    public static int[] twoRepeated(int arr[], int n){

        int temp = 0, array[] = new int[2], index = 0;

        for(int i=0; i<n; i++){                          // Time Complexity : O(n)

            temp = arr[Math.abs(arr[i]-1)];              // Auxiliary Space : O(1)

            if(temp < 0){
                
                array[index] = Math.abs(arr[i]);
                index++;

            }

            arr[Math.abs(arr[i]-1)] = -arr[Math.abs(arr[i]-1)];

        }

        return array;
    }



    public static int arrange(int arr[], int n){

        int index = 0, temp = 0;             

        for(int i=0; i<n; i++){

            if(arr[i] > 0){

                temp = arr[index];                    // Time Complexity : O(n)
                arr[index] = arr[i];
                arr[i] = temp;                        // Auxiliary Space : O(1)

                index++;

            }

        }

        return index - 1;

    }



    public static int[] findMinMax(int arr[], int l, int r){

        int holder[] = new int[2], max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int i=l; i<=r; i++){                        

            max = Math.max(max, arr[i]);                   // Time Complexity : O(n)
            min = Math.min(min, arr[i]);                   // Auxiliary Space : O(1)

        }

        holder[0] = min;

        holder[1] = max;

        return holder;
    }



    public static int countOccurenceOccuredMoreThan(int arr[], int n, int k){

        int count = 0, finalCount = 0;

        Arrays.sort(arr);

        for(int i=0; i<n-1; i++){                                // Time Complexity : O(n*log(n))

            if(arr[i] == arr[i+1]) count++;                      // Auxiliary Space : O(1)

            else{

                if(count > n/k) finalCount++;

                count =1;
            } 
                
        }

        if(count > n/k) finalCount++;

        return finalCount;

    }




    public static int efiicientCountOccurenceOccuredMoreThan(int arr[], int n, int k){

        int barrier = n / k;

        HashMap<Integer, Integer> map = new HashMap<>();                               // Time Complexity : O(n)

        int count = 0;                                                                 // Auxiliary Space : O(n)

        for(int i=0; i<n; i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        
        for(Map.Entry<Integer,Integer> element : map.entrySet())
            if(element.getValue() > barrier) count++;
        
        return count;

    }



    public static int majorityElement(int arr[], int n){

        if( n == 1 ) return arr[0];

        Arrays.sort(arr);                                // Time Complexity : O(n * log(n))

        int majority = -1, count =0;                     // Auxiliary Space : O(1)

        for(int i=1; i<n; i++){

            if(arr[i] == arr[i-1]){

                count++;
                majority=arr[i];

                if(count + 1 > n/2) return majority;
            }

            else {
                count =0;
            }
        }

        return -1;
    }



    public static int findCandidate(int arr[], int n){

        int maj_index = 0, count = 1;                   // Time Complexity : O(n)


        for(int i=1; i<n; i++){                         // Auxiliary Space : O(1)

            if(arr[maj_index] == arr[i]) count++;

            else count--;

            if( count == 0){
                maj_index = i;
                count =1;
            }
        }

        return arr[maj_index];
    }



    public static boolean isMajority(int arr[], int n, int cand){

        int count =0;                               // Time Complexity : O(n)

        for(int i=0; i<n; i++)                      // Auxiliary Space : O(1)
           if(cand == arr[i]) count++;

        return count > n/2;

    }



    public static int efficientMajorityElement(int arr[], int n){

        int cand = findCandidate(arr, n);                // Time Complexity : O(n)

        if(isMajority(arr, n, cand)) return cand;        // Auxiliary Space : O(1)

        return -1;
    }



    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        int start = 0, sum = arr[0];                              // Time Complexity : O(n)
        
        for(int i=1; i<=n; i++){                                   // Auxiliary Space : O(1)
                          
            while(sum > s && start < i-1){                        // I do not why O(n) I will learn the reason
                
                sum -=arr[start];
                start++;
                
            }
            
            if(sum == s){
                
                int p = i;
                
                array.add(start+1);
                array.add(p);
                
                return array;
            }
            
            if(i<n) sum+=arr[i];
        }
        
        array.add(-1);
        
        return array;
        
    }



    







    










    public static void main(String[] args) {

        int arr[] ={1,2,3,4,5,6,7};
        Array.write(arr);
        System.out.println(recursiveTernarySearch(arr, 0, arr.length-1, 5));
        
        
    }















    
}
