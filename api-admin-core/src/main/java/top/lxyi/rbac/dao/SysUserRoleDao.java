package top.lxyi.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lxyi.mybatis.dao.BaseDao;
import top.lxyi.rbac.entity.SysUserRoleEntity;

/**
 * 用户角色关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

}