package self;
class Abelt extends Accessory {
    private String color;
    private String material;

    public Abelt(String color, String material) {
        super("Belt");
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Belt{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
