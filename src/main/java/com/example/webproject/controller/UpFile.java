package com.example.webproject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "upFile", value = "/upFile")
public class UpFile extends HttpServlet {
    String pic;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(403);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath1 = this.getServletContext().getRealPath("res/upload");
        String realPath2 = this.getServletContext().getRealPath("res/tmp");
        File saveFilePath = new File(realPath1);
        File tempFilePath = new File(realPath2);
        boolean flag=false;
        if (!saveFilePath.exists()) {
            if(!saveFilePath.mkdir()){
                System.out.println("保存文件夹创建目录失败");
                return;
            }
        }
        if (!tempFilePath.exists()) {
            if(!tempFilePath.mkdir()){
                System.out.println("缓存文件夹创建目录失败");
                return;
            }
        }
        try {
            DiskFileItemFactory diskFileItemFactory = getDiskFileItemFactory(tempFilePath);
            ServletFileUpload servletFileUpload = getServletFileUpload(diskFileItemFactory);
            flag = uploadParseRequest(servletFileUpload, req, realPath1);
        } catch (FileUploadException e) {
            Log log = LogFactory.getLog(getClass());
            log.error("exception message:", e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print(pic);
    }

    private DiskFileItemFactory getDiskFileItemFactory(File file) {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024 * 1024);
        diskFileItemFactory.setRepository(file);
        return diskFileItemFactory;
    }

    private ServletFileUpload getServletFileUpload(DiskFileItemFactory diskFileItemFactory) {
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setProgressListener(
                (pBytesRead, pContentLength, pItems)
                        -> System.out.printf("总大小：%d，已上传：%d，%d\n", pContentLength, pBytesRead, pItems)
        );
        servletFileUpload.setHeaderEncoding("utf-8");
        servletFileUpload.setFileSizeMax(1024 * 1024 * 10);
        return servletFileUpload;
    }
    static class Rc implements RequestContext{
        HttpServletRequest request;
        public Rc(HttpServletRequest request) {
            this.request=request;
        }

        @Override
        public String getCharacterEncoding() {
            return request.getCharacterEncoding();
        }

        @Override
        public String getContentType() {
            return request.getContentType();
        }

        @Override
        public int getContentLength() {
            return request.getContentLength();
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return request.getInputStream();
        }
    }
    private boolean uploadParseRequest(ServletFileUpload upload, HttpServletRequest req, String saveFilePath) throws FileUploadException, IOException {
        boolean flag = false;
        List<FileItem> fileItems = upload.parseRequest(new Rc(req));
        System.out.println("进入uploadParseRequest");
        for (FileItem fileItem : fileItems) {
            System.out.println("进入循环");
            if (fileItem.isFormField()) {
                System.out.println("不是文件");
                System.out.println(fileItem.getFieldName() + "---" + fileItem.getString("utf-8"));
            } else {
                System.out.println("接收文件");
                String uploadpath = fileItem.getName();
                String uploadfilename = uploadpath.substring(uploadpath.lastIndexOf("/") + 1);
                String uploadfiletype = uploadfilename.substring(uploadfilename.lastIndexOf(".") + 1);
                System.out.println(uploadpath);
                System.out.println("文件名："+uploadfilename);
                System.out.println("文件类型："+uploadfiletype);
                System.out.println("上传的文件名为：" + uploadfilename + "，文件类型：" + uploadfiletype);
                String uuid = UUID.randomUUID().toString();
                pic = "upload/"+uuid+'/'+uploadfilename;
                req.setAttribute("pics",pic);
                String realpath = saveFilePath + "/" + uuid;
                System.out.println("保存路径为："+realpath);
                File realfilepath = new File(realpath);
                if (!realfilepath.exists()) {
                    if(!realfilepath.mkdir()){
                        throw new  RuntimeException();
                    }
                }
                InputStream ips = fileItem.getInputStream();
                FileOutputStream fops = new FileOutputStream(realfilepath+"/"+uploadfilename);
                byte[] buffer = new byte[1024 * 1024];
                int len;
                while ((len = ips.read(buffer)) > 0) {
                    fops.write(buffer, 0, len);
                }
                fops.close();
                ips.close();
                flag = true;
            }
        }
        return flag;
    }
}