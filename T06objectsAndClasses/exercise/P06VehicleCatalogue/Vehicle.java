package T06objectsAndClasses.exercise.P06VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String colour;
    private double horsePower;


    public Vehicle(String type, String model, String colour, double horsePower) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public double getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %.0f\n",
                (this.type.substring(0, 1).toUpperCase() + this.type.substring(1)),
                this.model, this.colour, this.horsePower);
    }
}
