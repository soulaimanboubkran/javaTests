public class Item {
    private String name;
    private int quantity;

    public Item(String name,int quantity){
        this.name = name;
        this.quantity = quantity;
    }
    //getters 

    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
}