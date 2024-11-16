package cn.xin.learn.java.generics;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;
import cn.xin.learn.java.generics.entity.MyClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author tiancx
 * @description: hutool类型工具类测试
 * @date 2024年11月14日
 */
@Slf4j
public class TypeUtilTest {
    @Test
    public void testGetClass() {
        Class<MyClass> myClass = MyClass.class;
        String name = myClass.getName();
        log.info(name);
        Assert.assertEquals("cn.xin.learn.java.generics.entity.MyClass", name);
        Class<?> aClass = TypeUtil.getClass(MyClass.class);
        log.info(String.valueOf(aClass));
    }

    /**
     * 获取方法上的泛型参数（说的花里胡哨的，实际就是形参类型）
     */
    @Test
    public void testGetMethodParam() {
        Method method = ReflectUtil.getMethodByName(MyClass.class, "strIntTest");
        log.info(method.toString());
        Type[] paramTypes = TypeUtil.getParamTypes(method);
        Assert.assertEquals(paramTypes[0], String.class);
        Assert.assertEquals(paramTypes[1], Integer.class);
        for (Type type : paramTypes) {
            log.info(type.toString());
        }
    }

    /**
     * 获取方法上的返回值类型
     */
    @Test
    public void testGetMethodReturn() {
        Method method = ReflectUtil.getMethodByName(MyClass.class, "strIntTest");
        Type returnType = TypeUtil.getReturnType(method);
        Assert.assertEquals(returnType, Integer.class);
        log.info(returnType.toString());
    }

    /**
     * 获取泛型类返回参数中的填充类型
     */
    @Test
    public void testGetGenericReturn() {
        Method method = ReflectUtil.getMethod(MyClass.class, "getList");
        Type returnType = TypeUtil.getReturnType(method);
        log.info(returnType.toString());
        Type typeArgument = TypeUtil.getTypeArgument(returnType);
        log.info(typeArgument.toString());
    }
}
