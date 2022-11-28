package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.test.DAO.*;
import project.test.DTO.*;
/**
 * Servlet implementation class user_show_evacuation_map_servlet
 */
public class user_show_evacuation_map_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_show_evacuation_map_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] map_info = new String[3];
		
		evacuation_map_DAO dao= new evacuation_map_DAO();
		map_info= dao.select_evacuation_map();
		
		int mapSize = Integer.parseInt(map_info[0]);
		Block block[] = new Block[mapSize];
		
		String [] room =map_info[1].split(",");
	
		for(int i=0; i<mapSize; i++) {
			
			block[i]= new Block();
		
			block[i].setRoom(room[i]) ;
			block[i].setAreaNumber(i);
			
			if(room[i].equals("path")) {
				block[i].setColor("green");
			}
			else if(room[i].equals("exit")) {
				block[i].setColor("blue");
			}
			else if (room[i].contains("extinguisher")) {
				block[i].setColor("green");
			}
			else {
				block[i].setColor("gray");
			}
		}
		request.setAttribute("block", block);
		request.getRequestDispatcher("user_show_evacuation_map.jsp").forward(request, response);
	
	}
	}


