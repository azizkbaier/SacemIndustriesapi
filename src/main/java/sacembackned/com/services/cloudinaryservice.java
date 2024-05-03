package sacembackned.com.services;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class cloudinaryservice {
    Cloudinary cloudinary;

    public cloudinaryservice() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name", "dkxksx6h9");
        valuesMap.put("api_key", "481187792333638");
        valuesMap.put("api_secret", "XjS8p1MyMOMhiqitrhjhS--Gy_c");
        cloudinary = new Cloudinary(valuesMap);
    }


    @SuppressWarnings("rawtypes")
    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        if (!Files.deleteIfExists(file.toPath())) {
            throw new IOException("Failed to delete temporary file: " + file.getAbsolutePath());
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    public Map delete(String id) throws IOException {
        return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

}
