package src.edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /** Clears the panel and redraws the current configuration of the list */
    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        int l = notes.indices.length;
        int rectWidth = this.getWidth() / l;
        for (int i = 0; i < l; i++){
            g.setColor(new Color(0, 255 - (notes.indices[i] * 255) / l, (notes.indices[i] * 255) / l));
            g.fillRect(i * rectWidth, this.getHeight() - ((notes.indices[i] + 1)* this.getHeight()) /l, rectWidth, ((notes.indices[i] + 1)* this.getHeight()) /l);
        }
    }
    

}