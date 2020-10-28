package com.video.social.dataaccess;

import com.video.social.entity.Video;
import reactor.core.publisher.Flux;

public interface VideoRepository {
    Flux<Video> findAll();
}
