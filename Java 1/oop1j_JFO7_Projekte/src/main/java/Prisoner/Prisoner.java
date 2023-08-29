package Prisoner;

public class Prisoner {
    
    // Fields
    private String name;
    private double height;
    private int sentence;
    private Cell cell;

    // public static final int DEFAULT_SENTENCE = 1;

    // Constructor
    public Prisoner(String name, double height, int sentence, Cell cell) {
        this.name = name;
        this.height = height;
        this.sentence = sentence;
        this.cell = cell;
    }

    public Prisoner() {
        this(null, 0, 1, null);
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getSentence() {
        return sentence;
    }

    public Cell getCell() {
        return cell;
    }

    // Methods
    public void think() {
        System.out.println("I'll have my revenge.");
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Height: " + height);
        System.out.println("Sentence: " + sentence);
        if (this.cell == null) {
            System.out.println("Keine Zelle!");
        } else {
            System.out.println("Zelle: " + cell.getName() + (this.cell.isOpen() ? " (TÜR OFFEN!)" : " (Tür zu)"));
        }
    }

    public void display(boolean doThinking) {
        this.display();

        if (doThinking) {
            this.think();
        }
    }
}