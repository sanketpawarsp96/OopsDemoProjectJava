package self;
class shoe {
    private String type;
    private String color;

    public shoe(String type, String color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
