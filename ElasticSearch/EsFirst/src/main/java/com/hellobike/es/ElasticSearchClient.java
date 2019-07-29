package com.hellobike.es;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hellobike.es.entiry.Article;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

/**
 * Package: com.hellobike.es
 * Description： TODO
 * Author: huanglong
 * Date: Created in 2019/6/25 15:15
 * Version: 0.0.1
 */
public class ElasticSearchClient {

    private TransportClient client;

    @Before
    public void init() throws UnknownHostException {
        Settings setting = Settings.builder().put("cluster.name","elasticsearch")
                .put("client.transport.sniff", false)
                .build();
        client = new PreBuiltTransportClient(setting);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("47.98.55.195"), 9300));
    }
    @Test
    public void createIndex() throws UnknownHostException {
        /**
         * 使用Java客户端创建索引库
         *  1.创建一个setting对象，相当于是一个配置信息，主要配置集群的名称
         *  2.创建一个客户端Client对象
         *  3.使用client对象创建一个索引库
         *  4.关闭client对象
         */
        Settings setting = Settings.builder().put("cluster.name","haystack-logs-dev").build();
        client = new PreBuiltTransportClient(setting);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        client.admin().indices().prepareCreate("index_hello").get();//get()才执行操作，前面设置参数
        client.close();
    }

    /**
     * 使用Java客户端设置Mappings
     * 1.创建一个Setitngs对象
     * 2.创建一个Client对象
     * 3.创建一个mapping信息，应该是一个json数据，可以是字符串，也可以是XContextBuilder对象
     * 4.使用client向es服务器发送mapping信息
     * 5.关闭client对象
     */
    @Test
    public void setMappings() throws IOException {
        Settings setting = Settings.builder().put("cluster.name","elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(setting);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                    .startObject("article")
                        .startObject("properties")
                            .startObject("id")
                                .field("type","long")
                                .field("store",true)
                            .endObject()
                            .startObject("title")
                                .field("type","text")
                                .field("store",true)
                                .field("analyzer","ik_smart")
                            .endObject()
                            .startObject("content")
                            .field("type","text")
                            .field("store",true)
                            .field("analyzer","ik_smart")
                            .endObject()
                        .endObject()
                    .endObject()
                .endObject();

        client.admin().indices().preparePutMapping("index_hello")
                .setType("article")
                .setSource(builder).get();

        client.close();
    }

    @Test
    public void addDoucment() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                    .field("id", 1)
                    .field("title", "上海哈啰出行")
                    .field("content", "数据与业务研发")
                .endObject();
        client.prepareIndex()
                .setId("1")
                .setType("article")
                .setIndex("index_hello")
                .setSource(builder).get();
        client.close();
    }

    @Test
    public void addDoucmentByObject() throws JsonProcessingException {
        Article article = new Article();
        for (int i = 1; i <= 100; i++) {
            article.setId(2+i);
            article.setTitle("浙江大学");
            article.setContent("再创辉煌");

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(article);
            System.out.println(json);

            client.prepareIndex()
                    .setId(2+i+"")
                    .setType("article")
                    .setIndex("index_hello")
                    .setSource(json, XContentType.JSON).get();
        }
        client.close();
    }

    /**
     * 使用es客户端实现搜索
     * 1.根据id搜索
     * 2.根据Term查询（关键字）
     * 3.QueryString查询方式（带分析的查询）
     *
     * 查询步骤：
     *      1.创建一个Client对象
     *      2.创建一个查询对象，可以使用QueryBuilders工具类创建QueryBuilder对象
     *      3.使用client执行查询
     *      4.取查询结果的总记录数
     *      5.取查询结果列表
     *      6.关闭client
     */
    @Test
    public void queryById(){
        QueryBuilder queryBuilder = QueryBuilders.idsQuery().addIds("1","2");
        query(queryBuilder);

        client.close();
    }

    @Test
    public void queryByTerm(){
        QueryBuilder queryBuilder =  QueryBuilders.termQuery("title", "浙江大学");
        query(queryBuilder);
        client.close();
    }

    @Test
    public void queryByStringQuery(){
        QueryBuilder queryBuilder =  QueryBuilders.queryStringQuery("哈啰").defaultField("title");
        query(queryBuilder);
        client.close();
    }

    private void query(QueryBuilder queryBuilder) {
        SearchResponse searchResponse = client.prepareSearch("index_hello")
                .setTypes("article")
                .setQuery(queryBuilder)
                //设置分页信息
                .setFrom(0)
                .setSize(500)
                .get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询结果总记录数："+hits.getTotalHits());
        Iterator<SearchHit> iterator = hits.iterator();

        while (iterator.hasNext()){
            SearchHit searchHit = iterator.next();
            System.out.println(searchHit.getSourceAsString());

            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            System.out.println(sourceAsMap.get("id"));
            System.out.println(sourceAsMap.get("content"));
            System.out.println("------------------");
        }
    }

    @Test
    public void testQuery(){
        QueryBuilder queryBuilder =  QueryBuilders.termQuery("yk_metric", "Bike.Receive.Closelock");
        SearchResponse searchResponse = client.prepareSearch("metrics-rentbike-fat-2019.06.26")
                .setTypes("logs")
                .setQuery(queryBuilder)
                //设置分页信息
                .setFrom(0)
                .setSize(500)
                .get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询结果总记录数："+hits.getTotalHits());
        Iterator<SearchHit> iterator = hits.iterator();

        while (iterator.hasNext()){
            SearchHit searchHit = iterator.next();
            System.out.println(searchHit.getSourceAsString());

//            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
//            System.out.println(sourceAsMap.get("id"));
//            System.out.println(sourceAsMap.get("content"));
//            System.out.println("------------------");
        }
        client.close();
    }

}
