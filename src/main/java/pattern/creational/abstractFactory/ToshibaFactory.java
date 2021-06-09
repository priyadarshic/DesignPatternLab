/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package pattern.creational.abstractFactory;

public class ToshibaFactory implements AbstractFactory{

    @Override
    public IComputer createComputer(ComputerType type) {

        switch(type){
            case DESKTOP:
                return new Desktop("Toshiba");

            case LAPTOP:
                return new Laptop("Toshiba");

            case SERVER:
                return new Server("Toshiba");

            default:
                return null;
        }
    }
}
