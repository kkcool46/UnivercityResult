package com.jbk.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.jbk.api.entity.Student;

@Repository
public class ResultdaoImpl implements ResultDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveResult(Student student) {

		boolean isAdded = false;
		Session session = sessionFactory.openSession();
		try {
			Student student2 = session.get(Student.class, student.getStudentPrn());
			if (student2 == null) {
				Transaction transaction = session.beginTransaction();
				session.save(student);
				transaction.commit();
				isAdded = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;
	}

	@Override
	public Student getStudentResultByPRN(long studentPrn) {
		Session session = sessionFactory.openSession();
		Student student = null;
		try {

			student = session.get(Student.class, studentPrn);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return student;

	}

	@Override
	public List<Student> getAllStudentResult() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	@Override
	public boolean deleteResult(long studentPrn) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Student student = session.get(Student.class, studentPrn);
			if (student != null) {
				session.delete(student);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isDeleted;

	}

	@Override
	public boolean updateStudentResult(Student student) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Student student2 = session.get(Student.class, student.getStudentPrn());
			try {
				session.evict(student2);

			} catch (Exception e) {
				System.out.println("Student not Found This id");

			}

			if (student != null) {
				session.update(student);
				transaction.commit();
				isUpdated = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@Override
	public List<Student> getAllStudentResultBySeatNo_Asc() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.addOrder(Order.asc("studentSeatNo"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Student> getAllStudentResultBySeatNo_Dsc() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.addOrder(Order.desc("studentSeatNo"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Student> getAllStudentResultByName_Asc() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.addOrder(Order.asc("studentName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Student> getAllStudentResultByName_Dsc() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.addOrder(Order.desc("studentName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Student> getAllStudentResultByCollegeCode(long collegeCode) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("collegeCode", collegeCode));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public Student getSingleStudentResultBySeatNo(long studentSeatNo) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		Student student = null;

		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("studentSeatNo", studentSeatNo));
			list = criteria.list();
			if (!list.isEmpty()) {

				student = list.get(0);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return student;
	}

	@Override
	public List<Student> getAllStudentResultByCollegeName(String collegeName) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("collegeName", collegeName));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	@Override
	public List<Student> getAllStudentResultByBranchName(String branchName) {

		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("branchName", branchName));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	@Override
	public List<Student> getAllStudentResultByBranchCode(long branchCode) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;

		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("branchCode", branchCode));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Student> getStudentsResultFinelPassOrFail(String result) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("result", result));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<String> getCollegeName() {
		Session session = sessionFactory.openSession();
		List<String> list = null;

		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.distinct(Projections.property("collegeName")));
			list = criteria.list();
			// System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<String> getBranchNames() {
		Session session = sessionFactory.openSession();
		List<String> list = null;
		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.distinct(Projections.property("branchName")));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> getStudentsSeatNowithStudentName() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.property("studentSeatNo");
			Projection p2 = Projections.property("studentName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.asc("studentName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Student> getStudentPrnwithStudentName() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.property("studentPrn");
			Projection p2 = Projections.property("studentName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.asc("studentName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	@Override
	public List<Student> getSubjectNamesBranchWise() {

		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p = Projections.distinct(Projections.property("branchName"));
			Projection p1 = Projections.property("sub1Name");
			Projection p2 = (Projections.property("sub2Name"));
			Projection p3 = (Projections.property("sub3Name"));
			Projection p4 = (Projections.property("sub4Name"));
			Projection p5 = (Projections.property("sub5Name"));
			ProjectionList plist = Projections.projectionList();
			plist.add(p);
			plist.add(p1);
			plist.add(p2);
			plist.add(p3);
			plist.add(p4);
			plist.add(p4);
			criteria.setProjection(plist);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Student> getStudentsSeatNowithStudentNameinDscOrder() {

		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.property("studentSeatNo");
			Projection p2 = Projections.property("studentName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.desc("studentName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	@Override
	public List<Student> getStudentPrnwithStudentNameinDscOrder() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.property("studentPrn");
			Projection p2 = Projections.property("studentName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.desc("studentName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	@Override
	public List<Student> getCollegeCodeWithCollegeName() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.distinct(Projections.property("collegeCode"));
			Projection p2 = Projections.property("collegeName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.asc("collegeCode"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> getBranchCodeWithBranchName() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.distinct(Projections.property("branchCode"));
			Projection p2 = Projections.property("branchName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.asc("branchCode"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> getCollegeCodeWithCollegeNameinDscOrder() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.distinct(Projections.property("collegeCode"));
			Projection p2 = Projections.property("collegeName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.desc("collegeName"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> getBranchCodeWithBranchNameinDscOrder() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection p1 = Projections.distinct(Projections.property("branchCode"));
			Projection p2 = Projections.property("branchName");
			ProjectionList pList = Projections.projectionList();
			pList.add(p1);
			pList.add(p2);
			criteria.setProjection(pList).addOrder(Order.desc("branchName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<String> getFinelResultValues() {

		Session session = sessionFactory.openSession();
		List<String> list = null;

		try {

			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.distinct(Projections.property("result")));
			list = criteria.list();
			// System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> getTopperInUnivercity() {
		Session session = sessionFactory.openSession();
		double maxper = 0;
		List<Student> topperlist = null;

		try {
			Criteria maxcriteria = session.createCriteria(Student.class);
			maxcriteria.setProjection(Projections.max("percentage"));
			List<Double> list = maxcriteria.list();
			maxper = list.get(0);
			Criteria eqcriteria = session.createCriteria(Student.class);
			eqcriteria.add(Restrictions.eq("percentage", maxper));
			topperlist = eqcriteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return topperlist;
	}

	@Override
	public List<Student> getFirstRankInCollege(String collegeName) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		Double maxPer = (double) 0;

		List<Student> list3 = null;
		try {

			Criteria maxPercentage = session.createCriteria(Student.class);
			maxPercentage.setProjection(Projections.max("percentage")).add(Restrictions.eq("collegeName", collegeName));
			List<Double> list2 = maxPercentage.list();
			maxPer = list2.get(0);

			Criteria eq = session.createCriteria(Student.class);
			eq.add(Restrictions.eq("percentage", maxPer));
			list3 = eq.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (session != null) {
				session.close();
			}
		}

		return list3;

	}

	@Override
	public List<Student> getFirstRankInUnivecityBranchWise(String branchName) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		Double maxPer = (double) 0;

		List<Student> list3 = null;
		try {

			Criteria maxPercentage = session.createCriteria(Student.class);
			maxPercentage.setProjection(Projections.max("percentage")).add(Restrictions.eq("branchName", branchName));
			List<Double> list2 = maxPercentage.list();
			maxPer = list2.get(0);

			Criteria eq = session.createCriteria(Student.class);
			eq.add(Restrictions.eq("percentage", maxPer));
			list3 = eq.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (session != null) {
				session.close();
			}
		}

		return list3;
	}

	@Override
	public List<Student> getFirstRankInCollegebyCollegeCode(long collegeCode) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		Double maxPer = (double) 0;

		List<Student> list3 = null;
		try {

			Criteria maxPercentage = session.createCriteria(Student.class);
			maxPercentage.setProjection(Projections.max("percentage")).add(Restrictions.eq("collegeCode", collegeCode));
			List<Double> list2 = maxPercentage.list();
			maxPer = list2.get(0);

			Criteria eq = session.createCriteria(Student.class);
			eq.add(Restrictions.eq("percentage", maxPer));
			list3 = eq.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (session != null) {
				session.close();
			}
		}

		return list3;
	}

	@Override
	public List<Student> getFirstRankInUnivecityBranchWiseUsingBranchCode(long branchCode) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		Double maxPer = (double) 0;

		List<Student> list3 = null;
		try {

			Criteria maxPercentage = session.createCriteria(Student.class);
			maxPercentage.setProjection(Projections.max("percentage")).add(Restrictions.eq("branchCode", branchCode));
			List<Double> list2 = maxPercentage.list();
			maxPer = list2.get(0);

			Criteria eq = session.createCriteria(Student.class);
			eq.add(Restrictions.eq("percentage", maxPer));
			list3 = eq.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (session != null) {
				session.close();
			}
		}

		return list3;
	}

	@Override
	public List<Student> getFirstRankInCollegeBranchWise(long collegeCode, long branchCode) {

		Session session = sessionFactory.openSession();
		List<Student> list = null;
		Double maxPer = (double) 0;

		List<Student> list3 = null;
		try {

			Criteria maxPercentage = session.createCriteria(Student.class);
			maxPercentage.setProjection(Projections.max("percentage")).add(Restrictions.eq("collegeCode", collegeCode))
					.add(Restrictions.eq("branchCode", branchCode));
			List<Double> list2 = maxPercentage.list();
			maxPer = list2.get(0);

			Criteria eq = session.createCriteria(Student.class);
			eq.add(Restrictions.eq("percentage", maxPer));
			list3 = eq.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (session != null) {
				session.close();
			}
		}

		return list3;
	}

	@Override
	public long getTotalCountOfStudentResult() {

		Session session = sessionFactory.openSession();
		long count = 0;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			List<Long> list = criteria.list();
			count = list.size();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return count;
	}

	@Override
	public double getAvgOfTotalUnivercityResults() {
		Session session = sessionFactory.openSession();
		double avg = 0;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.avg("percentage"));
			List<Double> list = criteria.list();
			avg = list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return avg;
	}

	@Override
	public List<Student> getCollegeAvgResult() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection groupProperty = Projections.groupProperty("collegeName");
			Projection avg = Projections.avg("percentage");
			ProjectionList plist = Projections.projectionList();
			plist.add(groupProperty);
			plist.add(avg);
			criteria.setProjection(plist);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> getAvgOfUnivercityBranchWise() {

		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);

			Projection groupProperty = Projections.groupProperty("branchName");
			Projection avg = Projections.avg("percentage");
			ProjectionList plist = Projections.projectionList();

			plist.add(groupProperty);
			plist.add(avg);
			criteria.setProjection(plist);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> getAvgOfCollegeBranchWise() {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			Projection groupProperty1 = Projections.groupProperty("collegeName");
			Projection groupProperty = Projections.groupProperty("branchName");
			Projection avg = Projections.avg("percentage");
			ProjectionList plist = Projections.projectionList();
			plist.add(groupProperty1);
			plist.add(groupProperty);
			plist.add(avg);
			criteria.setProjection(plist);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	@Override
	public String getTotalCountOfStudentsPassorFail(String result) {

		Session session = sessionFactory.openSession();
		long count = 0;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.setProjection(Projections.rowCount()).add(Restrictions.eq("result", result));
			List<Long> list = criteria.list();
			count = list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return "Result Wise Count  " +count;
	}

	@Override
	public List<Student> findGreterStudentper(double percentage) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.gt("percentage", percentage));
			 list = criteria.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> findLessStudentPercentageUsingLessThen(double percentage) {
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.lt("percentage", percentage));
			 list = criteria.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Student> findBetweenPercentageinUnivercityResults(double percentage, double percentage1) {
		
		Session session = sessionFactory.openSession();
		List<Student> list = null;
		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.between("percentage", percentage, percentage1));
			 list = criteria.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
