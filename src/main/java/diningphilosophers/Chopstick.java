/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package diningphilosophers;

import java.util.Objects;

public class Chopstick {

    private Philosopher heldBy = null;
    private Integer stickNum;

    public Chopstick(Integer stickNum) {
        this.stickNum = stickNum;
    }

    public Philosopher isHeldBy(){
        return heldBy;
    }

    public Chopstick grabStick(Philosopher philosopher) throws InterruptedException {

        if (Objects.nonNull(heldBy)) {
            synchronized (heldBy) {
                heldBy.wait();
            }
        } else {
            heldBy = philosopher;
            System.out.println("Grabbed chopstick " + stickNum +
                    " by Philosopher " + philosopher.getName());
        }

        return this;
    }

    public void releaseStick(Philosopher philosopher) {
        if (heldBy == philosopher) {
            synchronized (heldBy) {
                heldBy.notifyAll();
                heldBy = null;
                System.out.println("Released chopstick " + stickNum +
                        " by Philosopher" + philosopher.getName());
            }
        }
    }

}
