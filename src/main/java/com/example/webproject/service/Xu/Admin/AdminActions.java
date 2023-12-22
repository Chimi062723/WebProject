package com.example.webproject.service.Xu.Admin;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Review;
import com.example.webproject.model.Post;
import com.example.webproject.model.User;

import java.sql.Date;

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
    * 用户注册时会用到的添加用户
    * @param user 新添加的用户
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   /**
    * Description
    * @param
    * @return user
    * @author ChiMi
    * #Date 2023/12/22
    */
   User getAccount(int userId){

   }

   int addAccount(User user);
   /**
    * 修改用户，系统管理员可用
    * @param newUser 新用户样式
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editAccount(User newUser);
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
    * @param canteenId 餐厅编号
    * @param name 餐厅名
    * @param location 餐厅位置
    * @param openTime 时间
    * @param managerID 管理员编号
    * @return 餐厅实体类
    * @author ChiMi
    * #Date 2023/12/21
    */
   Canteen canteenEncapsulation(int canteenId, String name, String location, String openTime, int managerID);
   /**
    * 社区帖子封装类
    * @param postId 帖子编号（自动生成）
    * @param userId 用户编号
    * @param title 标题
    * @param content 内容
    * @param createDate 创建时间，可传空值，由系统自动生成
    * @param like 用户喜欢程度
    * @return 帖子实体类
    * @author ChiMi
    * #Date 2023/12/21
    */
   Post postEncapsulation(int postId, int userId, String title, String content, Date createDate, int like);
   /**
    * Description
    * @param reviewId 评价id（自动生成）
    * @param userId 用户id
    * @param dishId 菜品编号
    * @param rating 评价(int)
    * @param comment 评价内容
    * @param statue
    * @param createDate 创建日期(自动生成)
    * @return 封装后的评价实体类
    * @author ChiMi
    * #Date 2023/12/21
    */
   Review reviewEncapsulation(int reviewId,int userId,int dishId,int rating,String comment,int statue,Date createDate);

   Post postEncapsulation(int postId, int userId, String title, String content, String createDate, int like, String picture);

   Review reviewEncapsulation(int reviewId, int userId, int dishId, int rating, String comment, int statue, Date createDate, String picture);
}
