package de.fhro.inf.prg3.a11.openmensa;

import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * OpenMensaAPI service
 * holds an instance of OpenMensaAPI to avoid multiple instantiations of the API
 * @author Peter Kurfer
 */

public final class OpenMensaAPIService {

    /* singleton instance */
    private static final OpenMensaAPIService ourInstance = new OpenMensaAPIService();
    private final OpenMensaAPI openMensaAPI;

    /* singleton accessor */
    public static OpenMensaAPIService getInstance() {
        return ourInstance;
    }

    private OpenMensaAPIService() {

        /* Initialize Retrofit */
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .baseUrl("http://openmensa.org/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        openMensaAPI = retrofit.create(OpenMensaAPI.class);
    }

    public OpenMensaAPI getOpenMensaAPI() {
        return openMensaAPI;
    }
}
