package books4u.com.br.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import books4u.com.br.dto.LoggedDto;
import books4u.com.br.dto.UserLoginDto;
import books4u.com.br.entities.User;
import books4u.com.br.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public LoggedDto login(UserLoginDto loginDto) {
		LoggedDto logged = new LoggedDto(false);
		User user = repository.findUserLogged(loginDto.getUserEmail(),
				loginDto.getUserPassword());
		
		if (user != null) {
			logged.setLogged(true);
		}
		else {
			logged.setLogged(false);
		}
		
		return logged;
	}
}
