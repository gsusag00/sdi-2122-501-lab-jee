package com.uniovi.sdi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ProductsServlet", value = "/products")
public class ProductsServlet extends HttpServlet {


    //Fallo el commit, comment para poder hacerlo otra vez
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> products = new LinkedList<>(new ProductsService().getProducts());
        List<String> storeProducts = new LinkedList<>();
        for (Product product : products) {
            storeProducts.add(product.getName());
        }
        request.setAttribute("storeProducts",storeProducts);
        //No hay productos asi que lo cogemos de la base de datos.
        getServletContext().getRequestDispatcher("/products-view.jsp").forward(request, response);

//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<HTML>");
//        out.println("<HEAD><TITLE>Tienda SDI: Cesta de la compra</TITLE></HEAD>");
//        out.println("<BODY>");
//        out.println(shoppingCartToHtml(cart) + "<br>");
//        //out.println("<a href=\"shop.html\">Volver</a></BODY></HTML>");
//        out.println("<a href=\"index.jsp\">Volver</a></BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
