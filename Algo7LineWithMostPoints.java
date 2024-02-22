import java.util.Arrays;
import java.util.Objects;

void main() {
    printLineWithMostPoints(new int[]{2, 2},
            new int[]{1, 1},
            new int[]{2, 1},
            new int[]{3, 3},
            new int[]{4, 4},
            new int[]{1, 3});

    printLineWithMostPoints(new int[]{0, 0},
            new int[]{1, 3},
            new int[]{1, 2},
            new int[]{2, 4},
            new int[]{2, 2},
            new int[]{3, 1},
            new int[]{4, 0});

    printLineWithMostPoints(new int[]{-1, 0},
            new int[]{1, 3},
            new int[]{-1, 1},
            new int[]{-2, 2},
            new int[]{2, -2},
            new int[]{3, -3},
            new int[]{4, -4});

    printLineWithMostPoints(new int[]{2, 0},
            new int[]{1, 3},
            new int[]{-1, 1},
            new int[]{-2, 2},
            new int[]{2, -2},
            new int[]{2, -3},
            new int[]{1, 10});
}


void printLineWithMostPoints(int[]... coordinatePairs) {
    int[][] longestLinePairs = new int[coordinatePairs.length][];
    int[][] currentCoordinatesPairs;

    for (int i = 0; i < coordinatePairs.length - 2; i++) {
        for (int j = i + 1; j < coordinatePairs.length - 1; j++) {
            currentCoordinatesPairs = new int[coordinatePairs.length][];
            currentCoordinatesPairs[0] = coordinatePairs[i];
            currentCoordinatesPairs[1] = coordinatePairs[j];

            int countIn = 2;
            for (int k = j + 1; k < coordinatePairs.length; k++) {
                if (!arrayHasElement(currentCoordinatesPairs, coordinatePairs[k])) {

                    if (Objects.equals(getGradientBetween2Coordinates(coordinatePairs[i], coordinatePairs[j]), getGradientBetween2Coordinates(coordinatePairs[i], coordinatePairs[k]))) {
                        currentCoordinatesPairs[countIn] = coordinatePairs[k];
                        countIn++;
                    }
                }
            }
            if (getNotNullLengthOfArray(longestLinePairs) < getNotNullLengthOfArray(currentCoordinatesPairs)) {
                longestLinePairs = currentCoordinatesPairs;
            }
        }
    }

    System.out.print("Line with most points is : ");
    printArray(longestLinePairs);
    System.out.println("-------------------------------------");

}


int getNotNullLengthOfArray(int[][] coordinatePairs) {
    int count = 0;
    for (int[] coordinatePair : coordinatePairs) {
        if (coordinatePair == null) return count;
        count++;
    }
    return count;
}

Double getGradientBetween2Coordinates(int[] pair1, int[] pair2) {
    int x = pair1[0] - pair2[0];
    int y = pair1[1] - pair2[1];
    if (x != 0) return (double) y / x;
    return null;
}

boolean arrayHasElement(int[][] coordinatePairs, int[] coordinates) {
    for (int[] coordinatePair : coordinatePairs) {
        if (Arrays.equals(coordinatePair, coordinates)) return true;
    }
    return false;
}

void printArray(int[][] coordinatesList) {
    for (int[] ints : coordinatesList) {
        if (ints == null) {
            System.out.println();
            return;
        }
        System.out.print(Arrays.toString(ints));
    }
    System.out.println();
}
