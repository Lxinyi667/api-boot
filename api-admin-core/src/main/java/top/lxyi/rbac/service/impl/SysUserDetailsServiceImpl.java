package top.lxyi.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.lxyi.rbac.convert.SysUserConvert;
import top.lxyi.rbac.entity.SysUserEntity;
import top.lxyi.rbac.enums.UserStatusEnum;
import top.lxyi.rbac.service.SysMenuService;
import top.lxyi.rbac.service.SysUserDetailsService;
import top.lxyi.security.user.UserDetail;

import java.util.HashSet;
import java.util.Set;


/**
 * 获取用户 UserDetails 信息服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService {
    private final SysMenuService menuService;

    @Override
    public UserDetails getUserDetails(SysUserEntity userEntity) {
        // 转换成UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertDetail(userEntity);

        // 账号不可用
        if (userEntity.getStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

//        userDetail.setAuthoritySet(menuService.getAuthority(userDetail));
        // 用户权限列表
        Set<String> authoritySet = SysMenuService.getUserAuthority(userDetail);
        userDetail.setAuthoritySet(authoritySet);

        return userDetail;
    }

}
