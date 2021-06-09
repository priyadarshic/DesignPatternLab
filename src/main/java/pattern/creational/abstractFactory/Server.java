package pattern.creational.abstractFactory;


public class Server implements IComputer {

    private ComputerType computerType = ComputerType.SERVER;
    private String brand = null;
    private String RAM = "16GB";
    private String HDD = "128TB";
    private boolean power = false;

    public Server(String brand){
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

