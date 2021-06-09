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
    public boolean shutDown() {
        System.out.println("Shutting Down... " );
        power = false;
        return this.power;
    }

    @Override
    public boolean powerOn() {
        System.out.println("System Booting Up..." );
        power = true;
        return this.power;
    }

    @Override
    public boolean restart() {
        System.out.println("Restarting..." );
        shutDown();
        powerOn();
        return this.power;
    }

    @Override
    public ComputerType getType() {
        return computerType;
    }
}
