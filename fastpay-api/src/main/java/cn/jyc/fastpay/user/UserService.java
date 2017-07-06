package cn.jyc.fastpay.user;

import com.weibo.api.motan.transport.async.MotanAsync;

@MotanAsync
public interface UserService {

	String getName(String name);
}
