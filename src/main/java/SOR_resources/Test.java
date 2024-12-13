package SOR_resources;

import java.io.FileInputStream;
import java.security.*;
import java.util.Base64;

public class Test {

    // Method to generate a digital signature
    public String signatureGenerate(String incomingPayload) throws Exception {
        String signatureValue = null;

        try {
            // Keystore details
            char[] keyStorePassword = "Admin@1234".toCharArray();
            String certFile = "C:\\Users\\rajendra.mane\\Desktop\\Sor_Report\\SriSudhaBank_DocSign 4.pfx";

            // Load the keystore
            FileInputStream fis = new FileInputStream(certFile);
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(fis, keyStorePassword);

            // Use the known alias "1"
            String alias = "1";
            System.out.println("Using alias: " + alias);

            // Retrieve the private key
            Key key = keyStore.getKey(alias, keyStorePassword);
            if (key instanceof PrivateKey) {
                PrivateKey privateKey = (PrivateKey) key;

                // Initialize signature instance
                Signature sign = Signature.getInstance("SHA256withRSA");
                sign.initSign(privateKey);

                // Update the payload for signing
                sign.update(incomingPayload.getBytes("UTF-8"));

                // Generate the signature
                byte[] signature = sign.sign();
                signatureValue = Base64.getEncoder().encodeToString(signature);

                System.out.println("Generated Signature: " + signatureValue);
            } else {
                throw new KeyStoreException("The retrieved key is not a private key.");
            }

        } catch (Exception e) {
            System.err.println("Error generating signature: " + e.getMessage());
            throw e; // Re-throw the exception after logging it
        }

        return signatureValue;
    }

    // Main method to test the program
    public static void main(String[] args) {
        Test test = new Test();
        // JSON payload to be signed
        String payload = "orgId=200383&txnId=MII98a136fbce3f459a9476bf8f871db696&consentFlag=Yes&mode=SELF&callBackIP=14.140.208.172";

        try {
            String signature = test.signatureGenerate(payload);
            System.out.println("Final Signature: " + signature);
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }
}
