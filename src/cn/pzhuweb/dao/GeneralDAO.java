package cn.pzhuweb.dao;

import java.io.Serializable;
import java.util.List;

/*
 * 泛型公共接口，定义所有表的基本操作
 * <T>表示一个表的映射类型
 * 《K》主键类型
 * */
public interface GeneralDAO<T, K extends Serializable> {
    public int insert(T t);

    public int delete(K k);

    public int update(T t);

    public List<T> select();

    public T selectById(K k);

}
