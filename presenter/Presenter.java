package presenter;

import java.io.IOException;

import model.gender.Gender;
import model.saveHuman.SaveHuman;
import model.service.Service;

public class Presenter {
    private Service service;

    public Presenter(){
        service = new Service(new SaveHuman());
    }

    public void addHuman(String surname, String name, String patronymic, String dob, long number, Gender gender) throws IOException{
        service.addHuman(surname, name, patronymic, dob, number, gender);
    }
}