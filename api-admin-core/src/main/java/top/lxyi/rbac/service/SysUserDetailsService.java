package top.lxyi.rbac.service;


import org.springframework.security.core.userdetails.UserDetails;
import top.lxyi.rbac.entity.SysUserEntity;


/**
 * 用户详细信息接口
 * @author moqi
 */
public interface SysUserDetailsService {

    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
