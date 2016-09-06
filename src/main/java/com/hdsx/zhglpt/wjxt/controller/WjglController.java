package com.hdsx.zhglpt.wjxt.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.zhglpt.file.bean.MyFile;
import com.hdsx.zhglpt.file.controller.PropertiesReader;
import com.hdsx.zhglpt.utile.EasyUIPage;
import com.hdsx.zhglpt.utile.JsonUtils;
import com.hdsx.zhglpt.utile.ResponseUtils;
import com.hdsx.zhglpt.wjxt.bean.Bgda;
import com.hdsx.zhglpt.wjxt.bean.FileUrl;
import com.hdsx.zhglpt.wjxt.bean.GcdaZtjl;
import com.hdsx.zhglpt.wjxt.bean.Wjgl;
import com.hdsx.zhglpt.wjxt.server.WjglServer;
import com.hdsx.webutil.struts.BaseActionSupport;
import com.hdsx.zhglpt.wjxt.bean.Gcda;


/**
 * 系统管理Controller层
 * @author qwh
 *
 */
@Scope("prototype")
@Controller
public class WjglController extends BaseActionSupport{

	private static final long serialVersionUID = 1L;
	private int page = 1;
	private int rows = 10;
	@Resource(name = "wjglServerImpl")
	private WjglServer wjglServer;
	private Wjgl wjgl=new Wjgl();
	private Gcda gcda=new Gcda();
	private Bgda bgda=new Bgda();
	private String id;
	private String fileuploadFileName;
	private File fileupload;
	private String gydw;
	private String kssj;
	private String jssj;
	private String wjmc;
	private String xmmc;
	private String damc;
	private String bzdw;
	
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getDamc() {
		return damc;
	}
	public void setDamc(String damc) {
		this.damc = damc;
	}
	public String getBzdw() {
		return bzdw;
	}
	public void setBzdw(String bzdw) {
		this.bzdw = bzdw;
	}
	public String getWjtype() {
		return wjtype;
	}
	public void setWjtype(String wjtype) {
		this.wjtype = wjtype;
	}
	public String getWjid() {
		return wjid;
	}
	public void setWjid(String wjid) {
		this.wjid = wjid;
	}

	private String wjtype;
	private String wjid;
	private String wjgy;
	private GcdaZtjl gcdaZtjl;
	
	
	
