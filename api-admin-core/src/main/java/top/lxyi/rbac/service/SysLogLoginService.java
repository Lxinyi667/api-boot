package top.lxyi.rbac.service;

import org.springframework.stereotype.Service;
import top.lxyi.common.utils.PageResult;
import top.lxyi.mybatis.service.BaseService;
import top.lxyi.rbac.entity.SysLogLoginEntity;
import top.lxyi.rbac.query.SysLogLoginQuery;
import top.lxyi.rbac.vo.SysLogLoginVO;
/**
 * 登录日志业务接口
 *
 **/
@Service
public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {
    /**
     * 按条件分页查询
     * @param query
     * @return
     */
    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录
     * @param username
     * @param status
     * @param operation
     */
    void save(String username,Integer status,Integer operation);
}
