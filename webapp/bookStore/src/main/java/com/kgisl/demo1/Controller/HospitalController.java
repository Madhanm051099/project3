package com.kgisl.demo1.Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kgisl.demo1.entity.Hospital;
//@WebServlet("/hospital")

public class HospitalController extends HttpServlet {
    ArrayList<Hospital> hospital1 = null;
    List<Hospital> hospital= null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    inserthospital(req, resp);
                    break;
                case "/delete":
                    deletehospital(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updatehospital(req, resp);
                    break;
                default:
                    listhospital(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void listhospital(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/hospital1?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            hospital = new ArrayList<Hospital>();
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from hospital");
            while (rset.next()) {
                hospital.add(new Hospital(rset.getInt("hospital_id"), rset.getString("hospital_name"), rset.getString("hospital_address"),
                        rset.getInt("hospital_conno")));
            }
            // String s = "BatMan";
            // req.setAttribute("s", s);
            stmt.close();
            con.close();
            req.setAttribute("hospital", hospital);
            RequestDispatcher dis = req.getRequestDispatcher("Hospitalform.jsp");
            dis.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Hospitallist.jsp");
        dispatcher.forward(req, resp);
    }
    public void inserthospital(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/hospital1?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            //int hospital_id=Integer.parseInt(req.getParameter("hospital_id"));
            String hospital_name = req.getParameter("hospital_name");
            String hospital_address = req.getParameter("hospital_address");
            int hospital_conno = Integer.parseInt(req.getParameter("hospital_conno"));
            Hospital hospital = new Hospital(hospital_name,hospital_address,hospital_conno);
            String sql = "INSERT INTO hospital (hospital_name, hospital_address, hospital_conno) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            //statement.setInt(1, hospital.getHospital_id());
            statement.setString(1, hospital.getHospital_name());
            statement.setString(2, hospital.getHospital_address());
            statement.setInt(3, hospital.getHospital_conno());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletehospital(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/hospital1?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int hospital_id = Integer.parseInt(req.getParameter("hospital_id"));
            Hospital hospital = new Hospital(hospital_id);
            String sql = "DELETE FROM hospital where hospital_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, hospital.getHospital_id());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatehospital(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/hospital1?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int hospital_id = Integer.parseInt(req.getParameter("hospital_id"));
            String hospital_name = req.getParameter("hospital_name");
            String hospital_address = req.getParameter("hospital_address");
            int hospital_conno = Integer.parseInt(req.getParameter("hospital_conno"));
            Hospital hospitals = new Hospital(hospital_name,hospital_address,hospital_conno);
            String sql = "UPDATE hospital SET hospital_name = ?, hospital_address = ?, hospital_conno = ?";
            sql += " WHERE hospital_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, hospitals.getHospital_id());
            statement.setString(2, hospitals.getHospital_address());
            statement.setString(3, hospitals.getHospital_name());
            statement.setInt(4, hospitals.getHospital_conno());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/hospital1?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int hospital_id = Integer.parseInt(req.getParameter("id"));
            Hospital hospital = null;
            String sql = "SELECT * FROM hosital WHERE hospital_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, hospital_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String hospital_name = resultSet.getString("hospital_name");
                String hospital_address = resultSet.getString("hospital_address");
                int hospital_conno = resultSet.getInt("hospital_conno");
                hospital = (new Hospital(hospital_name,hospital_address,hospital_conno));
            }
            resultSet.close();
            statement.close();
            con.close();
            RequestDispatcher dispatcher = req.getRequestDispatcher("Hospitallist.jsp");
            req.setAttribute("hospital",hospital);
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}







