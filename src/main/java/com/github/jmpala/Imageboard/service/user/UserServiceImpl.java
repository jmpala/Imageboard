package com.github.jmpala.Imageboard.service.user;

import com.github.jmpala.Imageboard.dao.user.User;
import com.github.jmpala.Imageboard.dto.user.UserDto;
import com.github.jmpala.Imageboard.mapper.user.UserMapper;
import com.github.jmpala.Imageboard.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users) {
            userDtos.add(userMapper.userToUserDto(user));
        }
        return userDtos;
    }

    @Override
    @Transactional
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        Optional<UserDto> userDto = Optional.of(userMapper.userToUserDto(user.get()));
        return userDto;
    }

    @Override
    @Transactional
    public UserDto save(UserDto user) {
        User savedUser = userRepository.save(userMapper.userDtoToUser(user));
        return userMapper.userToUserDto(savedUser);
    }

    @Override
    @Transactional
    public void delete(UserDto user) {
        userRepository.delete(userMapper.userDtoToUser(user));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
