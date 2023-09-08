public interface Searchable {
    public final String SEPERATOR = "-";

    // Variante Teil 1
    // public String getSearchString();

    // Variante Teil 4
    default String getSearchString() {
        return this.toString();
    }
}