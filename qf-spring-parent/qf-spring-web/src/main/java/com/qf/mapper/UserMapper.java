package com.qf.mapper;

import com.qf.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/21 0021 上午 10:14
 */
@Mapper
public interface UserMapper {
    /**
     * 查询单个用户
     *
     * @return
     */

//    @Select("select * from tb_user where id = 2")
    User selectOnce();
}
