package sacembackned.com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.condidaturespontane;
import sacembackned.com.repository.condidaturespontanerepository;

@Service
public class condidaturespontaneimplement implements condidaturespontaneservice  {
    @Autowired
    condidaturespontanerepository condidaturespontanerepository;
@Override
public condidaturespontane addcondidaturespontane(condidaturespontane c){
         condidaturespontanerepository.save(c);
         return c ;
    }

    @Override
    public List <condidaturespontane> getallcondidaturespontane(){
         return (List<condidaturespontane>) condidaturespontanerepository.findAll();
    }
}
