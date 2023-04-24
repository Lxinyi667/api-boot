package top.lxyi.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import top.lxyi.common.exception.ServerException;
import top.lxyi.rbac.service.SysAuthService;
import top.lxyi.rbac.service.SysCaptchaService;
import top.lxyi.rbac.vo.SysAccountLoginVO;
import top.lxyi.rbac.vo.SysTokenVO;
import top.lxyi.security.cache.TokenStoreCache;
import top.lxyi.security.user.UserDetail;
import top.lxyi.security.utils.TokenUtils;


/**
 * 权限认证服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysAuthServiceImpl implements SysAuthService {
    private final TokenStoreCache tokenStoreCache;
    private final AuthenticationManager authenticationManager;
    private final SysCaptchaService sysCaptchaService;

    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO login) {
        // 验证码效验
//        boolean flag = sysCaptchaService.validate(login.getKey(), login.getCaptcha());
//        if (!flag) {
//            throw new ServerException("验证码错误");
//        }

        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        // 获取用户信息
        UserDetail user = tokenStoreCache.getUser(accessToken);
        // 删除用户
        tokenStoreCache.deleteUser(accessToken);
    }
}
