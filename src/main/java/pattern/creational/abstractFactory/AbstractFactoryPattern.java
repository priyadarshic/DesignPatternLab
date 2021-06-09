package pattern.creational.abstractFactory;

public class AbstractFactoryPattern {

    public static void main(String args[]){

        //CreateFactory createFactory = new CreateFactory();
        AbstractFactory factoryHP = CreateFactory.getFactory("HP");
        AbstractFactory factoryToshiba = CreateFactory.getFactory("Toshiba");

        IComputer desktop = factoryHP.createComputer(ComputerType.DESKTOP);
        IComputer lap = factoryToshiba.createComputer(ComputerType.LAPTOP);
        IComputer lap2 = factoryHP.createComputer(ComputerType.LAPTOP);

        desktop.showConfig();
        lap.showConfig();
        lap2.showConfig();

    }
}
