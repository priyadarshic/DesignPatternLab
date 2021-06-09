package pattern.creational.abstractFactory;

public class HPFactory implements AbstractFactory{



    @Override
    public IComputer createComputer(ComputerType type) {

        switch(type){
            case DESKTOP:
                return new Desktop("Hewlett Packard");

            case LAPTOP:
                return new Laptop("Hewlett Packard");

            case SERVER:
                break;
            default:
                return null;
        }
        return null;
    }
}
