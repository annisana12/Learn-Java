package belajar_package.data;

public class Company {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Inner Class
    public class Employee {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            // Bisa akses field outer class nya langsung walaupun private
            return Company.this.name;
        }
    }
}
