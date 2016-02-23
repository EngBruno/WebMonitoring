package br.com.ifce.user;

import java.util.List;

import br.com.ifce.util.DAOFactory;

public class UserBC {
	private UserDAO userDAO;
	public UserBC(){
		this.userDAO = DAOFactory.createUserDAO();
	}
	public User loanding(Integer cody){
		return this.userDAO.loanding(cody);
	}
	
	public User seachForLogin(String login){
		return this.userDAO.seachForLogin(login);
	}
	
	public void salvar(User user){
		Integer cody = user.getCode();
		if( cody==null || cody==0){
		this.userDAO.salvar(user);		
		}else{
			this.userDAO.update(user);
		}
	}
	
	public void delete(User user){
		this.delete(user);
	}
		
	public List<User> list(){
		return this.userDAO.listUser();
	}
}
