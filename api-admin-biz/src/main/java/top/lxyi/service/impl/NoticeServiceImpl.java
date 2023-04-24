package top.lxyi.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lxyi.common.utils.PageResult;
import top.lxyi.convert.NoticeConvert;
import top.lxyi.dao.NoticeDao;
import top.lxyi.entity.NoticeEntity;
import top.lxyi.mybatis.service.impl.BaseServiceImpl;
import top.lxyi.query.NoticeQuery;
import top.lxyi.security.user.UserDetail;
import top.lxyi.service.NoticeService;
import top.lxyi.vo.NoticeVO;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {
    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        IPage<NoticeEntity> page = baseMapper.selectPage(getPage(query),getWrapper(query));
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()),page.getTotal());
    }

    @Override
    public List<NoticeVO> getList() {
        return NoticeConvert.INSTANCE.convertList(baseMapper.selectList(getWrapper(new NoticeQuery())));
    }

    @Override
    public void save(NoticeVO vo) {
        baseMapper.insert(NoticeConvert.INSTANCE.convert(vo));
    }

    @Override
    public void update(NoticeVO vo) {
        updateById(NoticeConvert.INSTANCE.convert(vo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        removeById(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        removeByIds(Arrays.asList(ids));
    }

    /**
     * 查询条件构造
     * @param query 查询参数
     * @return 查询条件
     */
    private Wrapper<NoticeEntity> getWrapper(NoticeQuery query){
        LambdaQueryWrapper<NoticeEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getTitle()),NoticeEntity::getTitle,query.getTitle());
        return wrapper;
    }

    @Override
    public Set<String> getAuthority(UserDetail userDetail) {
        return null;
    }
}
