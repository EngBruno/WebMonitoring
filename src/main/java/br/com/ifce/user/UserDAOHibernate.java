package br.com.ifce.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOHibernate implements UserDAO{
	private Session session;
	
	public void setSession(Session session){
		this.session = session;
	}
	
	@Override
	public void salvar(User user) {
		this.session.save(user);
	}

	@Override
	public void excluir(User user) {
		this.session.delete(user);
	}

	@Override
	public void update(User user) {
		this.session.update(user);
	}

	@Override
	public User loanding(Integer id) {
		return (User)this.session.get(User.class, id);
	}

	@Override
	public User seachForLogin(String login) {
		String hql = "select u from User u where u.login = :login";
		Query seach = this.session.createQuery(hql);
		seach.setString("login", login);
		return (User) seach.uniqueResult();
	}
  
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		return this.session.createCriteria(User.class).list();
	}

}
