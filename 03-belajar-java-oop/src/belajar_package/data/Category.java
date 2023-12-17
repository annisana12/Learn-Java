package belajar_package.data;

public class Category {
    private String  id;
    private boolean expensive;

    // Getter
    public String getId() {
        return id;
    }

    // Setter
    public void setId(String id) {
        if (id != null) {
            this.id = id;
        }
    }

    public boolean isExpensive() {
        return expensive;
    }

    public void setExpensive(boolean expensive) {
        this.expensive = expensive;
    }
}
