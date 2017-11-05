package src.edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class SortTest {

    //Selection Sort Tests
    @Test
    public void testSelectionSort1() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.selectionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testSelectionSort2() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.selectionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testSelectionSort3() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Sorts.selectionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testSelectionSort4() {
        Character[] arr = {'b', 'c', 'e', 'd', 'f', 'a', 'g'};
        Character[] done = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Sorts.selectionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testSelectionSort5() {
        String[] arr = {"Pineapple","Apple", "Orange", "Banana", "Banana"};
        String[] done = {"Apple", "Banana", "Banana", "Orange", "Pineapple"};
        Sorts.selectionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testSelectionSort6() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Integer[] arrCopy = Arrays.copyOf(arr, 6);
        //Sorts.selectionSort(arr);
        Sorts.eventSort(arrCopy, Sorts.selectionSort(arr));
        assertArrayEquals(done,arrCopy);
    }
    
    //Insertion Sort Tests
    @Test
    public void testInsertionSort1() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.insertionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testInsertionSort2() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.insertionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testInsertionSort3() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Sorts.insertionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testInsertionSort4() {
        Character[] arr = {'b', 'c', 'e', 'd', 'f', 'a', 'g'};
        Character[] done = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Sorts.insertionSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testInsertionSort5() {
        String[] arr = {"Pineapple","Apple", "Orange", "Banana", "Banana"};
        String[] done = {"Apple", "Banana", "Banana", "Orange", "Pineapple"};
        Sorts.insertionSort(arr);
        assertArrayEquals(done,arr);
    }
    @Test
    public void testInsertionSort6() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Integer[] arrCopy = Arrays.copyOf(arr, 6);
        //Sorts.selectionSort(arr);
        Sorts.eventSort(arrCopy, Sorts.insertionSort(arr));
        assertArrayEquals(done,arrCopy);
    }
    //Bubble Sort Tests
    @Test
    public void testBubbleSort1() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.bubbleSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testBubbleSort2() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.bubbleSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testBubbleSort3() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Sorts.bubbleSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testBubbleSort4() {
        Character[] arr = {'b', 'c', 'e', 'd', 'f', 'a', 'g'};
        Character[] done = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Sorts.bubbleSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testBubbleSort5() {
        String[] arr = {"Pineapple","Apple", "Orange", "Banana", "Banana"};
        String[] done = {"Apple", "Banana", "Banana", "Orange", "Pineapple"};
        Sorts.bubbleSort(arr);
        assertArrayEquals(done,arr);
    }
    @Test
    public void testBubbleSort6() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Integer[] arrCopy = Arrays.copyOf(arr, 6);
        Sorts.eventSort(arrCopy, Sorts.bubbleSort(arr));
        assertArrayEquals(done,arrCopy);
    }
    //Merge Sort Tests
    @Test
    public void testMergeSort1() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.mergeSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testMergeSort2() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.mergeSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testMergeSort3() {
        Integer[] arr = {6, 2, 4, 1, 3, 7, 7, 0 ,5, 1};
        Integer[] done = {0, 1, 1, 2, 3, 4, 5, 6, 7, 7};
        Sorts.mergeSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testMergeSort4() {
        Character[] arr = {'b', 'c', 'e', 'd', 'f', 'a', 'g'};
        Character[] done = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Sorts.mergeSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testMergeSort5() {
        String[] arr = {"Pineapple","Apple", "Orange", "Banana", "Banana"};
        String[] done = {"Apple", "Banana", "Banana", "Orange", "Pineapple"};
        Sorts.mergeSort(arr);
        assertArrayEquals(done,arr);
    }
    @Test
    public void testMergeSort6() {
        Integer[] arr = {6, 2, 4, 1, 3, 7, 7, 0 ,5, 1};
        Integer[] done = {0, 1, 1, 2, 3, 4, 5, 6, 7, 7};
        Integer[] arrCopy = Arrays.copyOf(arr, 10);
        Sorts.eventSort(arrCopy, Sorts.mergeSort(arr));
        assertArrayEquals(done,arrCopy);
    }
    
    //Quick Sort Tests
    @Test
    public void testQuickSort1() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.quickSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testQuickSort2() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.quickSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testQuickSort3() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Sorts.quickSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testQuickSort4() {
        Character[] arr = {'b', 'c', 'e', 'd', 'f', 'a', 'g'};
        Character[] done = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Sorts.quickSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testQuickSort5() {
        String[] arr = {"Pineapple","Apple", "Orange", "Banana", "Banana"};
        String[] done = {"Apple", "Banana", "Banana", "Orange", "Pineapple"};
        Sorts.quickSort(arr);
        assertArrayEquals(done,arr);
    }
    @Test
    public void testQuickSort6() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Integer[] arrCopy = Arrays.copyOf(arr, 6);
        Sorts.eventSort(arrCopy, Sorts.quickSort(arr));
        assertArrayEquals(done,arrCopy);
    }
    //Odd and Even Sort Tests
    @Test
    public void testOddEvenSort1() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.oddEvenSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testOddEvenSort2() {
        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        Integer[] done = {1, 2, 3, 4, 5, 6, 7};
        Sorts.oddEvenSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testOddEvenSort3() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Sorts.oddEvenSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testOddEvenSort4() {
        Character[] arr = {'b', 'c', 'e', 'd', 'f', 'a', 'g'};
        Character[] done = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        Sorts.oddEvenSort(arr);
        assertArrayEquals(done,arr);
    }
    
    @Test
    public void testOddEvenSort5() {
        String[] arr = {"Pineapple","Apple", "Orange", "Banana", "Banana"};
        String[] done = {"Apple", "Banana", "Banana", "Orange", "Pineapple"};
        Sorts.oddEvenSort(arr);
        assertArrayEquals(done,arr);
    }
    @Test
    public void testOddEvenSort6() {
        Integer[] arr = {6, 2, 4, 1, 3, 7};
        Integer[] done = {1, 2, 3, 4, 6, 7};
        Integer[] arrCopy = Arrays.copyOf(arr, 6);
        Sorts.eventSort(arrCopy, Sorts.oddEvenSort(arr));
        assertArrayEquals(done,arrCopy);
    }
}
