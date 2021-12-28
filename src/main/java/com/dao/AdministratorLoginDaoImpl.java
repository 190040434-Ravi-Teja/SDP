package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Administrator;

@Repository
public class AdministratorLoginDaoImpl implements AdministratorLoginDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	public int checkCredential(Administrator administrator) {

		String HQL_QUERY = "from Administrator as o where o.username=:username and o.password=:password";

		Query query = sessionFactory.openSession().createQuery(HQL_QUERY);
		query.setParameter("username", administrator.getUsername());
		query.setParameter("password", administrator.getPassword());
		@SuppressWarnings("unchecked")
		List<Administrator> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			return 1;
		} else {
			return 0;
		}

	}

}
