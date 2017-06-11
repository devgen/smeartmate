package de.tum.datax.smeartheartapp.formular;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Devgen on 11.06.2017.
 */

public class FormularRestClientIml {


    private void prepareJsonObject(Formular formular){



        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValueAsBytes(formular);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
