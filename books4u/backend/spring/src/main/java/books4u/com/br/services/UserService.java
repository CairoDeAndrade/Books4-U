package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.user.LoggedDto;
import books4u.com.br.dto.user.UserLoginDto;
import books4u.com.br.entities.User;
import books4u.com.br.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public LoggedDto login(UserLoginDto loginDto) {
		LoggedDto logged = new LoggedDto(false);
		User user = repository.checkUserAuthentication(loginDto.getUserEmail(),
				loginDto.getUserPassword());
		
		if (user != null) {
			logged.setLogged(true);
		}
		
		return logged;
	}
}
