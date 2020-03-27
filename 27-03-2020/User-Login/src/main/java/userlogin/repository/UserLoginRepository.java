package userlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import userlogin.model.UserModel;

@Repository
public interface UserLoginRepository extends JpaRepository<UserModel,Long> {

  @Query("SELECT CASE WHEN COUNT(c.mailId) > 0 THEN true ELSE false END FROM UserModel c WHERE c.mailId = :mailId")
  boolean findByEmailId(@Param("mailId") String mailId);

  List<UserModel>findByuserName(String userName);
  

}
