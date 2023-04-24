package top.lxyi.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lxyi.mybatis.dao.BaseDao;
import top.lxyi.rbac.entity.SysMenuEntity;

import java.util.List;

/**
 * 菜单管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

    List<String> getAuthorityList();

    List<String> getUserAuthorityList(Long id);

    List<SysMenuEntity> getMenuList(Integer type);

    List<SysMenuEntity> getUserMenuList(Long id, Integer type);
}
