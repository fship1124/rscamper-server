/*
 *   모든 페이지에서 사용할 수 있도록 공통 컴포넌트로 생성
 */
package kr.co.rscamper.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/images")
public class DownloadImage extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		File f = new File(uploadPath + path);
		response.setHeader("Content-Type", "image/jpg");

		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);

		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);

		while (true) {
			int ch = bis.read();
			if (ch == -1)
				break;

			bos.write(ch);
		}

		bis.close();
		fis.close();
		bos.close();
		out.close();
	}
}
