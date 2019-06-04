package com.hellobike.controller;

import com.hellobike.domain.*;
import com.hellobike.service.IInterfaceNameService;
import com.hellobike.service.IMethodNameService;
import com.hellobike.service.IServiceNameService;
import com.hellobike.service.IUserCollectRecordService;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserCollectRecordController {

    @Autowired
    private IServiceNameService serviceNameService;
    @Autowired
    private IInterfaceNameService interfaceNameService;
    @Autowired
    private IMethodNameService methodNameService;
    @Autowired
    private IUserCollectRecordService userCollectRecordService;

    /**
     * 根据传入的记录信息返回记录在数据库实际的记录信息
     * @param record
     * @return
     */
    public UserCollectRecord findUserCollectRecordByRecord(Record record){

        //数据封装
        ServiceName serviceName = record.getServiceName();
        String interface_name = record.getInterfaceName();
        String method_name = record.getMethodName();
        String params = record.getParams();
        String result_params = record.getResultParams();
        Integer user_id = record.getUserId();

        //插入数据，后台会自动判断数据库是否已经存在相应数据，若存在则不会再次插入数据
        serviceNameService.insertServiceName(serviceName);
        interfaceNameService.insertInterfaceName(interface_name);
        methodNameService.insertMethodName(method_name);

        //得到收藏记录表中的所需的数据
        Integer service_id = serviceNameService.findIdByServiceName(serviceName);
        Integer interface_id = interfaceNameService.findIdByInterfaceName(interface_name);
        Integer method_id = methodNameService.findIdByMethodName(method_name);

        //封装记录，插入数据库，后台会自动判断记录在数据库是否存在
        UserCollectRecord userCollectRecord = new UserCollectRecord();
        userCollectRecord.setService_id(service_id);
        userCollectRecord.setInterface_id(interface_id);
        userCollectRecord.setMethod_id(method_id);
        userCollectRecord.setUser_id(user_id);
        userCollectRecord.setParams(params);
        userCollectRecord.setResult_params(result_params);

        return userCollectRecord;
    }


    /**
     * 用户增加收藏记录接口
     * @param record
     * @return
     */
    @RequestMapping("/insert/collectRecord")
    public String InsertCollectRecord(Record record){
        final UserCollectRecord userCollectRecord = findUserCollectRecordByRecord(record);
        userCollectRecordService.insertUserCollectRecord(userCollectRecord);
        return "list";
    }

    @RequestMapping("/delete/collectRecord")
    public String deleteUserCollectRecord(Record record){
        final UserCollectRecord userCollectRecord = findUserCollectRecordByRecord(record);
        userCollectRecordService.deleteRecordByRecord(userCollectRecord);
        return "list";
    }

    @RequestMapping("/select/collectRecord")
    public @ResponseBody Map<Node, Map<Node,List<Node>>> selectUserCollectRecord(Integer userId){
        //结果集的数据结构
        Map<Node, Map<Node,List<Node>>> map = new HashMap<>();
        List<ResultRecord> records = userCollectRecordService.selectUserCollectRecordByUserId(1);
        for (ResultRecord record : records) {
            Node nodeService = new Node("serviceName",record.getService_name());
            //如果结果集中还未包含该ServiceName
            if(!map.containsKey(nodeService)){
                    Node nodeInterface = new Node("interfaceName", record.getInterface_name());
                    Node nodeMethod = new Node("methodName", record.getMethod_name());
                    //方法集合
                    List<Node> methodList = new ArrayList<>();
                    methodList.add(nodeMethod);
                    //接口-方法映射关系
                    Map<Node,List<Node>> mapInterfaceToMethod = new HashMap<>();
                    mapInterfaceToMethod.put(nodeInterface, methodList);
                    //加入结果集
                    map.put(nodeService, mapInterfaceToMethod);
                }
                //如果结果集已经包含ServiceName
                else {
                    Node nodeInterface = new Node("interfaceName", record.getInterface_name());
                    Map<Node, List<Node>> nodeListMap = map.get(nodeService);
                    //如果结果集不包含InterfaceName
                    if(!nodeListMap.containsKey(nodeInterface)){
                        Node nodeMethod = new Node("methodName", record.getMethod_name());
                        //方法集合
                        List<Node> methodList = new ArrayList<>();
                        methodList.add(nodeMethod);
                        nodeListMap.put(nodeInterface, methodList);
                    }
                    //结果集包含InterfaceName
                    else {
                        Node nodeMethod = new Node("methodName", record.getMethod_name());
                        List<Node> nodes = map.get(nodeService).get(nodeInterface);
                        nodes.add(nodeMethod);
                    }

            }
        }
        return map;
    }


    @RequestMapping("/select/collectRecordTest")
    public @ResponseBody Map<String, Map<String,List<String>>> selectUserCollectRecordTest(Integer userId){
        //结果集的数据结构
        Map<String, Map<String,List<String>>> map = new HashMap<>();
        List<ResultRecord> records = userCollectRecordService.selectUserCollectRecordByUserId(1);
        for (ResultRecord record : records) {
            String serviceName = record.getService_name();
            //如果结果集中还未包含该ServiceName
            if(!map.containsKey(serviceName)){
                String interfaceName = record.getInterface_name();
                String methodName = record.getMethod_name();
                //方法集合
                List<String> methodList = new ArrayList<>();
                methodList.add(methodName);
                //接口-方法映射关系
                Map<String,List<String>> mapInterfaceToMethod = new HashMap<>();
                mapInterfaceToMethod.put(interfaceName, methodList);
                //加入结果集
                map.put(serviceName, mapInterfaceToMethod);
            }
            //如果结果集已经包含ServiceName
            else {
                String interfaceName = record.getInterface_name();
                Map<String, List<String>> nodeListMap = map.get(serviceName);
                //如果结果集不包含InterfaceName
                if(!nodeListMap.containsKey(interfaceName)){
                    String methodName = record.getMethod_name();
                    //方法集合
                    List<String> methodList = new ArrayList<>();
                    methodList.add(methodName);
                    nodeListMap.put(interfaceName, methodList);
                }
                //结果集包含InterfaceName
                else {
                    String methodName = record.getMethod_name();
                    List<String> nodes = map.get(serviceName).get(interfaceName);
                    nodes.add(methodName);
                }

            }
        }
        return map;
    }

}
