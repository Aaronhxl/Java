package com.hellobike.dao;

import com.hellobike.domain.Record;
import com.hellobike.domain.ResultRecord;
import com.hellobike.domain.UserCollectRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserCollectRecordDao {

    /**
     * 根据用户ID查询其对应的收藏记录，可能有多条
     * @param user_id
     * @return
     */
    List<UserCollectRecord> findUserRecordByUserId(Integer user_id);

    /**
     * 插入一条用户收藏信息，传入参数为UserCollectRecord对象
     * @param userCollectRecord
     */
    void insertUserCollectRecord(UserCollectRecord userCollectRecord);

    /**
     * 根据用户收藏记录查询该记录的ID（唯一主键），用于在插入之前使用，判断是否数据库已经有该记录
     * @param record
     * @return
     */
    Integer findIdByRecord(UserCollectRecord record);

    /**
     * 根据用户收藏记录来删除该条记录
     * @param record
     */
    void deleteRecordByRecord(UserCollectRecord record);

    /**
     * 根据用户ID查询其收藏的全部记录
     * @param userId
     * @return
     */
    List<ResultRecord> selectUserCollectRecordByUserId(Integer userId);

}