	public GcdaZtjl getGcdaZtjl() {
		return gcdaZtjl;
	}
	public void setGcdaZtjl(GcdaZtjl gcdaZtjl) {
		this.gcdaZtjl = gcdaZtjl;
	}
	public String getWjgy() {
		return wjgy;
	}
	public void setWjgy(String wjgy) {
		this.wjgy = wjgy;
	}
	public String getWjmc() {
		return wjmc;
	}
	public void setWjmc(String wjmc) {
		this.wjmc = wjmc;
	}
	public String getGydw() {
		return gydw;
	}
	public void setGydw(String gydw) {
		this.gydw = gydw;
	}
	public String getKssj() {
		return kssj;
	}
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getFileuploadFileName() {
		return fileuploadFileName;
	}
	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}
	public File getFileupload() {
		return fileupload;
	}
	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Wjgl getWjgl() {
		return wjgl;
	}
	public void setWjgl(Wjgl wjgl) {
		this.wjgl = wjgl;
	}
	
	public Gcda getGcda() {
		return gcda;
	}
	public void setGcda(Gcda gcda) {
		this.gcda = gcda;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public Bgda getBgda() {
		return bgda;
	}
	public void setBgda(Bgda bgda) {
		this.bgda = bgda;
	}
	public void queryZtjlByDaId(){
		try {
			JsonUtils.write(wjglServer.queryZjxdById(gcdaZtjl), getresponse().getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addGcdaZtjl(){
		boolean bl=wjglServer.addGcdaZtjl(gcdaZtjl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void delGcdaZtjlById(){
		boolean bl=wjglServer.delGcdaZtjlById(gcdaZtjl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void editGcdaZtjl(){
		boolean bl=wjglServer.editGcdaZtjl(gcdaZtjl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void uploadWjFile() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			InputStream inputStream = new FileInputStream(fileupload);
			String s = UUID.randomUUID().toString(); 
			String s1 = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
			String fileurl=PropertiesReader.getInstance().getFileUrl();
			wjgl.setId(s1);
			wjgl.setWjid(id);
			wjgl.setWjname(fileuploadFileName);
			wjgl.setWjfile(inputStreamToByte(inputStream));
			wjgl.setFileurl(fileurl);
			wjgl.setWjgy(wjgy);
			
			File file =new File(fileurl);
			boolean have=uploadFile(file,fileuploadFileName,
					fileupload);
			if(!have){
				response.getWriter().print(fileuploadFileName+"已存在，请重命名文件或删除之前已存在的文件");
			}else{
				boolean bl=wjglServer.uploadWjFile(wjgl);
				if(bl)
				response.getWriter().print(fileuploadFileName+"    上传成功"+s1);
				else
				response.getWriter().print(fileuploadFileName+"    上传失败"+s1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().print(fileuploadFileName +"上传失败！");
			e.printStackTrace();
		}
	}
	

	private boolean uploadFile(File file,String fileName,File filewj) throws FileNotFoundException,IOException {
		if(!file.exists()){
			file.mkdirs();
		}
		
		File saveFile =new File(file, fileName);
		boolean have=saveFile.exists();
		if(have){
			return false;
		}
		InputStream is = new FileInputStream(filewj); 
		OutputStream os = new FileOutputStream(saveFile);
		//设置缓存  
		byte[] buffer = new byte[1024]; 
		int length = 0;
		while((length= is.read(buffer))>0){
			os.write(buffer,0,length);
		}
		is.close();
		os.flush();
		os.close();
		return true;
	}
	public void deleteWjfile(){
		boolean bl=wjglServer.deleteWjfile(wjgl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void deleteGcdafile(){
		List<Wjgl> list = wjglServer.selectWjfileByWjid(wjgl);
		for(Wjgl l:list){
			File file =new File(l.getFileurl(), l.getWjname());
			boolean have=file.exists();
			if(have)			
				file.delete();
		}
		boolean bl=wjglServer.deleteWjfile(wjgl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void deleteWjfile1(){
		boolean bl=wjglServer.deleteWjfile1(id);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void deleteQtWjfile1(){
		boolean bl=wjglServer.deleteQtWjfile1(id);
		ResponseUtils.write(getresponse(), bl+"");
	}
	
	public void insertZcwj(){
		wjgl.setFbdw(wjgl.getFbdw().replaceAll("0*$",""));
		boolean bl=wjglServer.insertZcwj(wjgl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void insertQtwj(){
		boolean bl=wjglServer.insertQtwj(gcda);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void insertJhwj(){
		boolean bl=wjglServer.insertJhwj(bgda);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void updateZcwj(){
		wjgl.setFbdw(wjgl.getFbdw().replaceAll("0*$",""));
		boolean bl=wjglServer.updateZcwj(wjgl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void updateQtwj(){
		boolean bl=wjglServer.updateQtwj(gcda);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void updateJhwj(){
		boolean bl=wjglServer.updateJhwj(bgda);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void deleteZcwj(){
		List<Wjgl> list = wjglServer.selectWjfile(wjgl);
		for(Wjgl l:list){
			File file =new File(l.getFileurl(), l.getWjname());
			boolean have=file.exists();
			if(have)			
				file.delete();
		}
		boolean bl=wjglServer.deleteZcwj(wjgl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void deleteQtwj(){
		List<Wjgl> list = wjglServer.selectWjfile(wjgl);
		for(Wjgl l:list){
			File file =new File(l.getFileurl(), l.getWjname());
			boolean have=file.exists();
			if(have)			
				file.delete();
		}
		boolean bl=wjglServer.deleteQtwj(wjgl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void deleteJhwj(){
		List<Wjgl> list = wjglServer.selectWjfile(wjgl);
		for(Wjgl l:list){
			File file =new File(l.getFileurl(), l.getWjname());
			boolean have=file.exists();
			if(have)			
				file.delete();
		}
		boolean bl=wjglServer.deleteJhwj(wjgl);
		ResponseUtils.write(getresponse(), bl+"");
	}
	public void selectzcwjlist(){
		wjgl.setJsdw(gydw);
		wjgl.setKssj(kssj);
		wjgl.setJssj(jssj);
		wjgl.setWjmc(wjmc);
		wjgl.setPage(page);
		wjgl.setRows(rows);
		List<Wjgl> list = wjglServer.selectzcwjlist(wjgl);
		int count = wjglServer.selectzcwjlistCount(wjgl);
		EasyUIPage<Wjgl> e=new EasyUIPage<Wjgl>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void selectqtwjlist(){
		gcda.setXmmc(xmmc);
		gcda.setDamc(damc);
		gcda.setBzdw(bzdw);
		gcda.setKssj(kssj);
		gcda.setJssj(jssj);
		gcda.setPage(page);
		gcda.setRows(rows);
		List<Gcda> list = wjglServer.selectqtwjlist(gcda);
		int count = wjglServer.selectqtwjlistCount(gcda);
		EasyUIPage<Gcda> e=new EasyUIPage<Gcda>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void selectjhwjlist(){
		bgda.setXmmc(xmmc);
		bgda.setDamc(damc);
		bgda.setBzdw(bzdw);
		bgda.setKssj(kssj);
		bgda.setJssj(jssj);
		bgda.setPage(page);
		bgda.setRows(rows);
		List<Bgda> list = wjglServer.selectjhwjlist(bgda);
		int count = wjglServer.selectjhwjlistCount(bgda);
		EasyUIPage<Bgda> e=new EasyUIPage<Bgda>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void selectWjfile(){
		wjgl.setWjid(id);
		List<Wjgl> list = wjglServer.selectWjfile(wjgl);
		try {
			JsonUtils.write(list, getresponse().getWriter());
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void downWjFile() throws IOException{
		try {
			HttpServletResponse response = getresponse();
			OutputStream out = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("multipart/form-data");
			wjgl.setId(id);
			Wjgl wjgl1=wjglServer.selectWjById(wjgl);
			System.out.println("wjgl1.getFileurl()+wjgl1.getWjname()::"+wjgl1.getFileurl()+"\\"+wjgl1.getWjname());
			File file=new File(wjgl1.getFileurl()+"\\"+wjgl1.getWjname());
			
			response.addHeader("Content-Disposition", "attachment;filename="+ new String(wjgl1.getWjname().getBytes("gb2312"), "ISO-8859-1"));
			try {
				FileInputStream fis= new FileInputStream(file);
				byte [] arr = new byte[1024*10];
				int i;
				while((i=fis.read(arr))!=-1){
					out.write(arr,0,i);
					out.flush();
				}
				fis.close();
				out.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private byte [] inputStreamToByte(InputStream is) throws IOException { 
	    ByteArrayOutputStream bAOutputStream = new ByteArrayOutputStream(); 
	    byte [] arr = new byte[1024*10];
	    int ch; 
	    while((ch = is.read(arr) ) != -1){ 
	        bAOutputStream.write(arr,0,ch); 
	    } 
	    byte data [] =bAOutputStream.toByteArray(); 
	    bAOutputStream.close(); 
	    return data; 
	}
}
