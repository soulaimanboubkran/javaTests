import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public  Inventory(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }
    public void displayInventories(){
        for(Item item:items){
            System.out.println("Item : " + item.getName() + item.getQuantity());
        }
    }
}
