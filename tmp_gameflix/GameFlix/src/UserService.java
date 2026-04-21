

import org.springframework.stereotype.Service;
import gameflix.repository.UserRepository;
@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User registerUser(String username, String password, String email) {
        if (repo.findByUsername(username) != null) return null;
        return repo.save(new User(username, password, email));
    }

    public User loginUser(String username, String password) {
        User user = repo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
