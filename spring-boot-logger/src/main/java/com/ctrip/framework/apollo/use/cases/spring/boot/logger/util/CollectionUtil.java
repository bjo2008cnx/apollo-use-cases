package com.ctrip.framework.apollo.use.cases.spring.boot.logger.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * @date 2018-03-02
 */
public class CollectionUtil {
    public static boolean isEmpty(Collection collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 首先检测a，b是否为空集合
     * 再做交集校验
     *
     * @param a   集合a
     * @param b   集合b
     * @param <E> 集合类型
     * @return boolean
     */
    public static <E> boolean hasIntersection(Collection<E> a, Collection<E> b) {
        if (isEmpty(a) || isEmpty(b)) {
            return false;
        }

        for (E element : a) {
            if (b.contains(a)) {
                return true;
            }
        }
        return false;
    }

    public static <E> E getFirst(Collection<E> collection) {
        Iterator<E> it = collection.iterator();
        if (it.hasNext()) {
            return it.next();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
