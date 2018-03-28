package com.backend.restbackend.daoimpl;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.restbackend.dao.LoginDAO;
import com.backend.restbackend.user.dto.DistanceClass;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.model.DistanceClassModel;



/**
 * @author Sk Saddam Hosan
 *
 */
@Repository("loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {
	
	private static final Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.backend.restapi.dao.LoginDAO#checkLogin(com.backend.restapi.dto.User)
	 * 
	 * this is for login user or shopKeeper login validation
	 * 
	 */
	@Override
	public User checkLogin(User loginuser) {
		
		log.debug("Inserting LoginDAOImpl class of checkLogin() method");
		User user = null;
		String User_Name = loginuser.getUser_Name();
		String User_Password = loginuser.getUser_Password();
		try {
			String selectLogin = "FROM User WHERE User_Name = ? AND User_Password = ? AND is_Active =:is_Active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectLogin);

			query.setParameter(0, User_Name);
			query.setParameter(1, User_Password);
			query.setParameter("is_Active", true);
			List<User> list = query.getResultList();

			if ((list != null) && (list.size() > 0)) {
				// userFound= true;
				log.debug("get successful,User Name and Password found");
				user = list.get(0);
				return user;
			} else {
				log.debug("get successful,No User Name and Password found ");
				return user;
			}

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
			/*
			 * if (sessionFactory != null) { sessionFactory.close(); }
			 */
		}
	}

	/* (non-Javadoc)
	 * @see com.backend.restbackend.dao.LoginDAO#validDistance(com.backend.restbackend.user.dto.Distance)
	 */
	@Override
	public List<DistanceClass> validDistance(DistanceClassModel distanceClass) {
		try {
			String name = distanceClass.getName();
			double lat = distanceClass.getLat();
			double lng = distanceClass.getLng();
			int range = distanceClass.getRange();
    String sqlQuery = "FROM DistanceClass WHERE ((((ACOS( SIN(RADIANS("
					+ lat
					+ ")) * SIN(RADIANS(lat)) + COS(RADIANS("
					+ lat
					+ ")) * COS(RADIANS(lat)) * COS(RADIANS(lng) - RADIANS("
					+ lng
					+ ")) ) * 3963.1676) <= "
					+ range
					+ ")AND(name=:name )) OR (lat = "
					+ lat
                     + "AND lng ="
                     + lng
                     + ")) ";
			
		//String sqlQuery = "FROM DistanceClass WHERE ((((ACOS( SIN(RADIANS(:lat)) * SIN(RADIANS(lat)) + COS(RADIANS(:lat)) * COS(RADIANS(lat)) * COS(RADIANS(lng) - RADIANS(:lng)) ) * 3963.1676) <= (:range)) AND (name=:name )) OR (lat =:lat AND lng =:lng))";	
    List<DistanceClass> list = sessionFactory.getCurrentSession().createQuery(sqlQuery,DistanceClass.class)
			    .setParameter("name", name)
			    .setMaxResults(15)
			    .getResultList();
	        if ((list != null) && (list.size() > 0)) {
				log.debug("get successful,User Name and Password found");
				return list;
			} else {
				log.debug("get successful,No User Name and Password found ");
				return list;
			}
			
			
			
//			String sqlQuery = "SELECT (ACOS( SIN(RADIANS("
//					+ lat
//					+ ")) * SIN(RADIANS(lat)) + COS(RADIANS("
//					+ lat
//					+ ")) * COS(RADIANS(lat)) * COS(RADIANS(lng) - RADIANS("
//					+ lng
//					+ ")) ) * 3963.1676) FROM DistanceClass WHERE (((ACOS( SIN(RADIANS("
//					+ lat
//					+ ")) * SIN(RADIANS(lat)) + COS(RADIANS("
//					+ lat
//					+ ")) * COS(RADIANS(lat)) * COS(RADIANS(lng) - RADIANS("
//					+ lng
//					+ ")) ) * 3963.1676) <= "
//					+ range
//					+ ") OR (lat = "
//					+ lat
//                     + "AND lng ="
//                     + lng
//                     + "))";
			
			//List<DistanceClass> list = sessionFactory.getCurrentSession().createQuery(sqlQuery).getResultList();
			
			
			
			//query.setParameter("lat", lat);
			//query.setParameter("lng", lng);
			//query.setParameter("range", range);
		
				//query.setParameter("lat", lat);
				//query.setParameter("lng", lng);
				//query.setParameter("range", range);
			
//			String sqlValue0 = "SELECT id, (6371 * acos (cos(radians("
//	                + lat
//	                + ")) * cos(radians(lat)) * cos(radians(lng) - radians("
//	                + lng
//	                + "))  + sin(radians("
//	                + lat
//	                + ")) * sin(radians(lat)))) AS distance FROM DistanceClass where HAVING distance < "
//	                + range + " ORDER BY distance";
			
		//	String sqlValue = "SELECT ( 3959 * acos (cos ( radians(:lat) )* cos( radians( lat ) )* cos( radians( lng ) - radians(:lng) )+ sin ( radians(:lat) )* sin( radians( lat ) ))) AS distance FROM Distance HAVING distance < :range ORDER BY distance LIMIT 0 , 10" ;			
			
//			String sqlValue1 = "SELECT \n" +
//		            "  (\n" +
//		            "    3959 * acos(\n" +
//		            "        cos(radians(lat))\n" +
//		            "        * cos(radians(:lat))\n" +
//		            "        * cos(radians(:lon) - radians(lon))\n" +
//		            "        + sin(radians(lat))\n" +
//		            "          * sin(radians(:lat))\n" +
//		            "    )\n" +
//		            "  ) AS distance\n" +
//		            "FROM Distance \n" +
//		            "HAVING distance < 9\n" +
//		            "ORDER BY distance asc";
			
			//Query query = sessionFactory.getCurrentSession().createQuery(sqlValue0);
			//List<Object[]> list = null;
	       // list = query.list();
			//query.setParameter("lat", lat);
			//query.setParameter("lng", lng);
			//query.setParameter("range", range);

			//List<DistanceClass> list = query.getResultList();
			
//			String selectLogin = "FROM User WHERE User_Name = ? AND User_Password = ? AND is_Active =:is_Active";
//			Query query = sessionFactory.getCurrentSession().createQuery(selectLogin);
//           SELECT id,address, ( 3959 * acos (cos ( radians(12.997674) )* cos( radians( lat ) )* cos( radians( lng ) - radians(77.544044) )+ sin ( radians(12.997674) )* sin( radians( lat ) ))) AS distance FROM markers HAVING distance < 12 ORDER BY distance LIMIT 0 , 10
//			query.setParameter(0, User_Name);
//			query.setParameter(1, User_Password);
//			query.setParameter("is_Active", true);

			

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
			/*
			 * if (sessionFactory != null) { sessionFactory.close(); }
			 */
		}
	}

}
