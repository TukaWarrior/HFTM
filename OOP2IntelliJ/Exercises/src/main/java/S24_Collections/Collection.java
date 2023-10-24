package S24_Collections;

public class Collection {

    public static void main(String[] args) {

        Cell cell1 = new Cell("Test1");
        Cell cell2 = new Cell("Test1");
        Cell cell3 = new Cell("Test1");

        Cell[] cells = new Cell[3];
        cells[0] = new Cell("Test1");
        cells[1] = new Cell("Test2");
        cells[2] = new Cell("Test3");


        // You can access and modify the values of the cells like this:
        System.out.println("Cell 1: " + cells[0].getCell());
        System.out.println("Cell 2: " + cells[1].getCell());
        System.out.println("Cell 3: " + cells[2].getCell());
    }
}