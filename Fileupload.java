package com.servicehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;



/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2mb
                 maxFileSize=1024*1024*10,//10mb
                 maxRequestSize=1024*1024*50)//50mb
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html;charset=UTF-8");
		String subfoldername=request.getParameter("foldername");
		String realpath=getServletContext().getRealPath("/");
		
		uploadFileTolocaldirectory(subfoldername,request);
		
		uploadFileToserverContextRealpath(subfoldername,realpath,request);
		
		uploadFileToapplicationdirectory(subfoldername,request);
	}
      
		
	
	
	public static void uploadFileTolocaldirectory(String foldername,HttpServletRequest request) throws IllegalStateException, IOException, ServletException
	{
      
	  String savePath="C:\\rootdir\\"+File.separator+foldername;
	  File fileSaveDir = new File(savePath);
      if (!fileSaveDir.exists()) 
      {
          fileSaveDir.mkdirs();
      }
      
      Part part =request.getPart("file");
      String fileName = extractFileName(part);
      part.write(savePath + File.separator + fileName);
	}
	
	public static void uploadFileToserverContextRealpath(String foldername,String realpath,HttpServletRequest request) throws IllegalStateException, IOException, ServletException
	{
      String savepath=realpath+File.separator+foldername;
	  File fileSaveDir = new File(savepath);
      if (!fileSaveDir.exists()) 
      {
          fileSaveDir.mkdirs();
      }
      
      Part part =request.getPart("file");
      String fileName = extractFileName(part);
      part.write(savepath + File.separator + fileName);
	}
	
	public void uploadFileToapplicationdirectory(String foldername,HttpServletRequest request) throws IllegalStateException, IOException, ServletException
	{
      
		String path="D:\\yeldiallproject\\Fileuploadusingservlet\\WebContent";
		String savepath=path+File.separator+foldername;
	    File fileSaveDir = new File(savepath);
      if (!fileSaveDir.exists()) 
      {
          fileSaveDir.mkdirs();
      }
      
      Part part =request.getPart("file");
      String fileName = extractFileName(part);
      part.write(savepath + File.separator + fileName);
	}
	
	
	private static String extractFileName(Part part) {
	    String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            String filename = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	
	}
 
	


