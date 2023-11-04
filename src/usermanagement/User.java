package usermanagement;

public class User {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String gender;
    private String phonenum;
    private String country;
    private String email;
    private String birthdate;

    public User(int id, String username, String password, String firstname, String lastname, String gender, String phonenum, String country, String email, String birthdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.phonenum = phonenum;
        this.country = country;
        this.email = email;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNum() {
        return phonenum;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
