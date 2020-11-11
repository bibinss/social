package com.video.social.api;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadVideoForm {
    private MultipartFile file;
}
