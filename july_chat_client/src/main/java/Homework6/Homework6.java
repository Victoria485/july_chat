package Homework6;

import java.util.Arrays;

public class Homework6 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arrayAfterTheLast4(array)));
    }
    public static int[] arrayAfterTheLast4(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) return Arrays.copyOfRange(array, i + 1, array.length);
        }
        throw new RuntimeException("В массиве нет цифры 4");
    }
    public static boolean arrayWith1and4(int[] array) {
        boolean with1 = false;
        boolean with4 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) with1 = true;
            else if (array[i] == 4) with4 = true;
            else return false;
        }
        return with1 && with4;
    }
}
