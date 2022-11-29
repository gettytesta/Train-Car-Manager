/* Getty Testa
 * 115217416
 * Recitation 01
 */

public class ProductLoad {
    private String name;
    private double weight;
    private double value;
    private boolean isDangerous;

    /**
     * Constructor for a ProductLoad. Sets name to "Empty" and values to 0
     */
    public ProductLoad() {
        this("Empty", 0, 0, false);
    }

    /**
     * Constructor for a ProductLoad. Sets values to user's input
     * 
     * @param name        the name of the product/load
     * @param weight      the weight of the product
     * @param value       the value of the product
     * @param isDangerous the danger value associated with the product
     */
    public ProductLoad(String name, double weight, double value, boolean isDangerous) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.isDangerous = isDangerous;
    }

    /**
     * Gets the name of the product
     * 
     * @return the name of the product/load
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the product/load based on the user's input
     * 
     * @param name the new name for the product/load
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the weight of the load
     * 
     * @return the weight of the load
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Changes the weight of the load based on the user's input
     * 
     * @param weight the new weight of the load
     * @throws IllegalArgumentExcpetion when the weight is invalid
     */
    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException();
        } else {
            this.weight = weight;
        }
    }

    /**
     * Gets the value of the load
     * 
     * @return the value of the load
     */
    public double getValue() {
        return value;
    }

    /**
     * Changes the value of the load
     * 
     * @param value the new value of the load
     * @throws IllegalArgumentException when the value is invalid
     */
    public void setValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        } else {
            this.value = value;
        }
    }

    /**
     * Gets the danger value associated with this load
     * 
     * @return true if the load is dangerous, false otherwise
     */
    public boolean getIsDangerous() {
        return isDangerous;
    }

    /**
     * Changes the danger value associated with this load
     * 
     * @param isDangerous the new danger value for the load
     */
    public void setIsDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

    /**
     * Creates and returns a neatly formatted representation of a load
     * 
     * @return the formatted representation of this load
     */
    public String toString() {
        String formattedLoad = String.format("%10s%14.1f%14.2f", name, weight, value);
        if (isDangerous) {
            formattedLoad += String.format("%12s\n", "YES");
        } else {
            formattedLoad += String.format("%12s\n", "NO");
        }
        return formattedLoad;
    }

    /**
     * Prints the heading for the load table
     */
    public static void printHeading() {
        System.out.println("        Name      Weight (t)     Value ($)   Dangerous\n"
                + "    ===================================================");
    }
}