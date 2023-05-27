
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

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























    

    public static void main(String[] args) {
        
       

    }














}