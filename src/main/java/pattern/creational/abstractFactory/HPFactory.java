/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

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
                return new Server("Hewlett Packard");

            default:
                return null;
        }
    }
}
