package com.itron.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itron.dao.BaseDaoI;
import com.itron.model.Message;
import com.itron.receive.Rmessage;
import com.itron.service.MessageServiceI;

@Transactional
@Service("messageService")
public class MessageServiceImpl implements MessageServiceI {

	@Resource
	private BaseDaoI<Message> baseDao;

	@Override
	public void msgSub(Rmessage rmessage) {
		Message message = new Message();
		message.setMsgContent(rmessage.getMsgContent());
		message.setMsgId(rmessage.getMsgId());
		message.setMsgIp(rmessage.getMsgIp());
		message.setMsgName(rmessage.getMsgName());
		message.setMsgPhone(rmessage.getMsgPhone());
		message.setMsgTime(rmessage.getMsgTime());
		baseDao.save(message);
	}

}
