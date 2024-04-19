package com.syncpeer.authapi.create_profile;

import com.syncpeer.authapi.create_profile.exceptions.EmptyImageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.syncpeer.authapi.utils.Constants.API_BASE_PATH;
import static com.syncpeer.authapi.utils.Constants.CREATE_PROFILE;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_BASE_PATH + CREATE_PROFILE)
public class ProfileController {

    private final ProfileService service;

    @PostMapping("/add-image/{email}")
    public ResponseEntity<Boolean> addImageToProfile(@PathVariable String email,
                                                     @RequestParam("profile-image") MultipartFile file) throws EmptyImageException {
        return ResponseEntity.ok(service.addImageToProfile(email, file));
    }
}
