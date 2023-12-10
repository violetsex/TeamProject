import java.util.ArrayList;
import java.util.List;

public class RoleManagementSystem {
    private List<Role> roles = new ArrayList<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public void showAllRoles() {
        System.out.println("All role information is as follows:");
        for (Role role : roles) {
            role.showRoleInfo();
        }
    }

    public void deleteRole(String roleName) {
        for (Role role : roles) {
            if (role.getName().equals(roleName)) {
                roles.remove(role);
                System.out.println("Role deleted successfully!");
                return;
            }
        }
        System.out.println("Character not found!");
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Role findRole(String roleName) {
        for (Role role : roles) {
            if (role.getName().equals(roleName)) {
                return role;
            }
        }
        return null;
    }
}