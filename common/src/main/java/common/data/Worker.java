package worker;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 The Worker class represents a worker. It implements the Comparable interface for sorting workers by name length.
 */
public class Worker implements Comparable<Worker>{
    private static int counter=0;
    private int id;//Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float salary; //Поле не может быть null, Значение поля должно быть больше 0
    private java.time.ZonedDateTime startDate; //Поле не может быть null
    private java.time.LocalDateTime endDate; //Поле может быть null
    private Status status; //Поле не может быть null
    private Organization organization; //Поле может быть null

    private Boolean console = true;

    @JsonCreator
    public Worker(@JsonProperty("id") int id, @JsonProperty("name") String name,
                  @JsonProperty("coordinates")Coordinates coordinates, @JsonProperty("creationDate")Date creationDate,
                  @JsonProperty("salary")Float salary, @JsonProperty("startDate")ZonedDateTime startDate,
                  @JsonProperty("endDate")LocalDateTime endDate, @JsonProperty("status")Status status,
                  @JsonProperty("organization")Organization organization){

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.organization = organization;
    }

    public Worker() {
    }

//    public Worker(String name, Coordinates coordinates, Float salary, Status status){
//        this.id = counter++;
//        setCounter(counter++);
//        this.name = name;
//        this.coordinates = coordinates;
//        this.status = status;
//        this.creationDate = new Date();
//        this.salary = salary;
//    }
//    public Worker(Boolean console, int id, String name, Coordinates coordinates, Float salary,
//                  java.time.ZonedDateTime startDate, java.time.LocalDateTime endDate, Status status, Organization organization){
//        this.id = id;
//        this.name = name;
//        this.coordinates = coordinates;
//        this.status = status;
//        this.creationDate = new Date();
//        this.salary = salary;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.organization = organization;
//    }



