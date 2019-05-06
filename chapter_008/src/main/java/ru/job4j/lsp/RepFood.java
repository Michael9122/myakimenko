package ru.job4j.lsp;

import java.time.LocalDate;

public class RepFood extends Food {

    private boolean canReproduct;

    private boolean cold;

    public RepFood(String name, LocalDate expiryDate, LocalDate createDate, long price, long discount, boolean canReproduct, boolean cold) {
        super(name, expiryDate, createDate, price, discount);
        this.canReproduct = canReproduct;
        this.cold = cold;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    public boolean isCold() {
        return cold;
    }

    public void setCold(boolean cold) {
        this.cold = cold;
    }
}
