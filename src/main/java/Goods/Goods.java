package Goods;

public class Goods {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private int price;
    private int idPreOrder;

    public Goods(int id, String name, String description, int quantity, int price, int idPreOrder) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.idPreOrder = idPreOrder;
    }

    public int getIdPreOrder() {
        return idPreOrder;
    }

    public void setIdPreOrder(int idPreOrder) {
        this.idPreOrder = idPreOrder;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", idPreOrder=" + idPreOrder +
                '}';
    }
}
