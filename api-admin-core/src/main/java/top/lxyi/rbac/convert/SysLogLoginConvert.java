package top.lxyi.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.lxyi.rbac.entity.SysLogLoginEntity;
import top.lxyi.rbac.vo.SysLogLoginVO;


import java.util.List;
@Mapper
public interface SysLogLoginConvert {
    SysLogLoginConvert INSTANCE = Mappers.getMapper(SysLogLoginConvert.class);
    SysLogLoginEntity convert(SysLogLoginVO vo);
    List<SysLogLoginVO> convertList(List<SysLogLoginEntity> list);
}
