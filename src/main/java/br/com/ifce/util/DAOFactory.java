package br.com.ifce.util;

import br.com.ifce.user.UserDAO;
import br.com.ifce.user.UserDAOHibernate;

public class DAOFactory {
	public static UserDAO createUserDAO(){
		UserDAOHibernate userDAO = new UserDAOHibernate();
		userDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return userDAO;
	}
}
