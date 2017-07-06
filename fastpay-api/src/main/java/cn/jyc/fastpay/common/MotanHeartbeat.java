package cn.jyc.fastpay.common;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

public class MotanHeartbeat implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {// root application context 没有parent，他就是老大.
			// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
			MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
		}

	}
	
	public void breakdown() {
		MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, false);
    }

}
