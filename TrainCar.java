/* Getty Testa
 * 115217416
 * Recitation 01
 */

public class TrainCar {
    private double carLength;
    private double carWeight;
    private ProductLoad load;

    /**
     * Constructor for a TrainCar. Sets values to 0 and adds an empty load.
     */
    public TrainCar() {
        this(0, 0, null);
    }

    /**
     * Constructor for a TrainCar. Sets values to user's input.
     * 
     * @param carLength the length of the car
     * @param carWeight the weight of car (weight of load not included)
     * @param load      the ProductLoad for the car to carry
     */
    public TrainCar(double carLength, double carWeight, ProductLoad load) {
        this.carLength = carLength;
        this.carWeight = carWeight;
        this.load = load;
    }

    /**
     * Gets the length of the car.
     * 
     * @return the length of the car
     */
    public double getCarLength() {
        return carLength;
    }

    /**
     * Gets the weight of the car (weight of load not included)
     * 
     * @return the weight of the car
     */
    public double getCarWeight() {
        return carWeight;
    }

    /**
     * Gets the total weight of the car and load
     * 
     * @return the total weight of the car and load
     */
    public double getTotalWeight() {
        return getCarWeight() + this.load.getWeight();
    }

    /**
     * Gets the load held in the train car
     * 
     * @return the ProductLoad held in the car
     */
    public ProductLoad getLoad() {
        return load;
    }

    /**
     * Changes the load in the car based on the user's input
     * 
     * @param load the new load to be referenced by the train
     */
    public void setLoad(ProductLoad load) {
        this.load = load;
    }

    /**
     * Checks whether or not the train car is holding any load
     * 
     * @return true if the load is null, false otherwise
     */
    public boolean isEmpty() {
        if (load == null) {
            return true;
        }
        return false;
    }
}
