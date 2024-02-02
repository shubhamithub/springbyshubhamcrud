package com.becoder.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.becoder.entity.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveEmp(Emp emp) {

		return (int) hibernateTemplate.save(emp);
	}

	public Emp getEmpById(int id) {
		/* Emp emp = hibernateTemplate.get(Emp.class, id); */
		return hibernateTemplate.get(Emp.class, id);
	}

	public List<Emp> getAllEmp() {
		List<Emp> list = hibernateTemplate.loadAll(Emp.class);
		return list;
	}

	@Transactional
	public void update(Emp emp) {
		hibernateTemplate.update(emp);

	}

	@Transactional
	public void deletEmp(int id) {
		Emp emp = hibernateTemplate.get(Emp.class, id);
		hibernateTemplate.delete(emp);

	}

}
