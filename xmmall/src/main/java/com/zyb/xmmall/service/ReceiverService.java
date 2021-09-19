package com.zyb.xmmall.service;

import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Component;

@Component
public interface ReceiverService {

    public ResultVO selectAll();

    public ResultVO selectByUId(int usersId);

    public ResultVO insertReceiver(int usersId,String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress);

    public ResultVO updateReceiver(String receiverName,String receiverPhone,String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress,int receiverId);

}
