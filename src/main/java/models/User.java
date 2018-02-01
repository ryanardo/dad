package models;

public class User {

    //LOGIN
    private int id;
    private int loginId;
    private String realName;
    private String gender;
    private String preferredGender;
    private String userTagLine;
    private String age;
    private String location;
    private String sign;
    private String job;
    private String kids;

    /* CONSTRUCTORS * * * * * * * * * * */

    public User(String realName, String gender, String preferredGender) {
        this.realName = realName;
        this.gender = gender;
        this.preferredGender = preferredGender;
    }

    public User(int loginId, String realName, String gender, String userTagLine) {
        this.loginId = loginId;
        this.realName = realName;
        this.gender = gender;
        this.userTagLine = userTagLine;
    }

    public User(int loginId, String realName, String gender, String preferredGender, String userTagLine) {
        this.loginId = loginId;
        this.realName = realName;
        this.gender = gender;
        this.preferredGender = preferredGender;
        this.userTagLine = userTagLine;
    }

    public User(int loginId, String realName, String gender, String preferredGender, String userTagLine, String age, String location, String sign, String job, String kids) {
        this.loginId = loginId;
        this.realName = realName;
        this.gender = gender;
        this.preferredGender = preferredGender;
        this.userTagLine = userTagLine;
        this.age = age;
        this.location = location;
        this.sign = sign;
        this.job = job;
        this.kids = kids;

    }

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

    public String getPreferredGender() {
        return preferredGender;
    }

    public void setPreferredGender(String preferredGender) {
        this.preferredGender = preferredGender;
    }

    public String getUserTagLine() {
        return userTagLine;
    }

    public void setUserTagLine(String userTagLine) {
        this.userTagLine = userTagLine;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getKids() {
        return kids;
    }

    public void setKids(String kids) {
        this.kids = kids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (loginId != user.loginId) return false;
        if (realName != null ? !realName.equals(user.realName) : user.realName != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (preferredGender != null ? !preferredGender.equals(user.preferredGender) : user.preferredGender != null)
            return false;
        if (userTagLine != null ? !userTagLine.equals(user.userTagLine) : user.userTagLine != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (location != null ? !location.equals(user.location) : user.location != null) return false;
        if (sign != null ? !sign.equals(user.sign) : user.sign != null) return false;
        if (job != null ? !job.equals(user.job) : user.job != null) return false;
        return kids != null ? kids.equals(user.kids) : user.kids == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + loginId;
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (preferredGender != null ? preferredGender.hashCode() : 0);
        result = 31 * result + (userTagLine != null ? userTagLine.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (kids != null ? kids.hashCode() : 0);
        return result;
    }
}
