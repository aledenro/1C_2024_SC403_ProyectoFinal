package com.cookiesbysu.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "cookies-by-su.appspot.com"; //gs://cookies-by-su.appspot.com

    final String rutaSuperiorStorage = "cookies_by_Su";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "cookies-by-su-firebase-adminsdk-a6ofo-0504a117e0.json";
}
