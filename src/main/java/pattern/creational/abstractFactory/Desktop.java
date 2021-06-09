/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package pattern.creational.abstractFactory;

public class Desktop implements IComputer {

    private ComputerType computerType = ComputerType.DESKTOP;
    private String brand = null;
    private String RAM = "4GB";
    private String HDD = "1TB";
    private boolean power = false;

    public Desktop(String brand){
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
