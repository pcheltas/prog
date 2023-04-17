package commands;

import support.Loader;
import worker.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static support.Loader.lineReader;

/**

 The ConsoleCreation class is responsible for creating a new Worker object with user input through the console or from script.
 Its execute() method creates the input and sets the worker object's
 fields accordingly.
 */
public class ConsoleCreation{
        Worker worker = new Worker();
        Coordinates coordinates = new Coordinates();
        Organization org = new Organization();
        Date creationDate = new Date();

    public Worker getWorker() {
        return worker;
    }


    /**
     * Executes the console input creation of the worker object.
     * Prompts the user for input for each of the worker object's fields and sets them accordingly.
     */
        public void execute() {
            if (!Loader.isExecuteWorks()) {
                worker.setCreationDate(creationDate);

                while (worker.getName() == null) {
                    System.out.println("Введите имя работника");
                    try {
                        worker.setName(lineReader.read());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                }
                while (true) {
                    while (true) {
                        try {
                            System.out.println("Введите float координату x ");
                            coordinates.setX(lineReader.getScanner());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    while (true) {
                        System.out.println("Введите float координату y ");
                        try {
                            coordinates.setY(lineReader.getScanner());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    worker.setCoordinates(coordinates);
                    break;
                }
                while (true) {
                    System.out.println("Введите размер зарплаты");
                    try {
                        worker.setSalary(lineReader.getScanner());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                }

                while (true) {
                    String date;
                    String time;
                    while (true) {
                        System.out.println("Введите дату принятия на работу в формате 'гггг мм дд' " +
                                "(через пробел, без других символов)");
                        try {
                            date = worker.setDate(lineReader.read());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    while (true) {
                        System.out.println("Введите время принятия на работу в формате 'чч мм' по московскому времени" +
                                "(через пробел, без других символов)");
                        try {
                            time = worker.setTime(lineReader.read());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    worker.setStartDate(date, time);
                    break;
                }

                while (true) {
                    String date;
                    String time = null;
                    while (true) {
                        System.out.println("Введите дату увольнения в формате 'гггг мм дд' " +
                                "(через пробел, без других символов)");
                        try {
                            date = worker.setDate(lineReader.read());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }if (date==null) {
                        break;
                    }else {
                        while (true) {
                            System.out.println("Введите время увольнения в формате 'чч мм' по московскому времени" +
                                    "(через пробел, без других символов)");
                            try {
                                time = worker.setTime(lineReader.read());
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }

                        }
                    }
                        worker.setEndDate(date, time);
                    break;
                }

                while (true) {
                    if (worker.getEndDate()!=null) {
                        ArrayList s = new ArrayList();
                        for (Status i : Status.values()) {
                            s.add(i.getDescription());}
                        worker.setStatus("уволен", s);
                        break;
                    }else {
                        System.out.println("Введите статус (один из предложенных):");
                        ArrayList s = new ArrayList();
                        for (Status i : Status.values()) {
                            s.add(i.getDescription());
                            System.out.println(i.getDescription());
                        }
                        try {
                            worker.setStatus(lineReader.read(), s);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                }

                while (true) {
                    while (true) {
                        try {
                            System.out.println("Введите полное название комании");
                            org.setFullName(lineReader.read());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }if (org.getFullName() != null) {
                        while (true) {
                            try {
                                System.out.println("Введите ежегодный оборот компании");
                                org.setAnnualTurnover(lineReader.getScanner());
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        while (true) {
                            try {
                                System.out.println("Введите количество работников в компании");
                                org.setEmployeesCount(lineReader.getScanner());
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        worker.setOrganization(org);
                        break;
                    }else{
                        worker.setOrganization(null);
                        break;
                    }
                }
            }else if (Loader.isExecuteWorks()){
                try {
                    String date;
                    String time;
                    worker.setCreationDate(creationDate);
                    worker.setName(lineReader.read());
                    coordinates.setX(lineReader.getScanner());
                    coordinates.setY(lineReader.getScanner());
                    worker.setCoordinates(coordinates);
                    worker.setSalary(lineReader.getScanner());
                    date = worker.setDate(lineReader.read());
                    time = worker.setTime(lineReader.read());
                    worker.setStartDate(date, time);
                    date = worker.setDate(lineReader.read());
                    time = worker.setTime(lineReader.read());
                    worker.setEndDate(date, time);
                    ArrayList s = new ArrayList();
                    for (Status i : Status.values()) {
                        s.add(i.getDescription());
                    }
                    worker.setStatus(lineReader.read(), s);
                    org.setFullName(lineReader.read());
                    if (org.getFullName() != null) {
                        org.setAnnualTurnover(lineReader.getScanner());
                        org.setEmployeesCount(lineReader.getScanner());
                        worker.setOrganization(org);
                    }else{
                        worker.setOrganization(null);
                    }
                }catch (IllegalArgumentException e){
                    lineReader.setScanner(new Scanner(System.in));
                    throw new IllegalArgumentException("Данные в файле не валидны. Измените содержимое файла и поробуйте снова");
                }


        }
    }
}
