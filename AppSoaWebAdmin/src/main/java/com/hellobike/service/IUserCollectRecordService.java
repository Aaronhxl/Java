package com.hellobike.service;

import com.hellobike.domain.Record;
import com.hellobike.domain.ResultRecord;
import com.hellobike.domain.UserCollectRecord;

import java.util.List;

public interface IUserCollectRecordService {

    /**
     * 插入用户收藏记录
     * @param userCollectRecord
     */
    void insertUserCollectRecord(UserCollectRecord userCollectRecord);

    /**
     * 根据用户记录查询数据表中对应ID
     * @param record
     * @return
     */
    Integer findIdByRecord(UserCollectRecord record);

    void deleteRecordByRecord(UserCollectRecord record);

    List<ResultRecord> selectUserCollectRecordByUserId(Integer userId);
}
