public class KonversiNumber {
    public static void main(String[] args) {
        byte iniByte = 10;
        short iniShort = iniByte;
        int iniInt = iniShort;

        short iniShort2 = (short) iniInt;
        byte iniByte2 = (byte) iniShort2;

        int iniInt2 = 1000;
        byte iniByte3 = (byte) iniInt2;
        System.out.println(iniByte3); // -24
    }
}
