package sacembackned.com.services;
import java.util.List;

import sacembackned.com.entity.transformateur;

public interface transformateurservice {
 transformateur addtransformateur(transformateur t);
 List<transformateur> getalltTransformateurs();
 transformateur updatetransformateur(Long id, transformateur t);
    void deletetransformateur(Long id);
    transformateur gettransformateurById(Long id);
 
}
