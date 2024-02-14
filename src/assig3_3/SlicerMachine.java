package assig3_3;

public class SlicerMachine {

    int numOfCucumbers = 0;
    int numOfTomatoes = 0;
    int numOfPreparedSalads = 0;

    final int cucumbersNeededForOneSalad = 3;
    final int tomatoesNeededForOneSalad = 2;

    // add one cucumber into the slicer chamber
    void addOneCucumber() {
        if (numOfCucumbers < cucumbersNeededForOneSalad) {
            System.out.println("adding one cucumber to the machine");
            numOfCucumbers++;
        }
    }

    // add one tomato into the slicer chamber
    void addOneTomato() {
        if (numOfTomatoes < tomatoesNeededForOneSalad) {
            System.out.println("Adding one tomato to the machine");
            numOfTomatoes++;
        }
    }

    // if there are enough vegetables in the slicer
    // chamber, make another salad
    void sliceVegetables() {
        if ((numOfCucumbers >= cucumbersNeededForOneSalad) && (numOfTomatoes >= tomatoesNeededForOneSalad)) {
            makeNewSalad();
        }
    }

    private void makeNewSalad() {
        System.out.println("== preparing one more salad ==");
        numOfPreparedSalads++;
        // update stock
        numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
        numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
    }

    int getNumOfPreparedSalads() {
        return numOfPreparedSalads;
    }

}
