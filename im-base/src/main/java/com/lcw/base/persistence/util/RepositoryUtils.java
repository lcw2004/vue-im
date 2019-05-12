package com.lcw.base.persistence.util;

import com.lcw.base.utils.CollectionUtils;
import com.lcw.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @version 2017-05-19.
 * @auth Licw
 */
public class RepositoryUtils {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryUtils.class);

    public static Query getQueryWithParams(EntityManager entityManager, String hql, Object... params) {
        Query query = entityManager.createQuery(hql);
        return getQueryWithParams(query, hql, params);
    }

    public static Query getQueryWithParamMap(EntityManager entityManager, String hql, Map<String, Object> params) {
        Query query = entityManager.createQuery(hql);
        return getQueryWithParamMap(query, hql, params);
    }

    public static Query getNativeQueryWithParams(EntityManager entityManager, String hql, Object... params) {
        Query query = entityManager.createNativeQuery(hql);
        return getQueryWithParams(query, hql, params);
    }

    public static Query getNativeQueryWithParamMap(EntityManager entityManager, String hql, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(hql);
        return getQueryWithParamMap(query, hql, params);
    }

    public static Query getQueryWithParams(Query query, String hql, Object... params) {
        if (logger.isDebugEnabled()) {
            logger.debug("HQL [{}]", hql);
            if (params != null && params.length > 0) {
                logger.debug("HQL Param: {}", Arrays.asList(params));
                logger.debug("HQL Filled: [{}]", PersistenceUtils.fillParams(hql, params));
            }
        }

        int index = 1;
        if (CollectionUtils.isNotEmpty(params)) {
            for (Object param : params) {
                query.setParameter(index, param);
                index++;
            }
        }
        return query;
    }

    public static Query getQueryWithParamMap(Query query, String hql, Map<String, Object> params) {
        if (logger.isDebugEnabled()) {
            logger.debug("HQL [{}]", hql);
            if (CollectionUtils.isNotEmpty(params)) {
                logger.debug("HQL Param: {}", params);
                logger.debug("HQL Filled: [{}]", PersistenceUtils.fillParams(hql, params));
            }
        }

        if (CollectionUtils.isNotEmpty(params)) {
            for (Map.Entry<String, Object> entry: params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query;
    }

    public static String buildCountHQL(String hql) {
        hql = hql.trim();

        StringBuilder countHql = new StringBuilder();
        if (StringUtils.startsWithWithCase(hql, "select")) {
            // eg: select * from Test
            // eg: select new(xxxx) from Test
            // eg: select distinct t from Test

            // 处理select和form中间部分
            int fromIndex = StringUtils.indexWithCase(hql, "from");
            int selectIndex = StringUtils.indexWithCase(hql, "select");
            String hqlBetweenSelectAndForm = hql.substring(selectIndex + 6, fromIndex);
            if (StringUtils.containWithCase(hql, "new")) {
                // 如果包含new，用1替换调
                hqlBetweenSelectAndForm = "1";
            }

            // 处理from后部分
            String hqlNoSelect = hql.substring(fromIndex);

            countHql.append(" SELECT COUNT(").append(hqlBetweenSelectAndForm).append(") ").append(hqlNoSelect);
        } else if (StringUtils.startsWithWithCase(hql, "from")) {
            // eg: from Test
            countHql.append(" SELECT COUNT(*) ").append(hql);
        }

        return countHql.toString();
    }

    public static <T> T getFirst(Query query) {
        T obj = null;
        List<T> resultList = query.getResultList();
        if (CollectionUtils.isNotEmpty(resultList)) {
            obj = resultList.get(0);
        }
        return obj;
    }

    /**
     * 时间比较（小于等于）
     *
     * @param fieldName 字段名称
     * @param dateStr   时间
     * @return
     */
    public static String dateBefore(String fieldName, String dateStr) {
        return dateCompare(fieldName, dateStr, "<=");
    }

    /**
     * 时间比较（大于等于）
     *
     * @param fieldName 字段名称
     * @param dateStr   时间
     * @return
     */
    public static String dateAfter(String fieldName, String dateStr) {
        return dateCompare(fieldName, dateStr, ">=");
    }

    private static String dateCompare(String fieldName, String dateStr, String compareChar) {
        return " AND FUNCTION('DATE', " + fieldName + ") " + compareChar + " FUNCTION('DATE_FORMAT', " + dateStr + ", '%Y-%m-%d') ";
    }

}
