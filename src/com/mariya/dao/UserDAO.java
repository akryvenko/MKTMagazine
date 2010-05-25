package com.mariya.dao;

import com.mariya.entity.Employer;
import com.mariya.entity.User;

import java.util.List;

public class UserDAO extends BaseDAO {

    private static String USER_SEQUENCE = "user_id_seq";

    public List<User> findAll(){
        return findAll(User.class);
    }

    public User findById(Long id){
        return (User) getEntityById(User.class, id);
    }

    public void save(Employer employer){
        if (employer.getId() == null)
        {
            employer.setId(getNextVal(USER_SEQUENCE));
        }
       saveOrUpdateEntity(employer);
    }

    public void delete(User employer){
        deleteEntity(employer);
    }

    public void deleteById(Long employerId){
        deleteEntityById(User.class, employerId);
    }

}
