package worker;

/**

 The Status enum represents the possible statuses that an employee can have.
 Each status has a description associated with it.
 */
public enum Status {

    FIRED ("уволен"),
    HIRED ("нанят"),
    RECOMMENDED_FOR_PROMOTION("рекомендован к повышению"),
    REGULAR("штатный"),
    PROBATION("на испытательном сроке");

    String description;
    /**

     Constructs a new status with the given description.
     @param description the description of the status.
     */
    Status (String description){
        this.description =description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**

     Returns the Status enum constant with the specified description.
     @param name the description of the Status constant to be returned.
     @return the Status enum constant with the specified description, or null if no such constant exists.
     */
    public static Status fromString(String name){
        for (Status statushere : Status.values()) {
            if (statushere.getDescription().equals(name)) {
                return statushere;
            }
        }
        return null;
    }
}

