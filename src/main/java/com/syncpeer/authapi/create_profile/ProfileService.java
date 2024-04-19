package com.syncpeer.authapi.create_profile;

import com.syncpeer.authapi.auth.repository.UserRepository;
import com.syncpeer.authapi.create_profile.exceptions.EmptyImageException;
import com.syncpeer.authapi.model.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {

    private final UserRepository userRepository;

    public Boolean addImageToProfile(String email, MultipartFile file) throws EmptyImageException {
        if (file.isEmpty()) {
            throw new EmptyImageException("The profile photo for: " + email + " is empty!");
        }
        String path = saveFileToLocal(file);
        if (path != null) {
            UserModel user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User with the email: " + email + " cannot be found!"));
            user.setImageUri(path);
            userRepository.save(user);
        } else {
            return false;
        }
        return true;
    }

    private String saveFileToLocal(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();

            // Define the directory where you want to save the uploaded file
            String uploadDir = "D:\\licenta\\auth-api\\target\\test_image\\";

            // Create the directory if it doesn't exist
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Generate a unique filename for the uploaded file
            String filename = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, filename);

            // Save the uploaded file to the specified path
            Files.write(filePath, bytes);
            return uploadDir + filename;
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }

    }
}
