package com.yhb.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author YangHaiBo
 * @create 2019-09-10 11:24
 */
public class JsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Log log = LogFactory.getLog(JsonUtils.class);

    private JsonUtils(){
        super();
    }

    /**
     * 将对象转换为json对象
     * <p>Title:pojoToJson</p>
     * @param data 传入pojo对象
     * @return string 转换后的json
     */
    public static String objectToJson(Object data){
        try{
            return MAPPER.writeValueAsString(data);
        }catch (JsonProcessingException e){
            log.error(e);
        }
        return null;
    }

    /**
     * 将json数据转换为pojo对象list
     * @param jsonData json数据
     * @param beanType 需要转换成的类
     * @param <T> 泛型
     * @return t 需要转换类的类型
     */
    public static <T> T jsonToPojo(String jsonData,Class<T> beanType){
        try {
            return MAPPER.readValue(jsonData, beanType);
        }catch (Exception e){
            log.error(e);
        }
        return null;
    }
}
