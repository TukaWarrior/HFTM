package S24_Collections;

public class CellCollection {

    private Cell[] cells = new Cell[10];
    private int index;

    public void add(Cell c){
        cells[index]=c;
        index++;
    }

    public Cell get(int i){
        return cells[i];
    }

}
