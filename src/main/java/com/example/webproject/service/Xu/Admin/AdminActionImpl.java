package com.example.webproject.service.Xu.Admin;

import com.example.webproject.dao.CanteenDAO;
import com.example.webproject.dao.ReviewDAO;
import com.example.webproject.dao.UserDAO;
import com.example.webproject.model.Canteen;
import com.example.webproject.model.Review;
import com.example.webproject.model.Post;
import com.example.webproject.model.User;

import java.sql.Date;
import java.sql.SQLException;
/**
 * 使用说明：
 * 1.实例化，会自动调用dao层接口，对dao层进行实例化
 * 2.使用封装类xxxEncapsulation将传入的对象封装
 * 3.传入对应操作的类（例如editCanteen(canteen,canteenModifyed)
 * 4.反馈操作结果
 */
public class AdminActionImpl implements AdminActions{
    //todo: 管理员操作的具体实现，数据库错误的异常处理
    UserDAO userDAO;
    CanteenDAO canteenDAO;
    ReviewDAO reviewDAO;
    public AdminActionImpl(){
        this.userDAO = new UserDAO();
        this.canteenDAO = new CanteenDAO();
        this.reviewDAO = new ReviewDAO();
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
            //todo
            return 0;
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
            //todo
            return 0;
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
            //todo
            return 0;
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
            //todo
            return 0;
        }
    }

    /**
     * @param newUser 新用户样式
     * @return
     */
    @Override
    public int editAccount(User newUser) {
        try{
            userDAO.updateUser(newUser);
            return 1;
        }catch (SQLException e){
            //todo
            return 0;
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
            //todo
            return 0;
        }
    }

    /**
     * @param review 需要删除的评价
     * @return
     */
    @Override
    public int deleteReview(Review review) {
//        try{
//            //todo:reviewDAO.deleteReview(review); //todo:创建postDao类
//            return 1;
//        }catch (SQLException e){
//            //todo
//            return 0;
//        }
        return 0;
    }

    /**
     * @param newReview 新评论内容
     * @return
     */
    @Override
    public int editReview(Review newReview) {
//        try{
//            postDao.deletePost(post); //todo 创建postDao类
//            return 1;
//        }catch (SQLException e){
//            //todo
//            return 0;
//        }
        return 0;
    }

    /**
     * @param post 需要删除的评论
     * @return
     */
    @Override
    public int deletePost(Post post) {
//        try{
//            postDao.deletePost(post); //todo 创建postDao类
//            return 1;
//        }catch (SQLException e){
//            //todo
//            return 0;
//        }
        return 0;
    }

    /**
     * @param newPost 更改后的评论内容
     * @return
     */
    @Override
    public int editPost(Post newPost) {
//        try{
//            postDao.editPost(newPost); //todo 创建postDao类
//            return 1;
//        }catch (SQLException e){
//            //todo
//            return 0;
//        }
        return 0;
    }

    /**
     * @param canteenID 餐厅编号
     * @param name      餐厅名
     * @param location  餐厅位置
     * @param openTime  时间
     * @param managerID 管理员编号
     * @return
     */
    @Override
    public Canteen canteenEncapsulation(int canteenID, String name, String location, String openTime, int managerID) {
        return new Canteen(canteenID,name,location,openTime,managerID);
    }

    /**
     * @param postID     帖子编号（自动生成）
     * @param userID     用户编号
     * @param title      标题
     * @param content    内容
     * @param createDate 创建时间，可传空值，由系统自动生成
     * @param like       用户喜欢程度
     * @return
     */
    @Override
    public Post postEncapsulation(int postID, int userID, String title, String content, Date createDate, int like) {
        return null;
    }

    /**
     * @param reviewID   评价id（自动生成）
     * @param userID     用户id
     * @param dishID     菜品编号
     * @param rating     评价(int)
     * @param comment    评价内容
     * @param statue
     * @param createDate 创建日期(自动生成)
     * @return
     */
    @Override
    public Review reviewEncapsulation(int reviewID, int userID, int dishID, int rating, String comment, int statue, Date createDate) {
        return null;
    }

    /**
     * @param postID     帖子编号（自动生成）
     * @param userID     用户编号
     * @param title      标题
     * @param content    内容
     * @param createDate 创建时间，可传空值，由系统自动生成
     * @param like       用户喜欢程度
     * @return
     */
    @Override
    public Post postEncapsulation(int postID, int userID, String title, String content, String createDate, int like, String picture) {
        return new Post(postID,userID,title,content,createDate,like,picture);
    }

    /**
     * @param reviewID   评价id（自动生成）
     * @param userID     用户id
     * @param dishID     菜品编号
     * @param rating     评价(int)
     * @param comment    评价内容
     * @param statue
     * @param createDate 创建日期(自动生成)
     * @return
     */
    @Override
    public Review reviewEncapsulation(int reviewID, int userID, int dishID, int rating, String comment, int statue, Date createDate,String picture) {
        return new Review(reviewID,userID,dishID,rating,comment,statue,createDate,picture);
    }
}
