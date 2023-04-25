
package client.utils;
import common.exceptions.*;
import common.data.*;

import java.io.FileNotFoundException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CommunicationControl {
    public Scanner scanner;
    private boolean loop = true;
    public static boolean flagForScr;


    public CommunicationControl(Scanner scanner) {
        this.scanner = scanner;
        flagForScr = false;
    }

    public void setFileMode() {
        flagForScr = true;
    }


    public void setUserMode() {
        flagForScr = false;
    }



    public static boolean containsOnlyDigitsOrLetters(String str, boolean onlyDigits) {
        if (str.isBlank()) {
            return false;
        }
        String regex = onlyDigits ? "^\\d+$" : "^[a-zA-Z]+$";
        return str.matches(regex);
    }


    public void setUnsetLoop() {
        this.loop = !this.loop;
    }


    public void changeScanner(Scanner scanner) throws FileNotFoundException {
        this.scanner = scanner;
    }


    public String setName() throws InputException {
        String name;
        while (true) {
            try {
                System.out.println("введите имя");
                name = scanner.nextLine().trim();
                if (name.equals("")) throw new EmptyInputException("имя не может быть пустым");
                if (!containsOnlyDigitsOrLetters(name, false)) throw new InputException();
                System.out.println(name);
                flagForScr = true;
                return name;
            } catch (EmptyInputException | InputException e) {
                System.out.println("name is not correct!");
            } finally {
                if ((!loop) && (!flagForScr)) {
                    throw new InputException();

                }
                flagForScr = false;
            }
        }

    }
    public Float setCoodrinateX() throws InputException {
        float coordX;
        String line;
        while (true) {
            try {
                System.out.println("Введите float координату X: ");
                line = scanner.nextLine().trim();
                if (line.isBlank()) throw new EmptyInputException("не может быть пустым");
                coordX = Float.parseFloat(line);
                if (coordX > 862) throw new InputException();
                flagForScr = true;
                return coordX;
            } catch (EmptyInputException e) {
                System.out.println(e.getMessage());
            } catch (InputException e) {
                System.out.println("превышенно значение (max: 862)");
            } catch (NumberFormatException e) {
                System.out.println("должно быть числом а еще и целым !!!");
            } finally {
                if ((!loop) && (!flagForScr)) {
                    throw new InputException();

                }
                flagForScr = false;
            }

        }

    }

    public Long setCoodrinateY() throws InputException {
        long coordY;
        String line;
        while (true) {
            try {
                System.out.println("Введите координату Y: ");
                line = scanner.nextLine().trim();
                if (line.equals("")) throw new EmptyInputException();
                coordY = Long.parseLong(line);
                if (coordY <= 332) throw new InputException();
                flagForScr = true;
                return coordY;
            } catch (EmptyInputException e) {
                System.out.println("некорректные данные, попробуйте еще раз");
            } catch (InputException e) {
                System.out.println("превышенно значение (max: 468)");
            } finally {
                if ((!loop) && (!flagForScr)) {
                    throw new InputException();

                }
                flagForScr = false;
            }

        }

    }
    public Float setSalary() throws InputException {
        String line;
        Float salary;
        while (true) {
            try {
                System.out.println("введите з/п: ");
                line = scanner.nextLine().trim();
                if (line.equals("")) throw new EmptyInputException();
                salary = Float.parseFloat(line);
                if (salary <= 0) throw new InputException();
                flagForScr = true;
                return salary;
            } catch (EmptyInputException e) {
                System.out.println("вы ввели пустое значение!");
            } catch (InputException e) {
                System.out.println("зарплата должна быть больше 0");
            } finally {
                if ((!loop) && (!flagForScr)) {
                    throw new InputException();

                }
                flagForScr = false;
            }

        }

    }

    public ZonedDateTime setStartDate() throws InputException {
        while (true) {
            try {
                System.out.print("Введите дату принятия на работу в формате 'гггг мм дд' " +
                        "(через пробел, без других символов)");
                String date = scanner.nextLine().trim();
                String regex = "^\\d{4}\\s(0[1-9]|1[0-2])\\s(0[1-9]|[12]\\d|3[01])$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(date);
                if (date.isBlank()) throw new EmptyInputException("Введенная дата не " +
                        "соответствует формату");
                if (date!=null & !matcher.matches()) throw new IllegalArgumentException("Введенная дата не " +
                        "соответствует формату");

                System.out.print("Введите время принятия на работу в формате 'чч мм' по московскому времени" +
                        "(через пробел, без других символов)");
                String time = scanner.nextLine().trim();
                String regex1 = "^([01]\\d|2[0-3])\\s[0-5]\\d$";
                Pattern pattern1 = Pattern.compile(regex1);
                Matcher matcher1 = pattern1.matcher(time);
                if (!matcher1.matches()) throw new IllegalArgumentException("Введенное время не соотвествует формату");

                ZoneId zone = ZoneId.of("Europe/Moscow");
                LocalDate dates = LocalDate.of(Integer.parseInt(date.trim().split(" ")[0]),
                        Integer.parseInt(date.trim().split(" ")[1]),
                        Integer.parseInt(date.trim().split(" ")[2]));
                LocalTime times = LocalTime.of(Integer.parseInt(time.trim().split(" ")[0]),
                        Integer.parseInt(time.trim().split(" ")[1]));
                ZonedDateTime startDate = ZonedDateTime.of(dates, times, zone);

                flagForScr = true;
                return startDate;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if ((!loop) && (!flagForScr)) {
                    throw new InputException();

                }
                flagForScr = false;
            }
        }
    }
    public LocalDateTime setEndDate() throws InputException {
        while (true) {
            try {
                System.out.print("Введите дату увольнения в формате 'гггг мм дд' " +
                        "(через пробел, без других символов)");
                String date = scanner.nextLine().trim();
                String regex = "^\\d{4}\\s(0[1-9]|1[0-2])\\s(0[1-9]|[12]\\d|3[01])$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(date);
                if (date.isBlank() || !matcher.matches()) throw new IllegalArgumentException("Введенная дата не соответствует формату");

                System.out.println("Введите время увольнения в формате 'чч мм' по московскому времени" +
                        "(через пробел, без других символов)");
                String time = scanner.nextLine().trim();
                String regex1 = "^([01]\\d|2[0-3])\\s[0-5]\\d$";
                Pattern pattern1 = Pattern.compile(regex1);
                Matcher matcher1 = pattern1.matcher(time);
                if (!matcher1.matches()) throw new IllegalArgumentException("Введенное время не соотвествует формату");

                LocalDateTime endD = LocalDateTime.of(Integer.parseInt(date.trim().split(" ")[0]),
                        Integer.parseInt(date.trim().split(" ")[1]),
                        Integer.parseInt(date.trim().split(" ")[2]),
                        Integer.parseInt(time.trim().split(" ")[0]),
                        Integer.parseInt(time.trim().split(" ")[0]));

                flagForScr = true;
                return endD;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if ((!loop) && (!flagForScr)) {
                    throw new InputException();

                }
                flagForScr = false;
            }
        }
    }


    public Status setStatus() throws InputException {
        try {
            System.out.println("Введите статус (один из предложенных):");
            ArrayList s = new ArrayList();
            for (Status i : Status.values()) {
                s.add(i.getDescription());
                System.out.println(i.getDescription());
            }
            String status = scanner.nextLine().trim();
            if (status.isBlank())
                throw new IllegalArgumentException("Введенный статус не может быть пустым");
            if (!s.contains(status)) throw new IllegalArgumentException("Такого статуса не существует");
            return Status.fromString(status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InputException();
        }
    }






     public Coordinates setCoordinates() throws InputException {
        try {
            Float x;
            long y;
            x = setCoodrinateX();
            y = setCoodrinateY();

            return new Coordinates(x, y);
        } catch (InputException e) {
            throw new InputException();

        }

    }



    public Organization setOrganization() throws InputException {
        Organization org = new Organization();
        String name;
        String line;
        float x;
        long y;
        int z;
        try {
            while (true) {
                while (true) {
                    try {
                        System.out.println("Введите полное название комании");
                        org.setFullName(scanner.nextLine().trim());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Введите ежегодный оборот компании");
                        org.setAnnualTurnover(scanner);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Введите количество работников в компании");
                        org.setEmployeesCount(scanner);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
            return org;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return org;
    }
    public Date setCreationDate(){
        Date creationDate = new Date();
        return creationDate;
    }



    public boolean confirm() {
        if (loop) {
            String line;
            System.out.println("y/n");
            line = scanner.nextLine().trim();
            return line.equals("y");
        } else {
            return true;
        }
    }



    public String setEnotherInfo() {
        String line;
        line = scanner.nextLine().trim();
        return line;
    }
}
