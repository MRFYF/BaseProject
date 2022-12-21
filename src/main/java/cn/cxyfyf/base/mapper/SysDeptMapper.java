package cn.cxyfyf.base.mapper;

import cn.cxyfyf.base.domain.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门表Mapper接口
 * 
 * @author fengyingfeng
 * @date 2022-11-01
 */
public interface SysDeptMapper extends BaseMapper<SysDept>{
    /**
     * 查询部门表列表
     *
     * @param SysDept 部门表
     * @return 部门表集合
     */
    List<SysDept> selectSysDeptList(SysDept SysDept);
    /**
     * 分页查询部门表列表
     * @param page 分页数据
     * @param entity 实体封装对象
     */
    Page<SysDept> selectListByPage(Page<SysDept> page, @Param("params") SysDept entity);

}
