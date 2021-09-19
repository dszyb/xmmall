package com.zyb.xmmall.service;

import com.zyb.xmmall.dao.ReceiverDao;
import com.zyb.xmmall.entity.Receiver;
import com.zyb.xmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ReceiverServiceImpl implements ReceiverService{

    @Resource
    private ReceiverDao receiverDao;

    @Override
    public ResultVO selectAll() {
        List<Receiver> list = receiverDao.selectAll();
        if (list!=null){
            return new ResultVO(10000,"成功",list);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO selectByUId(int usersId) {
        List<Receiver> receiverList = receiverDao.selectByUId(usersId);
        if (receiverList!=null){
            return new ResultVO(10000,"成功",receiverList);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO insertReceiver(int usersId, String receiverName, String receiverPhone, String receiverProvince, String receiverCity, String receiverDistrict, String receiverAddress) {
        int i = receiverDao.insertReceiver(usersId, receiverName, receiverPhone, receiverProvince, receiverCity, receiverDistrict, receiverAddress);
        if (i==1){
            return new ResultVO(10000,"成功",null);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

    @Override
    public ResultVO updateReceiver(String receiverName, String receiverPhone, String receiverProvince, String receiverCity, String receiverDistrict, String receiverAddress, int receiverId) {
        int i = receiverDao.updateReceiver(receiverName, receiverPhone, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverId);
        if (i==1){
            return new ResultVO(10000,"成功",null);
        }else {
            return new ResultVO(10001,"失败",null);
        }
    }

}
