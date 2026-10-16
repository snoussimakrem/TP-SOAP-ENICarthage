
package tn.enicarthage;

import tn.enicarthage.proxy.BanqueService;
import tn.enicarthage.proxy.BanqueWSSOAP;
import tn.enicarthage.proxy.Compte;

public class ClientWS {

    public static void main(String[] args) {

        // Create the SOAP client proxy
        BanqueService stub = new BanqueWSSOAP().getBanqueServicePort();

        // Test 1: Convert 4500 TND to euros
        System.out.println("=== Conversion ===");
        System.out.println(
            "Le montant converti est : " + stub.convert(4500)
        );

        // Test 2: Retrieve account with ID 3
        System.out.println("\n=== Compte ===");
        Compte c = stub.getCompte(3);

        if (c != null) {
            System.out.println("Code : " + c.getCode());
            System.out.println("Solde : " + c.getSolde());
        } else {
            System.out.println("Compte introuvable.");
        }

        // Test 3: List all accounts
        System.out.println("\n=== Tous les comptes ===");
        stub.getComptes().forEach(compte ->
            System.out.println(
                "Code : " + compte.getCode()
                + " | Solde : " + compte.getSolde()
            )
        );
    }
}
