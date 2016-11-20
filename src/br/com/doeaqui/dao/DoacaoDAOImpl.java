package br.com.doeaqui.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.doeaqui.exception.DoacaoNaoEncontradaException;
import br.com.doeaqui.model.Doacao;

@Repository
public class DoacaoDAOImpl implements IDoacaoDAO {

	private SessionFactory sessionFactory;

	@Override
	public void addDoacao(Doacao p) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();

	}

	@Override
	public void updateDoacao(Doacao p) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(p);
		session.getTransaction().commit();

	}

	@Override
	public List<Doacao> listByCategoria(String categoria) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Doacao.class);
		List<Doacao> list = criteria.add(Restrictions.like("categoria", categoria)).list();

		session.getTransaction().commit();

		return list;

	}

	@Override
	public List<Doacao> listDoacao() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Doacao> list = session.createCriteria(Doacao.class).list();

		session.getTransaction().commit();

		return list;

	}

	@Override
	public Doacao findById(int id) throws DoacaoNaoEncontradaException {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Doacao doacao = (Doacao) session.createCriteria(Doacao.class).add(Restrictions.idEq(id)).uniqueResult();
		session.getTransaction().commit();

		if (doacao == null) {

			throw new DoacaoNaoEncontradaException();

		} else {

			return doacao;

		}

	}

}
