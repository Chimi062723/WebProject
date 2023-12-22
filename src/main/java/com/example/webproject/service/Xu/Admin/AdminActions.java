package com.example.webproject.service.Xu.Admin;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Review;
import com.example.webproject.model.Post;
import com.example.webproject.model.User;

import java.sql.Date;
import java.sql.Timestamp;

public interface AdminActions {
   //todo:细化对异常的处理
   /**
    * 添加餐厅
    * @param canteen 新的食堂信息
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int addCanteen(Canteen canteen);
   /**
    * 删除餐厅
    * @param canteen 要删除的餐厅信息
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int deleteCanteen(Canteen canteen);
   /**
    * 更改餐厅信息
    * @param newCanteen 新的餐厅信息
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editCanteen(Canteen newCanteen);

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
    * @param user 新添加的用户
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int addAccount(User user);
   /**
    * 修改用户，系统管理员可用
    * @param username 新用户
    * @param email
    * @param role
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editAccount(String username, String email, String role);

   /**
    * 删除指定用户
    * @param user 需要删除的用户
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int deleteAccount(User user);
   /**
    * 删除指定评价
    * @param review 需要删除的评价
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int deleteReview(Review review);
   /**
    * 删除指定评价
    * @param newReview 新评论内容
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editReview(Review newReview);
   /**
    * Description
    * @param post 需要删除的评论
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int deletePost(Post post);
   /**
    * Description
    * @param newPost 更改后的评论内容
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editPost(Post newPost);
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

   /**
    * 社区帖子封装类
    * @param postID 帖子编号（自动生成）
    * @param userID 用户编号
    * @param title 标题
    * @param content 内容
    * @param createDate 创建时间，可传空值，由系统自动生成
    * @param like 用户喜欢程度
    * @return 帖子实体类
    * @author ChiMi
    * #Date 2023/12/21
    */
   Post postEncapsulation(int postID, int userID, String title, String content, Date createDate, int like);
   /**
    * Description
    * @param reviewID 评价id（自动生成）
    * @param userID 用户id
    * @param dishID 菜品编号
    * @param rating 评价(int)
    * @param comment 评价内容
    * @param reply
    * @param createDate 创建日期(自动生成)
    * @return 封装后的评价实体类
    * @author ChiMi
    * #Date 2023/12/21
    */
   //Review reviewEncapsulation(int reviewID, int userID, int dishID, int rating, String comment, String reply, Timestamp createDate);

   //Post postEncapsulation(int postID, int userID, String title, String content, String createDate, int like, String picture);

  //Review reviewEncapsulation(int reviewID, int userID, int dishID, int rating, String comment, String reply,Timestamp createDate, String picture);
}
