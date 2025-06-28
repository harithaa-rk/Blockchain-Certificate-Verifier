package service;

import model.Certificate;

import java.util.HashMap;
import java.util.Map;

public class CertificateStorage {
    private static Map<String, Certificate> storage = new HashMap<>();

    public static void store(Certificate certificate) {
        storage.put(certificate.getId(), certificate);
    }

    public static boolean verify(String id, String hash) {
        Certificate cert = storage.get(id);
        return cert != null && cert.getHash().equals(hash);
    }

    public static Certificate get(String id) {
        return storage.get(id);
    }
}
