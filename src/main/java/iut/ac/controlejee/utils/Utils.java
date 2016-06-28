package iut.ac.controlejee.utils;

import iut.ac.controlejee.common.Const;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Utils {
	public static boolean isAuth(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute(Const.ADHERENT) != null;
	}
//	
//	public static void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
//		if(rd != null){
//			rd.forward(request, response);
//		}
//	}
//	
	
	/**
	 * Parse a string value to an object  
	 * @param value value to parse
	 * @param classType class of the object
	 * @return object parsed
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Object parseValue(String value, Class<?> classType) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,  SecurityException{
		Object valueO = null;
		switch(classType.getName()){
		case "int":
			valueO = Integer.parseInt(value);
			break;
		case "float":
			valueO = Float.parseFloat(value);
			break;
		case "double":
			valueO = Double.parseDouble(value);
			break;
		case "boolean":
			valueO = Boolean.parseBoolean(value);
			break;
		case "char":
			valueO = (value.length() == 1)?value.charAt(0):value.toCharArray();
			break;
			
		default:
			if(classType.getName().contains("Date")){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					valueO = format.parse(value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
			} else {
				Constructor<?> c;
				try {
					c = classType.getConstructor(String.class);
					if(c != null){
						valueO = c.newInstance(value);
					}
				} catch (NoSuchMethodException e) {
					try {
						Method m = classType.getMethod("parse", String.class);
						c = classType.getConstructor();
						if(c != null){
							valueO = c.newInstance();
							m.invoke(valueO, value);
						}
					} catch (NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						System.err.println(e1.getMessage());
					}
				}
			}
		}	
		return valueO;
	}
	
	/**
	 * Get set method of a specific object pass in param
	 * @param o Object which we will search the set method
	 * @param name name of the field
	 * @param classType class of the type of the field
	 * @return the set method
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Method getSet(Object o, String name, Class<?> classType) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String methodName = "set"+Character.toUpperCase(name.charAt(0))+name.substring(1, name.length()).toLowerCase();
		Method m = null;
		m = o.getClass().getMethod(methodName, classType);
		return m;
	}
	
	/***
	 * Get the class of the field
	 * @param field  one field of a bean
	 * @return the class of the param "field" 
	 * @throws ClassNotFoundException 
	 */
	public static Class<?> getFieldClass(Field field) throws ClassNotFoundException{
		Class<?> fieldClass = null;
		switch(field.getType().getName()){
		case "int":
			fieldClass = int.class;
			break;
		case "float":
			fieldClass = float.class;
			break;
		case "double":
			fieldClass = double.class;
			break;
		case "char":
			fieldClass = char.class;
			break;
		case "boolean":
			fieldClass = boolean.class;
			break;
		default:
			fieldClass = Class.forName(field.getType().getName());
		}
		return fieldClass;
	}
}
