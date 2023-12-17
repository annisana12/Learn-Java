package belajar_package.application;

public class StackTraceApp {
    public static void main(String[] args) {
       try {
           sampleError();
       } catch (RuntimeException exception) {
           // Print ke console errornya apa dan dimana
           exception.printStackTrace();
       }
    }

    public static void sampleError() {
        try {
            String[] names = {
                    "Budi", "Eko", "Joko"
            };

            System.out.println(names[100]);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
