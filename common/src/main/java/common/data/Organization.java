package worker;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Scanner;

/**

 The Organization class represents an organization, containing information about its full name,

 annual turnover, and number of employees.
 */
public class Organization {
    private String fullName; //Длина строки не должна быть больше 1516, Строка не может быть пустой, Поле не может быть null
    private int annualTurnover; //Значение поля должно быть больше 0
    private int employeesCount; //Значение поля должно быть больше 0

    /**

     Constructs an Organization object with the specified full name, annual turnover, and number of employees.
     @param fullName the full name of the organization
     @param annualTurnover the annual turnover of the organization
     @param employeesCount the number of employees in the organization
     */
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

    /**

     Sets the full name of the organization.
     @param fullName the full name of the organization
     @throws IllegalArgumentException if the full name is empty or null, or has a length greater than 1516
     */
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

    /**

     Sets the annual turnover of the organization.
     @param scan a Scanner object used to read user input
     @throws IllegalArgumentException if the user input is empty, not a number, or less than or equal to 0
     */
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
/**

 Sets the number of employees in the organization.
 @param scan a Scanner object used to read user input
 @throws IllegalArgumentException if the user input is empty, not a number, or less than or equal to 0
 */
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
