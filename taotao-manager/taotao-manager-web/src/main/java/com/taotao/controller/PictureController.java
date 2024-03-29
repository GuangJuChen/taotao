package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/**
 * 
 * @ClassName: PictureController
 * @Description: 上传图片处理
 * @author chenguangju
 * @date 2019年10月17日
 *
 */
@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;
	
	/**
	 * 
	 * @Title: pictureUpload
	 * @Description: 图片上传
	 * @param  uploadFile
	 * @return String
	 * @throws
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
