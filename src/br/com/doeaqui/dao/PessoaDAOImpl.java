package br.com.doeaqui.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.doeaqui.model.Empresa;
import br.com.doeaqui.model.ONG;
import br.com.doeaqui.model.Pessoa;

@Repository
public class PessoaDAOImpl implements IPessoaDAO {

	private static final Logger logger = LoggerFactory.getLogger(PessoaDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addPessoa(Pessoa p) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		if (p instanceof Empresa) {

			session.save(p);

		} else {

			session.save((ONG) p);

		}

		session.getTransaction().commit();

	}

	@Override
	public void updatePessoa(Pessoa p) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.merge((Empresa) p);
		logger.info("Pessoa updated successfully. Pessoa " + p);

		// TODO - Implementar tratando ONG
	}

	@Override
	public void removePessoa(String cnpj) {

		// //Session session = this.sessionFactory.getCurrentSession();
		// Session session =
		// HibernateUtil.getSessionFactory().getCurrentSession();
		//
		// Pessoa p = findPessoa(cnpj);
		// session.delete(p);
		//
		// logger.info("Aluno removed successfully. Aluno " + p);
		//
		// session.getTransaction().commit();
		// session.close();
	}

	@Override
	public Pessoa findPessoa(String cnpj) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Pessoa.class);
		Pessoa p = (Pessoa) criteria.add(Restrictions.like("cnpj", cnpj)).list().get(0);

		session.getTransaction().commit();

		return p;

	}

	@Override
	public List<Pessoa> listPessoa() {
		// Session session = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Pessoa> pessoaList = session.createQuery("from Pessoa").list();

		for (Pessoa pessoa : pessoaList) {

			logger.info("Pessoa List::" + pessoa.toString());

		}

		return pessoaList;

	}

}