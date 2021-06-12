package pl.lukaszmalina.mas2021.model.mp3.multiInheritance;

public class CarRegisteredAsAntique extends Car {

    private String conservatorOpinion;


    public CarRegisteredAsAntique(Car car, String conservatorOpinion) {
        super(car.getMark(), car.getModel());
        this.conservatorOpinion = conservatorOpinion;
    }

    public String getConservatorOpinion() {
        return conservatorOpinion;
    }

    public void setConservatorOpinion(String conservatorOpinion) {
        this.conservatorOpinion = conservatorOpinion;
    }

    @Override
    public String toString() {
        return "CarRegisteredAsAntique{" +
                "mark='" + this.getMark() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", conservatorOpinion='" + conservatorOpinion + '\'' +
                '}';
    }
}
