package worker;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Scanner;


public class Organization implements Serializable {
    private String fullName; //Длина строки не должна быть больше 1516, Строка не может быть пустой, Поле не может быть null
    private int annualTurnover; //Значение поля должно быть больше 0
    private int employeesCount; //Значение поля должно быть больше 0


    public Organization (@JsonProperty("fullName") String fullName, @JsonProperty("annualTurnover") int annualTurnover,
                         @JsonProperty("employeesCount") int employeesCount){
        this.fullName = fullName;
        this.annualTurnover = annualTurnover;
        this.employeesCount = employeesCount;
    }
    public Organization (){}


    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public Integer getAnnualTurnover() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        if (fullName.isBlank()){
            this.fullName = null;
        }else {
            //    throw new IllegalArgumentException("Название организации не может быть пустым");
            if (fullName.length() > 1516)
                throw new IllegalArgumentException("Название организации слишком длинное");
            this.fullName = fullName;
        }

    }


 public void setAnnualTurnover(Scanner scan) {
        String  annualTurnover;
        annualTurnover = scan.nextLine();
        if (annualTurnover.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try{
            if (Integer.parseInt(annualTurnover) <= 0)
                throw new IllegalArgumentException("Введенное число должно быть больше 0");
            this.annualTurnover = Integer.parseInt(annualTurnover);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        }catch (IllegalStateException e){
            throw new IllegalArgumentException("Введенное число должно быть больше 0");
        }
        //this.annualTurnover = Integer.parseInt(annualTurnover);
    }

    public void setEmployeesCount(Scanner scan) {
        String employeesCount;
        employeesCount = scan.nextLine();
        if (employeesCount.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try{
            if (Integer.parseInt(employeesCount) <= 0)
                throw new IllegalArgumentException("Введенное число должно быть больше 0");
            this.employeesCount = Integer.parseInt(employeesCount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }

        //this.employeesCount = Integer.parseInt(employeesCount);
    }

    @Override
    public String toString() {
        return  "\n     Название компании: " + getFullName() +
                "\n     Ежегодный оборот: " + getAnnualTurnover() +
                "\n     Количество сотрудников: " + getEmployeesCount();
    }
}
