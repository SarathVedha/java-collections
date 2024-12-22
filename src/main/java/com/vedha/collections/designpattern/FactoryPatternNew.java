package com.vedha.collections.designpattern;

public class FactoryPatternNew {

    interface ComputerFactory {

        Computer initComputer();

        default Computer getComputer() {

            return initComputer();
        }
    }

    interface Computer {

        String deviceName();

        String ram();

        String rom();

        default String print() {

            return "Device: ".concat(deviceName()).concat(", RAM: ").concat(ram()).concat(", ROM: ").concat(rom());
        }
    }

    static class CallFactory {

        public static Computer createComputer(ComputerFactory computerFactory) {

            return computerFactory.getComputer();
        }
    }

    static class Desktop implements ComputerFactory {

        private final String deviceName;

        private final String ram;

        private final String rom;

        public Desktop(String deviceName, String ram, String rom) {
            this.deviceName = deviceName;
            this.ram = ram;
            this.rom = rom;
        }

        @Override
        public Computer initComputer() {
            return new PC(deviceName, ram, rom);
        }
    }

    static class Intel implements ComputerFactory {

        private final String deviceName;

        private final String ram;

        private final String rom;

        public Intel(String deviceName, String ram, String rom) {
            this.deviceName = deviceName;
            this.ram = ram;
            this.rom = rom;
        }

        @Override
        public Computer initComputer() {
            return new Server(deviceName, ram, rom);
        }
    }

    record PC(String deviceName, String ram, String rom) implements Computer {

    }

    static class Server implements Computer {

        private final String deviceName;

        private final String ram;

        private final String rom;

        public Server(String deviceName, String ram, String rom) {
            this.deviceName = deviceName;
            this.ram = ram;
            this.rom = rom;
        }

        @Override
        public String deviceName() {
            return this.deviceName;
        }

        @Override
        public String ram() {
            return this.ram;
        }

        @Override
        public String rom() {
            return this.rom;
        }
    }
}
