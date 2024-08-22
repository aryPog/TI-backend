public class X {
    private int id;
    private String name;

    public X(String name) {
        this.name = name;
    }

    public X(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "X [id=" + id + ", name=" + name + "]";
    }
}
