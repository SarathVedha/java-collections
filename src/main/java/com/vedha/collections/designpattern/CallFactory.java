package com.vedha.collections.designpattern;

public class CallFactory {

    public static void main(String[] args) {

        FactoryPatternNew.Computer desktop = FactoryPatternNew.CallFactory.createComputer(new FactoryPatternNew.Desktop("Asus", "16GB", "512GB"));
        System.out.println(desktop.getClass().getSimpleName());
        System.out.println(desktop.print());

        FactoryPatternNew.Computer server = FactoryPatternNew.CallFactory.createComputer(new FactoryPatternNew.Intel("Intel-Xeon", "1TB", "12TB"));
        System.out.println(server.getClass().getSimpleName());
        System.out.println(server.print());
    }
}
