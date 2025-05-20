package ra.jsp.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Map;

public class CloudService {
    private static CloudService instance = new CloudService();
    private static final String CLOUD_NAME = "dwqmfiprt";
    private static final String API_KEY = "547165255154353";
    private static final String API_SECRET = "vzEY6Tk0t_mKQw3V5yfDB0F1LPI";
    private Cloudinary cloudinary;
    public void initCloudinary() {
       this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET));
    }
    private CloudService(){
        initCloudinary();
    }

    public static CloudService getInstance() {
        return instance;
    }

    // phuong thuc xu li upload
    public String uploadFile(Part file) throws IOException {

        try {
            // Sử dụng phương thức upload để gửi file lên Cloudinary
            Map uploadResult = cloudinary.uploader().upload(file.getInputStream().readAllBytes(), ObjectUtils.emptyMap());
            // Lấy ra đường dẫn truy cập
            String secureUrl = (String) uploadResult.get("secure_url");
            if (secureUrl == null || secureUrl.isEmpty()) {
                throw new IOException("Secure URL not found in Cloudinary upload response");
            }
            return secureUrl;
        } catch (IOException e) {
            // Log lỗi hoặc xử lý ngoại lệ theo ý của bạn
            e.printStackTrace();
            throw new IOException("Could not upload file to Cloudinary", e);
        }
    }
}
