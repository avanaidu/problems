package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxItemInCart {

    public static void main(String[] args) {

        List<Item> shoppingCart = Arrays.asList(ItemBuilder.anItem().withItemId("Phone").withItemName("1").build()
                , ItemBuilder.anItem().withItemId("WashingMachine").withItemName("22").build()
                , ItemBuilder.anItem().withItemId("Charger").withItemName("33").build()
                , ItemBuilder.anItem().withItemId("Phone").withItemName("jnnn").build()
                , ItemBuilder.anItem().withItemId("Phone").withItemName("yy").build()
                , ItemBuilder.anItem().withItemId("Charger").withItemName("22").build()
                , ItemBuilder.anItem().withItemId("Fridge").withItemName("2").build());

        System.out.println(findDuplicatesItemsMap(shoppingCart));
        System.out.println(findDuplicatesNumberForEachItem(shoppingCart));
        System.out.println(findMaxNumberofItemAddedToShoppingCart(shoppingCart));

    }

    private static String findMaxNumberofItemAddedToShoppingCart(List<Item> shoppingCart) {
        return shoppingCart.stream().collect(Collectors.groupingBy(Item::getItemId))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, x->x.getValue().size()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (y1, y2)->y1, LinkedHashMap::new))
                .keySet().stream().findFirst().get();

    }

    private static Map findDuplicatesNumberForEachItem(List<Item> shoppingCart) {
        return shoppingCart.stream().collect(Collectors.groupingBy(Item::getItemId))
                 .entrySet().stream().collect(Collectors.toMap(x->x.getKey(), x->x.getValue().size()))
                    .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(y->y.getKey(), y-> y.getValue(), (y1,y2)->y1, LinkedHashMap::new));

    }

    private static Map<String, List<Item>> findDuplicatesItemsMap(List<Item> shoppingCart) {

        return shoppingCart.stream().collect(Collectors.groupingBy(Item::getItemId));

    }
}
