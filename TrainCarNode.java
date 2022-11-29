/* Getty Testa
 * 115217416
 * Recitation 01
 */

public class TrainCarNode {
    private TrainCarNode prev;
    private TrainCarNode next;
    private TrainCar car;

    /**
     * Constructor for a TrainCarNode. Sets the current car to null
     */
    public TrainCarNode() {
        this(null);
    }

    /**
     * Constructor for a TrainCarNode. Sets the current car to the user's input.
     * 
     * @param car the car for the Node to hold
     */
    public TrainCarNode(TrainCar car) {
        this.prev = null;
        this.next = null;
        this.car = car;
    }

    /**
     * Gets the previous node in the linked list
     * 
     * @return the previous node
     */
    public TrainCarNode getPrev() {
        return prev;
    }

    /**
     * Changes the reference to the previous node in the linked list
     * 
     * @param prev the new previous node to reference
     */
    public void setPrev(TrainCarNode prev) {
        this.prev = prev;
    }

    /**
     * Gets the next node in the linked list
     * 
     * @return the next node in the linked list
     */
    public TrainCarNode getNext() {
        return next;
    }

    /**
     * Changes the reference to the next node in the linked list
     * 
     * @param next the new next node to reference
     */
    public void setNext(TrainCarNode next) {
        this.next = next;
    }

    /**
     * Gets the TrainCar the node references
     * 
     * @return the TrainCar the node references
     */
    public TrainCar getCar() {
        return this.car;
    }

    /**
     * Changes the car that the node references
     * 
     * @param car the TrainCar for the node to reference
     */
    public void setCar(TrainCar car) {
        this.car = car;
    }

    /**
     * Creates and returns a string representation of the node
     * 
     * @return the string representation of the node
     */
    public String toString(int i) {
        String formattedCar = "";
        formattedCar += String.format("%3d%15.1f%14.1f  |", i, car.getCarLength(), car.getCarWeight());
        if (car.isEmpty()) {
            formattedCar += new ProductLoad().toString();
        } else {
            formattedCar += car.getLoad().toString();
        }
        return formattedCar;
    }
}
