package self;
class lower_Garments {
    private String type;
    private String color;

    public lower_Garments(String type, String color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        return "LowerGarments{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
