package src.edu.grinnell.sortingvisualizer.sorts;
import src.edu.grinnell.sortingvisualizer.sortevents.*;
import java.util.List;
import java.util.ArrayList;

public class Sorts<T>{

    /**
     * Sort the data using selection sort
     * @param arr the array to be sorted
     * @return SortEvent list of all events happened during sorting
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr){
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        int l = arr.length;
        for (int i = 0; i < l; i++){
            int index = i;
            for (int j = i; j < l; j++){
                ret.add((SortEvent<T>) new CompareEvent<T>(j, index));
                if (arr[j].compareTo(arr[index]) < 0){
                    index = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            ret.add((SortEvent<T>) new SwapEvent<T>(i, index));
        }
        return ret;
    }

    /**
     * Sort the data using insertion sort
     * @param arr the array to be sorted
     * @return SortEvent list of all events happened during sorting
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr){
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        int l = arr.length;
        for (int i = 0; i < l; i++){
            int j = i;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0){
                ret.add((SortEvent<T>) new CompareEvent<T>(j, j-1));
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                ret.add((SortEvent<T>) new SwapEvent<T>(j, j-1));
                j--;
            }
            ret.add((SortEvent<T>) new CompareEvent<T>(j, j-1));
        }
        return ret;
    }

    /**
     * Sort the data using bubble sort
     * @param arr the array to be sorted
     * @return SortEvent list of all events happened during sorting
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr){
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        boolean changed = true;
        while (changed){
            changed = false;
            for (int i = 1; i < arr.length; i++){
                ret.add((SortEvent<T>) new CompareEvent<T>(i, i - 1));
                if (arr[i].compareTo(arr[i -1]) < 0){
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    ret.add((SortEvent<T>) new SwapEvent<T>(i, i - 1));
                    changed = true;
                }
            }
        }
        return ret;
    }

    /**
     * Helper for merge sort method and logs all activities
     * @param arr the array to be sorted
     * @param h the index for the first (head) element of the region to be sorted
     * @param m the index for the middle element of the sub-array to be sorted
     * @param t the index for the last (tail) element to the region
     * @param ret the SortEvent list that all events are being saved into
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void mergeSortHelper(T[] arr, int h, int m, int t, List<SortEvent<T>> ret){  
        if (h < t){
            mergeSortHelper(arr, h, (h + m)/2, m, ret);
            mergeSortHelper(arr, m + 1, (m + t + 1)/2, t, ret);
            T[] first =(T[]) new Comparable[m - h + 1];
            T[] second = (T[]) new Comparable[t - m];  
            for (int i = h; i <= m; i++){
                first[i - h] = arr[i];
            }
            for (int i = m + 1; i <= t; i++){
                second[i - m - 1] = arr[i];
            }
            int f = 0, s = 0, a = h;
            while (f < first.length && s < second.length){
                ret.add((SortEvent<T>) new CompareEvent<T>(f, s));
                if (first[f].compareTo(second[s]) < 0){
                    ret.add((SortEvent<T>) new CopyEvent<T>(a, first[f]));
                    arr[a] = first[f];
                    a++;
                    f++;
                }else{
                    ret.add((SortEvent<T>) new CopyEvent<T>(a, second[s]));
                    arr[a] = second[s];
                    a++;
                    s++;
                }
            }
            while(f < first.length){
                ret.add((SortEvent<T>) new CopyEvent<T>(a, first[f]));
                arr[a] = first[f];
                a++;
                f++;
            }
            while(s < second.length){
                ret.add((SortEvent<T>) new CopyEvent<T>(a, second[s]));
                arr[a] = second[s];
                a++;
                s++;
            }
        }
    }

    /**
     * Main function for the merge sort method
     * @param arr the array to be sorted
     * @return the SortEvent list of all events happened during sorting
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr){
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        mergeSortHelper(arr, 0, arr.length/2, arr.length - 1, ret);
        return ret;
    }

    /**
     * Helper function for quick sort's helper, finds the index for the value which all elements are compared with
     * @param arr the array to be sorted
     * @param h the index of the first element of the array
     * @param t the index of the last element of the array
     * @return the index of the median of first, last and the middle element
     */
    private static <T extends Comparable<T>> int findMedian(T[] arr, int h, int t){
        T o1 = arr[h];
        T o2 = arr[t];
        T o3 = arr[(h+t)/2];
        if(o1.compareTo(o2) <= 0 && o2.compareTo(o3) <= 0){
            return t;
        }else if(o1.compareTo(o3) <= 0 && o3.compareTo(o2) <= 0){
            return (h+t)/2;
        }else if(o2.compareTo(o1) <= 0 && o1.compareTo(o3) <= 0){
            return h;
        }else if(o2.compareTo(o3) <= 0 && o3.compareTo(o1) <= 0){
            return (h+t)/2;
        }else if(o3.compareTo(o1) <= 0 && o1.compareTo(o2) <= 0){
            return h;
        }else{
            return t;
        }
    }

