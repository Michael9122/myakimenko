package ru.job4j.lsp;

public abstract class Decorator implements Strategy {
    protected Strategy decoratorStrategy;

    public Decorator(Strategy decoratorStrategy) {
        this.decoratorStrategy = decoratorStrategy;
    }

    public boolean execute(Food food) {
        return decoratorStrategy.execute(food);
    }
}
