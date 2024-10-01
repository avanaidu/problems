package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListSorting {
    public static void main(String[] args) throws Exception {
        int[] a = new int[]{5, 13, 4, 21, 13, 27, 2, 59, 59, 34};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(sortingInAscending(list));
        System.out.println(findThridLargest(list));
    }

    private static Integer findThridLargest(List<Integer> list) throws Exception {

      return  list.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElseThrow(Exception::new);
    }

    private static List<Integer> sortingInAscending(List<Integer> list) {
        return list.stream().distinct().sorted(Comparator.comparing(li->li)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
