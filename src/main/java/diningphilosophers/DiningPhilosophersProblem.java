/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package diningphilosophers;

public class DiningPhilosophersProblem {

    public static final int SIZE = 10;

    public static void main(String[] args) throws InterruptedException {

        Chopstick[] chopsticks = new Chopstick[SIZE];
        Runnable[] philosophers = new Runnable[SIZE];

        for (int i = 0; i < SIZE; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        for (int i = 0; i < SIZE; i++) {
            philosophers[i] = new Philosopher(chopsticks, i);
            Thread thread = new Thread(philosophers[i]);
            thread.start();
            Thread.sleep(5000);
        }


    }


}
