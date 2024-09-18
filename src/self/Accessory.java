package self;
class Accessory {
    private String type;

    public Accessory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}




