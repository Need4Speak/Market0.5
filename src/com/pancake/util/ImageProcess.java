/**   
* @Title: ImageProcess.java 
* @Package com.pancake.util 
* @Description: TODO 
* @author zhangchao zcsd2668@163.com   
* @date 2017年5月17日 上午10:31:18 
* @version V1.0   
*/
package com.pancake.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import com.pancake.controller.GoodController;
import com.pancake.entity.GoodWithImage;

/**
 * @ClassName: ImageProcess
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chao zcsd2668@163.com
 * @date 2017年5月17日 上午10:31:18
 *
 */
public class ImageProcess {
	private static final Log logger = LogFactory.getLog(ImageProcess.class);

	public static List<String> storeImage(GoodWithImage good, HttpSession session, HttpServletRequest servletRequest) {
		// 上传图片到服务器
		List<MultipartFile> files = good.getPictures();

		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileName = GetTime.getTimeForPic() + "." + fileName.split("[.]")[fileName.split("[.]").length - 1];
				fileNames.add(fileName);
				String imagesDir = servletRequest.getServletContext().getRealPath("/images");
				String userName = ((String) session.getAttribute("userName")).trim();
				String picStoreDir = servletRequest.getServletContext()
						.getRealPath("/images/" + userName + "/goodPics");
				FilePath.isExistDir(picStoreDir);

				logger.info("images path: " + servletRequest.getServletContext().getRealPath("/images"));
				File imageFile = new File(picStoreDir, fileName);
				try {
					multipartFile.transferTo(imageFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileNames;
	}
}
