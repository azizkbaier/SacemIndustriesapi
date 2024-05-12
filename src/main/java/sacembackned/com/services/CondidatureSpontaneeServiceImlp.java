package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.condidaturespontanee;
import sacembackned.com.repository.condidaturespontaneerepository;

@Service
public class CondidatureSpontaneeServiceImlp implements condidaturespontaneeservice {

    @Autowired
    condidaturespontaneerepository csrep;

    @Override
    public condidaturespontanee addCondidature(condidaturespontanee cs) {
        csrep.save(cs);
        return cs;
    }

    @Override
    public void deleteCondidature(Long id) {
        csrep.deleteById(id);
    }

    @Override
    public List<condidaturespontanee> getAllcondidatures() {
        List<condidaturespontanee> CSList = csrep.findAll();
        return CSList;
    }

    @Override
    public Optional<condidaturespontanee> getCondidature(Long id) {
        Optional<condidaturespontanee> CS = csrep.findById(id);
        return CS;
    }

}
