import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 35;
        int y = 105;
        int num= Math.min(x, y);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 2; i <= num; i++) {
            while (x % i == 0 && y % i == 0) {
                num /= i;
                set.add(i);
                x/=i;
                y/=i;
            }
        }

        System.out.println(set);

    }
}
