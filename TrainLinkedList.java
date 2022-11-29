/* Getty Testa
 * 115217416
 * Recitation 01
 */

public class TrainLinkedList {
    TrainCarNode head;
    TrainCarNode tail;
    TrainCarNode cursor;
    private int sizeOfTrain = 0;
    private double lengthOfTrain = 0;
    private double valueOfTrain = 0;
    private double weightOfTrain = 0;
    private int numOfDangerousCars = 0;

    /**
     * Constructs a new TrainLinkedList with an empty node
     */
    public TrainLinkedList() {
        this.cursor = null;
        this.head = null;
        this.tail = null;
    }

    /**
     * Returns the Train car referenced by the current node
     * Preconditions - the list is not empty (cursor is not null)
     * 
     * @return the reference to the TrainCar at the current node
     */
    public TrainCar getCursorData() {
        return cursor.getCar();
    }

    /**
     * Sets the TrainCar for the cursor to reference
     * 
     * Preconditions - the list is not empty (cursor is not null)
     * Postconditions - the cursor node now contains a reference to car as its data
     * 
     * @param car the TrainCar for the node to reference
     */
    public void setCursorData(TrainCar car) {
        changeTrainData(cursor.getCar(), false);
        cursor.setCar(car);
        changeTrainData(car, true);
    }

    /**
     * Moves the cursor to the next node
     * 
     * Preconditions - The list is not empty (cursor is not null) and cursor
     * does not currently reference the tail of the list.
     * Postconditions - the cursor has been advanced to the next TrainCarNode,
     * or has remained at the tail of the list.
     */
    public void cursorForward() {
        if (cursor != tail && cursor != null) {
            cursor = cursor.getNext();
        } else {
            System.out.println("No next car, cannot move cursor forward.");
        }
    }

    /**
     * Moves the cursor to the previous node
     * 
     * Preconditions - The list is not empty (cursor is not null) and cursor
     * does not currently reference the head of the list.
     * Postconditions - the cursor has been moved back to the previous TrainCarNode,
     * or has remained at the head of the list.
     */
    public void cursorBackward() {
        if (cursor != head && cursor != null) {
            cursor = cursor.getPrev();
            System.out.println("Cursor moved backward");
        } else {
            System.out.println("No previous car, cannot move cursor backwards.");
        }
    }

    /**
     * Inserts a car into the train after the cursor position.
     * Preconditions - this TrainCar object has been instantiated
     * Postconditions - the new TrainCar has been inserted into the train
     * after the position of the cursor. All TrainCar objects previously on
     * the train are still on the train, and their order has been preserved.
     * The cursor now points to the inserted car.
     * 
     * @param newCar the TrainCar to be inserted into the train
     * @throws IllegalArgumentException if newCar is null
     */
    public void insertAfterCursor(TrainCar newCar) {
        if (newCar == null) {
            throw new IllegalArgumentException();
        } else if (cursor == null) {
            cursor = new TrainCarNode(newCar);
            head = cursor;
            tail = cursor;
        } else {
            TrainCarNode insertNode = new TrainCarNode(newCar);
            insertNode.setNext(cursor.getNext());
            insertNode.setPrev(cursor);
            if (cursor != tail) {
                cursor.getNext().setPrev(insertNode);
            } else {
                tail = insertNode;
            }
            cursor.setNext(insertNode);
        }
        System.out.printf("New train car of %.1f meters and %.1f tons inserted into train.\n",
                newCar.getCarLength(), newCar.getCarWeight());
        changeTrainData(newCar, true);
        sizeOfTrain++;
    }

    /**
     * Removes the car referenced by the cursor
     * 
     * Preconditions - The cursor is not null.
     * Postconditions - The TrainCarNode referenced by the cursor has been
     * removed from the train. The cursor now references the next node, or
     * the previous node if no next node exists.
     * 
     * @throws NullPointerException when the cursor is null
     * @throws IllegalAccessError   when the node is the last car in the train
     */
    public TrainCar removeCursor() {
        TrainCar removedCar = cursor.getCar();
        if (cursor == null) {
            throw new NullPointerException();
        } else if (tail == head) {
            cursor = null;
            tail = null;
            head = null;
        } else if (cursor == tail) {
            cursor.getPrev().setNext(null);
            cursor = cursor.getPrev();
            tail = cursor;
        } else if (cursor == head) {
            cursor.getNext().setPrev(null);
            cursor = cursor.getNext();
            head = cursor;
        } else {
            cursor.getNext().setPrev(cursor.getPrev());
            cursor.getPrev().setNext(cursor.getNext());
            cursor = cursor.getNext();
        }
        changeTrainData(removedCar, false);
        sizeOfTrain--;
        return removedCar;
    }

    /**
     * Determines the number of train cars on the train
     * 
     * @return the number of train cars on the train
     */
    public int size() {
        return sizeOfTrain;
    }

    /**
     * Determines the total length of the train in meters
     * 
     * @return the sums of all the train cars on the train
     */
    public double getLength() {
        return lengthOfTrain;
    }

    /**
     * Determines the total value of the train
     * 
     * @return the sums of all the values of the train cars on the train
     */
    public double getValue() {
        return valueOfTrain;
    }

    /**
     * Determines the total weight of the train
     * 
     * @return the sums of all the weights of the train cars on the train
     */
    public double getWeight() {
        return weightOfTrain;
    }

