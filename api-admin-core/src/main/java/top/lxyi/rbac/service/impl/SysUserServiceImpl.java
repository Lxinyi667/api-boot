package top.lxyi.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lxyi.mybatis.service.impl.BaseServiceImpl;
import top.lxyi.rbac.dao.SysUserDao;
import top.lxyi.rbac.entity.SysUserEntity;
import top.lxyi.rbac.service.SysUserService;
import top.lxyi.security.user.UserDetail;


import java.util.Set;

/**
 * 系统用户服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }

    @Override
    public Set<String> getAuthority(UserDetail userDetail) {
        return null;
    }
}
