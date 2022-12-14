package com.BootCampAcademy.demo.service;
import com.BootCampAcademy.demo.model.Role;
import java.util.List;

public interface IRoleService {
    Role findRoleById(Long id);
    List<Role> findAllRoles();

    Role createRole(Role role);

    boolean deleteRole(long id);
    Role updateRole (long id, Role role);

    Long findRoleByName(String name);
}
