package com.sg.util;

import java.lang.reflect.Method;

import com.sg.Column;
import com.sg.Table;
//import com.sun.org.apache.bcel.internal.classfile.Method;

public class SQLUtil {
	public static String getCreateStatement(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		Table t=clazz.getAnnotation(Table.class);
		if(t!=null) {
			builder.append("create table ");
			builder.append(t.name());
			builder.append("(");
			Method[] methods=clazz.getDeclaredMethods();
			for(Method m:methods) {
				if(m.getName().startsWith("get")) {
					Column c = m.getAnnotation(Column.class);
					if(c!=null) {
						builder.append(c.name());
						builder.append(" ");
						builder.append(c.type());
						builder.append(",");
						
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		return builder.toString();
		
	}
	public static String getInsertSQL(Object obj) {
		StringBuilder builder = new StringBuilder();
		Table t=obj.getClass().getAnnotation(Table.class);
		if(t!=null) {
			builder.append("create table ");
			builder.append(t.name());
			builder.append("values (");
			Method[] methods=obj.getClass().getDeclaredMethods();
			for(Method m:methods) {
				if(m.getName().startsWith("get")) {
					Column c = m.getAnnotation(Column.class);
					if(c!=null) {
						try {
							Object ret = m.invoke(obj);
							if(ret instanceof String) 
							{
								builder.append("'");
								builder.append(ret);
								builder.append("'");
							}
							else {
								builder.append(ret);
							}
							builder.append(",");
						}catch(Exception e) {e.printStackTrace();}
						
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		return builder.toString();
		

		
	}

}
