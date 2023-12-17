public class TipeDataBukanPrimitif {
    public static void main(String[] args) {
        Integer iniInteger = 10;
        Long iniLong = 10L;
        Byte iniByte = null;

        // Konversi tipe data primitif ke non primitif
        int age = 30;
        Integer ageObject = age;
        int ageAgain = ageObject;

        Short shortObject = ageObject.shortValue();
        Long longObject = ageObject.longValue();
        Byte byteObject = ageObject.byteValue();
    }
}
