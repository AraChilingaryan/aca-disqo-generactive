package repository.model;

public class Item {

    private int id;
    private int groupId;
    private double price;
    private String currency;

    public Item(int id, int groupId, double price, String currency) {
        this.id = id;
        this.groupId = groupId;
        this.price = price;
        this.currency = currency;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
