package cn.xin.learn.community.config;

import cn.xin.learn.community.entity.po.BasePo;
import cn.xin.learn.community.helpers.UserHelper;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xin
 * @description: 元对象字段填充处理器
 * @date 2024年12月28日
 */
@Component
public class CommunityMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //插入时填充
        Object originalObject = metaObject.getOriginalObject();
        if (originalObject instanceof BasePo) {
            BasePo entity = (BasePo) originalObject;
            Date currentDate = new Date();
            entity.setUpdateTime(currentDate);
            entity.setCreateTime(currentDate);
            entity.setIsDelete(0);
            entity.setCreateUser(UserHelper.getUserIdAndName());
            entity.setUpdateUser(UserHelper.getUserIdAndName());
        }
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object originalObject = metaObject.getOriginalObject();
        if (originalObject instanceof BasePo) {
            BasePo entity = (BasePo) originalObject;
            Date currentDate = new Date();
            entity.setUpdateTime(currentDate);
            entity.setUpdateUser(UserHelper.getUserIdAndName());
        }
    }

}
