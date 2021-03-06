package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;

public class Presentation2 {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Scanner scanner=new Scanner(new File("config.txt"));
		
		String daoClassName=scanner.nextLine();
		Class<?> cDao=Class.forName(daoClassName);
		IDao dao=(IDao)cDao.getDeclaredConstructor().newInstance();
		
		String metierClassName=scanner.nextLine();
		Class<?> cMetier=Class.forName(metierClassName);
		IMetier metier=(IMetier)cMetier.getDeclaredConstructor(IDao.class).newInstance(dao);
		
		//Method m=cMetier.getMethod("setDao",IDao.class);
		//m.invoke(metier, dao);
		
		System.out.println("Res="+metier.calcul());
		
		
	}

}
