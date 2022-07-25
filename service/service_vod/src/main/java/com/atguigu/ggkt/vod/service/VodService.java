package com.atguigu.ggkt.vod.service;

public interface VodService {
    String updateVideo();

    void removeVideo(String fileId);

    Object getPlayAuth(Long courseId, Long videoId);
}
