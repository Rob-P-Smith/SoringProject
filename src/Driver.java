import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
//Inversions are when n > m where indexn < indexm, eg. the items in teh array are out of order
//stable sorts maintain the relative position of comparatively equal values after sorting as the same order as input
//Bogo sort, earch after class


public class Driver {
    public static final int TEST_SIZE = 2000000;
    public static final int[] TEST_ARRAY = generateTestArray(TEST_SIZE);
    public static final Sorter SORTER = new Sorter();

    public static void main(String[] args) {
        System.out.println("ArraySize     SortType        Elapsed Minutes:Seconds:Milliseconds");

//        System.out.println("Test Array" + Arrays.toString(TEST_ARRAY));    //enable to print test array
        javaSort();         //
        mergeSort();        //
        heapSort();         //
//        insertionSort();    //
//        selectionSort();    //
//        bubbleSort();       //
//        shellSort();        // to write
//        arrayCopyTest();
//        System.out.println(Arrays.toString(TEST_ARRAY));                   //enable to verify test array not mutated
    }

    private static void mergeSort() {
        printResults(TEST_ARRAY.length, getTime(SORTER.mergeSort(TEST_ARRAY)), "Merge Sort");
    }

    private static void heapSort() {
        printResults(TEST_ARRAY.length, getTime(SORTER.heapSort(TEST_ARRAY)), "Heap Sort");
    }

    private static void insertionSort() {
        printResults(TEST_ARRAY.length, getTime(SORTER.insertionSort(TEST_ARRAY)), "Insertion Sort");
    }

    private static void shellSort() {
        printResults(TEST_ARRAY.length, getTime(SORTER.shellSort(TEST_ARRAY)), "Shell Sort");
    }

    private static void selectionSort() {
        printResults(TEST_ARRAY.length, getTime(SORTER.selectionSort(TEST_ARRAY)), "Selection Sort");
    }

    public static void bubbleSort() {
        printResults(TEST_ARRAY.length, getTime(SORTER.bubbleSort(TEST_ARRAY)), "Bubble Sort");
    }

    public static void javaSort() {
        printResults(TEST_ARRAY.length, getTime(SORTER.javaSort(TEST_ARRAY)), "Java Sort");
    }

    public static String getTime(long elapsedTimeMillis){
        if(elapsedTimeMillis < 1000){
            return String.valueOf(elapsedTimeMillis)+ " Milliseconds";
        } else if (elapsedTimeMillis < 3600001){
            String minutes = String.valueOf((int)elapsedTimeMillis / 60000);
            String seconds = String.valueOf((int)elapsedTimeMillis/1000);
            String millis = String.valueOf(elapsedTimeMillis%1000);
            return minutes+":"+seconds+":"+millis;
        }
        return "oops";
    }

    private static void printResults(int size, String test, String type) {;
        System.out.printf("%-14d%-16s%-20s\n", size, type, test);
    }

    private static int[] generateTestArray(int size) {
        Random rand = new Random();
        int[] testArray = new int[size];
        for (int i = 0; i < size; i++) {
            testArray[i] = rand.nextInt(100);
        }
        return testArray;
    }
    private static void arrayCopyTest() {
        int[] copyTestArray = generateTestArray(TEST_SIZE);
//        System.out.println(Arrays.toString(copyTestArray));
        int[] copyTargetOne = new int[copyTestArray.length];
        int[] copyTargetTwo = new int[copyTestArray.length];

        long startTime = System.nanoTime();
        System.arraycopy(copyTestArray, 0, copyTargetOne, 0, copyTestArray.length);
        long endTime = System.nanoTime()-startTime;
        double secs = endTime/1_000_000_000.0;
        System.out.printf("System.arraycopy() Time is: \nnanos: %d\nseconds: %.6f", endTime, secs);

        startTime = System.nanoTime();
        copyTargetTwo = Arrays.copyOf(copyTestArray, copyTestArray.length);
        endTime = System.nanoTime()-startTime;
        double seconds = endTime/1_000_000_000.0;
        System.out.printf("\nArrays.copyOf() Time is: \nnanos: +%d\nseconds: %.6f", endTime, seconds);
    }
}