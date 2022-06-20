package professor.marcomaddo.appminhaideia.controller;

import android.util.Log;

import professor.marcomaddo.appminhaideia.core.AppUtil;
import professor.marcomaddo.appminhaideia.model.Cliente;

public class ClienteController {
    String versaoApp;

    public ClienteController() {

        this.versaoApp = AppUtil.versaoDoAplicativo();
        Log.i(AppUtil.TAG, "ClienteController: "+versaoApp);
    }
}
