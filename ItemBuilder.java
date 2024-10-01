package java8;

public final class ItemBuilder {
    private String itemId;
    private String itemName;

    private ItemBuilder() {
    }

    public static ItemBuilder anItem() {
        return new ItemBuilder();
    }

    public ItemBuilder withItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemBuilder withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Item build() {
        Item item = new Item();
        item.setItemId(itemId);
        item.setItemName(itemName);
        return item;
    }
}
