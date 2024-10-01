
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateArrayButPersistPreviousPosition {


    /*Input:1,2,3,4,5,6,7
//output 7,1,2,3,4,5,6
    // 7,6,1,2,3,4,5
    //7,6,5,1,2,3,4
    k=3*/


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};

        for (int k=1; k<= 3 ; k++) {
            List<Integer> list = Stream.concat(Arrays.stream(input).boxed().skip(input.length - k), Arrays.stream(input).boxed().limit(input.length - k)).collect(Collectors.toList());

            List<Integer> a = list.stream().limit(k).collect(Collectors.toList());
            Collections.reverse(a);
            /*List<Integer> temp = new LinkedList<>();
            for (int i = a.size() - 1; i >= 0; i--) {
                temp.add(a.get(i));
            }*/

            System.out.println(Stream.concat(a.stream(), list.stream().skip(k)).collect(Collectors.toList()));
        }

        //
        //System.out.println(modifyString(input, 3));
    }

    /*private static List<Integer> modifyString(int[] input, int val) {

    }*/
}
