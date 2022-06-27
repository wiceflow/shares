package com.wiceflow.shares.util;

import java.util.Collection;

/**
 * @author BF
 * @date 2022/6/27
 * <p>
 * 集合工具类
 */
public class CollectionUtil {
    /**
     * 判断集合是否为空
     *
     * @param collection [Collection<?>]待判断集合
     * @return [boolean]
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    /**
     * 判断集合是否不为空
     *
     * @param collection [Collection<?>]待判断集合
     * @return [boolean]
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
