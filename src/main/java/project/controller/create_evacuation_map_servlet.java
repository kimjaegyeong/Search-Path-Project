package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.test.DTO.*;
import project.test.DAO.*;
/**
 * Servlet implementation class create_evacuation_map_servlet
 */

@WebServlet("/create_evaucation_map")
public class create_evacuation_map_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create_evacuation_map_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int MatSize = Integer.parseInt(request.getParameter("MatrixSize"));

		Block[] block= new Block[MatSize];
		String room= "";
		String arr="";
	
		for(int i=0; i<MatSize; i++) {
			
			block[i] = new Block();
			String numbers= "number"+i;
			room= request.getParameter(numbers);
			arr = arr+ room+",";
			block[i].setRoom(room) ;
			block[i].setAreaNumber(i);
			if(room.equals("path")) {
				block[i].setColor("green");
			}
			else if(room.equals("exit")) {
				block[i].setColor("blue");
			}
			else {
				block[i].setColor("gray");
			}
					
		}
		create_evacuation_map_DAO map = new create_evacuation_map_DAO();
		boolean check = map.insert_evaucation_map(arr, MatSize, "floor4");
		if(check) {
			request.setAttribute("block", block);
			request.getRequestDispatcher("show_evacuation_map.jsp").forward(request, response);
		}
	}
}
