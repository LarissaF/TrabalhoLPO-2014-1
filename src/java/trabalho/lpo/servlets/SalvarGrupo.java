/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.lpo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trabalho.lpo.classes.Grupo;
import trabalho.lpo.db.GrupoDAO;

/**
 *
 * @author taiany.coelho
 */
@WebServlet(name = "SalvarGrupo", urlPatterns = {"/salvar-grupo.do"})
public class SalvarGrupo extends HttpServlet {
    
    
    public static GrupoDAO dao = null;

    public SalvarGrupo() throws Exception{
        
               try {
           dao = new GrupoDAO();
             
        } catch (Exception ex) {
            throw new ServletException("Erro ao criar o comando SQL");
        }
    }
    
    
 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
 
        Grupo grupo = new Grupo();
        GrupoDAO dao = new GrupoDAO();
 
        grupo.setTitulo(request.getParameter("titulo"));
        grupo.setDescricao(request.getParameter("descricao"));
        grupo.setFase(Integer.parseInt(request.getParameter("fase")));
        grupo.setCodGrupo(Integer.parseInt(request.getParameter("cod_grupo")));
        dao.salvarGrupo(grupo);

        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SalvarOferta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SalvarGrupo at " + request.getContextPath() + "</h1>");
            out.println("Titulo: " + grupo.getTitulo());
            out.println("</br>Descrição Grupo: " + grupo.getDescricao());
            out.println("</br>Fase: " + grupo.getFase());
            out.println("</br><a href='lista-grupo.html'>Listar</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SalvarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}