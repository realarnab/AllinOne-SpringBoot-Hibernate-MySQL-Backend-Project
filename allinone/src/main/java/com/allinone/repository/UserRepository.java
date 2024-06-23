package com.allinone.repository;

import com.allinone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Modifying
    @Query("UPDATE User u SET u.name= :name, u.email= :email WHERE u.id= :id")
    int update(@Param("id") long id,@Param("name") String name,@Param("email") String email);
}
