/*
 * Copyright 2009-2016 Weibo, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package cn.jyc.fastpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jyc.fastpay.demo.DemoService;

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;

@Controller
public class DemoController {

	@MotanReferer
	DemoService iDemoService;
	
	@Autowired
	cn.jyc.fastpay.service.DemoService demoService;
	
    @RequestMapping("/test")
    @ResponseBody
    public String home() {
    	/*可以直接调用service（用于服务拆分的过渡）*/
//    	demoService.demo("abc");
        return iDemoService.demo("abc");
    }
}
