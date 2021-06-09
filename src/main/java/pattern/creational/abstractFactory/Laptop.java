package pattern.creational.abstractFactory;

public class Laptop implements IComputer {

    private ComputerType computerType = ComputerType.LAPTOP;
    private String brand = null;
    private String RAM = "6GB";
    private String HDD = "500GB";
    private boolean power = false;

    public Laptop(String brand){
        this.brand = brand;
    }

    @Override
    public void showConfig() {

        System.out.println("\nType: " + computerType );
        System.out.println("Brand: " + brand );
        System.out.println("RAM: " + RAM );
        System.out.println("HDD: " + HDD );

    }

    @Override
    public void shutDown() {
        System.out.println("Shutting Down... " );
        power = false;
    }

    @Override
    public void powerOn() {
        System.out.println("System Booting Up..." );

    }

    @Override
    public void restart() {
        System.out.println("Restarting..." );
        shutDown();
        powerOn();
    }

    @Override
    public ComputerType getType() {
        return computerType;
    }
}
