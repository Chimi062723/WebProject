package com.example.webproject.service.Xu.Admin;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Comment;
import com.example.webproject.model.Post;
import com.example.webproject.model.User;

public interface AdminActions {
   //todo:细化对异常的处理
   //todo:controller层可以进行调用并与前端对接了，将需求反馈给我们

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
    * @param canteen 更改的餐厅信息
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editCanteen(Canteen canteen);
   /**
    * 用户注册时会用到的添加用户
    * @param user 新添加的用户
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   void addAccount(User user);
   /**
    * 修改用户，系统管理员可用
    * @param oldUser 需要修改的用户
    * @param newUser 新用户样式
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editAccount(User oldUser, User newUser);
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
    * @param comment 需要删除的评价
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int deleteComment(Comment comment);
   /**
    * 删除指定评价
    * @param oldComment 更改的旧评论
    * @param newComment 新评论内容
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editComment(Comment oldComment, Comment newComment);
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
    * @param oldPost 要更改的评论
    * @param newPost 更改后的评论内容
    * @return 操作正常，返回结果1，操作异常，返回结果0
    * @author ChiMi
    * #Date 2023/12/21
    */
   int editPost(Post oldPost,Post newPost);
}
