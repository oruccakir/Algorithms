
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.Comparator;

import javax.xml.transform.Templates;

import java.util.Iterator;



public class Hashing{

    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

    public static boolean isPairSum(int arr[],int n,int sum){

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){

            if(set.contains(sum - arr[i])) return true;

            else set.add(arr[i]);

        }

        return false;

    }



    /*
     * Time Complexity : O(N * N)
     * Auxiliary Space : O(1)
     */

    public static void writeDistinctElements(int arr[],int n){

        for(int i=0; i<n; i++){

            boolean flag = false;

            for(int k=0; k<i && flag == false; k++){

                if(arr[i] == arr[k]) flag = true;

            }

            if(flag == false) System.out.println(arr[i] +" ");

        }

    }



    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

    public static int countDistinctElements(int arr[]){

        HashSet<Integer> set = new HashSet<>();

        for(Integer item : arr) set.add(item);

        return set.size();

    }



    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

    public static boolean checkTwoArraysContents(int arr1[], int arr2[]){          // arrays should be equal if all elements frequency are the same but the locations might be different

        if(arr1.length != arr2.length) return false;

        HashMap<Integer,Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        for(int i=0; i<arr1.length; i++){

            if(map1.get(arr1[i]) == null) map1.put(arr1[i],1);
            
            else map1.put(arr1[i],map1.get(arr1[i])+1);

            if(map2.get(arr2[i]) == null) map2.put(arr2[i],1);
            
            else map2.put(arr2[i],map2.get(arr2[i])+1);

        }

        return map1.equals(map2);

    }



    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

    public static void printNonRepeatedElements(int arr[]){

        Map<Integer,Integer> map = new LinkedHashMap<>();

        for(Integer key : arr) map.put(key,map.getOrDefault(key,0)+1);

        for(Integer key : map.keySet()){

            if(map.get(key) == 1) System.out.print(key+" ");

        }

    }



    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

     public static int countNonRepeatedElements(int arr[]){

        Map<Integer,Integer> map = new HashMap<>();

        int count = 0;

        for(Integer key : arr) map.put(key,map.getOrDefault(key,0)+1);

        for(Integer key : map.keySet()){

            if(map.get(key) == 1) count++;

        }

        return count;

    }



    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

    public static int firstRepeatedElement(int arr[]){

        Map<Integer,Integer> map = new LinkedHashMap<>();

        for(Integer key : arr) map.put(key,map.getOrDefault(key, 0)+1);

        for(Integer key : map.keySet()) if(map.get(key) >1) return key;

        return -1;

    }



    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

    public static int numberOfElementsIntersection(int a[], int b[]){

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0; i<a.length; i++) set1.add(a[i]);

        for(int i=0; i<b.length; i++) set2.add(b[i]);

        set1.retainAll(set2);

        return set1.size();

    }



    /*
     * Time Complexity : O(N)
     * Auxiliary Space : O(N)
     */

    public static int unionOfArrays(int a[], int b[]){

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0; i<a.length; i++) set1.add(a[i]);

        for(int i=0; i<b.length; i++) set2.add(b[i]);

        set1.addAll(set2);

        return set1.size();

    }


    /*
     * Time Complexity : O(NlogN)
     * Auxiliary Space : O(N)
     */

    public static int[] sortA1ByA2(int []a1, int []a2){

        HashSet<Integer> set = new LinkedHashSet<>();

        Map<Integer,Integer> map = new LinkedHashMap<>();

        for(Integer i : a2) set.add(i);

        int arr[] = new int[a1.length];

        for(int i=0; i<a1.length; i++){

            if(map.get(arr[i]) == null) map.put(arr[i], 1);

            else map.put(a1[i], map.get(arr[i]+1));

        }

        Iterator<Integer> itr = set.iterator();

        int index = 0, count = 0;

        while(itr.hasNext()){

            int goal = (Integer) itr.next(), loop = 0;

            if(map.get(goal) != null) loop = map.get(goal);

            for(int i=0; i<loop; i++){

                arr[index] = goal;

                index++;

            }

        }

        for(int i=0; i<a1.length; i++){

            if(!set.contains(a1[i])){

                arr[index] = a1[i];

                index++;

            }

        }

        Arrays.sort(arr,a1.length-count,a1.length);

        return arr;

    }



    /*
     * Time Complexity : O(NlogN)
     * Auxiliary Space : O(N)
     */

    public static ArrayList<Integer> sortByFrequency(int arr[]){

        class Point implements Comparable<Point>{

            int freq,value;

            public Point(int f, int v){ freq = f; value = v;}

            @Override
            public int compareTo(Point o) {

                if(this.freq > o.freq) return -1;

                else if(this.freq < o.freq) return 1;

                else{

                    if(this.value < o.value) return -1;

                    if(this.value > o.value) return 1;

                    else return 0;

                }

            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        TreeSet<Point> set = new TreeSet<>();

        for(int i=0; i<arr.length; i++){

            if(map.get(arr[i]) == null) map.put(arr[i], 1);

            else map.put(arr[i], map.get(arr[i])+1);

        }

        Point [] p_array = new Point[arr.length];

        for(int i=0; i<arr.length; i++){

            p_array[i] = new Point(map.get(arr[i]),arr[i]);

            set.add(p_array[i]);

        }

        for(Point p : p_array){

            for(int i=0; i<p.freq; i++){

                list.add(p.value);

            }

        }

        return list;

    }




    /*
     * Time Complexity : O(NlogN)
     * Auxiliary Space : O(N)
     */

    static class comparator implements Comparator<Map.Entry<Integer,Integer>>{

        @Override
        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
            
            if(o1.getValue() > o2.getValue()) return -1;

            else if(o1.getValue() == o2.getValue()){

                if(o2.getKey() < o1.getKey()) return 1;

                else return -1;

            }

            else return 1;

        }
  
    }


    public static ArrayList<Integer> sortByFrequencyEfficient(int arr[]){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){

            if(map.get(arr[i]) == null) map.put(arr[i], 1);

            else map.put(arr[i], map.get(arr[i])+1);

        }

        List<Map.Entry<Integer,Integer>> set = new ArrayList<>(map.entrySet());

        Collections.sort(set,new comparator());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<map.size(); i++){

            int count = set.get(i).getValue();

            while(count >=0){

                list.add(set.get(i).getKey());

                count--;

            }

        }

        return list;

    }



    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */

    public static boolean subArrayWithZero(int arr[],int n){

        int prefix_sum = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){

            prefix_sum += arr[i];

            if(prefix_sum == 0) return true;

            if(set.contains(prefix_sum)) return true;

            set.add(prefix_sum);

        }

        return false;

    }


     /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */

    public static boolean isSum(int arr[],int sum,int n){

        int prefix_sum = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){

            prefix_sum += arr[i];

            if(prefix_sum == sum) return true;

            if(set.contains(prefix_sum-arr[i])) return true;

            set.add(prefix_sum);

        }

        return false;

    }




    /*
        Time Complexity : O(N*N)
        Auxiliary Space : O(N)
    */

    public static int largestSubArrayWithGivenSum(int arr[],int sum,int n){

        int current_sum = 0;
        int result = 0;

        for(int i=0; i<n; i++){

            for(int k = i; k<n; k++){

                current_sum += arr[i];

                if(current_sum == sum)
                    result = Math.max(result,k-i+1);
                

            }

        }

        return result;

    }


    /*
        Time Complexity : O(N*N)
        Auxiliary Space : O(N)
    */

    public static int efficientLargestSubArrayWithGivenSum(int arr[],int sum,int n){

        HashMap<Integer,Integer> map = new HashMap<>();

        int prefix_sum = 0, max = 0;

        for(int i=0; i<n; i++){

            prefix_sum += arr[i];

            if(prefix_sum == sum)
                max = i+1;

            if(!map.containsKey(prefix_sum))
                map.put(prefix_sum, i);

            if(map.containsKey(prefix_sum - sum))
                max = Math.max(max, i-map.get(prefix_sum-sum));

        }

        return max;

    }



    /*
        Time Complexity : O(N)
        Auxiliary Space : O(1)
    */
    

    public static boolean isSumThere(int arr[], int sum, int n){

        int current_sum = arr[0], start = 0, i=0;

        for(i=1; i<=n; i++){

            while(current_sum > sum && start<i-1){

                current_sum = current_sum - arr[i];

                start++;

            }

            if(current_sum == sum){
                System.out.println(" "+start+" "+(i-1));
                return true;
            }

            if(i<n) current_sum+=arr[i];

        }

        return false;

    }


    /*
        Time Complexity : O(N*N)
        Auxiliary Space : O(1)
    */


    // Array consists of zeros and ones

    public static int largestSubarrayEqualZeroandOne(int arr[], int n){

        int result = 0, count_one = 0, count_zero = 0;

        for(int i=0; i<n; i++){

            for(int k=i; k<n; k++){

                if(arr[k] == 0)
                    count_zero++;
                else
                    count_one++;

                if(count_one == count_zero)
                    result = Math.max(result,count_one+count_zero);

            }

        }

        return result;

    }



    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */

    // Array consists of zeros and ones

    public static int efficientLargestSubarrayEqualZoreOne(int arr[],int n){

        for(int i=0; i<n; i++)
            if(arr[i] == 0)
                arr[i] = -1;
        
        int prefix_sum = 0, count = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){

            prefix_sum += arr[i];

            if(prefix_sum == 0) count = i+1;

            if(!map.containsKey(prefix_sum))
                map.put(prefix_sum,i);
            else
                count = Math.max(count, i-map.get(prefix_sum));

        }

        return count;

    }



    /*
        Time Complexity : O(N*N)
        Auxiliary Space : O(1)
    */


    public static int maxCommonSubarrayBinary(int arr1[], int arr2[]){

        int n = arr1.length; // equal to the length of arr2

        int result = 0;

        for(int i=0; i<n; i++){

            int sum1 = 0, sum2 = 0;

            for(int k=i; k<n; k++){

                sum1+=arr1[k];

                sum2+=arr2[k];

                if(sum1 == sum2)
                    result = Math.max(result,k-i+1);

            }


        }

        return result;

    }



    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */

    public static int efficientMaxCommonSubarrayBinary(int arr1[], int arr2[]){

        int temp[] = new int[arr1.length];

        for(int i=0; i<temp.length; i++)
            temp[i] = arr1[i]-arr2[i];
        
        return efficientLargestSubArrayWithGivenSum(temp,0,temp.length);

    }


    /*
        Time Complexity : O(N*logN)
        Auxiliary Space : O(1)
    */

    public static int largestSubsequence(int arr[],int n){

        Arrays.sort(arr);

        int max = 1, count = 1;

        for(int i=1; i<n; i++){

            if(arr[i] == arr[i-1]+1) count++;

            else if(arr[i] != arr[i-1]){

                max = Math.max(count,max);

                count=1;

            }

        }

        return Math.max(max, count); // for last subarray control

    }


    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */


    public static int efficientLargestSubsequence(int arr[],int n){

        Set<Integer> h_set = new HashSet<>();

        for(int i=0; i<n; i++)
            h_set.add(arr[i]);
        
        int result = 1;

        for (Integer x : h_set){

            if(h_set.contains(x-1) == false){

                int current = 1;

                while(h_set.contains(x+current))
                    current++;
                
                result = Math.max(current, result);

            }

        }
        
        return result;

    }


    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */


    public static ArrayList<Integer> countDistinctWindow(int arr[],int k){

        ArrayList<Integer> arrayList = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<k; i++)
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        
        arrayList.add(map.size());

        for(int i=k; i<arr.length; i++){
            
            if(map.get(arr[i-k]) == 1) 
                map.remove(arr[i-k]);
            else
                map.put(arr[i-k], map.get(arr[i-k])-1);
            
            map.put(arr[i-k], map.getOrDefault(arr[i], 0)+1);

            arrayList.add(map.size());
        
        }

        return arrayList;

    }



    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */


    public static void printNByK(int arr[],int k){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int key : arr)
            map.put(key, map.getOrDefault(key, 0)+1);

        for(Map.Entry<Integer,Integer> item : map.entrySet())
            if(item.getValue() > arr.length / k)
                System.out.print(item.getKey()+" ");
        
    }



    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */


    public static int findNumberZeroSum(int arr[],int n){

        Map<Integer,Integer> map = new HashMap<>();

        int prefix_sum = 0, count = 0;

        for(int i=0; i<n; i++){

            prefix_sum += arr[i];

            if(prefix_sum == 0)
                count++;

            if(map.containsKey(prefix_sum))
                count += map.get(prefix_sum);
            
            map.put(prefix_sum, map.getOrDefault(prefix_sum,0)+1);
            
        }

        return count;
    }



    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */


    public static int countSubarrWithEqualZeroAndOne(int arr[],int n){
        
        for(int i=0; i<n; i++)
            if(arr[i] == 0) arr[i] = -1;

        return findNumberZeroSum(arr, n);

    }





    /*
        Time Complexity : O(N)
        Auxiliary Space : O(N)
    */

    
    public static int counSubarraySum(int arr[],int n, int sum){

        Map<Integer,Integer> map = new HashMap<>();

        int prefix_sum = 0, count=0;

        for(int i=0; i<n; i++){

            prefix_sum += arr[i];

            if(prefix_sum == sum)
                count++;
            
            if(map.containsKey(prefix_sum-sum))
                count += map.get(prefix_sum-sum);

            map.put(prefix_sum, map.getOrDefault(prefix_sum,0)+1);

        }

        return count;

    }








    







    


    








    


































    

    public static void main(String[] args) {
        
       

    }














}