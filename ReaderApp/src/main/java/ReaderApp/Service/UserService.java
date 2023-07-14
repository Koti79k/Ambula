package ReaderApp.Service;

import ReaderApp.Exception.InvalidId;
import ReaderApp.Model.User;

public interface UserService {

	public User createUser(User user);
	
	public User updateUser(User user, Long id)throws InvalidId;
}
