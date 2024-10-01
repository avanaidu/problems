import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddNumbers {

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9};

        System.out.println(partitionEvenOdd(arr));
    }

    private static Map<Boolean, List<Integer>> partitionEvenOdd(int[] arr) {

        Map<Boolean, List<Integer>> listMap = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(x -> x%2==0));
        return listMap;

    }
}
