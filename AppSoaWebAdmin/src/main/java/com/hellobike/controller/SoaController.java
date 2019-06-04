package com.hellobike.controller;


import com.hellobike.domain.Record;
import com.hellobike.domain.SoaInvokeResult;
import com.hellobike.soa.client.SoaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/soa")
public class SoaController {

    @RequestMapping("/invoke")
    @ResponseBody
    public SoaInvokeResult soaInvoke(@RequestBody Record record){

        //请求的套接字
        String host = record.getServiceName().getIp()+":"+record.getServiceName().getPort();
        //设置超时时间
        int timeout = 50000;
        //接口名
        String iface = record.getInterfaceName();
        //方法名
        String method = record.getMethodName();
        //请求参数
        String requestJson = record.getParams();


        System.out.println(host+"--"+timeout+"--"+iface+"--"+method+"--"+requestJson);

        //封装SOA调用
        SoaClient soaClient = new SoaClient(host);
        String queryByPassengerOrderId = soaClient.call(timeout, iface, method, requestJson);

        /*
        SoaClient soaClient = new SoaClient("118.31.61.49:29201");

        String queryByPassengerOrderId = soaClient.call(50000,
                "com.easybike.bosdata.partner.bill.PartnerBillDetailIface",
                "exec", "{\"arg0\":\"1118920262303555586\"}");*/

        System.out.println(queryByPassengerOrderId);
        SoaInvokeResult soaInvokeResult = new SoaInvokeResult();
        soaInvokeResult.setResultParams(queryByPassengerOrderId);

        return soaInvokeResult;
    }


}
