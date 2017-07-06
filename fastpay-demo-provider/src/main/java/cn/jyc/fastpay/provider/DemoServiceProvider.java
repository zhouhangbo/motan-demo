package cn.jyc.fastpay.provider;

import javax.annotation.Resource;

import cn.jyc.fastpay.demo.DemoService;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;

/**
 * @author zhouhb
 *  不兼容升级需要修改版本号，默认1.0
 *	@MotanService(version="1.0")
 */
@MotanService
public class DemoServiceProvider implements DemoService {

	@Resource
	private cn.jyc.fastpay.service.DemoService demoService;
	@Override
	public String demo(String name) {
		System.out.println("=***************Hello! " + name + "******************=");
		demoService.demo(name);
		return "Hello! " + name;
	}

}
