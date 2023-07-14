package ReaderApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ReaderApp.Exception.InvalidId;
import ReaderApp.Model.User;
import ReaderApp.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping("/create_data")
	public ResponseEntity<User> createData(@RequestBody User user){
		User save = uService.createUser(user);
		return new ResponseEntity<User>(save,HttpStatus.CREATED);
	}
	
	@PutMapping("/update_data/{id}")
	public ResponseEntity<User> updateData(@RequestBody User user, @PathVariable Long id) throws InvalidId{
		User upd = uService.updateUser(user, id);
		return new ResponseEntity<User>(upd,HttpStatus.ACCEPTED);		
	}

}