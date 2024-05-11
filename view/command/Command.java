package view.command;

import view.Console;

public abstract class Command {
    private String description;
    protected Console console;

    public Command(String description ,Console console) {
        this.console = console;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}