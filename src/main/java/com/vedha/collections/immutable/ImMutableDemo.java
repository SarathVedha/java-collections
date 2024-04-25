package com.vedha.collections.immutable;

public class ImMutableDemo {

    // class will be in final state and no setter methods
    // final class will not be inherited by any other class and no one can change the state of the object
    static final class StudentImmutable {

        private final int id;
        private final String name;
        private final AddressMutable address;

        public StudentImmutable(int id, String name, AddressMutable address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        // return the copy of the address object
        public AddressMutable getAddress() {
            return new AddressMutable(address);
        }

        @Override
        public String toString() {
            return "StudentImmutable{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", address=" + address +
                    '}';
        }
    }

    static class AddressMutable {

        private String city;
        private String state;

        public AddressMutable(String city, String state) {
            this.city = city;
            this.state = state;
        }

        // copy constructor
        public AddressMutable(AddressMutable address) {

            this(address.getCity(), address.getState());
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "AddressMutable{" +
                    "city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        AddressMutable address = new AddressMutable("Bangalore", "Karnataka");
        StudentImmutable student = new StudentImmutable(1, "Vedha", address);
        System.out.println(student);

        // changing the address of the student
        AddressMutable address1 = student.getAddress();
        address1.setCity("Chennai");
        address1.setState("Tamil Nadu");

        System.out.println(student);

    }
}
