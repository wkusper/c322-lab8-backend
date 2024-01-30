package edu.iu.habahram.ducksservice.model;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public int[] performFly(int[] positionBefore) {
        return flyBehavior.fly(positionBefore);
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
