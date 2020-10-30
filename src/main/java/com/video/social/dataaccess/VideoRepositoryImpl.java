package com.video.social.dataaccess;

import com.video.social.entity.Video;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoRepositoryImpl implements VideoRepository {
    private List<Video> videos = getSampleVideos();

    private static List<Video> getSampleVideos() {
        return List.of(
                new Video(1, "Game 1", "/ico/img-1.jpg"),
                new Video(2, "Game 2", "/ico/img-2.jpg"),
                new Video(3, "Game 3", "/ico/img-3.jpg"),
                new Video(4, "Game 4", "/ico/img-4.jpg"),
                new Video(4, "Game 5", "/ico/img-5.jpg"));
    }

//    @Override
//    public Flux<Video> findAllAsynch() {
//        return Flux.fromStream(videos.stream()).delayElements(Duration.ofSeconds(2));
//    }

    @Override
    public List<Video> findAll() {
        return videos;
    }
}
