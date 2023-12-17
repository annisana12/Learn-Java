package belajar_package.data;

public class Country {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Static inner class
    public static class City {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Tidak bisa akses field / method dari outer classnya jika inner classnya static
//        public String getCountry() {
//            return Country.this.name;
//        }
    }
}
