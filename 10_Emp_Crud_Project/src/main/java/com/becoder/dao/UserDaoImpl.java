package com.becoder.dao;

import javax.management.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.becoder.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	public int saveUser(User user) {
		
	 return (int) hibernateTemplate.save(user);
	}
	

	@Override
	public User loginUser(String email, String password) {
		// select * from user where email=? and password=? ; ->user object
				String sql = "from User where email=:em and password=:pwd";

				User us = (User) hibernateTemplate.execute(s -> {
					org.hibernate.Query q = (org.hibernate.Query) s.createQuery(sql);
					((org.hibernate.query.Query) q).setString("em", email);
					((org.hibernate.query.Query) q).setString("pwd", password);
					return ((org.hibernate.query.Query) q).uniqueResult();
				});

		return us;
	}

}
