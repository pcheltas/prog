package common.functional;

import common.data.Coordinates;
import common.data.Person;
import common.data.Position;
import common.data.Status;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class WorkerPacket implements Serializable {
    private String name;
    private Coordinates coordinates;

    private java.util.Date creationDate;
    private Float salary;
    private java.time.ZonedDateTime startDate;
    private java.time.LocalDateTime endDate;
    private Status status;
    private Organization organization;


    public WorkerPacket(String name, Coordinates coordinates, java.util.Date creationDate, Float salary,
                        java.time.ZonedDateTime startDate, java.time.LocalDateTime endDate,
                        Status status, Organization organization) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
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

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Status getStatus() {
        return status;
    }

    public Organization getOrganization() {
        return organization;
    }
}
