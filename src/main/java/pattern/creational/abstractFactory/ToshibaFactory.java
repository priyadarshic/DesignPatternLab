package pattern.creational.abstractFactory;

public class ToshibaFactory implements AbstractFactory{

    @Override
    public IComputer createComputer(ComputerType type) {

        switch(type){
            case DESKTOP:
                return new Desktop("Toshiba");

            case LAPTOP:
                return new Laptop("Toshiba");

            case SERVER:
                return new Server("Toshiba");

            default:
                return null;
        }
    }
}
