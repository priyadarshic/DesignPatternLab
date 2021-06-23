/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package pattern.creational.abstractFactory;

import junit.framework.TestCase;

public class DesktopTest extends TestCase {

    public void testShowConfig() {
    }

    public void testShutDown() {
        AbstractFactory factoryHP = CreateFactory.getFactory("HP");
        IComputer lap = factoryHP.createComputer(ComputerType.LAPTOP);
        boolean test = lap.shutDown();
        assertEquals(false, test);
    }

    public void testPowerOn() {
        AbstractFactory factoryHP = CreateFactory.getFactory("HP");
        IComputer lap = factoryHP.createComputer(ComputerType.LAPTOP);
        boolean test = lap.powerOn();
        assertEquals(true, test);
    }

    public void testRestart() {
        AbstractFactory factoryHP = CreateFactory.getFactory("HP");
        IComputer lap = factoryHP.createComputer(ComputerType.LAPTOP);
        boolean test = lap.restart();
        assertEquals(true, test);
    }

    public void testGetType() {
        AbstractFactory factoryHP = CreateFactory.getFactory("HP");
        IComputer lap = factoryHP.createComputer(ComputerType.LAPTOP);
        assertEquals(ComputerType.LAPTOP, lap.getType());
    }
}