    /**
     * Helper for quick sort function
     * @param arr the array to be sorted
     * @param h the index of first element of subarray
     * @param t the index of last element of subarray
     * @param ret the SortEvent list of all activities
     */
    private static <T extends Comparable<T>> void quickSortHelper(T[] arr, int h, int t, List<SortEvent<T>> ret){
        if(h < t){
            int sepIndex = findMedian(arr, h, t);
            ret.add((SortEvent<T>) new SwapEvent<T>(h, sepIndex));
            T value = arr[sepIndex];
            arr[sepIndex] = arr[h];
            arr[h] = value;
            int pointer = h + 1;
            T temp = arr[pointer];
            for (int i = h + 1; i <= t; i++){
                ret.add((SortEvent<T>) new CompareEvent<T>(i, h));
                if(arr[i].compareTo(value) < 0){
                    temp = arr[i];
                    arr[i] = arr[pointer];
                    arr[pointer] = temp;
                    ret.add((SortEvent<T>) new SwapEvent<T>(i, pointer));
                    pointer++;
                }
            }
            pointer--;
            ret.add((SortEvent<T>) new SwapEvent<T>(h, pointer)); 
            temp = arr[pointer];
            arr[pointer] = arr[h];
            arr[h] = temp;
            quickSortHelper(arr, h, pointer - 1, ret);
            quickSortHelper(arr, pointer + 1, t, ret);
        }
    }

    /**
     * Main function for quick sort method
     * @param arr the array to be sorted
     * @return the list of all activities happened during sorting
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr){
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        quickSortHelper(arr, 0, arr.length - 1, ret);
        return ret;
    }

    /**
     * Custom sorting method, odd even sort
     * @param arr the array to be sorted
     * @return the SortEvent list of all events during sorting
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> oddEvenSort(T[] arr){
        List<SortEvent<T>> ret = new ArrayList<SortEvent<T>>();
        boolean changed = true;
        while (changed){
            changed = false;
            for (int i = 1; i < arr.length; i += 2){
                ret.add((SortEvent<T>) new CompareEvent<T>(i, i - 1));
                if (arr[i].compareTo(arr[i -1]) < 0){
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    ret.add((SortEvent<T>) new SwapEvent<T>(i, i - 1));
                    changed = true;
                }
            }
            for (int i = 2; i < arr.length; i += 2){
                ret.add((SortEvent<T>) new CompareEvent<T>(i, i - 1));
                if (arr[i].compareTo(arr[i -1]) < 0){
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    ret.add((SortEvent<T>) new SwapEvent<T>(i, i - 1));
                    changed = true;
                }
            }
        }
        return ret;
    }

    /**
     * Using the given event log to sort the given array
     * @param arr the array to be sorted
     * @param events the list of all events to be applied onto the array to sort it
     */
    public static <T> void eventSort(T[] arr, List<SortEvent<T>> events){
        for (int i = 0; i < events.size(); i++){
            events.get(i).apply(arr);
        }
    }

}
