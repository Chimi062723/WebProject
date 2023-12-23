package com.example.webproject.service.Xu.Admin;

import com.example.webproject.dao.*;
import com.example.webproject.model.*;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用说明：
 * 1.实例化，会自动调用dao层接口，对dao层进行实例化
 * 2.使用封装类xxxEncapsulation将传入的对象封装
 * 3.传入对应操作的类（例如editCanteen(canteen,canteenModifyed)
 * 4.反馈操作结果
 */
public class AdminActionImpl implements AdminActions{
    UserDAO userDAO;
    CanteenDAO canteenDAO;
    ReviewDAO reviewDAO;
    DishDAO dishDAO;
    PostDAO postDAO;
    @Override
    public List<User> getAllAccount() {
        return userDAO.getAllUsers();
    }
    public AdminActionImpl(){
        this.userDAO = new UserDAO();
        this.canteenDAO = new CanteenDAO();
        this.reviewDAO = new ReviewDAO();
        this.dishDAO = new DishDAO();
        this.postDAO = new PostDAO();
    }

    public Canteen getCanteen(int canteenID){
        try {
            return canteenDAO.getCanteenByID(canteenID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Canteen> getAllCanteen(){
        try {
            return canteenDAO.getAllCanteens();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param canteen 新的食堂信息
     * @return
     */
    @Override
    public int addCanteen(Canteen canteen) {
        try{
            canteenDAO.addCanteen(canteen);
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param canteen 要删除的餐厅信息
     * @return
     */
    @Override
    public int deleteCanteen(Canteen canteen) {
        try{
            canteenDAO.deleteCanteen(canteen.getCanteenID());
            return 1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param newCanteen 新的餐厅信息
     * @return
     */
    @Override
    public int editCanteen(Canteen newCanteen) {
        try{
            canteenDAO.updateCanteen(newCanteen);
            return 1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @param userID
     * @return
     */
    @Override
    public User getAccount(int userID) {
        return userDAO.getUserByID(userID);
    }

    /**
     * @param user 新添加的用户
     */
    @Override
    public int addAccount(User user) {
        try{
            userDAO.addUser(user);
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param username 用户名
     * @param email 邮箱
     * @param role 角色
     * @return
     */
    @Override
    public int editAccount(String username, String email, String role) {
        try{
            userDAO.updateUser(username,email,role);
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param user 需要删除的用户
     * @return
     */
    @Override
    public int deleteAccount(User user) {
        try{
            userDAO.deleteUser(user.getUserName());
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param reviewID 需要删除的评价
     * @return
     */
    @Override
    public int deleteReview(int reviewID) {
        try{
            reviewDAO.deleteReview(reviewID); //todo:创建postDao类
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param newReview 新评论内容
     */
    @Override
    public void editReview(Review newReview) {
        try{
            reviewDAO.updateReview(newReview);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param postID 需要删除的评论
     * @return
     */
    @Override
    public int deletePost(int postID) {
        try{
            postDAO.deletePost(postID);
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param newPost 更改后的评论内容
     * @return
     */
    @Override
    public int editPost(Post newPost) {
        try{
            postDAO.editPost(newPost);
            return 1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * @param canteenID 餐厅编号
     * @param name      餐厅名
     * @param location  餐厅位置
     * @param openTime  时间
     * @param managerName 管理员编号
     * @return
     */
    @Override
    public Canteen canteenEncapsulation(int canteenID, String name, String location, String openTime, String managerName,String notice) {
        int managerID = userDAO.getUserByUsername(managerName).getUserID();
        return new Canteen(canteenID,name,location,openTime,managerID,notice);
    }

    @Override
    public Review getReview(int reviewid) {
        try {
            return reviewDAO.getReviewByReviewID(reviewid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Dish getDishByID(int dishID) {
        try {
            return dishDAO.getDish(dishID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getAccountByUserName(String user) {
       return userDAO.getUserByUsername(user);
    }

    public int getDishIDByName(String dish) {
        try {
            return dishDAO.getDishIDByName(dish);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Review> getAllReview() {
        try {
            return reviewDAO.getAllReviews();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
