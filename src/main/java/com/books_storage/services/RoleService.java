package com.books_storage.services;

import com.books_storage.entities.Role;

import java.util.List;

public interface RoleService {

    void add(Role role);
    void delete(Role role);
    Role getById(long id);
    Role getByName(String roleName);
    void edit(Role role);
    List<Role> getAll();

}
