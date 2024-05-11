package view;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.gender.Gender;
import presenter.Presenter;

public class Console implements View{

    private Scanner scanner;
    private Presenter presenter;
    private boolean flag;
    private Menu menu;
    
    public Console(){
        scanner = new Scanner(System.in);
        presenter = new Presenter();
        menu = new Menu(this);
        flag = true;
    }

    @Override
    public void start() {
    System.out.println("Система запущена");
    while (flag) {
        try {
            System.out.println(menu.printMenu());
            String strIndex = scanner.nextLine();
            int index = Integer.parseInt(strIndex);
            menu.execute(index);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: введенное значение не является числом");
        } catch(IndexOutOfBoundsException e){
            System.err.println("Введите значение 1 или 2");
        }catch (NoSuchElementException e) {
            finish();
            System.err.println("Ошибка ввода: " + e.getMessage());
        }
    }
}

    public void addHuman(){
        System.out.println("Введите информацию о человеке: Фамилия Имя Отчество дата_рождения(дд.мм.гггг) номер_телефона пол");
        String line = scanner.nextLine();
        try{
            String[] info = line.split(" ");
            presenter.addHuman(checkStringType(info[0], "Фамилия"), checkStringType(info[1], "Имя"), checkStringType(info[2], "Отчество"), checkDate(info[3]), checkNumber(info[4]), checkGender(info[5]));
        }catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: недостаточно данных для добавления человека. Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        }catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage() );
        }catch(IOException e){
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public void finish(){
        System.out.println("Завершение работы...");
        flag = false;
    }

    @Override
    public void print(String text){
        System.out.println(text);
    }

    public Gender checkGender(String info){
        Gender gender = null;
            if(info.equals("f")){
                gender = Gender.f;
            }else if(info.equals("m")){
                gender = Gender.m;
            }else{
                throw new IllegalArgumentException("Введите пол человека в правильном формате.");
            }
        return gender;
    }

    public String checkDate(String info){
        String[] date = info.split("\\.");
        if (date.length != 3) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Введите дату в формате дд.мм.гггг");
        }

        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        if(String.valueOf(year).length() < 4){
            throw new IllegalArgumentException("Неверный формат даты рождения. Введите корректный год рождения");
        }
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Введите дату в формате дд.мм.гггг");
        }
        return info;
    }

    public Long checkNumber(String info){
        if (info.length() != 11) {
            throw new IllegalArgumentException("Номер телефона должен состоять из 11 цифр");
        }
        if(info.charAt(0)!='8'){
            throw new IllegalArgumentException("Номер телефона должен начинаться с 8");
        }
        for (int i = 0; i < info.length(); i++) {
            if (!Character.isDigit(info.charAt(i))) {
                throw new IllegalArgumentException("Номер телефона должен состоять из цифр");
            }
        }
        return Long.parseLong(info);
    }

    public String checkStringType(Object obj, String field) {
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(field + "должно(а) состоять из букв");
        }
        String str = (String) obj;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= 'а' && ch <= 'я') || (ch >= 'А' && ch <= 'Я'))) {
                throw new IllegalArgumentException(field + " должно состоять только из букв русского алфавита");
            }
        }
        return str;
    }
}
