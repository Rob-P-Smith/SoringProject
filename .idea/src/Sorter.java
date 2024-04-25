import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorter {

    public long javaSort(int[] testArray) {
        //prep the array copy for sorting
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
        long startTime = System.currentTimeMillis();
        Arrays.sort(sampleArray);
        return System.currentTimeMillis() - startTime;
    }

    public long bubbleSort(int[] testArray) {
        //prep the array copy for sorting
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
//        System.out.println("Sample Array "+ Arrays.toString(sampleArray));  //enable to print copied array unsorted
        //sort the sample and return the elapsed time
        boolean swapped = false;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < sampleArray.length - 1; i++) {
            for (int j = 0; j < sampleArray.length - i - 1; j++) {
                if (sampleArray[j] > sampleArray[j + 1]) {
                    int temp = sampleArray[j];
                    sampleArray[j] = sampleArray[j + 1];
                    sampleArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
//            System.out.println(Arrays.toString(sampleArray));
        }
        long elapsed = System.currentTimeMillis() - startTime;
//        System.out.println("Sorted Sample "+Arrays.toString(sampleArray));  //enable to print copied array sorted
        return elapsed;
    }

    public long selectionSort(int[] testarray) {
        int[] sampleArray = new int[testarray.length];
        System.arraycopy(testarray, 0, sampleArray, 0, testarray.length);
//        System.out.println(Arrays.toString(sampleArray));
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < sampleArray.length; i++) {
            int min = sampleArray[i];
            int minIndex = i;
            for (int j = i + 1; j < sampleArray.length; j++) {
                if (sampleArray[j] < min) {
                    min = sampleArray[j];
                    minIndex = j;
                }
            }
            int temp = sampleArray[i];
            sampleArray[i] = min;
            sampleArray[minIndex] = temp;
        }
        long elapsed = System.currentTimeMillis() - startTime;
//        System.out.println(Arrays.toString(sampleArray));
        return elapsed;
    }

    public long shellSort(int[] testArray) {
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
//        System.out.println(Arrays.toString(sampleArray));
        long startTime = System.currentTimeMillis();


        long elapsed = System.currentTimeMillis() - startTime;
//        System.out.println(Arrays.toString(sampleArray));
        return elapsed;
    }

    public long insertionSort(int[] testArray) {
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
//        System.out.println("Starting Array: "+Arrays.toString(sampleArray));
        int[] sortedArray = new int[testArray.length];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < sampleArray.length; i++) {
            if (i == 0) {
                sortedArray[i] = sampleArray[i];
            } else {
                int val = sampleArray[i];
//                System.out.println("Adding Item: "+val);
                for (int j = i; j > 0; j--) {
                    if (sortedArray[j - 1] <= val) {
                        sortedArray[j] = val;
                        break;
                    } else if (val < sortedArray[j - 1]) {
                        sortedArray[j] = sortedArray[j - 1];
                        sortedArray[j - 1] = val;
                    }
                }
            }
//            System.out.println(i+" Sort Step: "+Arrays.toString(sortedArray));
        }
        long elapsed = System.currentTimeMillis() - startTime;
//        System.out.println("Sorted Array: "+Arrays.toString(sortedArray));
        return elapsed;
    }

    public long heapSort(int[] testArray) {
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
//        System.out.println(Arrays.toString(sampleArray));
        PriorityQueue<Integer> newQueue = new PriorityQueue<>();
        int[] sortedArray = new int[sampleArray.length];
        long startTime = System.currentTimeMillis();

        for (int item : sampleArray) {
            newQueue.offer(item);
        }
        for (int i = 0; i < sampleArray.length; i++) {
            sortedArray[i] = newQueue.poll();
        }
        long elapsed = System.currentTimeMillis() - startTime;
//        System.out.println(Arrays.toString(sortedArray));
        return elapsed;
    }

    public long heapifySort(int[] testArray) {
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
        long startTime = System.currentTimeMillis();




        long elapsed = System.currentTimeMillis() - startTime;
        return elapsed;
    }

    private void heapifySink(int curIndex, int[] sampleArray){
        while(curIndex < sampleArray.length){
            int leftChildIndex = curIndex * 2 + 1;
            int rightChildIndex = curIndex * 2 + 2;
            int smallestChildIndex = leftChildIndex;

            if(rightChildIndex<leftChildIndex && sampleArray[rightChildIndex] < sampleArray[leftChildIndex]){
                smallestChildIndex = rightChildIndex;
            }

            if(sampleArray[curIndex] > sampleArray[smallestChildIndex]){
                swap(curIndex, smallestChildIndex, sampleArray);
            } else {
                break;
            }
        curIndex = smallestChildIndex;
        }
    }

    private void swap(int curIndex,int smallestIndex, int[] sampleArray){

    }

    public long quickSort(int[] testArray) {
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
        System.out.println(Arrays.toString(sampleArray));
        long startTime = System.currentTimeMillis();


        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println(Arrays.toString(sampleArray));
        return elapsed;
    }

    private void sortQ() {

    }

    public long mergeSort(int[] testArray) {
        int[] sampleArray = new int[testArray.length];
        System.arraycopy(testArray, 0, sampleArray, 0, testArray.length);
        int len = sampleArray.length;
//        System.out.println("Unsorted: "+Arrays.toString(sampleArray));
        long startTime = System.currentTimeMillis();
        mergeIt(sampleArray, len);
        long elapsed = System.currentTimeMillis() - startTime;
//        System.out.println("Sorted:   "+Arrays.toString(sampleArray));
//        int[] verifyArray = new int[testArray.length];
//        System.arraycopy(testArray, 0, verifyArray, 0, testArray.length);
//        Arrays.sort(verifyArray);
//        System.out.println("J Sorted: "+Arrays.toString(verifyArray));
        return elapsed;
    }

    private void mergeIt(int[] sampleArray, int length) {
        if (length < 2) return;
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = sampleArray[i];
        }

        for (int i = mid; i < length; i++) {
            right[i - mid] = sampleArray[i];
        }

        mergeIt(left, mid);
        mergeIt(right, length - mid);
        merge(sampleArray, left, right);
    }

    private void merge(int[] sampleArray, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, sampleArrayIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                sampleArray[sampleArrayIndex] = left[leftIndex];
                leftIndex++;
                sampleArrayIndex++;
            } else {
                sampleArray[sampleArrayIndex] = right[rightIndex];
                rightIndex++;
                sampleArrayIndex++;
            }
        }

        while (leftIndex < left.length) {
            sampleArray[sampleArrayIndex] = left[leftIndex];
            leftIndex++;
            sampleArrayIndex++;
        }
        while (rightIndex < right.length) {
            sampleArray[sampleArrayIndex] = right[rightIndex];
            rightIndex++;
            sampleArrayIndex++;
        }
    }
}
