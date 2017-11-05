package src.edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {
    private int i;
    private int j;
    
    /**
     * Constructor
     * @param i the index of the compared element
     * @param j the index of the compared element
     */
    public CompareEvent(int i, int j){
        this.i = i;
        this.j = j;
    }
    
    /**
     * apply the event to the array, which does nothing
     */
    public void apply(Object[] arr){
        
    }
    
    /**
     * return the affected indices of this event
     */
    public List<Integer> affectedIndices(){
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(i);
        ret.add(j);
        return ret;
    }
    
    /**
     * return if this event is emphasized
     */
    public boolean isEmphasized(){
        return false;
    }
    
}