    public  int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Float getSalary() {
        return salary;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public Organization getOrganization() {
        return organization;
    }
    public Status getStatus() {
        return status;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public static void setCounter(int counter) {
        Worker.counter = counter;
    }
    /**

     Sets the ID of the worker.
     @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**

     Sets the name of the worker.
     @param name the name to set
     @throws IllegalArgumentException if the name is null or blank
     */
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Введенное имя не может быть пустым");
        this.name = name;
    }
    /**

     Sets the coordinates of the worker's location.
     @param coordinates the coordinates to set
     @throws IllegalArgumentException if the coordinates are null
     */
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null)
            throw new IllegalArgumentException("Координаты не могут быть пустыми");
        this.coordinates = coordinates;
    }

    /**

     Sets the creation date of the worker.
     @param creationDate the creation date to set
     @throws IllegalArgumentException if the creationDate is null
     */
    public void setCreationDate(Date creationDate) {
        if (creationDate == null)
            throw new IllegalArgumentException("Координаты не могут быть пустыми");
        this.creationDate = creationDate;
    }

    /**

     Sets the salary of the worker.
     @param scan a scanner for reading the input
     @throws IllegalArgumentException if the input is blank, not a number, or zero
     */
    public void setSalary(Scanner scan) {
        String salary = null;
        salary = scan.nextLine();
        if (salary.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try{
            if (Float.parseFloat(salary) <= 0.0f)
                throw new IllegalArgumentException("Введенное значение не может быть меньше или равно 0");
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        } catch (IllegalStateException e){
            throw new IllegalArgumentException("Введенное значение не может быть равно 0");
        }
        this.salary = Float.parseFloat(salary);
    }

    /**

     Sets the start date of the worker's employment.
     @param date the date to set in the format "yyyy MM dd"
     @param time the time to set in the format "HH mm"
     */
    public void setStartDate(String date, String time) {
        ZoneId zone = ZoneId.of("Europe/Moscow");
        LocalDate dates = LocalDate.of(Integer.parseInt(date.trim().split(" ")[0]),
                Integer.parseInt(date.trim().split(" ")[1]),
                Integer.parseInt(date.trim().split(" ")[2]));
        LocalTime times = LocalTime.of(Integer.parseInt(time.trim().split(" ")[0]),
                Integer.parseInt(time.trim().split(" ")[1]));
        this.startDate = ZonedDateTime.of(dates, times, zone);
    }

    /**

     Sets the end date of the worker's employment.
     @param date the date to set in the format "yyyy MM dd"
     @param time the time to set in the format "HH mm"
     @throws IllegalArgumentException if the end date is before the start date
     */
    public void setEndDate(String date, String time) {
            LocalDateTime endD = LocalDateTime.of(Integer.parseInt(date.trim().split(" ")[0]),
                    Integer.parseInt(date.trim().split(" ")[1]),
                    Integer.parseInt(date.trim().split(" ")[2]),
                    Integer.parseInt(time.trim().split(" ")[0]),
                    Integer.parseInt(time.trim().split(" ")[0]));
            if (endD.compareTo(startDate.toLocalDateTime()) <= 0)
                throw new IllegalArgumentException("Дата окончания работы в компании должна быть не раньше " +
                        "даты принятия на работу");
            this.endDate = endD;
    }
    /**

     Gives the date of the worker.
     @param date the date in format "yyyy MM dd"
     @return the formatted date string
     @throws IllegalArgumentException if the date is blank or does not match the expected format
     */
    public String setDate(String date) {
        String regex = "^\\d{4}\\s(0[1-9]|1[0-2])\\s(0[1-9]|[12]\\d|3[01])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        if (date.isBlank()){
            return null;
        }
        if (date!=null & !matcher.matches()) throw new IllegalArgumentException("Введенная дата не соответствует формату");
        return date;
    }

    /**

     Gives the time of the worker.
     @param time the time in format "hh mm"
     @return the formatted time string
     @throws IllegalArgumentException if the time does not match the expected format
     */
    public String setTime(String time) {
        String regex1 = "^([01]\\d|2[0-3])\\s[0-5]\\d$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(time);
        if (!matcher1.matches()) throw new IllegalArgumentException("Введенное время не соотвествует формату");
        return time;
    }

    /**

     Sets the status of the worker based on a string input and a list of allowed status values.
     @param status the string input for the status
     @param arrayList the list of allowed status values
     @throws IllegalArgumentException if the status is blank or not in the allowed status values list
     */
    public void setStatus(String status, ArrayList arrayList) {
            if (status.isBlank())
                throw new IllegalArgumentException("Введенный статус не может быть пустым");
            if (!arrayList.contains(status)) throw new IllegalArgumentException("Такого статуса не существует");
            this.status = Status.fromString(status);
            }

    /**

     Sets the organization of the worker.
     @param organization the organization object to set for the worker
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    /**

     Returns a string representation of the worker object.
     @return the string representation of the worker object
     */
    @Override
    public String toString(){
        if (organization == null) {
            return
                    "\nID: " + getId() +
                            "\nNAME: " + getName() +
                            "\nCOORDINATES: " + coordinates.toString() +
                            "\nCREATIONDATE: " + getCreationDate() +
                            "\nSALARY: " + getSalary() +
                            "\nSTARTDATE: " + getStartDate() +
                            "\nENDDATE: " + getEndDate() +
                            "\nSTATUS: " + getStatus().getDescription();
        }else{
            return
                "\nID: " + getId() +
                        "\nNAME: " + getName() +
                        "\nCOORDINATES: " + coordinates.toString() +
                        "\nCREATIONDATE: " + getCreationDate() +
                        "\nSALARY: " + getSalary() +
                        "\nSTARTDATE: " + getStartDate() +
                        "\nENDDATE: " + getEndDate() +
                        "\nORGANIZATION: " + organization.toString() +
                        "\nSTATUS: " + getStatus().getDescription();

        }

    }

    @Override
    public int compareTo(Worker o) {
        return this.name.length()-o.getName().length();
    }
}
