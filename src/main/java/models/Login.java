package models;

/**
 * Created by Guest on 1/29/18.
 */
public class Login {
    /* Ryan test Join Statement.
    "SELECT * FROM logins JOIN users ON (users.loginsId = users.id) WHERE logins.id = :id";
     */
    private int id;
    private String userName;
    private String userEmail;
    private String password;
    private String birthday;


    public Login(String userName, String userEmail, String password, String birthday) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.birthday = birthday;
    }

    public Login(String userName, String password, String birthday) {
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login = (Login) o;

        if (id != login.id) return false;
        if (!userName.equals(login.userName)) return false;
        if (!userEmail.equals(login.userEmail)) return false;
        if (!password.equals(login.password)) return false;
        return birthday.equals(login.birthday);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userName.hashCode();
        result = 31 * result + userEmail.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }
}



//    username VARCHAR,
//    email VARCHAR,
//    password VARCHAR,
//    birthday TIMESTAMP NULL DEFAULT NULL