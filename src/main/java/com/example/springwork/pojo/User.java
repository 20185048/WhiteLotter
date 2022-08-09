package com.example.springwork.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.example.springwork.pojo.BasePojo;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jinyaxu
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BasePojo {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 是否删除，1删除，0未删除
     */
    @TableLogic
    private Integer deleted;


}
