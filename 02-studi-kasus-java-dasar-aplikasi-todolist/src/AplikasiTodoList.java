import java.util.Scanner;

public class AplikasiTodoList {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    /**
     * Test showTodoList
     */
    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus Java Dasar: Aplikasi Todo List";
        showTodoList();
    }

    /**
     * Menambahkan todo ke list
     */
    public static void addTodoList(String todo){
        // Cek apakah model penuh
        var isFull = true;

        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
            }
        }

        // Jika penuh, maka resize ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Tambahkan ke posisi yang data arraynya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * Test addTodoList
     */
    public static void testAddTodoList() {
        for (var i = 0; i < 25; i++) {
            addTodoList("Todo ke-" + i);
        }

        System.out.println(model.length);
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }

            return true;
        }
    }

    /**
     * Test removeTodoList
     */
    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(6);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * Input data dari user melalui terminal
     * @param info
     * @return data inputted by user
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * Menampilkan view show todo list
     */
    public static void viewShowTodoList(){
        while (true) {
            System.out.println("Todo List");
            showTodoList();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        viewShowTodoList();
    }

    /**
     * Menampilkan view add todo list
     */
    public static void viewAddTodoList(){
        System.out.println("Menambah Todo list");
        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")) {
            // Batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();
        showTodoList();
    }

    /**
     * Menampilkan view remove todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("Menghapus Todo List");

        var nomor = input("Nomor yang dihapus (x jika batal)");

        if (nomor.equals("x")) {
            // Batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(nomor));

            if (!success) {
                System.out.println("Gagal menghapus todo list nomor: " + nomor);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        System.out.println("Todo List :");
        showTodoList();

        viewRemoveTodoList();
        showTodoList();
    }
}
