package Prisoner;

public class Cell {

    private String name;
    private boolean open;
    private String code;

    public Cell(String name, boolean open, String code) {
        this.name = name;
        this.open = open;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void openDoor(String code) {
        if (this.code.equals(code)) {
            this.open = !this.open;
            return;
        }
        System.out.println("Code is wrong. Cell " + this.name + " can not be opened.");
    }

}
