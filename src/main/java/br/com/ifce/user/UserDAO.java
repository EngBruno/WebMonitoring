package br.com.ifce.user;

import java.util.List;

public interface UserDAO {
	public void salvar(User user);
	public void excluir(User user);
	public void update(User user);
	public User loanding(Integer id);
	public User seachForLogin(String login);
	public List<User> listUser();
}
