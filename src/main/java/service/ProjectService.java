package service;

import bl.HibernateUtil;
import bl.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;


public class ProjectService extends SessionUtil implements ProjectDAO {

    public void add(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(project);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Project> getAll() {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM PROJECT";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return projectList;
    }

    public Project getById(Long id) {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM PROJECT WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return project;
    }

    public void update(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Project project) {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        //close session with a transaction
        closeTransactionSession();
    }
}
