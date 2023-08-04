package com.fjp.shoesshop.controller;

import com.fjp.shoesshop.pojo.Goods;
import com.fjp.shoesshop.service.GoodsService;
import com.fjp.shoesshop.service.impl.GoodsServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsServlet", value = "/GoodsServlet")
public class GoodsServlet extends GoodsBaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        findAll(req, resp);
    }

       protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           HttpSession session = request.getSession();
           List<Goods> good = goodsService.findAll();
           session.setAttribute("good",good);
           request.getRequestDispatcher("goodmanger.jsp").forward(request, response);
    }
    protected void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods goods = goodsService.findById(id);
        request.setAttribute("good",goods);
        request.getRequestDispatcher("goodsupdate.jsp").forward(request,response);
    }
    protected void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean b = goodsService.deleteGoods(id);
        response.sendRedirect("GoodsServlet");
    }
    protected void findImageById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Goods goods = goodsService.findById(id);
        request.setAttribute("good",goods);
        request.getRequestDispatcher("imageupdate.jsp").forward(request,response);
    }
    protected void updateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int gid = id == null ? 0: Integer.parseInt(id);
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
       double pprice= price == null ? 0: Double.parseDouble(price);
        String desc = request.getParameter("desc");
        String stock = request.getParameter("stock");
        int pstock= stock == null ? 0: Integer.parseInt(stock);
        String type_id = request.getParameter("type_id");
        int ptye = type_id == null ? 0: Integer.parseInt(type_id);
        Goods goods = new Goods();
        goods.setId(gid);
        goods.setName(name);
        goods.setImage(image);
        goods.setPrice(pprice);
        goods.setGdesc(desc);
        goods.setStock(pstock);
        goods.setType_id(ptye);
//        upFiles(request, response);
        boolean b = goodsService.updateGood(goods);
        response.sendRedirect("GoodsServlet");
    }
    protected void upFiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fi : list) {
                if(fi.isFormField()){
                    System.out.println(fi.getFieldName() + "\t" + fi.getString());
                }else{
                    String path = getServletContext().getRealPath("/img");
//                   // String path =this.getClass().getClassLoader().getResource("src/main/webapp/img").getPath();
                    System.out.println(path);
                    File f = new File(path);
                    if(!f.exists()){
                        f.mkdirs();
                    }
                    String name = fi.getName();
                    name = name.substring(name.lastIndexOf(File.separator) + 1);
                    System.out.println(name);
                    File file = new File(path, name);
                    fi.write(f);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("GoodsServlet");
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
}}
