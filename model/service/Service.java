package model.service;

import java.io.IOException;

import model.gender.Gender;
import model.human.Human;
import model.saveHuman.HumanSaver;

public class Service{
    private final HumanSaver humanSaver;

    public Service(HumanSaver humanSaver) {
        this.humanSaver = humanSaver;
    }

    public void addHuman(String surname, String name, String patronymic, String dob, long number, Gender gender) throws IOException{
        Human human = new Human(surname, name, patronymic, dob, number, gender);
        try {
            humanSaver.saveHuman(human);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
