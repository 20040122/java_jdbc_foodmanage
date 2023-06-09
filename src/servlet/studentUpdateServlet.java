package servlet;

import Dao.StudentDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/studentUpdateServlet")
public class studentUpdateServlet extends HttpServlet {
    private static final long serialVersionUid = 1L;
    public studentUpdateServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid= req.getParameter("sid");
        String sname= req.getParameter("sname");
        String sex=req.getParameter("sex");
        Student student=new Student(sid,sname,sex);
        StudentDao dao = new StudentDao();
        dao.update(student);
        resp.sendRedirect("StudentDel.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}


