package com.example.webproject.service.Xu.Admin;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Review;
import com.example.webproject.model.User;

import java.util.List;

public interface AdminActions {
    //todo:细化对异常的处理
    /**
     * 添加餐厅
     *
     * @param canteen 新的食堂信息
     * @author ChiMi
     * #Date 2023/12/21
     */
    void addCanteen(Canteen canteen);

    List<User> getAllAccount();
    /**
     * 删除餐厅
     *
     * @param canteen 要删除的餐厅信息
     * @author ChiMi
     * #Date 2023/12/21
     */
    void deleteCanteen(Canteen canteen);
    /**
     * 更改餐厅信息
     *
     * @param newCanteen 新的餐厅信息
     * @author ChiMi
     * #Date 2023/12/21
     */
    void editCanteen(Canteen newCanteen);

    /**
     * 用用户id获取用户
     * @param
     * @return user
     * @author ChiMi
     * #Date 2023/12/22
     */
    User getAccount(int userID);

    /**
     * 用户注册时会用到的添加用户
     *
     * @param user 新添加的用户
     * @author ChiMi
     * #Date 2023/12/21
     */
    void addAccount(User user);
    /**
     * 修改用户，系统管理员可用
     *
     * @param username 新用户
     * @param email
     * @param role
     * @author ChiMi
     * #Date 2023/12/21
     */

    void editAccount(String username, String email, String role, Integer userID);

    /**
     * 删除指定用户
     *
     * @param user 需要删除的用户
     * @author ChiMi
     * #Date 2023/12/21
     */
    void deleteAccount(User user);
    /**
     * 删除指定评价
     *
     * @param reviewID 需要删除的评价
     * @author ChiMi
     * #Date 2023/12/21
     */
    void deleteReview(int reviewID);

    /**
     * 删除指定评价
     *
     * @param newReview 新评论内容
     * @author ChiMi
     * #Date 2023/12/21
     */
    void editReview(Review newReview);
    /**
     * Description
     *
     * @param postID 需要删除的评论
     * @author ChiMi
     * #Date 2023/12/21
     */
    void deletePost(int postID);
    /**
     * Description
     *
     * @author ChiMi
     * #Date 2023/12/21
     */
    void editPost(int id,String title,String content,String username,String createDate);
    /**
     * 将食堂信息封装为食堂实体类
     * @param canteenID 餐厅编号
     * @param name 餐厅名
     * @param location 餐厅位置
     * @param openTime 时间
     * @param managerName 管理员编号
     * @param notice
     * @return 餐厅实体类
     * @author ChiMi
     * #Date 2023/12/21
     */
    Canteen canteenEncapsulation(int canteenID, String name, String location, String openTime, String managerName, String notice);

    Review getReview(int reviewid);

    //实体封装类改为用实体类构造方法实现，除canteen封装需要用到managerid和name的转换所以保留以外，其余全部移除
}
