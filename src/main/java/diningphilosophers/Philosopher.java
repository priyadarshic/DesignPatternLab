/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package diningphilosophers;

import java.util.Objects;

import static diningphilosophers.DiningPhilosophersProblem.SIZE;

public class Philosopher implements Runnable{

    private Chopstick[] chopsticks;
    private Chopstick left;
    private Chopstick right;
    private Integer philNum;
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RESET = "\u001B[0m";

    public Philosopher(Chopstick[] chopsticks, Integer philNum) {
        this.chopsticks = chopsticks;
        this.philNum = philNum;
    }

    public Integer getName(){
        return philNum;
    }

    private boolean canEat(){
        if(left != null && right != null){
            if(left.isHeldBy() == this && right.isHeldBy() == this)
                return true;
        }
        return false;
    }

    @Override
    public void run() {
        while (true){

            System.out.println("Philosopher " + this.philNum +
                    " is Thinking ... ");
            try {
                Thread.sleep((long) (10000 * Math.random()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                if(chopsticks[philNum].isHeldBy() == null){
                    left = chopsticks[philNum].grabStick(this);
                }
                if(Objects.nonNull(chopsticks[(philNum + 1) % SIZE].isHeldBy()))
                {
                    if(chopsticks[(philNum + 1) % SIZE].isHeldBy() != this && left != null)
                        left.releaseStick(this);


                    // If Right Chopstick is not Available, release Left one as well
                    // NON GREEDY approach
                }



                if(chopsticks[(philNum + 1) % SIZE].isHeldBy() == null)
                    right = chopsticks[(philNum + 1) % SIZE].grabStick(this);

                if(Objects.nonNull(chopsticks[philNum].isHeldBy()))
                {
                    if(chopsticks[philNum].isHeldBy() != this && right != null)
                        right.releaseStick(this);


                    // If Left Chopstick is not Available, release Right one as well
                }

                if(canEat()){
                    System.out.println(TEXT_GREEN + "Philosopher " + this.philNum +
                            " is Eating ... " + TEXT_RESET);
                    Thread.sleep(1000);
                    left.releaseStick(this);
                    right.releaseStick(this);
                    left = null;
                    right = null;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
