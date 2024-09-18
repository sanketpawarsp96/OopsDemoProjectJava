package self;
class Upper_Garment{
    private String type;
    private String color;
    private String fit;

    public Upper_Garment(String type, String color, String fit) {
        this.type = type;
        this.color = color;
        this.fit = fit;
    }

    @Override
    public String toString() {
        return "UpperGarments{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", fit='" + fit + '\'' +
                '}';
    }
}
