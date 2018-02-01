package models;

import java.util.Objects;

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
    private String profilePic;
    private String email;
    private String phone;

    /* CONSTRUCTORS * * * * * * * * * * */
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

    public User(int loginId, String realName, String gender, String preferredGender, String userTagLine, String age, String location, String sign, String job, String kids, String profilePic, String email, String phone) {
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
        this.profilePic = profilePic;
        this.email = email;
        this.phone = phone;

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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                loginId == user.loginId &&
                Objects.equals(realName, user.realName) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(preferredGender, user.preferredGender) &&
                Objects.equals(userTagLine, user.userTagLine) &&
                Objects.equals(age, user.age) &&
                Objects.equals(location, user.location) &&
                Objects.equals(sign, user.sign) &&
                Objects.equals(job, user.job) &&
                Objects.equals(kids, user.kids) &&
                Objects.equals(profilePic, user.profilePic) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, loginId, realName, gender, preferredGender, userTagLine, age, location, sign, job, kids, profilePic, email, phone);
    }
}

