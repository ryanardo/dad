package models;

/**
 * Created by Guest on 1/29/18.
 */
public class Interests {

    private int id;
    private String interests;

    public Interests(String interests) {
        this.interests = interests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interests interests1 = (Interests) o;

        if (id != interests1.id) return false;
        return interests.equals(interests1.interests);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + interests.hashCode();
        return result;
    }
}
