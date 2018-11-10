package br.com.uniara.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uniara.model.Aluno;
import br.com.uniara.service.AlunoService;

@WebServlet("/AlunoServlet")
public class AlunoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Acessei aluno pelo get ");
		
		AlunoService alunoService = new AlunoService();
		String obter = alunoService.obterTudo();
		
		response.getWriter().append(obter);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.getWriter().append("Acessei aluno pelo Post");
		// TODO Auto-generated method stub
				
		int ra = Integer.parseInt(request.getParameter("ra"));
		int idade = Integer.parseInt(request.getParameter("age"));
		int curso = Integer.parseInt(request.getParameter("course"));
		String nome = request.getParameter("name");
		String sobrenome = request.getParameter("lastName");
		
		Aluno aluno = new Aluno();
		aluno.setRa(ra);
		aluno.setIdade(idade);
		aluno.setCurso(curso);
		aluno.setNome(nome);
		aluno.setSobrenome(sobrenome);
	
		AlunoService alunoService = new AlunoService();
		alunoService.salvar(aluno);
	}

}
