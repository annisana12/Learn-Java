package todolist.view;

import todolist.service.TodoListService;
import todolist.util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            System.out.println("Todo List");
            todoListService.showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("Menambah Todo list");
        var todo = InputUtil.input("Todo (x jika batal)");

        if (todo.equals("x")) {
            // Batal
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("Menghapus Todo List");

        var nomor = InputUtil.input("Nomor yang dihapus (x jika batal)");

        if (nomor.equals("x")) {
            // Batal
        } else {
            todoListService.removeTodoList(Integer.valueOf(nomor));
        }
    }
}
