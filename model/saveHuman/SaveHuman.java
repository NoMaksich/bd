package model.saveHuman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.human.Human;

public class SaveHuman implements HumanSaver {
    @Override
    public void saveHuman(Human human) throws IOException {
        String fileName = human.getSurname() + ".txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true); BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(human.getSurname() + " " + human.getName() + " " + human.getPatronymic() + " " + human.getDob() + " " + human.getNumber() + " " + human.getGender());
            writer.newLine();
        }
    }
}
