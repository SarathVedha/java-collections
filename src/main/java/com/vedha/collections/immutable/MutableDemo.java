package com.vedha.collections.immutable;

public class MutableDemo {

    static class StudentMutable {

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "StudentMutable{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        StudentMutable studentMutable = new StudentMutable();
        studentMutable.setId(1);
        studentMutable.setName("John");
        System.out.println(studentMutable);

        // Modifying the object
        studentMutable.setId(2);
        studentMutable.setName("Doe");
        System.out.println(studentMutable);
    }
}
