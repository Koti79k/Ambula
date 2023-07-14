package ReaderApp.Service;

import java.util.Comparator;
import java.util.List;
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

	@Override
	public List<User> getNearestUsersList(int count) throws InvalidId {
		
	    //finding all users
		List<User> all_users = uRepo.findAll();
		
		//sort users by distance from (0,0)
		all_users.sort(Comparator.comparingDouble(user -> calculated_Distance(user.getLatitude(),user.getLongitude())));
		
		//Return the Requested No.of Users
		int limit = Math.min(count, all_users.size());
		return all_users.subList(0, limit);
	}

	private double calculated_Distance(double latitude, double longitude) {
		double latitude_Of_Origin = 0.0;
		double longitude_Of_Origin = 0.0;
		
		//Calculating distance b/w two points using Haversine formula
		double earthRadius = 6371; //Radius of Earth in Kilometers
		
		//difference of latitude
		double latitude_diff = Math.toRadians(latitude_Of_Origin - latitude);
		
		//difference of longitude
		double longitude_diff = Math.toRadians(longitude_Of_Origin - longitude);
		
		double a = Math.sin(latitude_diff/2) * Math.sin(latitude_diff/2) 
				+ Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude_Of_Origin)) * 
				  Math.sin(longitude_diff / 2) * Math.sin(longitude_diff / 2) ;
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		return earthRadius * c;
	}

}

/*
 * Haversine formula to calculate distance between two 
 * 
 * a = sin²(ΔlatDifference/2) + cos(lat1).cos(lt2).sin²(ΔlonDifference/2)
 * 
 * c = 2.atan2(√a, √(1−a))
 * 
 * d = R.c
 * 
 * ΔlatDifference = lat1 – lat2 (difference of latitude)
 * 
 * ΔlonDifference = lon1 – lon2 (difference of longitude)
 * 
 * R is radius of earth i.e 6371 KM or 3961 miles
 * 
 * and d is the distance computed between two points.
 * 
 */






