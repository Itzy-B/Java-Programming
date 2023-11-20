
import java.util.ArrayList;

interface Item {
public String getName();
public double getPrice();
}


public class Product implements Item{

    private String name;
    private double price;
    private String bioInfo;

    public Product(String name, double price, String bioInfo) {
        this.name = name;
        this.price = price;
        this.bioInfo = bioInfo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getBioInfo() {
        return bioInfo;
    }
}


class ShoppingBag{
    private ArrayList<Item> items;

    public ShoppingBag() {
        items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public double totalPriceProduct(String name){
        double total = 0;
        for(Item item : items){
            if(item.getName().equals(name)){
                total += item.getPrice();
            }
        }return total;
    }
}
