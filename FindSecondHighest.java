import java.util.Arrays;
import java.util.Comparator;

public class FindSecondHighest {

    public static void main(String[] args) {

        int[] arr = {2, 5, 3, 7, 6, 9, 4};

        System.out.println("findSecondHighest :: "+findSecondHighest(arr));
        System.out.println("conventionalSecondHighest :: "+conventionalSecondHighest(arr));

    }

    private static int conventionalSecondHighest(int[] arr) {
        Arrays.sort(arr);
        return  arr[arr.length-2];
    }

    private static int findSecondHighest(int[] arr) {

        return Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
    }
}
