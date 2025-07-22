package com.jh.picturebackend.api.imagesearch.model;

import lombok.Data;

/**
 * 以图搜图
 */
@Data
public class ImageSearchResult {

    /**
     * 缩略图地址
     */
    private String thumbUrl;

    /**
     * 来源地址
     */
    private String fromUrl;
}