package br.com.ifce.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.ifce.user.User;
import br.com.ifce.user.UserBC;

@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {
	private User user = new User();
	private String confirmPassworld;
	
	public String newUser(){
		this.user = new User();
		this.user.setActive(true);
		return "/public/user";
	}
	
	public String save(){
		FacesContext contex = FacesContext.getCurrentInstance();
		String passworld = this.user.getPassworld();
		if(!passworld.equals(this.confirmPassworld)){
			FacesMessage facesMessage = new FacesMessage("A senha nao foi confirmadda corretamente");
			contex.addMessage(null, facesMessage);
			return null;
		}
		
		UserBC userCB = new UserBC();
		userCB.salvar(this.user);
		return "usersuccess";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getConfirmPassworld() {
		return confirmPassworld;
	}
	public void setConfirmPassworld(String confirmPassworld) {
		this.confirmPassworld = confirmPassworld;
	}
}
