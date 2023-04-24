package top.lxyi.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lxyi.mybatis.dao.BaseDao;
import top.lxyi.rbac.entity.SysUserEntity;

/**
 * 系统用户管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

}