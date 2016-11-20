package br.com.doeaqui.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {

			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder register = new StandardServiceRegistryBuilder();
			register.applySettings(cfg.getProperties());
			StandardServiceRegistry service = register.build();
			return cfg.buildSessionFactory(service);

		} catch (Throwable e) {

			System.out.println("Criação do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);

		}

	}

	public static SessionFactory getSessionFactory() {

		return HibernateUtil.sessionFactory;
		

	}

}
