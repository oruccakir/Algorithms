import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeap{

    public static void swap(int arr[], int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void minHeapify(int arr[],int i,int n){

        int l = (2*i)+1, r = (2*i)+2, smallest = i;

        if(l<n && arr[l] < arr[smallest]) smallest = l;

        if(r<n && arr[r] < arr[smallest]) smallest = r;

        if(smallest != i){

            swap(arr, i, smallest);

            minHeapify(arr, smallest, n);

        }

    }

    public static void maxHeapify(int arr[],int i,int n){

        int l = (2*i)+1, r = (2*i)+2, largest = i;

        if(l<n && arr[l] > arr[largest]) largest = l;

        if(r<n && arr[r] > arr[largest]) largest = r;

        if(largest != i){

            swap(arr, i,largest);
            maxHeapify(arr, largest, n);

        }
    }

    public static void buildMaxHeap(int arr[],int n){

        for(int i = n/2-1; i>=0; i--){
            maxHeapify(arr, i, n);
        }

    }


    public static void builMinHeap(int arr[],int n){

        for(int i = n/2-1; i>=0; i--){
            minHeapify(arr, i, n);
        }

    }

    public static void heapSortIncreasing(int arr[],int n){

        buildMaxHeap(arr, n);

        for(int i=n-1; i>=0; i--){
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }



    }

    public static void heapSortDecreasing(int arr[],int n){

        builMinHeap(arr, n);

        for(int i=n-1; i>=0; i--){
            swap(arr, 0,i);
            minHeapify(arr, 0,i);
        }

    }

     public static int KthLargest(int arr[], int n, int k) 
    {
        //implementing MinHeap using priority queue.
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) 
        {
            //if size of priority queue becomes equal to k and top 
            //element is smaller than arr[i], we pop the front 
            //element and push arr[i] in priority queue.
            if (pq.size() == k &&pq.peek() < arr[i]) 
            {
                pq.poll();
                pq.add(arr[i]);
            } 
            //else we just push arr[i] in priority queue.
            else if (pq.size() < k)
                pq.add(arr[i]);
        }
        //returning the top element of priority queue.
        return pq.peek(); 
    }


    public static void main(String[] args) {
        
        int arr[] = {3, 5, 4 ,2 ,9};

        //heapSortIncreasing(arr, arr.length);

        buildMaxHeap(arr, arr.length);

        System.out.println(Arrays.toString(arr));

        heapSortDecreasing(arr, arr.length);

        System.out.println(Arrays.toString(arr));



    }





















}