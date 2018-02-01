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
    private String profilePic;

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

    public User(int loginId, String realName, String gender, String preferredGender, String userTagLine, String age, String location, String sign, String job, String kids, String profilePic) {
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (loginId != user.loginId) return false;
        if (!realName.equals(user.realName)) return false;
        if (!gender.equals(user.gender)) return false;
        if (!preferredGender.equals(user.preferredGender)) return false;
        if (!userTagLine.equals(user.userTagLine)) return false;
        if (!age.equals(user.age)) return false;
        if (!location.equals(user.location)) return false;
        if (!sign.equals(user.sign)) return false;
        if (!job.equals(user.job)) return false;
        if (!kids.equals(user.kids)) return false;
        return profilePic.equals(user.profilePic);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + loginId;
        result = 31 * result + realName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + preferredGender.hashCode();
        result = 31 * result + userTagLine.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + sign.hashCode();
        result = 31 * result + job.hashCode();
        result = 31 * result + kids.hashCode();
        result = 31 * result + profilePic.hashCode();
        return result;
    }
}
