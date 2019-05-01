package ru.job4j.srp;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @version 1
 * @since 01.05.2019
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return input.ask(question);
    }

    @Override
    public int ask(String question, int[] size) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.valueOf(this.input.ask(question, size));
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return  value;
    }
}
