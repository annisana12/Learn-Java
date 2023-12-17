package belajar_package.data;

/**
 * Belajar Java record class
 * getter, constructor, equals, hashCode, toString akan otomatis terbuat
 * paremeter otomatis jadi field dan di set final
 * Tidak bisa extends class lain
 * Bisa implements interface
 */
public record LoginRequest(String username, String password) {
    /**
     * Compact constructor
     * Terpanggil saat object dibuat
     */
    public LoginRequest {
        System.out.println("Membuat object LoginRequest");
    }

    /**
     * Constructor overloading
     * Wajib manggil default constructor-nya
     */
    public LoginRequest(String username) {
        this(username, null);
    }

    public LoginRequest() {
        this(null, null);
    }

    // Method di Java record
    public void sayHello(String name) {
        System.out.println("Hello " + name + ", my name is " + username);
    }
}
