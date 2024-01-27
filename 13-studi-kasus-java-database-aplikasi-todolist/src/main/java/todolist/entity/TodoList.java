package todolist.entity; // data

public class TodoList {

    private Integer id;

    private String todo;

    private Integer status_id;

    public TodoList() {

    }

    public TodoList(String todo) {
        this.todo = todo;
    }

    public TodoList(Integer id, String todo, Integer status_id) {
        this.id = id;
        this.todo = todo;
        this.status_id = status_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", todo='" + todo + '\'' +
                ", status_id=" + status_id +
                '}';
    }
}
