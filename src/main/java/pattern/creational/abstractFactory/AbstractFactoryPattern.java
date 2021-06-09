package pattern.creational.abstractFactory;

public class AbstractFactoryPattern {

    public static void main(String args[]){

        AbstractFactory factoryHP = CreateFactory.getFactory("HP");
        AbstractFactory factoryToshiba = CreateFactory.getFactory("Toshiba");

        IComputer desktop = factoryHP.createComputer(ComputerType.DESKTOP);
        IComputer lap = factoryToshiba.createComputer(ComputerType.LAPTOP);
        IComputer lap2 = factoryHP.createComputer(ComputerType.LAPTOP);
        IComputer server1 = factoryToshiba.createComputer(ComputerType.SERVER);

        desktop.showConfig();
        desktop.powerOn();
        lap.showConfig();
        lap2.showConfig();
        server1.showConfig();
        server1.powerOn();

    }
}
