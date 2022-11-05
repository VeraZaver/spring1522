package com.example.spring152.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

@Service
public class FirebaseImageService {
    private Storage storage = StorageOptions.getDefaultInstance().getService();

    public String save(MultipartFile multipartFile){
        try {
            String imageName = String.valueOf(System.currentTimeMillis());
            BlobId blobId = BlobId.of("spring152-4e5ae.appspot.com", imageName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                    .setContentType(multipartFile.getContentType())
                    .build();
            storage = StorageOptions.newBuilder()
                    .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("spring152-4e5ae-firebase-adminsdk-2txtm-239d6ff808.json")))
                    .build()
                    .getService();
            storage.create(blobInfo, multipartFile.getInputStream());
            return imageName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    /*
https://firebasestorage.googleapis.com/v0/b/spring152-4e5ae.appspot.com/o/1667133476217?alt=media&token=7275922e-07f9-4164-82d9-a35760e27b3e*/

    public String getImageUrl(String fileName){
        return "https://firebasestorage.googleapis.com/v0/b/spring152-4e5ae.appspot.com/o/" +fileName + "?alt=media&token=7275922e-07f9-4164-82d9-a35760e27b3e";
    }
}

