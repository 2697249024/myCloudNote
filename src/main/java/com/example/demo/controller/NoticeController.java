package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Notice;
import com.example.demo.eumns.ResponseEumn;
import com.example.demo.service.NoticeService;
import com.example.demo.service.impl.NoticeServiceImpl;
import com.example.demo.vo.ResponseDTO;

@Controller
public class NoticeController {
	
	private static final Logger log =LoggerFactory.getLogger(NoticeServiceImpl.class);
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	RedisTemplate redisTemplate;
	
	/***
	 *  公告查询
	 * @param type
	 * 	0  站点公告
	 *  1 置顶公告 
	 * @return 
	 */
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/selectNoticeByType",method = RequestMethod.POST)
	public ResponseDTO<Notice> selectNoticeByType(Integer type){
		
		Notice selectNoticeByType = noticeService.selectNoticeByType(type);
		if(selectNoticeByType != null) {
			return ResponseDTO.buildSuccessMsg(selectNoticeByType, ResponseEumn.SUCCESS.getDesc());
		}
		//查询结果为null 返回错误
		return ResponseDTO.buildFailure(ResponseEumn.ERROE.getDesc());
	}
	/***
	 * 	第一次进入主页时会查询数据库 并将数据存入redis 设置过期时间5分钟
	 * 	之后重复进入主页 ajax请求数据从redis中获取
	 * 	如果redis 过期 则重新从数据库中查询后放入redis中
	 *  关闭网页后sessionStorage清空则whetherFirstStop为空
	 * @param whetherFirstStop
	 * 		等于1时 表示第一次登录
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/selectaAllNotice",method = RequestMethod.POST)
	public ResponseDTO<List<Notice>> selectaAllNotice(String whetherFirstStop){
		log.info("whetherFirstStop----->:"+whetherFirstStop);
		//判断当whetherFirstStop 不为空 时 请求redis 缓存数据
		if(!StringUtils.isEmpty(whetherFirstStop)) {
			List<Notice> selectaAllNotice = (List<Notice>) redisTemplate.opsForValue().get("selectaAllNotice");
			if(!StringUtils.isEmpty(selectaAllNotice)) {
				return ResponseDTO.buildSuccessMsg(selectaAllNotice, ResponseEumn.SUCCESS.getDesc());
			}			
			//为空说明redis数据为空
			//重新查询数据库
			log.info("-->selectaAllNotice redis数据为空重新查询数据库");
			selectaAllNotice = noticeService.selectaAllNotice();
			if(!StringUtils.isEmpty(selectaAllNotice)) {
				//将查询数据更新至redis数据库中
				try {
					redisTemplate.opsForValue().set("selectaAllNotice", selectaAllNotice,5, TimeUnit.MINUTES);
					return ResponseDTO.buildSuccessMsg(selectaAllNotice, ResponseEumn.SUCCESS.getDesc());
				} catch (Exception e) {
					log.error("selectaAllNotice----> redis异常");
					e.printStackTrace();
				}
			}
			return ResponseDTO.buildFailure("网络错误 ，请关闭浏览器重试");
		}else {
			//whetherFirstStop为空 查询数据库
			List<Notice> selectaAllNotice = noticeService.selectaAllNotice();
			if(!StringUtils.isEmpty(selectaAllNotice)) {
				//将查询数据更新至redis数据库中
				try {
					redisTemplate.opsForValue().set("selectaAllNotice", selectaAllNotice, 5, TimeUnit.MINUTES);
					return ResponseDTO.buildSuccessMsg(selectaAllNotice, ResponseEumn.SUCCESS.getDesc());
				} catch (Exception e) {
					log.error("selectaAllNotice----> redis异常");
					e.printStackTrace();
				}
			}
			//查询结果为null 返回错误
			return ResponseDTO.buildFailure(ResponseEumn.ERROE.getDesc());
			
		}
		
	}
	
	
	
	
}
