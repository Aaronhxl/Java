<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<html>
<body>
<h2>Hello World!</h2>

    <FORM ACTION="/user/insert/collectRecord" METHOD="post">
        service：<input type="text" name="serviceName.service_name"><br>
        ip：<input type="text" name="serviceName.ip"><br>
        port：<input type="text" name="serviceName.port"><br>
        interface：<input type="text" name="interfaceName"><br>
        method：<input type="text" name="methodName"><br>
        params：<input type="text" name="params"><br>
        result：<input type="text" name="resultParams"><br>
        userId：<input type="number" name="userId"><br>
        <input type="submit" value="增加">
    </FORM>
    <br>
    <FORM ACTION="/user/delete/collectRecord" METHOD="post">
    service：<input type="text" name="serviceName.service_name"><br>
    ip：<input type="text" name="serviceName.ip"><br>
    port：<input type="text" name="serviceName.port"><br>
    interface：<input type="text" name="interfaceName"><br>
    method：<input type="text" name="methodName"><br>
    params：<input type="text" name="params"><br>
    result：<input type="text" name="resultParams"><br>
    userId：<input type="number" name="userId"><br>
    <input type="submit" value="删除">
    </FORM>

<FORM ACTION="/soa/invoke" METHOD="post">
    service：<input type="text" name="serviceName.service_name"><br>
    ip：<input type="text" name="serviceName.ip"><br>
    port：<input type="text" name="serviceName.port"><br>
    interface：<input type="text" name="interfaceName"><br>
    method：<input type="text" name="methodName"><br>
    params：<input type="text" name="params"><br>
    result：<input type="text" name="resultParams"><br>
    userId：<input type="number" name="userId"><br>
    <input type="submit" value="执行">
</FORM>


</body>
</html>
