package test.com.book.address.model;

/**
 * Created by jamit on 16/07/2017.
 */
public class Customer {
    private String first;
    private String middle;
    private String last;

    public Customer() {
    }

    public Customer(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Customer(String firstName, String middleName, String lastName){
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
    }

    public void setFirstName(String name){
        this.first = name;
    }

    public String getFirstName(){
        return first;
    }

    public void setMiddleName(String name){
        this.middle = name;
    }

    public String getMiddleName(){
        return middle;
    }

    public void setLastName(String name){
        this.last = name;
    }

    public String getLastName(){
        return last;
    }
}
