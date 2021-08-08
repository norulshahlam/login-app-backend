package shah.loginappbackend.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shah.loginappbackend.model.User;
import shah.loginappbackend.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		System.out.println("userdetailsimpl: "+username+", user: "+user);
		
		if(user==null) {
			
			throw new UsernameNotFoundException("User not found for username: "+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getRoles());

	}
}
