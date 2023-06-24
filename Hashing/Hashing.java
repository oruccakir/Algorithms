
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

            else map.put(a1[i], map.get(arr[i]+1);

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


























    

    public static void main(String[] args) {
        
       

    }














}