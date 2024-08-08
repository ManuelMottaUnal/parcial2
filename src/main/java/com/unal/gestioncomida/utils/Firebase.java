package com.unal.gestioncomida.utils;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.unal.zoologico.model.Zoo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Firebase {
    private static Firestore db;
    private static String COLLECTION_NAME = "zoo";
    private static String DOCUMENT_NAME = "zoo";
    public static void initializeApp() {
        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream("zoologico-fe14b-firebase-adminsdk-j634z-04aca10908.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Como que se conectó, creo: ");
            db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Zoo getZoo() throws InterruptedException, ExecutionException {
        ApiFuture<DocumentSnapshot> docSnapshot = db.collection(COLLECTION_NAME).document(DOCUMENT_NAME).get();
        return docSnapshot.get().toObject(Zoo.class);
    }
    
    public static boolean saveMap(String documentName, Map<String, Object> data) {
        try {
            ApiFuture<WriteResult> future = db.collection(COLLECTION_NAME).document(documentName).set(data, SetOptions.merge());
            System.out.println("Registro correctamente actualizado. Tiempo: " + future.get().getUpdateTime());
            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean saveObject(String documentName, Object data) {
        try {
            ApiFuture<WriteResult> future = db.collection(COLLECTION_NAME).document(documentName).set(data, SetOptions.merge());
            System.out.println("Registro correctamente actualizado. Tiempo: " + future.get().getUpdateTime());
            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
