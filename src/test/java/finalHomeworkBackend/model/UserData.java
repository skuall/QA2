package finalHomeworkBackend.model;

public class UserData {

    private String name;
    private String surname;
    private String discountcode;
    private Integer personCount;
    private Integer childrenCount;
    private Integer luggageCount;
    private String nextFlightDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDiscountcode() {
        return discountcode;
    }

    public void setDiscountcode(String discountcode) {
        this.discountcode = discountcode;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public Integer getLuggageCount() {
        return luggageCount;
    }

    public void setLuggageCount(Integer luggageCount) {
        this.luggageCount = luggageCount;
    }

    public String getNextFlightDate() {
        return nextFlightDate;
    }

    public void setNextFlightDate(String nextFlightDate) {
        this.nextFlightDate = nextFlightDate;
    }
}
