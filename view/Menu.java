package view;

import java.util.ArrayList;
import java.util.List;

import view.command.Command;
import view.command.Finish;
import view.command.AddHuman;


public class Menu {
    private List<Command> commands;

    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new Finish(console));
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int index){
        Command command = commands.get(index-1);
        command.execute();
    }
}