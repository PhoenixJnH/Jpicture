package com.jh.picturebackend.api.imagesearch;

import com.jh.picturebackend.api.imagesearch.model.ImageSearchResult;
import com.jh.picturebackend.api.imagesearch.sub.GetImageFirstUrlApi;
import com.jh.picturebackend.api.imagesearch.sub.GetImageListApi;
import com.jh.picturebackend.api.imagesearch.sub.GetImagePageUrlApi;

import java.util.List;

public class ImageSearchApiFacade
{
    /**
     * 搜索图片
     *
     * @param imageUrl
     * @return
     */
    public static List<ImageSearchResult> searchImage(String imageUrl)
    {
        String imagePageUrl = GetImagePageUrlApi.getImagePageUrl(imageUrl);
        String imageFirstUrl = GetImageFirstUrlApi.getImageFirstUrl(imagePageUrl);
        return GetImageListApi.getImageList(imageFirstUrl);
    }

}
