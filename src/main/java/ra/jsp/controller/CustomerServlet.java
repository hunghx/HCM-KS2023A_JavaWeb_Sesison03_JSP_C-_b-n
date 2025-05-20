package ra.jsp.controller;

import ra.jsp.model.Customer;
import ra.jsp.service.CloudService;
import ra.jsp.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 2 * 1024 * 1024,
        maxRequestSize = 20 * 1024 * 1024
)@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private static final CustomerService customerService = new CustomerService();
    private static final CloudService cloudService = CloudService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action!=null){
            switch (action){
                case "GETALL":
                    req.setAttribute("customers", customerService.findAll());
                    req.getRequestDispatcher("/views/customer/list-customer.jsp").forward(req,resp);
                    break;
                case "DELETE": {
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    customerService.deleteById(id);
                    // sau khi xóa xong
                    resp.sendRedirect(req.getContextPath()+"/customer?action=GETALL");
                    break;
                }
                case "NEW":
                    req.getRequestDispatcher("/views/customer/add-customer.jsp").forward(req,resp);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action!=null){
            switch (action){
                case "ADD":
                {
                    // lấy dữ liệu từ form
                    String name = req.getParameter("name");
                    String phone = req.getParameter("phone");
                    String email = req.getParameter("email");
                    String address = req.getParameter("address");
                    Part file = req.getPart("avatar");
                    // xử lý upload v trả về đường dẫn
                    String avatar = cloudService.uploadFile(file);

                    Customer customer = new Customer(0, name,address,phone,email, avatar);
                    customerService.save(customer);
                    resp.sendRedirect(req.getContextPath()+"/customer?action=GETALL");
                    break;
                }
            }
        }
    }
}
