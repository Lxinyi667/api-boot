package top.lxyi.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.lxyi.common.constant.Constant;
import top.lxyi.common.utils.TreeUtils;
import top.lxyi.mybatis.service.impl.BaseServiceImpl;
import top.lxyi.rbac.convert.SysMenuConvert;
import top.lxyi.rbac.dao.SysMenuDao;
import top.lxyi.rbac.entity.SysMenuEntity;
import top.lxyi.rbac.enums.SuperAdminEnum;
import top.lxyi.rbac.service.SysMenuService;
import top.lxyi.rbac.vo.SysMenuVO;
import top.lxyi.security.user.UserDetail;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 菜单管理服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public List<SysMenuVO> getMenuList(Integer type) {
        List<SysMenuEntity> menuList = baseMapper.getMenuList(type);
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList), Constant.ROOT);
    }

    @Override
    public List<SysMenuVO> getUserMenuList(UserDetail user, Integer type) {
        List<SysMenuEntity> menuList;
        // 系统管理员，拥有最高权限
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            menuList = baseMapper.getMenuList(type);
        } else {
            menuList = baseMapper.getUserMenuList(user.getId(), type);
        }
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList));
    }

    @Override
    public Set<String> getAuthority(UserDetail userDetail) {
        List<String> authorityList;
        if (userDetail.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            // 全部权限
            authorityList = baseMapper.getAuthorityList();
        } else {
            authorityList = baseMapper.getUserAuthorityList(userDetail.getId());
        }

        // 分割字符串，去重
        Set<String> permSet = new HashSet<>();
        for (String authority : authorityList) {
            if ( StrUtil.isBlank(authority)) {
                continue;
            }
            permSet.addAll(Arrays.asList(authority.trim().split(",")));
        }
        return permSet;
    }

}