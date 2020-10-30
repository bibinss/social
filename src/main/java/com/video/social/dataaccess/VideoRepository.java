package com.video.social.dataaccess;

import com.video.social.entity.Video;

import java.util.List;

public interface VideoRepository {
//    Flux<Video> findAllAsynch();
    List<Video> findAll();
}
