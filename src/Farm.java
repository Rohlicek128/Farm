import java.util.concurrent.Flow;

public class Farm {

    private Flower[] flowers;
    private int farmSize;

    public Farm(int flowersSize, int farmSize) {
        this.flowers = new Flower[flowersSize];
        this.farmSize = farmSize;
    }

    public void plant(Flower other){
        for (int i = 0; i < flowers.length; i++){
            if (flowers[i] == null){
                flowers[i] = other;
                return;
            }
        }
        throw new RuntimeException(flowers.length + "/" + flowers.length + " flowers!");
    }



}
