package am.hakobyan.hgh.service;

import am.hakobyan.hgh.entity.User;
import am.hakobyan.hgh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User userByName(String userName) {
       return userRepository.findByUserName(userName);
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public List<User> getUserByZipCode(String zipCode) {
        return userRepository.findByHomeAddressZip(zipCode);
    }

    public List<User> getUserByTask() {
        return userRepository.getUserFromTask();
    }


}
