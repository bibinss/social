package com.video.social.service;

import com.clickntap.vimeo.Vimeo;
import com.clickntap.vimeo.VimeoResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class VideoService {

    public void upload(MultipartFile file) {
        Vimeo vimeo = new Vimeo("");
        try {
            boolean upgradeTo1080 = true;
            String videoEndPoint = vimeo.addVideo(file.getBytes(), upgradeTo1080);

            //get video info
            VimeoResponse info = vimeo.getVideoInfo(videoEndPoint);
            System.out.println(info);

            //edit video
            String name = "Home Stay in Kerala";
            String desc = "My home in Kerala";
            String license = ""; //see Vimeo API Documentation
            String privacyView = "disable"; //see Vimeo API Documentation
            String privacyEmbed = "whitelist"; //see Vimeo API Documentation
            boolean reviewLink = false;
            vimeo.updateVideoMetadata(videoEndPoint, name, desc, license, privacyView, privacyEmbed, reviewLink);

            //add video privacy domain
            //vimeo.addVideoPrivacyDomain(videoEndPoint, "clickntap.com");

            //delete video
            //vimeo.removeVideo(videoEndPoint);
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
