package top.lxyi.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import top.lxyi.common.utils.AddressUtils;
import top.lxyi.common.utils.HttpContextUtils;
import top.lxyi.common.utils.IpUtils;
import top.lxyi.common.utils.PageResult;
import top.lxyi.mybatis.service.impl.BaseServiceImpl;
import top.lxyi.rbac.dao.SysLogLoginDao;
import top.lxyi.rbac.entity.SysLogLoginEntity;
import top.lxyi.rbac.service.SysLogLoginService;
import top.lxyi.rbac.vo.SysLogLoginVO;
import top.lxyi.security.user.UserDetail;


import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {


    @Override
    public PageResult<SysLogLoginVO> page(SysLogLoginQuery query) {
        IPage<SysLogLoginEntity> page = baseMapper.selectPage(getPage(query),getWrapper(query));
        List<SysLogLoginEntity> list = page.getRecords();
        List<SysLogLoginVO> reslist = SysLogLoginConvert.INSTANCE.convertList(list);
        Long count = page.getTotal();

        return new PageResult<>(reslist,count);
    }

    @Override
    public void save(String username, Integer status, Integer operation) {
        //获得请求对象
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //从请求对象中获取请求地址、IP、UA等信息
        assert request !=null;
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);//org.springframework.http.HttpHeaders
        String ip = IpUtils.getIpAddr(request);
        String address = AddressUtils.getAddressByIP(ip);

        SysLogLoginEntity entity = new SysLogLoginEntity();
        //TODO：后续换成用工具类获取真实ID、地址、UA
        entity.setUsername(username);
        entity.setIp("127.0.0.1");
        entity.setUserAgent("Mozills/5.0");
        entity.setAddress("南京");
        entity.setStatus(status);
        entity.setOperation(operation);
        baseMapper.insert(entity);
    }
    private LambdaQueryWrapper<SysLogLoginEntity> getWrapper(SysLogLoginQuery query){
        LambdaQueryWrapper<SysLogLoginEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StrUtil.isNotBlank(query.getUsername()),SysLogLoginEntity::getUsername,query.getUsername());
        wrapper.like(StrUtil.isNotBlank(query.getAddress()),SysLogLoginEntity::getAddress,query.getAddress());
        wrapper.like(query.getStatus() != null,SysLogLoginEntity::getStatus,query.getStatus());
        wrapper.orderByDesc(SysLogLoginEntity::getId);
                return wrapper;

    }
    //老师没有，但是我们不自动生成就这个方法就报错了

    @Override
    public Set<String> getAuthority(UserDetail userDetail) {
        return null;
    }
}
