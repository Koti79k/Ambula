package ReaderApp.Service;

import java.util.List;

import ReaderApp.Exception.InvalidId;
import ReaderApp.Model.User;

public interface UserService {

	public User createUser(User user);
	
	public User updateUser(User user, Long id)throws InvalidId;
	
	public List<User> getNearestUsersList(int count)throws InvalidId;
}
