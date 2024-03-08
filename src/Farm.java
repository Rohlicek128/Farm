public class Farm {

    private Flower[] flowers;
    private double money;
    private final double land;
    private double landLeft;

    public Farm(int flowersSize, double land, int startingMoney) {
        this.flowers = new Flower[flowersSize];
        this.land = land;
        this.landLeft = land;
        this.money = startingMoney;
    }

    public void plant(Flower other){
        if (landLeft < other.neededArea) throw new RuntimeException("Not enough space!");
        for (int i = 0; i < flowers.length; i++){
            if (flowers[i] == null){
                flowers[i] = other;
                landLeft -= flowers[i].neededArea;
                return;
            }
        }
        throw new RuntimeException(flowers.length + "/" + flowers.length + " flowers!");
    }

    public void removeFlower(Flower f){
        for (int i = 0; i < flowers.length; i++){
            if (f == flowers[i]){
                flowers[i] = null;
                return;
            }
        }
        throw new RuntimeException("Not found!");
    }

    public int flowerToIndex(Flower f){
        for (int i = 0; i < flowers.length; i++){
            if (f == flowers[i]) return i;
        }
        throw new RuntimeException("Not found");
    }

    public void harvest(){
        for (Flower f : flowers){
            if (f.isGrown){
                money += f.getPrice();
                removeFlower(f);
            }
        }
    }

    public void waterFlower(Flower f){
        flowers[flowerToIndex(f)].water();
    }

}
