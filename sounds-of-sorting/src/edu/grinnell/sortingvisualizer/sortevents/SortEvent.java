package src.edu.grinnell.sortingvisualizer.sortevents;

import java.util.List;

public interface SortEvent<T> {
    public void apply(T[] arr);
    public List<Integer> affectedIndices();
    public boolean isEmphasized();
}