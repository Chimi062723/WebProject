package com.example.webproject.service.Xu.Admin;

import com.example.webproject.dao.CanteenDAO;
import com.example.webproject.dao.UserDAO;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Comment;
import com.example.webproject.model.Post;
import com.example.webproject.model.User;

import java.sql.SQLException;

public class AdminActionImpl implements AdminActions{
    //todo: 管理员操作的具体实现，数据库错误的异常处理
    UserDAO userDAO;
    CanteenDAO canteenDAO;
    AdminActionImpl(){
        this.userDAO = new UserDAO();
        this.canteenDAO = new CanteenDAO();
    }
    /**
     * @param canteen 新的食堂信息
     * @return
     */
    @Override
    public int addCanteen(Canteen canteen) {
        canteenDAO.addCanteen(canteen);
        return 0;
    }

    /**
     * @param canteen 要删除的餐厅信息
     * @return
     */
    @Override
    public int deleteCanteen(Canteen canteen) {
        return 0;
    }

    /**
     * @param canteen 更改的餐厅信息
     * @return
     */
    @Override
    public int editCanteen(Canteen canteen) {
        return 0;
    }

    /**
     * @param user 新添加的用户
     */
    @Override
    public void addAccount(User user) {

    }

    /**
     * @param oldUser 需要修改的用户
     * @param newUser 新用户样式
     * @return
     */
    @Override
    public int editAccount(User oldUser, User newUser) {
        return 0;
    }

    /**
     * @param user 需要删除的用户
     * @return
     */
    @Override
    public int deleteAccount(User user) {
        return 0;
    }

    /**
     * @param comment 需要删除的评价
     * @return
     */
    @Override
    public int deleteComment(Comment comment) {
        return 0;
    }

    /**
     * @param oldComment 更改的旧评论
     * @param newComment 新评论内容
     * @return
     */
    @Override
    public int editComment(Comment oldComment, Comment newComment) {
        return 0;
    }

    /**
     * @param post 需要删除的评论
     * @return
     */
    @Override
    public int deletePost(Post post) {
        return 0;
    }

    /**
     * @param oldPost 要更改的评论
     * @param newPost 更改后的评论内容
     * @return
     */
    @Override
    public int editPost(Post oldPost, Post newPost) {
        return 0;
    }
}
