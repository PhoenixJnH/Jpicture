package com.jh.picturebackend.controller;

import com.jh.picturebackend.annotation.AuthCheck;
import com.jh.picturebackend.common.BaseResponse;
import com.jh.picturebackend.common.ResultUtils;
import com.jh.picturebackend.constant.UserConstant;
import com.jh.picturebackend.model.dto.picture.PictureUploadRequest;
import com.jh.picturebackend.model.entity.User;
import com.jh.picturebackend.model.vo.PictureVO;
import com.jh.picturebackend.service.PictureService;
import com.jh.picturebackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController
{
    @Resource
    private UserService userService;

    @Resource
    private PictureService pictureService;
    /**
     * 上传图片（可重新上传）
     */
    @PostMapping("/upload")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<PictureVO> uploadPicture(
            @RequestPart("file") MultipartFile multipartFile,
            PictureUploadRequest pictureUploadRequest,
            HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        PictureVO pictureVO = pictureService.uploadPicture(multipartFile, pictureUploadRequest, loginUser);
        return ResultUtils.success(pictureVO);
    }
}
