package cn.xin.learn.java.generics;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tiancx
 * @description: 泛型测试类
 * @date 2024年08月15日
 */

class A {
}

class B extends A {
}

class C extends B {
}

class D extends C {
}

class E extends D {
}

public class GenericsDemoTest {

    /**
     * 数组-协变
     * 定义：即使某个对象不是数组的基类型，我们也可以把它赋值给数组元素
     */
    @Test
    public void testArray() {
        Assert.assertThrows(ArrayStoreException.class, () -> {
            A[] arrA1 = new C[10];
            arrA1[1] = new D();
            arrA1[0] = new B();
        });

    }

    @Test
    public void testGenerics() {
        List<A> listA = new ArrayList<>();
        listA.add(new A());
        listA.add(new B());
        listA.add(new C());
        System.out.println(listA.size());
        Assert.assertTrue(listA.size() == 3);
    }

    /**
     * 测试上界
     */
    @Test
    public void testGenericsExtends() {
        //extends 只能读取，不能添加（null除外）
        List<? extends A> listA = new ArrayList<>(Arrays.asList(new A(), new B(), new C()));
        List<? extends B> listB = new ArrayList<>(Arrays.asList(new B(), new C()));
//        listA.forEach(x-> System.out.println(x.getClass().getSimpleName()));
        testExtends(listA);
        testExtends(listB);
    }

    public void testExtends(List<? extends A> listA) {
//        listA.add(new A());
        listA.forEach(x -> System.out.println(x.getClass().getSimpleName()));
        System.out.println("===================================");
    }


    @Test
    public void testGenericsSuper() {
        //super
        List<? super B> listB = new ArrayList<>(Arrays.asList(new A(), new B(), new C()));
        List<? super A> listA = new ArrayList<>(Arrays.asList(new C(), new D()));
        ArrayList<Object> list = new ArrayList<>();
//        testSuper(list);
//        testSuper(listA);
//        testSuper(listB);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList<Number> list2 = new ArrayList<>();

        testSuper(list2, list1);
        System.out.println("list2 = " + list2);

    }

    //可以传入的实参的类型是T或者T的父类类型，可以往里面添加T或者T的子类类型
    public static <T> void testSuper(List<? super T> listB, List<? extends T> listA) {
        for (int i = 0; i < listA.size(); i++) {
            T t = listA.get(i);
            listB.add(t);
        }
//        listB.add(new E());
//        Object object = listB.get(0);

//        listB.forEach(x-> System.out.println(x.getClass().getSimpleName()));
//        System.out.println("===================================");
    }

    /**
     * 获取泛型
     * 可以参考博客：https://www.cnblogs.com/cainiao-Shun666/p/15754113.html#_label0_0
     */
    @Test
    public void testGetGenericsTypeVariable() throws Exception {
        Class<GenericsDemo> aClass = GenericsDemo.class;
        //获取泛型参数
        TypeVariable<Class<GenericsDemo>>[] typeParameters = aClass.getTypeParameters();
        for (TypeVariable<Class<GenericsDemo>> typeParameter : typeParameters) {
            System.out.println(typeParameter.getName());
        }
        //获取参数里面的泛型
        Field tField = aClass.getDeclaredField("t");
        tField.setAccessible(true);
        Type genericType = tField.getGenericType();
        TypeVariable typeVariable = (TypeVariable) genericType;

        System.out.println(genericType.getTypeName());
        Type[] bounds = typeVariable.getBounds();
        for (Type bound : bounds) {
            System.out.println("边界：" + bound.getTypeName());
        }
        System.out.println("===================================");


    }


    /**
     * 获取泛型参数化类型
     */
    @Test
    public void testGetGenericsParameterizedType() throws Exception {
        Class<GenericsDemo> aClass = GenericsDemo.class;
        //parameterizedType
        Field list = aClass.getDeclaredField("list");
        list.setAccessible(true);
        Type genericType1 = list.getGenericType();
        if (genericType1 instanceof ParameterizedType) {
            System.out.println("list 是参数化类型");
            System.out.println(genericType1.getTypeName());
            ParameterizedType parameterizedType = (ParameterizedType) genericType1;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("实际类型参数：" + actualTypeArgument.getTypeName());
            }
            Type rawType = parameterizedType.getRawType();
            System.out.println("原始类型：" + rawType.getTypeName());
        }

        System.out.println("===================================");
        Field map = aClass.getDeclaredField("map");
        map.setAccessible(true);
        Type genericType2 = map.getGenericType();
        if (genericType2 instanceof ParameterizedType) {
            System.out.println("map 是参数化类型");
            System.out.println(genericType2.getTypeName());
            ParameterizedType parameterizedType = (ParameterizedType) genericType2;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("实际类型参数：" + actualTypeArgument.getTypeName());
            }
            Type rawType = parameterizedType.getRawType();
            System.out.println("原始类型：" + rawType.getTypeName());
        }
    }

    
}
