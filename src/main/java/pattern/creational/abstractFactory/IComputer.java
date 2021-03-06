/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package pattern.creational.abstractFactory;

public interface IComputer
{
    public void showConfig();
    public boolean shutDown();
    public boolean powerOn();
    public boolean restart();
    public ComputerType getType();

}
