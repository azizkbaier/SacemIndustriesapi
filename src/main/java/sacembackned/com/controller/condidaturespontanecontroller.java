package sacembackned.com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import sacembackned.com.entity.condidaturespontane;
import sacembackned.com.entity.cv;
import sacembackned.com.repository.cvrepository;
import sacembackned.com.services.condidaturespontaneservice;

@RestController
@CrossOrigin("*")
@RequestMapping("/sacemindustrieplatform/api")
public class condidaturespontanecontroller {
    @Autowired
    condidaturespontaneservice condidaturespontaneservice;
	@Autowired
	cvrepository cvrepository;

    
    @GetMapping("/allcondidaturespontane")
	@ResponseBody
	public ResponseEntity<?> getallcondidaturespontane() {
		
	    List<condidaturespontane> list = condidaturespontaneservice.getallcondidaturespontane();
	    
	    if (list.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("La liste des condidaturespontanes est vide.");
	    } else {
	        return ResponseEntity.ok(list);
	    }
	}

	@PostMapping("/addcondidaturespontane")
	@ResponseBody
	public ResponseEntity<?> addcondidaturespontane(@RequestParam("file") MultipartFile file,
	  @RequestParam("civilite") String civilite,
	@RequestParam("nometprenom") String nometprenom,
	@RequestParam("datedenaissance") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datedenaissance,
	@RequestParam("email") String email,
	@RequestParam("adresse") String adresse,
	@RequestParam("codepostal") int codepostal,
	@RequestParam("ville") String ville,
	@RequestParam("telephone") int telephone,
	@RequestParam("niveaudediplome") String niveaudediplome,
	@RequestParam("intituledediplome") String intituledediplome) {

cv cv=condidaturespontaneservice.savefile(file);

		condidaturespontane	cs= new condidaturespontane(civilite, nometprenom, datedenaissance, email, adresse, codepostal, ville, telephone, niveaudediplome, intituledediplome) ;
		 cs.setCv(cv);

	     condidaturespontaneservice.addcondidaturespontane(cs);
		 return ResponseEntity.status(HttpStatus.CREATED).body(cs);
		 }

	 @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            cv cv = new cv();
            cv.setName(file.getOriginalFilename());
            cv.setData(file.getBytes());
            this.cvrepository.save(cv);

            return "File uploaded successfully: " + file.getOriginalFilename();
        } catch (Exception e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }
}
