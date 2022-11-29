/* Getty Testa
 * 115217416
 * Recitation 01
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainManager {
    public static void main(String args[]) {
        TrainLinkedList userTrain = new TrainLinkedList();
        boolean systemIsTerminated = false;

        while (!systemIsTerminated) {
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("(F) Cursor Forward\n(B) Cursor Backward\n"
                    + "(I) Insert Car After Cursor\n(R) Remove Car At Cursor\n"
                    + "(L) Set Product Load\n(S) Search For Product\n(T) Display Train"
                    + "\n(M) Display Manifest\n(D) Remove Dangerous Cars\n(Q) Quit\n");

            System.out.print("Enter a selection: ");
            String userSelection = inputScanner.nextLine();
            userSelection = userSelection.toUpperCase();

            switch (userSelection) {
                case "F":
                    userTrain.cursorForward();
                    System.out.println("Cursor moved forward");
                    break;
                case "B":
                    userTrain.cursorBackward();
                    break;
                case "I":
                    try {
                        System.out.print("Enter car length in meters: ");
                        double carLength = inputScanner.nextDouble();
                        System.out.print("Enter car weight in tons: ");
                        double carWeight = inputScanner.nextDouble();
                        inputScanner.nextLine();
                        userTrain.insertAfterCursor(new TrainCar(carLength, carWeight, null));
                        if (userTrain.size() != 1) {
                            userTrain.cursorForward();
                        }
                        break;
                    } catch (InputMismatchException ime) {
                        System.out.println("Invalid input!");
                        break;
                    }
                case "R":
                    try {
                        ProductLoad tempLoad = userTrain.removeCursor().getLoad();
                        System.out.println("Car successfully unlinked. The"
                                + " following load has been removed from the train:\n");
                        ProductLoad.printHeading();
                        if (tempLoad == null) {
                            System.out.println("    " + new ProductLoad().toString());
                        } else {
                            System.out.println("    " + tempLoad.toString());
                        }
                        break;
                    } catch (NullPointerException npe) {
                        System.out.println("No car to remove!");
                        break;
                    }
                case "L":
                    try {
                        ProductLoad userProduct = new ProductLoad();
                        System.out.print("Enter product name: ");
                        userProduct.setName(inputScanner.nextLine());
                        System.out.print("Enter car weight in tons: ");
                        userProduct.setWeight(inputScanner.nextDouble());
                        System.out.print("Enter value in dollars: ");
                        userProduct.setValue(inputScanner.nextDouble());
                        inputScanner.nextLine();
                        System.out.print("Enter is product dangerous? (y/n): ");
                        String dangerInput = inputScanner.nextLine();
                        if (dangerInput.toUpperCase().equals("Y")) {
                            userProduct.setIsDangerous(true);
                        } else if (dangerInput.toUpperCase().equals("N")) {
                            userProduct.setIsDangerous(false);
                        } else {
                            System.out.println("Invalid input!");
                            continue;
                        }
                        userTrain.setCursorData(new TrainCar(userTrain.getCursorData().getCarLength(),
                                userTrain.getCursorData().getCarWeight(), userProduct));
                        System.out.printf("%.1f tons of %s added to the current car.\n",
                                userProduct.getWeight(), userProduct.getName());
                        break;
                    } catch (InputMismatchException ime) {
                        System.out.println("Invalid input!");
                        break;
                    } catch (NullPointerException npe) {
                        System.out.println("Train does not exist!");
                        break;
                    }
                case "S":
                    try {
                        System.out.print("Enter product name: ");
                        userTrain.findProduct(inputScanner.nextLine());
                        break;
                    } catch (NullPointerException npe) {
                        System.out.println("No train cars to search through!");
                        break;
                    }
                case "T":
                    System.out.printf("Train: %s\n", userTrain.toString());
                    break;
                case "M":
                    userTrain.printManifest();
                    break;
                case "D":
                    userTrain.removeDangerousCars();
                    System.out.println("Dangerous cars successfully removed from the train.");
                    break;
                case "Q":
                    systemIsTerminated = true;
                    inputScanner.close();
                    break;
            }
            System.out.print("\n");
        }
        System.out.println("Program terminating successfully...\n");
    }
}