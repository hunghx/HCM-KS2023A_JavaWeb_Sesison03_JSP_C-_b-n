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
@MultipartConfig( // cấu hình file upload
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 2 * 1024 * 1024,
        maxRequestSize = 20 * 1024 * 1024
)
@WebServlet("/customer") // định nghĩa đường dân cho Servlet
public class CustomerServlet extends HttpServlet {
    private static final CustomerService customerService = new CustomerService(); // khai báo customer service
    private static final CloudService cloudService = CloudService.getInstance(); // khai báo cloud service
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action"); // lấy ra tham số action để diều hướng
        if (action!=null){
            switch (action){
                case "GETALL": // hiê thị danh sách
                    req.setAttribute("customers", customerService.findAll());
                    req.getRequestDispatcher("/views/customer/list-customer.jsp").forward(req,resp); // chuyển tiếp yêu cầu tới trang jsp
                    break;
                case "DELETE": { // xóa theo id
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    customerService.deleteById(id);
                    // sau khi xóa xong
                    resp.sendRedirect(req.getContextPath()+"/customer?action=GETALL"); // điều hướng theo đường dẫn
                }
                break;
                case "NEW": // hiển thị form thêm mới
                    req.getRequestDispatcher("/views/customer/add-customer.jsp").forward(req,resp);
                    break;
                case "EDIT": {
                    Integer id = Integer.parseInt(req.getParameter("id"));
                    Customer cus = customerService.findById(id);
                    req.setAttribute("customer", cus);
                    req.getRequestDispatcher("/views/customer/edit-customer.jsp").forward(req,resp); // chuyển tiếp yêu cầu tới trang jsp
                }
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
                case "UPDATE":
                {
                    // lấy dữ liệu từ form
                    Integer id = Integer.valueOf(req.getParameter("id"));
                    String name = req.getParameter("name");
                    String phone = req.getParameter("phone");
                    String email = req.getParameter("email");
                    String address = req.getParameter("address");
                    Part file = req.getPart("avatar");
                    // xử lý upload v trả về đường dẫn
                    String avatar = cloudService.uploadFile(file);

                    Customer customer = new Customer(id, name,address,phone,email, avatar);
                    customerService.save(customer);
                    resp.sendRedirect(req.getContextPath()+"/customer?action=GETALL");
                    break;
                }
            }
        }
    }
}
