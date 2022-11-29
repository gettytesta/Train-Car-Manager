# Train-Car-Manager
In this assignment, you will write a train car manager for a commercial train. The train, modelled using a Double-Linked List data structure, consists of a chain of train cars, each of which contains a product load. A product load has a weight, a value, and can be dangerous or safe. The train car manager will be able to add and remove cars from the train, set the product load for each car, and determine useful properties of the train, such as its length, weight, total value, and whether it contains any dangerous product loads.

1. Write a fully-documented class named ProductLoad which contains the product name (String), its weight in tons (double), its value in dollars (double), and whether the product is dangerous or not (boolean). You should provide accessor and mutator methods for each variable. The mutator methods for weight and value should throw exceptions for illegal arguments (i.e. negative values). The class should include a constructor. The full list of required methods is:

public ProductLoad - constructor (you may include a constructor with parameters)
getter and setter methods for each variable
2. Write a fully-documented class named TrainCar which contains a length in meters (double), a weight in tons (double), and a load reference (ProductLoad). The load variable of the train may be null, which indicates that the train car is empty and contains no product. The train car should have accessor methods for the length, weight, and load variables; however, you should only provide a mutator method for the load variable (the car weight and length should be constant once set). In addition, the class should specify a constructor method (with whatever parameters are necessary), and a method determining whether the car is empty or not. The full list of required methods is:

public TrainCar - constructor (you may include a constructor with parameters)
getter methods for each variable
setter method only for the load variable.
isEmpty() method
3. Write a fully-documented class named TrainCarNode which acts as a node wrapper around a TrainCar object. The class should contain two TrainCarNode references (one for the next node in the chain, one for the previous node in the chain), and one TrainCar reference variable containing the data. Include mutator/accessor methods for each member variable, and a constructor method. The full list of required methods is:

public TrainCarNode - constructor (you may include a constructor with parameters)
getter and setter methods for each variable

ProductLoad, TrainCar, and TrainCarNode UML specification.
4. Write a fully-documented class named TrainlinkedList which implements a Double-Linked List ADT. The class should contain references to the head and tail of the list, as well as a cursor variable (all TrainCarNode), and should provide methods to perform insertion, deletion, search, and various other operations. The class will be based on the following ADT specification:

public class TrainLinkedList
The TrainlinkedList class implements an abstract data type for a Double-Linked List of train cars supporting some common operations on such lists, as well as a few others.

public TrainLinkedList()
Brief:
Constructs an instance of the TrainLinkedList with no TrainCar objects in it.
Postconditions:
This TrainLinkedList has been initialized to an empty linked list.
head, tail, and cursor are all set to null.

public TrainCar getCursorData()
Brief:
Returns a reference to the TrainCar at the node currently referenced by the cursor.
Preconditions:
The list is not empty (cursor is not null).
Returns:
The reference to the TrainCar at the node currently referenced by the cursor.

public void setCursorData(TrainCar car)
Brief:
Places car in the node currently referenced by the cursor.
Preconditions:
The list is not empty (cursor is not null).
Postconditions:
The cursor node now contains a reference to car as its data.

public void cursorForward()
Brief:
Moves the cursor to point at the next TrainCarNode.
Preconditions:
The list is not empty (cursor is not null) and cursor does not currently reference the tail of the list.
Postconditions:
The cursor has been advanced to the next TrainCarNode, or has remained at the tail of the list.

public void cursorBackward()
Brief:
Moves the cursor to point at the previous TrainCarNode.
Preconditions:
The list is not empty (cursor is not null) and the cursor does not currently reference the head of the list.
Postconditions:
The cursor has been moved back to the previous TrainCarNode, or has remained at the head of the list.

public void insertAfterCursor(TrainCar newCar)
Brief:
Inserts a car into the train after the cursor position.
Parameters:
newCar - the new TrainCar to be inserted into the train.
Preconditions:
This TrainCar object has been instantiated
Postconditions:
The new TrainCar has been inserted into the train after the position of the cursor.
All TrainCar objects previously on the train are still on the train, and their order has been preserved.
The cursor now points to the inserted car.
Throws:
IllegalArgumentException - Indicates that newCar is null.

public TrainCar removeCursor()
Brief:
Removes the TrainCarNode referenced by the cursor and returns the TrainCar contained within the node.
Preconditions:
The cursor is not null.
Postconditions:
The TrainCarNode referenced by the cursor has been removed from the train.
The cursor now references the next node, or the previous node if no next node exists.

