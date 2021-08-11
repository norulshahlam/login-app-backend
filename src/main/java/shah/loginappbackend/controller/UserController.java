package shah.loginappbackend.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import shah.loginappbackend.model.User;
import shah.loginappbackend.repository.UserRepo;
import shah.loginappbackend.security.LoginRequest;
import shah.loginappbackend.security.MapValidationErrorService;
import shah.loginappbackend.security.UserDetailsServiceImpl;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/")
public class UserController {
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	UserRepo userRepo;

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
		System.out.println("userDetails controller---"+username);
		String name = userRepo.findByUsername(username).getName();
		Response response = new Response();
		response.setName(name);
		response.setPrincipal(principal);
		System.out.println(principal);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}

	@GetMapping("login")	// 
	public ResponseEntity<?> login() {
		System.out.println("get login");
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@PostMapping("login")
	@ResponseBody
	public ResponseEntity<?> loginaction( @RequestParam Map<String, String> body ) {
String username1 = body.get("username");
	    final UserDetails userDetails = userDetailsService.loadUserByUsername(username1);
	    System.out.println(1);
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println("userDetails controller---"+principal);
//		String name = userRepo.findByUsername(username).getName();
		Response response = new Response();
//		response.setName(name);
		response.setPrincipal(principal);
		System.out.println("principal "+principal);
		
	    System.out.println(1);
	    return new ResponseEntity<Object>(userDetails, HttpStatus.OK);
	}
}
