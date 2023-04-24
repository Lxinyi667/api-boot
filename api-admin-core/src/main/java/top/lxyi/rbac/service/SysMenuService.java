package top.lxyi.rbac.service;




import top.lxyi.mybatis.service.BaseService;
import top.lxyi.rbac.entity.SysMenuEntity;
import top.lxyi.rbac.vo.SysMenuVO;
import top.lxyi.security.user.UserDetail;

import java.util.List;
import java.util.Set;

/**
 * 菜单管理
 *
 * @author mqxu
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    Set<String> getAuthority(UserDetail userDetail);


}
