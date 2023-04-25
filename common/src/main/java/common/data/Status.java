package worker;


import java.io.Serializable;

public enum Status implements Serializable {

    FIRED ("уволен"),
    HIRED ("нанят"),
    RECOMMENDED_FOR_PROMOTION("рекомендован к повышению"),
    REGULAR("штатный"),
    PROBATION("на испытательном сроке");

    String description;

    Status (String description){
        this.description =description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public static Status fromString(String name){
        for (Status statushere : Status.values()) {
            if (statushere.getDescription().equals(name)) {
                return statushere;
            }
        }
        return null;
    }
}

