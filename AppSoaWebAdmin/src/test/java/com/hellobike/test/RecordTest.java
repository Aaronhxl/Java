package com.hellobike.test;

import com.hellobike.domain.Record;
import com.hellobike.domain.ResultRecord;
import com.hellobike.service.IUserCollectRecordService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecordTest {
    @Autowired
    private IUserCollectRecordService userCollectRecordService;

    /**
     * 单元测试测不了spring的东西
     */
    @Test
    public void testSelectUserRecordByUserId(){
        List<ResultRecord> records = userCollectRecordService.selectUserCollectRecordByUserId(1);
        for (ResultRecord record : records) {
            System.out.println(record);
        }
    }
}
