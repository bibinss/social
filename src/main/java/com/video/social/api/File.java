package com.video.social.api;

import lombok.Data;

@Data
public class File {
    private String url;
    private FileUploadStatus fileUploadStatus;
    private FileType fileType;
}
