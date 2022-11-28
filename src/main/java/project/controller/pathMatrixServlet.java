package project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.test.DTO.Block;

/**
 * Servlet implementation class pathMatrixServlet
 */
public class pathMatrixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public pathMatrixServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		final int matrixSize= 5; 	
		int width;
		int height;
		int count =0 ;
		Block[][] blockMatrix = new Block[matrixSize][matrixSize];
		
		//블록 초기화 
		for(width=0; width<matrixSize; width++) {
			
			for(height=0; height<matrixSize; height++) {
				blockMatrix[width][height] = new Block();
				//일단 모든 블록을 복도로 초기화
				blockMatrix[width][height].setAreaNumber(count);
				blockMatrix[width][height].setRoom("path");
				blockMatrix[width][height].setColor("green");
				count ++;
			}
		}
		// 호실 표시 
		
		
		blockMatrix[0][0].setRoom("401");
		blockMatrix[0][0].setColor("e7e7e7");

		blockMatrix[0][1].setRoom("401");
		blockMatrix[0][1].setColor("e7e7e7");

		blockMatrix[0][3].setRoom("restroom");
		blockMatrix[0][3].setColor("e7e7e7");
		
		
		blockMatrix[2][0].setRoom("402");
		blockMatrix[2][0].setColor("e7e7e7");
		
		blockMatrix[2][1].setRoom("402");
		blockMatrix[2][1].setColor("e7e7e7");
		
		blockMatrix[3][4].setRoom("403");
		blockMatrix[3][4].setColor("e7e7e7");
		
		blockMatrix[4][4].setRoom("403");
		blockMatrix[4][4].setColor("e7e7e7");
		
		blockMatrix[3][3].setRoom("403");
		blockMatrix[3][3].setColor("e7e7e7");
		
		blockMatrix[4][3].setRoom("403");
		blockMatrix[4][3].setColor("e7e7e7");
	
		//비상구 블록 표시

		blockMatrix[0][4].setRoom("escape");
		blockMatrix[0][4].setColor("#008CBA");
		
		blockMatrix[4][0].setRoom("escape");
		blockMatrix[4][0].setColor("#008CBA");
		
		blockMatrix[3][0].setRoom("escape");
		blockMatrix[3][0].setColor("#008CBA");
		
		blockMatrix[2][2].setRoom("fire");
		blockMatrix[3][0].setColor("red");
		request.setAttribute("blockMatrix", blockMatrix);
		request.getRequestDispatcher("test.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
