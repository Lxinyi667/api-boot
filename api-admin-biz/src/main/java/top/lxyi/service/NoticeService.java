package top.lxyi.service;

import top.lxyi.common.utils.PageResult;
import top.lxyi.entity.NoticeEntity;
import top.lxyi.mybatis.service.BaseService;
import top.lxyi.query.NoticeQuery;
import top.lxyi.vo.NoticeVO;

import java.util.List;

/**
 * 通知模块服务接口
 */

public interface NoticeService extends BaseService<NoticeEntity> {
    /**
     * 分页查询通知
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<NoticeVO> page(NoticeQuery query);

    /**
     * 获取所有通知数据
     *
     * @return {@link List}<{@link NoticeVO}>
     */
    List<NoticeVO> getList();

    /**
     * 保存
     *
     * @param vo 签证官
     */
    void save(NoticeVO vo);

    /**
     * 更新
     *
     * @param vo 签证官
     */
    void update(NoticeVO vo);

    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);

    void deleteBatch(Long[] ids);
}
