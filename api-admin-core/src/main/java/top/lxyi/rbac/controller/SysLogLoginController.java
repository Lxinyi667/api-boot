package top.lxyi.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.common.utils.PageResult;
import top.lxyi.common.utils.Result;
import top.lxyi.rbac.query.SysLogLoginQuery;
import top.lxyi.rbac.service.SysLogLoginService;
import top.lxyi.rbac.vo.SysLogLoginVO;


@RestController
@RequestMapping("sys/log/login")
@Tag( name="登录日志")
@AllArgsConstructor
public class SysLogLoginController {
    private final SysLogLoginService sysLogLoginService;
    @GetMapping("page")
    @Operation( summary = "登录日志分页")
    @PreAuthorize("hasAnyAuthority('sys:log:page')")
    // 授权
    public Result<PageResult<SysLogLoginVO>> page(@ParameterObject @Valid SysLogLoginQuery query){
        PageResult<SysLogLoginVO> page = sysLogLoginService.page(query);
        return Result.ok(page);
    }

}
