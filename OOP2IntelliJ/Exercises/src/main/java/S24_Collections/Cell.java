package S24_Collections;

public class Cell {
    private String value;

    public Cell(String value){
        this.value = value;
    }

    public String getCell(){
        return value;
    }

    public void setCell(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cell" + value;
    }
}
