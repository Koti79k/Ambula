package ReaderApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ReaderApp.Exception.InvalidId;
import ReaderApp.Model.User;
import ReaderApp.Repositery.UserRepo;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepo uRepo;

	@Override
	public User createUser(User user) {
		User add = uRepo.save(user);
		return add;
	}

	@Override
	public User updateUser(User user, Long id) throws InvalidId {

		// finding use Id by using userRepo
		Optional<User> u1 = uRepo.findById(id);

		// Instance of a User class
		User u2 = new User();

		// If user present we can update his details
		if (u1.isPresent()) {
			u2.setName(user.getName());
			u2.setLatitude(user.getLatitude());
			u2.setLongitude(user.getLongitude());

			uRepo.save(u2);
			return u2;
		}

		// If user not present it's throwing InvalidId Exception
		else {
			throw new InvalidId("User with Id " + id + " does not exist");
		}
	}

}
