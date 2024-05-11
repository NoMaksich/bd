package model.human;

import model.gender.Gender;

public class Human{
    private String name;
    private String surname;
    private String patronymic;
    private String dob;
    private long number;
    private Gender gender;

    public Human(String surname, String name, String patronymic, String dob, long number, Gender gender){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dob = dob;
        this.number = number;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getPatronymic(){
        return patronymic;
    }
    public String getDob(){
        return dob;
    }
    public long getNumber(){
        return number;
    }
    public Gender getGender(){
        return gender;
    }
}