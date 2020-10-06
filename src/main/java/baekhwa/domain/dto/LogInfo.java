package baekhwa.domain.dto;

import baekhwa.domain.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LogInfo {
	
	private String email;
	private String name;
	
	public LogInfo(User user) {
		super();
		this.email = user.getEmail();
		this.name = user.getName();
	}
	
	
	
}
