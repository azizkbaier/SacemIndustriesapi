package sacembackned.com.services;

import java.util.List;


import sacembackned.com.entity.assistance;
public interface assistanceservice {
	assistance addassistance(assistance a);
	 List<assistance> getallassistance();
}
