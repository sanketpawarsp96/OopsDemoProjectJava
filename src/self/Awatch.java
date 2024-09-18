package self;
class Awatch extends Accessory {
    private String brand;
    private String type;

    public Awatch(String brand, String type) {
        super("Watch");
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}