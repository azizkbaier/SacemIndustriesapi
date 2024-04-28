package sacembackned.com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sacembackned.com.entity.transformateur;
import sacembackned.com.repository.transformateurrepository;

@Service
public class transformateurserviceimplement implements transformateurservice {

    @Autowired
    private transformateurrepository transformateurrepository;

    @Override
    public transformateur addtransformateur(transformateur t) {
         transformateurrepository.save(t);
         return t;
    }

    @Override
    public List<transformateur> getalltTransformateurs() {
        return transformateurrepository.findAll();
    }

    @Override
    public transformateur updatetransformateur(Long id, transformateur t) {
        Optional<transformateur> existingtransformateurOptional = transformateurrepository.findById(id);
        if (existingtransformateurOptional.isPresent()) {
            transformateur existingtransformateur = existingtransformateurOptional.get();
            existingtransformateur.setNomtransformateur(t.getNomtransformateur());
            existingtransformateur.setDescription(t.getDescription());
            existingtransformateur.setPathimage(t.getPathimage());
            existingtransformateur.setPathdetailstechnique(t.getPathdetailstechnique());
            existingtransformateur.setType(t.getType());
            existingtransformateur.setPuissance(t.getPuissance());
            return transformateurrepository.save(existingtransformateur);
        } else {
            // Gérer le cas où l'ID n'existe pas
            return null;
        }
    }

    @Override
    public void deletetransformateur(Long id) {
        transformateurrepository.deleteById(id);
    }

    @Override
    public transformateur gettransformateurById(Long id) {
        Optional<transformateur> transformateurOptional = transformateurrepository.findById(id);
        return transformateurOptional.orElse(null);
    }
}
