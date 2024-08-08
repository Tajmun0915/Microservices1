package com.nisum.users.service;

import com.nisum.users.dao.CreditCardInfoRepository;
import com.nisum.users.dao.UserRepository;
import com.nisum.users.dto.UserDTO;
import com.nisum.users.mappers.UserMapper;
import com.nisum.users.model.CreditCardInfo;
import com.nisum.users.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private CreditCardInfoRepository creditCardInfoRepository;

    public UserService(UserRepository userRepository, CreditCardInfoRepository creditCardInfoRepository) {
        this.userRepository = userRepository;
        this.creditCardInfoRepository = creditCardInfoRepository;
    }

//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserById(Long id) {
//        User user = UserMapper.toEntity(UserDTO.);
//        return userRepository.findById(id).orElse(null);
//    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(UserMapper::toDTO).orElse(null);
    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        User createdUser = userRepository.save(user);
        return UserMapper.toDTO(createdUser);
    }
//        User createdUser = userRepository.save(user);
//        if (userDTO.getCreditCardInfo() != null) {
//            CreditCardInfo creditCardInfo = new CreditCardInfo();
//            creditCardInfo.setUser(user);
//            user.setCreditCardInfo(creditCardInfo);
//        }
//        return UserMapper.toDTO(createdUser);
//    }


    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = UserMapper.toEntity(userDTO);
            user.setUserId(id);
            User updatedUser = userRepository.save(user);
            return UserMapper.toDTO(updatedUser);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            System.out.println("User with " + id + " not found");
        }
        return false;
    }
}
