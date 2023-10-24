public final class User implements Searchable{
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getSearchString() {
        return "name: " + name;
    }

    @Override
    public String toString(){
        return "Name: " + name;
    }
}