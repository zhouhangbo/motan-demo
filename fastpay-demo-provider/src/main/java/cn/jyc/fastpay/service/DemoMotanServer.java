package cn.jyc.fastpay.service;

import org.springframework.context.annotation.Bean;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import com.weibo.api.motan.util.MotanSwitcherUtil;

/**
 * @author zhouhb
 * 可以对照各个配置对象内的字段，调整相应的配置
 */
@Deprecated
public class DemoMotanServer {

	@Bean
    public AnnotationBean motanAnnotationBean() {
        AnnotationBean motanAnnotationBean = new AnnotationBean();
        motanAnnotationBean.setPackage("cn.jyc.fastpay.impl");
        return motanAnnotationBean;
    }

    @Bean(name = "demoMotan")
    public ProtocolConfigBean protocolConfig1() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        config.setDefault(true);
        config.setName("motan");
        config.setMaxContentLength(1048576);
        config.setRequestTimeout(3000);
        return config;
    }

    @Bean(name = "registryConfig1")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
        config.setRegProtocol("consul");
        config.setAddress("127.0.0.1:8500");
        return config;
    }

    @Bean
    public BasicServiceConfigBean baseServiceConfig() {
        BasicServiceConfigBean config = new BasicServiceConfigBean();
        config.setExport("demoMotan:8002");
        config.setGroup("myGroup");
        config.setAccessLog(false);
        config.setShareChannel(true);
        config.setModule("myModule1");
        config.setApplication("myApp1");
        config.setRegistry("registryConfig1");
        return config;
    }
    
    @Bean
    public Object heartbeat() {
    	MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
    	return null;
    }
    
}
