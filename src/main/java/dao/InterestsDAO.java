package dao;

import models.Interests;

import java.util.List;

public interface InterestsDAO {

    //create
    void add(Interests interests);

    //read
    Interests findInterestsById(int id);
    List<Interests> getAll();
    //update
    void update(int id, String Interests);

    //delete
    void deleteInterestById(int id);
    void deleteAll();

}
