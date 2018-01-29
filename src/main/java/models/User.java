package models;

public class User {

    //LOGIN
    private int id;
    private int loginId;
    private String realName;
    private String gender;
    private String userTagLine;

    /* CONSTRUCTORS * * * * * * * * * * */
    public User(int loginId, String realName, String gender, String userTagLine) {
        this.loginId = loginId;
        this.realName = realName;
        this.gender = gender;
        this.userTagLine = userTagLine;
    }

    /* GETTERS & SETTERS * * * * * * * * * * */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserTagLine() {
        return userTagLine;
    }

    public void setUserTagLine(String userTagLine) {
        this.userTagLine = userTagLine;
    }

    /* EQUALS & HASH CODE * * * * * * * * * * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (loginId != user.loginId) return false;
        if (realName != null ? !realName.equals(user.realName) : user.realName != null) return false;
        if (!gender.equals(user.gender)) return false;
        return userTagLine.equals(user.userTagLine);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + loginId;
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + gender.hashCode();
        result = 31 * result + userTagLine.hashCode();
        return result;
    }
}
