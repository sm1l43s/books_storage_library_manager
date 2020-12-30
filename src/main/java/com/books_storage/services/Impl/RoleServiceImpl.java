package com.books_storage.services.Impl;

import com.books_storage.entities.Role;
import com.books_storage.repositories.RoleRepository;
import com.books_storage.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    @Transactional
    public Role getById(long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
            return role.get();
        }
        return null;
    }

    @Override
    @Transactional
    public Role getByName(String roleName) {
       Optional<Role> role = Optional.ofNullable(roleRepository.findByRoleName(roleName));

       if (role.isPresent()) {
           return role.get();
       }

       return null;
    }

    @Override
    @Transactional
    public void edit(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public List<Role> getAll() {
        return (List<Role>) roleRepository.findAll();
    }
}
