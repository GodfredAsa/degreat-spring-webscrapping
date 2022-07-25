package tonaton;

public class Product {
    private Integer id;
    private String name;
    private String brand;
    private String location;
    private Double price;

    public Product(Integer id, String name, String brand, String location, Double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.location = location;
        this.price = price;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                '}';
    }
}
