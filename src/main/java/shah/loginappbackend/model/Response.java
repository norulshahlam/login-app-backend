package shah.loginappbackend.model;

import lombok.Data;

@Data
public class Response {

	private Object principal;
	private String name;

	public Response(Object principal, String d) {
	}

	public Response() {
	}

	@Override
	public String toString() {
		return "Response [principal=" + principal + ", name=" + name + "]";
	}

	public Object getPrincipal() {
		return principal;
	}

	public void setPrincipal(Object principal) {
		this.principal = principal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
