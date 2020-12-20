package com.example.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl() {

	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(user);

		return user;
	}

	@Override
	@Transactional
	@SuppressWarnings({"deprecation","unchecked"})
	public String checkLogin(User user) {
		String ss = "";
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria cr = currentSession.createCriteria(User.class);
		cr.add(Restrictions.eq("email", user.getEmail()).ignoreCase());
		cr.add(Restrictions.eq("password", user.getPassword()));
		List<User> listUser = cr.list();
		if (listUser.size() == 1) {
			ss = "success";
		} else {
			ss = "fail";
		}
		return ss;
	}

}
