package com.example.demo.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

/**
 * mycat多租户拦截器
 */
@Intercepts(value = {
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class,Integer.class})})
public class MycatTenantInterceptor implements Interceptor {
    private static final String preState="/*!mycat:schema=";
    private static final String afterState="*/";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
        MetaObject metaStatementHandler= SystemMetaObject.forObject(statementHandler);
        Object object=null;
        //分离代理对象链
        while(metaStatementHandler.hasGetter("h")){
            object=metaStatementHandler.getValue("h");
            metaStatementHandler=SystemMetaObject.forObject(object);
        }
        statementHandler=(StatementHandler)object;
        String sql=(String)metaStatementHandler.getValue("delegate.boundSql.sql");
        /*
        String schema=(String)TestController.threadLocal.get();
        */
        String schema = "db02";
        System.out.println("处理之前的sql语句："+sql);
        if(schema!=null) {
            //sql = preState + schema + afterState + sql;
        }
        System.out.println("处理之后的sql语句："+sql);
        metaStatementHandler.setValue("delegate.boundSql.sql",sql);
        Object result = invocation.proceed();
        System.out.println("Invocation.proceed()");
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);

    }

    @Override
    public void setProperties(Properties properties) {
    }
}
