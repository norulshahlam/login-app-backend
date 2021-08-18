package shah.loginappbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shah.loginappbackend.model.Response;
import shah.loginappbackend.repository.UserRepo;
import shah.loginappbackend.security.UserDetailsServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class UserController {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	UserRepo userRepo;

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> currentUserName() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println("userDetails controller---" + username);
		String name = userRepo.findByUsername(username).getName();
		Response response = new Response();
		response.setName(name);
		response.setPrincipal(principal);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("login")
	public ResponseEntity<?> login() {
		System.out.println("get login");
		return new ResponseEntity<Object>("Please login", HttpStatus.OK);
	}
}
