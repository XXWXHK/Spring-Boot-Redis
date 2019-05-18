package cn.com.xuxiaowei.springbootredis.framework.tool;

/**
 * SQL 辅助类
 *
 * @author xuxiaowei
 */
public class SuperSqlHelper {

    /**
     * <p>
     * 判断数据库操作是否成功，并返回 null/实体类对象
     * </p>
     *
     * @param result 数据库操作返回影响条数
     * @param entity 实体类数据
     * @param <T>    类型
     * @return null/实体类
     */
    public static <T> T retBool(Integer result, T entity) {
        if (result != null && result >= 1) {
            return entity;
        } else {
            return null;
        }
    }

    /**
     * <p>
     * 判断数据库操作是否成功，并返回 null/实体类对象
     * </p>
     *
     * @param result 数据库操作返回影响条数
     * @param entity 实体类数据
     * @param <T>    类型
     * @return null/实体类
     */
    public static <T> T retBool(boolean result, T entity) {
        if (result) {
            return entity;
        } else {
            return null;
        }
    }

}