    /**
     * Whether or not there is a dangerous product on one of the TrainCar
     * objects on the train.
     * 
     * @return true if the train contains at least one TrainCar carrying
     *         a dangerous ProductLoad, false otherwise.
     */
    public boolean isDangerous() {
        if (numOfDangerousCars > 0) {
            return true;
        }
        return false;
    }

    /**
     * Custom function to change the weight, value, length, and danger values
     * of the train. Called whenever a new car is added, changed, or removed.
     * 
     * @param car         the car being added or removed from the train
     * @param removeOrAdd whether or not we're removing or adding the car to the
     *                    train. True indicates we're adding, false indicates we're
     *                    removing.
     */
    public void changeTrainData(TrainCar car, boolean removeOrAdd) {
        if (car.isEmpty()) {
            if (removeOrAdd) {
                weightOfTrain += car.getCarWeight();
                lengthOfTrain += car.getCarLength();
            } else {
                weightOfTrain -= car.getCarWeight();
                lengthOfTrain -= car.getCarLength();
            }
        } else if (removeOrAdd) {
            weightOfTrain += car.getTotalWeight();
            lengthOfTrain += car.getCarLength();
            valueOfTrain += car.getLoad().getValue();
            if (car.getLoad().getIsDangerous()) {
                numOfDangerousCars++;
            }
        } else {
            weightOfTrain -= car.getTotalWeight();
            lengthOfTrain -= car.getCarLength();
            valueOfTrain -= car.getLoad().getValue();
            if (car.getLoad().getIsDangerous()) {
                numOfDangerousCars--;
            }
        }
    }

    /**
     * Searches the list for all ProductLoad objects with the indicated name
     * and sums together their weight and value (Also keeps track of whether
     * the product is dangerous or not), then prints a single ProductLoad
     * record to the console.
     * 
     * @param name the name of the ProductLoad to find on the train
     */
    public void findProduct(String name) {
        TrainCarNode tempCursor = head;
        int productWeight = 0;
        int productValue = 0;
        boolean productDanger = false;

        while (tempCursor != null) {
            if (tempCursor.getCar().getLoad().getName().equals(name)) {
                productValue += tempCursor.getCar().getLoad().getValue();
                productWeight += tempCursor.getCar().getLoad().getWeight();
                if (!productDanger) {
                    productDanger = tempCursor.getCar().getLoad().getIsDangerous();
                }
            }
            tempCursor = tempCursor.getNext();
        }
        if (productWeight == 0) {
            System.out.printf("No record of %s on board train.\n", name);
        } else {
            ProductLoad.printHeading();
            System.out.println("    " + new ProductLoad(name, productWeight, productValue, productDanger).toString());
        }
    }

    /**
     * Prints a neatly formatted table of the car number, car length, car
     * weight, load name, load weight, load value, and load dangerousness
     * for all of the car on the train.
     */
    public void printManifest() {
        TrainCarNode tempCursor = head;
        System.out.println("    CAR:                               LOAD:\n" +
                "      Num   Length (m)    Weight (t)  |    Name      Weight (t)     Value ($)   Dangerous\n" +
                "    ==================================+===================================================");
        for (int i = 1; tempCursor != null; i++) {
            if (tempCursor == cursor) {
                System.out.print(" -> ");
            } else {
                System.out.print("    ");
            }
            if (tempCursor.getCar() == null) {
                System.out.println("  No cars in the train!");
                break;
            }
            System.out.printf(tempCursor.toString(i));
            tempCursor = tempCursor.getNext();
        }
    }

    /**
     * Removes all dangerous cars from the train, maintaining the order of
     * the cars in the train.
     * 
     * Postconditions - All dangerous cars have been removed from this train.
     * The order of all non-dangerous cars must be maintained upon the
     * completion of this method.
     */
    public void removeDangerousCars() {
        TrainCarNode tempCursor = head;
        TrainCarNode holdCursor = cursor;
        while (holdCursor != null && !holdCursor.getCar().isEmpty() && holdCursor.getCar().getLoad().getIsDangerous()) {
            holdCursor = holdCursor.getNext();
        }
        while (tempCursor != null) {
            // Empty if statements to avoid any exceptions and keep loop running
            if (tempCursor.getCar() == null) {
            } else if (tempCursor.getCar().isEmpty()) {
            } else if (tempCursor.getCar().getLoad().getIsDangerous()) {
                cursor = tempCursor;
                this.removeCursor();
            }
            tempCursor = tempCursor.getNext();
        }
        if (holdCursor != null) {
            cursor = holdCursor;
        } else {
            cursor = tail;
        }
    }

    /**
     * Returns a neatly formatted String representation of the train.
     * 
     * @return a neatly formatted string containing information about
     *         the train, including its size (number of cars), length in meters,
     *         weight in tons, value in dollars, and whether it is dangerous or not.
     */
    public String toString() {
        String trainString = String.format("%d cars, %.1f meters, %.1f tons, $%.2f value, ", this.size(),
                this.lengthOfTrain, this.weightOfTrain, this.valueOfTrain);
        if (this.isDangerous()) {
            trainString += "DANGEROUS";
        } else {
            trainString += "SAFE";
        }
        return trainString;
    }
}
