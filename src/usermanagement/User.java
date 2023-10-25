package usermanagement;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int phoneNum;
    
    public User(int ID, String FirstName, String LastName, int PhoneNum)
    {
        this.id = ID;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.phoneNum = PhoneNum;
    }
    
    public int getId() 
    {
        return id;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }
    
    public int getPhoneNum() 
    {
        return phoneNum;
    }
    
}
