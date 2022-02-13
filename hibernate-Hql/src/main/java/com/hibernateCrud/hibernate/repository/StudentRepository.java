package com.hibernateCrud.hibernate.repository;

import com.hibernateCrud.hibernate.HibernateUtil.HibernateUtil;
import com.hibernateCrud.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {
    public void saveStudent(Student student){
        Transaction transaction=null;
        Session session=null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }finally {
            session.close();
        }
    }
    public void updateStudent(Student student){
        Transaction transaction=null;
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
        }catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
        }finally {
            session.close();
        }
    }
    public Student findStudentById(long id){
        Transaction transaction=null;
        Session session=null;
        Student student=null;
                try{
                    session=HibernateUtil.getSessionFactory().openSession();
                    transaction=session.beginTransaction();
                   // Query query=session.createQuery()
                    student=session.get(Student.class,id);
                    transaction.commit();
                }catch (Exception e){
                    if (transaction!=null){
                        transaction.rollback();
                    }
                }finally {
                    session.close();
                }
                return  student;
    }


    public List<Student> getAllStudents() {
        Transaction transaction = null;
        List<Student> students = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // save the student object
            Query query=session.createQuery("from Student where ad=:add");
            query.setParameter("add","abdulvaha guncel");
            students=query.list();
            //students=session.createQuery("from Student").list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return students;
    }
    public List<Student> getStudentByName(String studentName) {
        Transaction transaction = null;
        List<Student> students = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // save the student object
            Query query=session.createQuery("from Student where ad=:add");
            query.setParameter("add",studentName);
            students=query.list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        return students;
    }
    public void deleteStudent(long id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // save the student object
            student=session.get(Student.class,id);
            session.delete(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction!=null) {
                transaction.rollback();
            }
        }
    }

}
