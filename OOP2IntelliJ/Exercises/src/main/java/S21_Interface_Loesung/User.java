package S21_Interface_Loesung;
public final class User implements Searchable {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}