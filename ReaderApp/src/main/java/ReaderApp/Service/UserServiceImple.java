package ReaderApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ReaderApp.Exception.InvalidId;
import ReaderApp.Model.User;
import ReaderApp.Repositery.UserRepo;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepo uRepo;

	@Override
	public User createUser(User user) {
		User add = uRepo.save(user);
		return add;
	}

	@Override
	public User updateUser(User user, Long id)throws InvalidId {
		Optional<User> u1 = uRepo.findById(id);
		User u2 = new User();

		if(u1.isPresent()) {
			u2.setName(user.getName());
			u2.setLatitude(user.getLatitude());
			u2.setLongitude(user.getLongitude());
			
			uRepo.save(u2);
			return u2;
		}
		else {
			throw new InvalidId("User with Id "+id+" does not exist");
		}
	}

}
