package top.lxyi.rbac.service;


import top.lxyi.mybatis.service.BaseService;
import top.lxyi.rbac.entity.SysUserEntity;

/**
 * 用户管理
 *
 * @author mqxu
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

}
