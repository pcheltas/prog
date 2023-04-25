package common.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Scanner;

public class Coordinates implements Serializable {
    private Float x; //Значение поля должно быть больше -862, Поле не может быть null
    private Long y; //Максимальное значение поля: 332, Поле не может быть null


    public Coordinates (@JsonProperty("x")Float x, @JsonProperty("y")Long y){
        this.x = x;
        this.y = y;
    }
    public Coordinates (){}

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

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }
}
