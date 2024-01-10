import java.util.ArrayList;
import java.util.HashSet;

public class Question6 {
    
    public static void main(String[] args) {
        
        int arr[] = {7, 9 ,11, 5 ,13 ,15 ,17 ,3 ,8 ,19};
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++)
            set.add(arr[i]);

        HashSet<Integer> keyList = new HashSet<>();
        keyList.add(1);
        keyList.add(2);
        keyList.add(4);
        int x = 2;
        int num = 1;
        while(control(set, keyList) == false){

            keyList.add((int)Math.pow(2, x-1));
            keyList.add((int)Math.pow(2, x));
            keyList.add((int)Math.pow(2, x+1));
            num++;
            x++;
        }
        System.out.println(num);

    }

    public static boolean control(HashSet<Integer> set,HashSet<Integer> keylist){

        for(Integer num : set){
            if(canBeExpressedAsSum((keylist.toArray(), num) == false)
                return false;
        }

        return true;

    }

   private static boolean canBeExpressedAsSum(Integer[] array, Integer num) {
        return false;
    }

// Verilen sayıyı, dizi elemanlarının toplamı olarak ifade edebilme kontrolü
   public static boolean canBeExpressedAsSum(int[] array, int targetSum) {
    return canBeExpressedAsSumHelper(array, targetSum, 0);
}

private static boolean canBeExpressedAsSumHelper(int[] array, int remainingSum, int currentIndex) {
    if (remainingSum == 0) {
        // Hedef toplam 0 ise, başarıyla ifade edilmiştir.
        return true;
    }

    if (currentIndex == array.length) {
        // Dizi sona ulaşıldı, ancak hedef toplam 0 değilse başarısız oldu.
        return false;
    }

    // Elemanı toplama dahil etme veya dahil etmeme seçenekleri ile devam et
    // currentIndex elemanını dahil et
    boolean includeCurrent = canBeExpressedAsSumHelper(array, remainingSum - array[currentIndex], currentIndex + 1);

    // currentIndex elemanını dahil etme
    boolean excludeCurrent = canBeExpressedAsSumHelper(array, remainingSum, currentIndex + 1);

    // Her iki durumda da başarılı olabilirse true döndür
    return includeCurrent || excludeCurrent;
}

}
