public class Main {
    public static void main(String[] args){
        Inventory inventory = new Inventory();

        Item item1 = new Item("soul",21);
        Item item2 = new Item("soul2",23);


        inventory.addItem(
            item1
        );
        inventory.addItem(
            item2
        );
        inventory.displayInventories();
    }
}
