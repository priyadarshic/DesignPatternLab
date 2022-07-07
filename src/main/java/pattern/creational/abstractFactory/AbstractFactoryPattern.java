/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package pattern.creational.abstractFactory;

public class AbstractFactoryPattern {

    public static void main(String args[]){

        AbstractFactory factoryHP = CreateFactory.getFactory("HP");
        AbstractFactory factoryToshiba = CreateFactory.getFactory("Toshiba");

        IComputer desktop = factoryHP.createComputer(ComputerType.DESKTOP);
        IComputer lap1 = factoryToshiba.createComputer(ComputerType.LAPTOP);
        IComputer lap2 = factoryHP.createComputer(ComputerType.LAPTOP);
        IComputer server1 = factoryToshiba.createComputer(ComputerType.SERVER);

        desktop.showConfig();
        desktop.powerOn();
        lap1.showConfig();
        lap2.showConfig();
        server1.showConfig();
        server1.powerOn();

    }
}
