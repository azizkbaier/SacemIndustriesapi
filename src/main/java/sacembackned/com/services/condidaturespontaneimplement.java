package sacembackned.com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sacembackned.com.entity.condidaturespontane;
import sacembackned.com.entity.cv;
import sacembackned.com.repository.condidaturespontanerepository;
import sacembackned.com.repository.cvrepository;

@Service
public class condidaturespontaneimplement implements condidaturespontaneservice  {
    @Autowired

    condidaturespontanerepository condidaturespontanerepository;
    @Autowired
    cvrepository cvrepository;
@Override
public condidaturespontane addcondidaturespontane(condidaturespontane c){
         condidaturespontanerepository.save(c);
         return c ;
    }
    @Override
    public cv savefile(MultipartFile file ){
        try {
            cv cv = new cv();
            cv.setName(file.getOriginalFilename());
            cv.setData(file.getBytes());
            this.cvrepository.save(cv);
return cv;
        } catch (Exception e) {return null;
        }
    }

    @Override
    public List <condidaturespontane> getallcondidaturespontane(){
         return (List<condidaturespontane>) condidaturespontanerepository.findAll();
    }
}
