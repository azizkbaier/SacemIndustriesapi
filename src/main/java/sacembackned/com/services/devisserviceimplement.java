package sacembackned.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.devis;
import sacembackned.com.repository.devisrepository;

@Service
public class devisserviceimplement implements devisservice {
    
    @Autowired
    private devisrepository repdevis;

    @Override
    public devis adddevis(devis d) {
        repdevis.save(d);
        return d;
    }

    @Override
    public List<devis> getalldevis() {
        return (List<devis>) repdevis.findAll();
    }
}
