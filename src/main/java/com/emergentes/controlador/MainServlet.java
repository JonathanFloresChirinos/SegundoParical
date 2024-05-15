package com.emergentes.controlador;

import com.emergentes.modelo.Seminario;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "listado";
            ArrayList<Seminario> seminario = new ArrayList<Seminario>();
            ConexionBD ses = new ConexionBD();
            Connection con = ses.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("listado")) {
                String sql = "select * from estudiantes";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Seminario sem = new Seminario();
                    sem.setId(rs.getInt("id"));
                    sem.setNombres(rs.getString("nombres"));
                    sem.setApellidos(rs.getString("apellidos"));
                    sem.setSeminario(rs.getString("seminario"));
                    sem.setConfirmado(rs.getString("confirmado"));
                    sem.setFecha(rs.getString("fecha"));
                    seminario.add(sem);
                }
                request.setAttribute("sem", seminario);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if (op.equals("nuevo")) {
                Seminario sem = new Seminario();
                request.setAttribute("part", sem);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
            if (op.equals("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "select * from estudiantes where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                rs.next();
                Seminario sem = new Seminario();

                sem.setId(id);
                sem.setNombres(rs.getString("nombres"));
                sem.setApellidos(rs.getString("apellidos"));
                sem.setSeminario(rs.getString("seminario"));
                sem.setConfirmado(rs.getString("confirmado"));
                sem.setFecha(rs.getString("fecha"));
                
                request.setAttribute("part", sem);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
            if (op.equals("eliminar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "delete from estudiantes where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainServlet");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR AL CONECTAR CON LA BASE DE DATOS: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String seminario = request.getParameter("seminario");
            String confirmado = request.getParameter("confirmado");
            String fecha = request.getParameter("fecha");

            Seminario sem = new Seminario();
            sem.setId(id);
            sem.setNombres(nombres);
            sem.setApellidos(apellidos);
            sem.setSeminario(seminario);
            sem.setConfirmado(confirmado);
            sem.setFecha(fecha);

            ConexionBD ses = new ConexionBD();
            Connection con = ses.conectar();
            PreparedStatement ps;
            ResultSet rs;
            
            if (id == 0) {
                String sql = "insert into estudiantes (nombres,apellidos,seminario,confirmado,fecha) values (?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, sem.getNombres());
                ps.setString(2, sem.getApellidos());
                ps.setString(3, sem.getSeminario());
                ps.setString(4, sem.getConfirmado());
                ps.setString(5, sem.getFecha());
                
                ps.executeUpdate();
            } else {
                String sql = "update estudiantes set nombres=?, apellidos=?, seminario=?, confirmado=?, fecha=? where id = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, sem.getNombres());
                ps.setString(2, sem.getApellidos());
                ps.setString(3, sem.getSeminario());
                ps.setString(4, sem.getConfirmado());
                ps.setString(5, sem.getFecha());
                ps.setInt(6, sem.getId());
                ps.executeUpdate();
            }
            response.sendRedirect("MainServlet");
        } catch (SQLException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
