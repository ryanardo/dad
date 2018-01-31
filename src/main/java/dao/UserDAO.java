package dao;


import models.User;

import java.util.List;

public interface UserDAO {

    /* CREATE * * * * * * * * * * */
    void add(User user);
    void addLike(int userId, int likedId);

    /* READ * * * * * * * * * * */
    User findById(int id);
    User findUserByLoginId(int loginId);
    List<User> getAll();
    List<User> matchingGender(User user);
    List<Integer> userLikes(User user);
    List<Integer> userLikedBy(User user);
    List<User> getMatchedPairs(User user);



    /* UPDATE * * * * * * * * * * */
    void updateUser(int id, String realName, String gender, String preferredGender, String userTagLine, String age, String location, String sign, String job, String kids);
//

    /* DELETE * * * * * * * * * * */
    void deleteById(int id);

}
