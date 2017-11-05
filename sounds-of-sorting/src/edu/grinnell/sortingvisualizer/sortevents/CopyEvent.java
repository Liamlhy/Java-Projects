package src.edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T>{
    private int i;
    private T value;

    /**
     * Constructor
     * @param i the index that the value is copied into
     * @param value the value being copied
     */
    public CopyEvent(int i, T value){
        this.i = i;
        this.value = value;
    }

    /**
     * apply the copy event
     */
    public void apply(Object[] arr){
        arr[i] = value;
    }
    
    /**
     * return a list of affected indices
     */
    public List<Integer> affectedIndices(){
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(i);
        return ret;
    }
    
    /**
     * return if the event is being emphasized
     */
    public boolean isEmphasized(){
        return true;
    }
}
