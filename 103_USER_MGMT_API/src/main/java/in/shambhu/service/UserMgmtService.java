package in.shambhu.service;

import java.util.List;

import in.shambhu.binding.ActivateAccount;
import in.shambhu.binding.Login;
import in.shambhu.binding.User;

public interface UserMgmtService {

	public boolean saveUser(User user);

	public boolean activateUserAcc(ActivateAccount activeAcc);

	public List<User> getAllUsers();
	
	public User getUserById(Integer userId);

	public boolean deleteUserById(Integer userId);

	public boolean changeAccountStatus(Integer userId, String accStatus);

	public String login(Login login);
	
	public String forgotPwd(String email);
}
