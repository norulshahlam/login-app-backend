package shah.loginappbackend.controller;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shah.loginappbackend.model.User;
import shah.loginappbackend.repository.UserRepo;
import shah.loginappbackend.security.LoginRequest;
import shah.loginappbackend.security.MapValidationErrorService;
import shah.loginappbackend.security.UserDetailsServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000/**")
@RequestMapping("/")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	UserRepo userRepo;

	@GetMapping("")
	public String index() {
		return "index page";

	}

	@GetMapping("login")
	public ResponseEntity<?> login() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:3000/login");
		return new ResponseEntity<Object>(headers, HttpStatus.FOUND);

	}

	@GetMapping("welcome")
	public ResponseEntity<?> welcome(Principal principal, ModelMap model) {
		System.out.println("welcome controler");
		StringBuilder role = new StringBuilder();
		List<String> r = new ArrayList<>();

		// GET ROLE
		Authentication authority = SecurityContextHolder.getContext().getAuthentication();
		String username = authority.getName();
		Collection<? extends GrantedAuthority> roles = authority.getAuthorities();
		roles.forEach(i -> role.append(i.getAuthority().substring(5)));
//		roles.forEach(i-> r.add(i.getAuthority()));
		System.out.println(authority.getPrincipal());

		// GET NAME
		String name = userRepo.findByUsername(username).getName();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:3000/welcome");
		headers.add("username", username);
		headers.add("name", name);
		headers.add("role", role.toString());
//		headers.addAll("role", <?> r);
		return new ResponseEntity<Object>(headers, HttpStatus.FOUND);
	}

	@GetMapping("restricted")
	public String restricted() {
		return "restricted page";
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
		
		System.out.println(333333);
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:3000/welcome");
		return new ResponseEntity<Object>(headers, HttpStatus.FOUND);
	}

}
