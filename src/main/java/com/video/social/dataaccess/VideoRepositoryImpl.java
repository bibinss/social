package com.video.social.dataaccess;

import com.video.social.entity.Video;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Component
public class VideoRepositoryImpl implements VideoRepository {
    private List<Video> videos = getSampleVideos();

    private static List<Video> getSampleVideos() {
        return List.of(
                new Video(1, "Match 1", "Url"),
                new Video(2, "Match 2", "Url"),
                new Video(3, "Match 3", "Url"),
                new Video(4, "Match 4", "Url"));
    }

    @Override
    public Flux<Video> findAll() {
        return Flux.fromStream(videos.stream()).delayElements(Duration.ofSeconds(2));
    }
}
