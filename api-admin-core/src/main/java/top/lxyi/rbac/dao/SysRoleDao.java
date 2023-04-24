package top.lxyi.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lxyi.mybatis.dao.BaseDao;
import top.lxyi.rbac.entity.SysRoleEntity;

/**
 * 角色管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}
