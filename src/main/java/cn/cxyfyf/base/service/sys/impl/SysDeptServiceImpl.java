package cn.cxyfyf.base.service.sys.impl;

import cn.cxyfyf.base.controller.to.SysDeptTo;
import cn.cxyfyf.base.domain.SysDept;
import cn.cxyfyf.base.framework.utils.BeanConvertUtil;
import cn.cxyfyf.base.framework.utils.SecurityUtils;
import cn.cxyfyf.base.framework.web.domain.AjaxResult;
import cn.cxyfyf.base.framework.web.page.TableSupport;
import cn.cxyfyf.base.mapper.SysDeptMapper;
import cn.cxyfyf.base.service.sys.ISysDeptService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 部门表Service业务层处理
 *
 * @author fengyingfeng
 * @date 2022-11-01
 */
@RequiredArgsConstructor
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    private final SysDeptMapper mapper;

    /**
     * 分页列表查询
     * @param to to
     * @return 分页列表
     */
    @Override
    public Page<SysDept> selectListByPage(SysDeptTo to) {
        Page<SysDept> page = TableSupport.getPage();
        SysDept entity = BeanConvertUtil.convert(to, SysDept.class);
        return mapper.selectListByPage(page, entity);
    }

    /**
     * 根据ID获取详细信息
     * @param id id
     * @return 详细信息
     */
    @Override
    public AjaxResult getInfo(Long id) {
        return AjaxResult.success(this.getById(id));
    }

    /**
     * 新增
     * @param to to
     * @return result
     */
    @Override
    public AjaxResult add(SysDeptTo to) {
        SysDept entity = BeanConvertUtil.convert(to, SysDept.class);
        entity.setCreateBy(SecurityUtils.getUserIdString());
        return AjaxResult.success(this.save(entity));
    }

    /**
     * 修改
     * @param to to
     * @return result
     */
    @Override
    public AjaxResult edit(SysDeptTo to) {
        SysDept entity = BeanConvertUtil.convert(to, SysDept.class);
        entity.setUpdateBy(SecurityUtils.getUserIdString());
        return AjaxResult.success(this.updateById(entity));
    }

    /**
     * 根据ID修改状态
     * @param id id
     * @param status 状态
     * @return result
     */
    @Override
    public AjaxResult editStatus(Long id, String status) {
        UpdateWrapper<SysDept> wrapper = new UpdateWrapper<>();
        wrapper.set("status", status);
        wrapper.set("update_by", SecurityUtils.getUserIdString());
        wrapper.set("update_time", LocalDateTime.now());
        wrapper.eq("id", id);
        return AjaxResult.success(this.update(wrapper));
    }

    /**
     * 根据ID逻辑删除
     * @param id id
     * @return result
     */
    @Override
    public AjaxResult delete(Long id) {
        UpdateWrapper<SysDept> wrapper = new UpdateWrapper<>();
        wrapper.set("del_falg", 2);
        wrapper.set("update_by", SecurityUtils.getUserIdString());
        wrapper.set("update_time", LocalDateTime.now());
        wrapper.eq("id", id);
        return AjaxResult.success(this.update(wrapper));
    }

}