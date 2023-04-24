package top.lxyi.rbac.service.impl;

import org.springframework.stereotype.Service;
import top.lxyi.mybatis.service.impl.BaseServiceImpl;
import top.lxyi.rbac.dao.SysRoleMenuDao;
import top.lxyi.rbac.entity.SysRoleMenuEntity;
import top.lxyi.rbac.service.SysRoleMenuService;
import top.lxyi.security.user.UserDetail;

import java.util.Set;


/**
 * 角色与菜单对应业务实现类
 *
 * @author mqxu
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {


    @Override
    public Set<String> getAuthority(UserDetail userDetail) {
        return null;
    }
}