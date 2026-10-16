
package tn.enicarthage.banque;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "BanqueWSSOAP")
public class BanqueService {

    private final List<Compte> comptes = new ArrayList<>();

    // Constructor: initialize sample bank accounts
    public BanqueService() {
        comptes.add(new Compte(1, 1500.0, new Date()));
        comptes.add(new Compte(2, 3200.0, new Date()));
        comptes.add(new Compte(3, 4500.0, new Date()));
    }

    // Convert Tunisian dinars (TND) to euros (EUR)
    @WebMethod
    public double convert(double montant) {
        // Example rate: 1 EUR = 3.4 TND
        return montant / 3.4;
    }

    // Retrieve one account using its ID
    @WebMethod
    public Compte getCompte(int id) {
        for (Compte compte : comptes) {
            if (compte.getCode() == id) {
                return compte;
            }
        }

        return null;
    }

    // Retrieve all bank accounts
    @WebMethod
    public List<Compte> getComptes() {
        return comptes;
    }
}
