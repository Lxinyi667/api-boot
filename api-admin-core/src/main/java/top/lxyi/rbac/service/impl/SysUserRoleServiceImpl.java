package top.lxyi.rbac.service.impl;


import org.springframework.stereotype.Service;
import top.lxyi.mybatis.service.impl.BaseServiceImpl;
import top.lxyi.rbac.dao.SysUserRoleDao;
import top.lxyi.rbac.entity.SysUserRoleEntity;
import top.lxyi.rbac.service.SysUserRoleService;
import top.lxyi.security.user.UserDetail;


import java.util.Set;

/**
 * 用户角色关系服务
 *
 * @author mqxu
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
    @Override
    public Set<String> getAuthority(UserDetail userDetail) {
        return null;
    }
}