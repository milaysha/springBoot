package org.example.sprinfbootdem.service;



import org.example.sprinfbootdem.model.User;
import org.example.sprinfbootdem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public User findById(Long id) {
       return userRepository.getOne(id);
   }

   public List<User> findAll() {
       return userRepository.findAll();
   }

   public User saveUser(User user) {
       return userRepository.save(user);
   }
   public void deleteById(Long id) {
       userRepository.deleteById(id);
   }
}

