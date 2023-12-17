package belajar_package.error;

// Penggunaan untuk jika terjadi error maka aplikasi harus dimatikan
public class DatabaseError extends Error {
    public DatabaseError(String message) {
        super(message);
    }
}
