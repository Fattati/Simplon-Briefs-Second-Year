package com.springboot.service;

import com.springboot.model.Role;

public interface RoleService {
    Role findByName(String name);
}
