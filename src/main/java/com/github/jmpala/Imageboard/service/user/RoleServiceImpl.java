package com.github.jmpala.Imageboard.service.user;

import com.github.jmpala.Imageboard.dao.user.Role;
import com.github.jmpala.Imageboard.dto.user.RoleDto;
import com.github.jmpala.Imageboard.mapper.user.RoleMapper;
import com.github.jmpala.Imageboard.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    @Transactional
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        for (Role role: roles) {
            roleDtos.add(roleMapper.roleToRoleDto(role));
        }
        return roleDtos;
    }

    @Override
    @Transactional
    public Optional<RoleDto> findById(Long id) {
        Optional<Role> oRole = roleRepository.findById(id);
        Optional<RoleDto> oRoleDto = Optional.of(roleMapper.roleToRoleDto(oRole.get()));
        return oRoleDto;
    }

    @Override
    @Transactional
    public RoleDto save(RoleDto role) {
        Role savedRole = roleRepository.save(roleMapper.roleDtoToRole(role));
        return roleMapper.roleToRoleDto(savedRole);
    }

    @Override
    @Transactional
    public void delete(RoleDto role) {
        roleRepository.delete(roleMapper.roleDtoToRole(role));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
