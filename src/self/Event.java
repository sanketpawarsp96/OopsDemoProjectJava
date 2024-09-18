package self;
import java.util.ArrayList;



class Events {
	
	
    private String occasion;
    private  Upper_Garment upperGarment;
    private lower_Garments lowerGarment;
    private shoe shoe;
    private ArrayList<Accessory> accessories;

    public Events(String occasion, Upper_Garment upperGarment,  lower_Garments lowerGarment, shoe shoe, ArrayList<Accessory> accessories) {
        this.occasion = occasion;
        this.upperGarment = upperGarment;
        this.lowerGarment = lowerGarment;
        this.shoe = shoe;
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return "Events{" +
                "occasion='" + occasion + '\'' +
                ", upperGarment=" + upperGarment +
                ", lowerGarment=" + lowerGarment +
                ", shoe=" + shoe +
                ", accessories=" + accessories +
                '}';
    }
}
