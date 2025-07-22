package com.jh.picturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jh.picturebackend.model.dto.picture.*;
import com.jh.picturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jh.picturebackend.model.entity.User;
import com.jh.picturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author jh
 * @description 针对表【picture(图片)】的数据库操作Service
 * @createDate 2025-07-13 19:40:07
 */
public interface PictureService extends IService<Picture>
{
    /**
     * 上传图片
     *
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    void deletePicture(long pictureId, User loginUser);

    void editPicture(PictureEditRequest pictureEditRequest, User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser);

    /**
     * 删除图片
     * @param oldPicture
     */
    void clearPictureFile(Picture oldPicture);

    /**
     * 校验空间图片的权限
     *
     * @param loginUser
     * @param picture
     */
    void checkPictureAuth(User loginUser, Picture picture);

    List<PictureVO> searchPictureByColor(Long spaceId, String picColor, User loginUser);

    void editPictureByBatch(PictureEditByBatchRequest pictureEditByBatchRequest, User loginUser);


}
