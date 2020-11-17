package com.video.social.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class FilesGetResult {
    private List<File> files;
    private ResponseStatus responseStatus;
}
