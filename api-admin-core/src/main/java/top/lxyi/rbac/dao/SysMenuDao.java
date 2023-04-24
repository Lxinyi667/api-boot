package top.lxyi.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lxyi.mybatis.dao.BaseDao;
import top.lxyi.rbac.entity.SysMenuEntity;

/**
 * 菜单管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

}
