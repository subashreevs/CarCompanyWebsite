import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class testServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        try{
            int count;
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            //session.setMaxInactiveInterval(30);
            if(session.getAttribute("count") != null){
                count = (int)session.getAttribute("count");
            }
            else{
                count =0;
            }
            count++;
            session.setAttribute("count", count);
            out.println("Number of users visited the page: " +count);

        }
        catch(Exception e){
            System.out.println(e);
        }


        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String model = request.getParameter("model");

        out.println("<HTML><head><title>TEST DRIVE DETAILS</title><hr></head>");
        
        out.println("<body style='font-size: 20pt; background: rgb(10,11,41); background: radial-gradient(circle, #3f1b1b 20%, #000 69%); color: white;'> <table width=50% style='border:2px solid white text-align: center' align='center'> <tr style='border:2px solid white'><th style='border:2px solid white'>Customer Name: </th><td style='border:2px solid white'>"+name+"</td></tr> <tr style='border:2px solid white'><th style='border:2px solid white'>Age: </th><td style='border:2px solid white'>"+age+"</td></tr> <tr style='border:2px solid white'><th style='border:2px solid white'>Phone: </th><td style='border:2px solid white'>"+phone+"</td></tr> <tr style='border:2px solid white'><th style='border:2px solid white'>Car Model: </th><td style='border:2px solid white'>"+model+"</td></tr></table></body>");


    } 

}