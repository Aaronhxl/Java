package com.hellobike.service.Impl;

import com.hellobike.dao.IUserCollectRecordDao;
import com.hellobike.domain.Record;
import com.hellobike.domain.ResultRecord;
import com.hellobike.domain.UserCollectRecord;
import com.hellobike.service.IUserCollectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectRecordServiceImpl implements IUserCollectRecordService {

    @Autowired
    private IUserCollectRecordDao userCollectRecordDao;

    @Override
    public void insertUserCollectRecord(UserCollectRecord userCollectRecord) {
        if(userCollectRecordDao.findIdByRecord(userCollectRecord) == null)
        userCollectRecordDao.insertUserCollectRecord(userCollectRecord);
    }

    @Override
    public Integer findIdByRecord(UserCollectRecord record) {
        return userCollectRecordDao.findIdByRecord(record);
    }

    @Override
    public void deleteRecordByRecord(UserCollectRecord record) {
        userCollectRecordDao.deleteRecordByRecord(record);
    }

    @Override
    public List<ResultRecord> selectUserCollectRecordByUserId(Integer userId) {
        return userCollectRecordDao.selectUserCollectRecordByUserId(userId);
    }
}
