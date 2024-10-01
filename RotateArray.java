import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        arr= rotateArray(arr, 2);
        for (int ar : arr){
            System.out.print(ar+" ");
        }

     }

    private static int[] rotateArray(int[] arr, int i) {

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        return Stream.concat(list.stream().skip(arr.length - i), list.stream().limit(arr.length - i))
                .mapToInt(Integer::intValue).toArray();


        //1 3 4 5 6 2 7
        //3
        //6 2 7 1 3 4 5
        //skip len -rotate + limit len-rotate

    }
}
