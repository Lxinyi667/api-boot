package top.lxyi.rbac.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.lxyi.mybatis.service.impl.BaseServiceImpl;
import top.lxyi.rbac.dao.SysRoleDao;
import top.lxyi.rbac.entity.SysRoleEntity;
import top.lxyi.rbac.service.SysRoleService;
import top.lxyi.security.user.UserDetail;


import java.util.Set;

/**
 * 系统角色服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Override
    public Set<String> getAuthority(UserDetail userDetail) {
        return null;
    }
}