public int size()
Brief:
Determines the number of TrainCar objects currently on the train.
Returns:
The number of TrainCar objects on this train.
Notes:
This function should complete in O(1) time.

public double getLength()
Brief:
Returns the total length of the train in meters.
Returns:
The sum of the lengths of each TrainCar in the train.
Notes:
This function should complete in O(1) time.

public double getValue()
Brief:
Returns the total value of product carried by the train.
Returns:
The sum of the values of each TrainCar in the train.
Notes:
This function should complete in O(1) time.

public double getWeight()
Brief:
Returns the total weight in tons of the train. Note that the weight of the train is the sum of the weights of each empty TrainCar, plus the weight of the ProductLoad carried by that car.
Returns:
The sum of the weight of each TrainCar plus the sum of the ProductLoad carried by that car.
Notes:
This function should complete in O(1) time.

public boolean isDangerous()
Brief:
Whether or not there is a dangerous product on one of the TrainCar objects on the train.
Returns:
Returns true if the train contains at least one TrainCar carrying a dangerous ProductLoad, false otherwise.
Notes:
This function should complete in O(1) time.

public void findProduct(String name)
Brief:
Searches the list for all ProductLoad objects with the indicated name and sums together their weight and value (Also keeps track of whether the product is dangerous or not), then prints a single ProductLoad record to the console.
Parameters:
name - the name of the ProductLoad to find on the train.
Notes:
This method should search the entire train for the indicated ProductLoad, and should not stop after the first match. For example, if there are three different TrainCar objects each carrying a ProductLoad with the name "corn", then this method should print a single record with the sum of the weight and value for the corn on each car. If nothing was found, indicate that there are no ProductLoad objects of the indicated name on board the train.
For the purposes of this assignment, you may assume that the dangerousness of loads with equal names are equal. Simply use the boolean value of isDangerous for the first match found.

public void printManifest()
Brief:
Prints a neatly formatted table of the car number, car length, car weight, load name, load weight, load value, and load dangerousness for all of the car on the train.
Notes:
There should be a record for each TrainCar printed to the console, numbered from 1 to n. For each car, print the data of the car, followed by the ProductLoad data if the car is not empty. If the car is empty, print "Empty" for name, 0 for weight and value, and "NO" for dangerousness (see sample I/O for example).

public void removeDangerousCars()
Brief:
Removes all dangerous cars from the train, maintaining the order of the cars in the train.
Postconditions:
All dangerous cars have been removed from this train.
The order of all non-dangerous cars must be maintained upon the completion of this method.
Notes:
All the dangerous cars may be discarded after calling this method.

public String toString()
Brief:
Returns a neatly formatted String representation of the train.
Returns:
A neatly formatted string containing information about the train, including its size (number of cars), length in meters, weight in tons, value in dollars, and whether it is dangerous or not.

5. Write a fully-documented class named TrainManager that is based on the following specification:

public class TrainManager

public static void main(String[] args)
The main method runs a menu driven application which first creates an empty TrainLinkedList object. The program prompts the user for a command to execute an operation. Once a command has been chosen, the program may ask the user for additional information if necessary, and performs the operation. The operations should be defined as follows:

F - Move Cursor Forward
Moves the cursor forward one car (if a next car exists).
B - Move Cursor Backward
Moves the cursor backward one car (if a previous car exists).
I - Insert Car After Cursor
Inserts a new empty car after the cursor. If the cursor is null (i.e. the train is empty), the car is set as the head of the train. After insertion, the cursor is set to the newly inserted car.
R - Remove Car At Cursor
Removes the car at current position of the cursor. After deletion, the cursor is set to the next car in the list if one exists, otherwise the previous car. If there is no previous car, the list is empty and the cursor is set to null.
L - Set Load At Cursor
Sets the product load at the current position in the list.
S - Search For Product
Searches the train for all the loads with the indicated name and prints out the total weight and value, and whether the load is dangerous or not. If the product could not be found, indicate to the user that the train does not contain the indicated product.
T - Print Train
Prints the String value of the train to the console.
M - Print Manifest
Prints the train manifest - the loads carried by each car.
D - Remove Dangerous Cars
Removes all the dangerous cars from the train.
Q - Quit
Terminates the program.
