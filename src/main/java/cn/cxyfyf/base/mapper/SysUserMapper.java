package cn.cxyfyf.base.mapper;

import cn.cxyfyf.base.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息表Mapper接口
 * 
 * @author fengyingfeng
 * @date 2022-11-01
 */
public interface SysUserMapper extends BaseMapper<SysUser>{
    /**
     * 查询用户信息表列表
     *
     * @param SysUser 用户信息表
     * @return 用户信息表集合
     */
    List<SysUser> selectSysUserList(SysUser SysUser);
    /**
     * 分页查询用户信息表列表
     * @param page 分页数据
     * @param entity 实体封装对象
     */
    Page<SysUser> selectListByPage(Page<SysUser> page, @Param("param") SysUser entity);

}
