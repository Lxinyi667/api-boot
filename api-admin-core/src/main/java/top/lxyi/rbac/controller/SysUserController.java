package top.lxyi.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.common.utils.Result;
import top.lxyi.rbac.convert.SysUserConvert;
import top.lxyi.rbac.service.SysMenuService;
import top.lxyi.rbac.service.SysUserService;
import top.lxyi.rbac.vo.SysAuthVO;
import top.lxyi.rbac.vo.SysUserPasswordVO;
import top.lxyi.rbac.vo.SysUserVO;
import top.lxyi.security.user.SecurityUser;
import top.lxyi.security.user.UserDetail;


/**
 * 用户管理接口,编写获取用户信息接口
 *
 * @author mqxu
 */
@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysMenuService sysMenuService;
    //补充
    private final SysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("password")
    @Operation(summary = "修改密码")
    public Result<String> password(@RequestBody @Valid SysUserPasswordVO vo) {
        // 原密码不正确
        UserDetail user = SecurityUser.getUser();
        if (!passwordEncoder.matches(vo.getOldPassword(), user.getPassword())) {
            return Result.error("原密码不正确");
        }
        // 修改密码
        sysUserService.updatePassword(user.getId(), passwordEncoder.encode(vo.getNewPassword()));
        return Result.ok();
    }
    @PostMapping("info")
    @Operation(summary = "获取登录用户信息")
//    public Result<SysUserVO> info() {
//        SysUserVO user = SysUserConvert.INSTANCE.convert(SecurityUser.getUser());
//        return Result.ok(user);
//    }
    public Result<SysAuthVO> info() {
        SysAuthVO vo = new SysAuthVO();
        UserDetail userDetail = SecurityUser.getUser();
        //1 获得用户详细信息，转成 vo
        SysUserVO user = SysUserConvert.INSTANCE.convert(userDetail);
        vo.setSysUserVO(user);
        //2 获取用户导航菜单
        vo.setNav(sysMenuService.getUserMenuList(userDetail, 0));
        //3 获得用户授权信息
        vo.setAuthority(SysMenuService.getUserAuthority(userDetail));
        return Result.ok(vo);
    }




}
