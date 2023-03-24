package com.lengdi.api.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date:2023/03/11/ 15:34
 * Author:leng
 * Description:
 */
@Service
public class SendMsgToMQService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String orderId){
        amqpTemplate.convertAndSend("ex6","key1",orderId);
    }

}
