package shah.loginappbackend.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
}