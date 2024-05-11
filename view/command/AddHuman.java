package view.command;

import view.Console;

public class AddHuman extends Command{
     
    public AddHuman(Console console){
        super("Добавить человека", console);
    }

    public void execute(){
        console.addHuman();
    }
}