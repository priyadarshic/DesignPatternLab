package pattern.creational.abstractFactory;

public class CreateFactory{

    public static AbstractFactory getFactory(String brand){

        switch (brand){

            case "HP":
                return new HPFactory();
            case "Toshiba":
                return new ToshibaFactory();
            default:
                return null;

        }
    }




}
