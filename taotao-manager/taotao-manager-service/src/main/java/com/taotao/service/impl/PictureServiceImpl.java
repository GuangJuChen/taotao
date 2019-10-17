package com.taotao.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.jcraft.jsch.ChannelSftp;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.SFTPUtil;
import com.taotao.service.PictureService;

/**
 * 
 * @ClassName: PictureServiceImpl
 * @Description: 图片上传服务
 * @author chenguangju
 * @date 2019年10月17日
 *
 */
@Service
public class PictureServiceImpl implements PictureService {
	
	@Value("${SFTP_ADDRESS}")
	private String SFTP_ADDRESS;
	@Value("${SFTP_PORT}")
	private Integer SFTP_PORT;
	@Value("${SFTP_USERNAME}")
	private String SFTP_USERNAME;
	@Value("${SFTP_PASSWORD}")
	private String SFTP_PASSWORD;
	@Value("${SFTP_BASE_PATH}")
	private String SFTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		//生成一个新的文件名
		//取原始文件名
		String oldName = uploadFile.getOriginalFilename();
		//生成新文件名
		//UUID.randomUUID();
		String newName = IDUtils.genImageName();
		newName = newName + oldName.substring(oldName.lastIndexOf("."));
		//图片上传
		String imagePath = new DateTime().toString("/yyyy/MM/dd");
		SFTPUtil sftpUtil = new SFTPUtil();
		ChannelSftp channel = new ChannelSftp(); 
		try {
			sftpUtil.connectServer(SFTP_ADDRESS, SFTP_PORT, SFTP_USERNAME, SFTP_PASSWORD);
			//sftpUtil.createDir("www/images"+imagePath, channel);
			//sftpUtil.uploadFile("www/images"+imagePath+"/"+newName, "D:\\Documents\\Pictures\\images\\img1.jpg");
			//sftpUtil.uploadFile2("www/images"+"/"+newName, "D:\\Documents\\Pictures\\images\\img10.jpg");
			sftpUtil.uploadFile2("www/images"+"/"+newName, uploadFile.getInputStream());
			System.out.println("上传成功");
			sftpUtil.close();
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		} 
		//返回结果，生成一个可以访问到图片的url返回
		resultMap.put("error", 0);
		resultMap.put("url", IMAGE_BASE_URL+newName);
		return resultMap;
	}	

}
