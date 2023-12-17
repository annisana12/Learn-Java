package application;

import java.util.Objects;

public class ObjectsApp {
    public static class Data {
        private String data;

        public Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "data='" + data + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data1 = (Data) o;

            return Objects.equals(data, data1.data);
        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }
    }

    public static void main(String[] args) {
        execute(new Data("Test"));
        execute(null); // nggak error
    }

    public static void execute(Data data) {
//        System.out.println(data.toString()); // Error jika data null
        System.out.println(Objects.toString(data));
        System.out.println(Objects.hashCode(data));
    }
}
