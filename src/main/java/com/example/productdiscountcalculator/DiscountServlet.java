package com.example.productdiscountcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String productDescription = request.getParameter("productDescription");
        String listPriceStr = request.getParameter("listPrice");
        String discountPercentStr = request.getParameter("discountPercent");

        // Chuyển đổi giá trị nhập vào thành kiểu số
        double listPrice = Double.parseDouble(listPriceStr);
        double discountPercent = Double.parseDouble(discountPercentStr);

        // Tính toán
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        // Hiển thị kết quả
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Discount Result</title></head>");
        writer.println("<body>");
        writer.println("<h2>Product Discount Calculator</h2>");
        writer.println("<p>Product Description: " + productDescription + "</p>");
        writer.println("<p>List Price: $" + listPrice + "</p>");
        writer.println("<p>Discount Percent: " + discountPercent + "%</p>");
        writer.println("<p>Discount Amount: $" + discountAmount + "</p>");
        writer.println("<p>Discount Price: $" + discountPrice + "</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
