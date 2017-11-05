package src.edu.grinnell.sortingvisualizer.sortevents;

import java.util.List;
import java.util.ArrayList;

public class SwapEvent<T> implements SortEvent<T>{
    private int i;
    private int j;

    /**
     * Constructor
     * @param i Index for swapped element
     * @param j Index for swapped element
     */
    public SwapEvent(int i, int j){
        this.i = i;
        this.j = j;
    }

    /**
     * Apply the swap method onto the given array
     * @param arr the array in which two elements are to be swapped
     */
    @SuppressWarnings("unchecked")
    public void apply(Object[] arr){
        T temp = (T) arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * returns the affected indices of the event
     * @return the list of affected indices
     */
    public List<Integer> affectedIndices(){
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(i);
        ret.add(j);
        return ret;
    }
    
    /**
     * Check if this event is emphasized
     */
    public boolean isEmphasized(){
        return true;
    }

}
