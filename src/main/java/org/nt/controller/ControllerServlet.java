package org.nt.controller;

import org.nt.action.SaveProductAction;
import org.nt.form.ProductForm;
import org.nt.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * HttpServlet需要导Tomcat包中的serlvet-api的jar包
 */
// 此注释类似于springMVC中的RequestMapping("/input-product", "/save-product")
@WebServlet(name = "ControllerServlet", urlPatterns = {"/input-product", "/save-product"})
public class ControllerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    /**
     * 在process方法中执行控制操作
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取url, 如:/appdesign1/input-product
        String uri = request.getRequestURI();
        // 获取资源路径
        String action = uri.substring(uri.lastIndexOf("/") + 1);
        // 如果要填写产品表单, 则直接显示视图
        String dispatchUrl = null;
        if ("input-product".equals(action)) {
            dispatchUrl = "/jsp/ProductForm.jsp";
        } else if ("save-product".equals(action)) {
            // 存储表单产品信息
            ProductForm productForm = new ProductForm();
            // 请求过来的参数都是字符串
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));
            // 创建产品对象, 就是一个javaBean对象, 用来封装数据库中表中的数据
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(new BigDecimal(productForm.getPrice()));
            SaveProductAction saveProductAction = new SaveProductAction();
            // 将数据存到数据库中
            saveProductAction.save(product);
            // 将product对象放入到request对象中, 便于之后再JSP编程中使用该对象
            request.setAttribute("product", product);
            // 将完成的视图返回给客户端的用户
            dispatchUrl = "/jsp/ProductDetail.jsp";
        }

        // 控制器返回对应的视图给客户端的用户
        if (dispatchUrl != null) {
            request.getRequestDispatcher(dispatchUrl).forward(request, response);
        }
    }
}