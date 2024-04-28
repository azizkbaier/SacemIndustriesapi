package sacembackned.com.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import sacembackned.com.entity.condidaturespontane;
import sacembackned.com.entity.cv;

public interface condidaturespontaneservice  {
    condidaturespontane addcondidaturespontane(condidaturespontane c);
    List <condidaturespontane> getallcondidaturespontane();
    cv savefile(MultipartFile file);

}
