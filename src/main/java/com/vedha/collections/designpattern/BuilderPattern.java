package com.vedha.collections.designpattern;

class Computer {

    private final String deviceName;

    private final String Ram;

    private final String Rom;

    public Computer(String deviceName, String ram, String rom) {
        this.deviceName = deviceName;
        Ram = ram;
        Rom = rom;
    }

    public static ComputerBuilder builder() {

        return new ComputerBuilder();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "deviceName='" + deviceName + '\'' +
                ", Ram='" + Ram + '\'' +
                ", Rom='" + Rom + '\'' +
                '}';
    }
}

class ComputerBuilder {

    private String deviceName;

    private String ram;

    private String rom;

    public ComputerBuilder deviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public ComputerBuilder ram(String ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder rom(String rom) {
        this.rom = rom;
        return this;
    }

    public Computer build() {

        return new Computer(this.deviceName, this.ram, this.rom);
    }

    @Override
    public String toString() {
        return "ComputerBuilder{" +
                "deviceName='" + deviceName + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                '}';
    }
}

public class BuilderPattern {

    public static void main(String[] args) {

        Computer asus = Computer.builder().deviceName("Asus").ram("16GB").rom("512GB").build();
        System.out.println(asus);
    }
}
