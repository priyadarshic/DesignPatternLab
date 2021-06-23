/*
 * Copyright (c) 2021. Copyright belongs to Author @PChaudhuri.
 * Maybe used for Non-commercial purpose only with Credits and link to GitHub repository
 */

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

