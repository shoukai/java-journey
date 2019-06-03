package org.apframework.spi;

import org.apframework.spi.exception.ObjectSerializerException;
import org.apframework.spi.serializer.ObjectSerializer;
import org.apframework.spi.service.SerializerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/6/3 19:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaSpiApplicationTests {

    @Autowired
    private SerializerService serializerService;

    @Test
    public void serializerTest() throws ObjectSerializerException {
        ObjectSerializer objectSerializer = serializerService.getObjectSerializer();
        System.out.println(objectSerializer.getSchemeName());
        byte[] arrays = objectSerializer.serialize(new BusinessBean(101, "jumper"));
        BusinessBean businessBean = objectSerializer.deSerialize(arrays, BusinessBean.class);
        Assert.assertTrue(Integer.valueOf(101).equals(businessBean.value));
        Assert.assertTrue("jumper".equals(businessBean.desc));
    }

    public static class BusinessBean implements Serializable {

        private Integer value;
        private String desc;

        public BusinessBean() {
        }

        public BusinessBean(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
