package top.lxyi.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lxyi.entity.NoticeEntity;
import top.lxyi.mybatis.dao.BaseDao;

@Mapper
public interface NoticeDao extends BaseDao<NoticeEntity> {
}
