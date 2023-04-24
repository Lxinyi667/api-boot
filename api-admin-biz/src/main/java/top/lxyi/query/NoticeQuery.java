package top.lxyi.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lxyi.common.query.Query;

/**
 * 通知管理查询参数
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知管理查询")
public class NoticeQuery extends Query {
    @Schema(description = "通知标题")
    private String title;
}
