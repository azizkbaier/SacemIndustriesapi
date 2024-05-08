package sacembackned.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import sacembackned.com.entity.file; // Renamed entity class to "file" for broader scope
import sacembackned.com.services.cloudinaryservice;
import sacembackned.com.services.fileservice; // Renamed service interface

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sacemindustrieplatform")
@CrossOrigin("*")
public class cloudinarycontroller {

    @Autowired
    cloudinaryservice cloudinaryService;

    @Autowired
    fileservice fileService; // Renamed service interface

    @GetMapping("/list")
    public ResponseEntity<List<file>> list() {
        List<file> list = fileService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/upload")
    @ResponseBody
    public  Map<String, String> upload(@RequestBody MultipartFile file) throws IOException {
        System.out.println(file);
        @SuppressWarnings("unchecked")
        Map<String, Object> result = cloudinaryService.upload(file);
        file uploadedFile = new file(
                (String) result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"));
        fileService.save(uploadedFile);
        Map<String, String> url = new HashMap<>();
        url.put("url", (String) result.get("url"));

        return (url);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<file> fileOptional = fileService.getOne(id);
        if (fileOptional.isEmpty()) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
        file uploadedFile = fileOptional.get();
        String cloudinaryFileId = uploadedFile.getFileId();
        try {
            cloudinaryService.delete(cloudinaryFileId);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to delete file from Cloudinary", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        fileService.delete(id);
        return new ResponseEntity<>("File deleted!", HttpStatus.OK);
    }
}
