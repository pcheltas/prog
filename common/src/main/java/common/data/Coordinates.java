package worker;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Scanner;

/**

 The Coordinates class represents the coordinates of a location in two-dimensional space.

 It contains an x-coordinate and a y-coordinate.
 */
public class Coordinates {
    private Float x; //Значение поля должно быть больше -862, Поле не может быть null
    private Long y; //Максимальное значение поля: 332, Поле не может быть null

    /**

     Creates a new Coordinates object with the specified x and y coordinates.
     @param x the x-coordinate of the location
     @param y the y-coordinate of the location
     */
    public Coordinates (@JsonProperty("x")Float x, @JsonProperty("y")Long y){
        this.x = x;
        this.y = y;
    }
    public Coordinates (){}

    /**

     Sets the x-coordinate of the location.
     @param scan a scanner object to read user input
     @throws IllegalArgumentException if the input is empty, not a number or the number is less than or equal to -862
     */
    public void setX(Scanner scan) {
        String x = null;
        x = scan.nextLine();
        if (x.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try{
            if (Float.parseFloat(x) <= -862)
                throw new IllegalArgumentException();
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Введенное число должно быть больше -862");
        }
        this.x = Float.parseFloat(x);
    }

    /**

     Sets the y-coordinate of the location.
     @param scan a scanner object to read user input
     @throws IllegalArgumentException if the input is empty, not a number or the number is greater than 332
     */
    public void setY(Scanner scan) {
        String y;
        y = scan.nextLine();
        if (y.isBlank()) throw new IllegalArgumentException("Введенные данные не могут быть пустыми");
        try {
            if (Long.parseLong(y) > 332)
                throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введенные данные должны быть числом");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Введенное число должно быть меньше 332");
        }
        this.y = Long.parseLong(y);
    }
    public Float getX() {return x;}

    public Long getY() {return y;}

    /**

     Returns a string representation of the coordinates in the format "x=<x-coordinate>, y=<y-coordinate>".
     @return a string representation of the coordinates
     */
    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }
}
