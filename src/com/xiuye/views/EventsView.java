package com.xiuye.views;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name="events")
@RequestScoped
public class EventsView {


	private void say(String info){
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(info));
	}
	
	public void phisics(){
		say("物理");
	}
	public void english(){
		say("英语");
	}
	public void c_cpp(){
		say("C/C++");
	}
	public void java(){
		say("Java");
	}
	public void python(){
		say("Python");
	}
	public void js(){
		say("JavaScript");
	}
	public void jquery(){
		say("JQuery");
	}
	
	public void csharp(){
		say("C#");
	}
	public void oc(){
		say("Objective-c");
	}
	public void swift(){
		say("Swift");
	}
	public void php(){
		say("Php");
	}
	public void nodejs(){
		say("Node.js");
	}
	public void html(){
		say("Html");
	}
	public void vb(){
		say("VB");
	}
	public void delphi(){
		say("Delphi");
	}
	public void erlang(){
		say("Erlang");
	}
	public void shell(){
		say("Shell");
	}
	
	public void powerShell(){
		say("PowerShell");
	}
	public void sql(){
		say("SQL");
	}
	public void asp(){
		say("ASP.NET");
	}
	public void jsp(){
		say("JSP");
	}
	public void matlab(){
		say("Matlab");
	}
	
	public void css(){
		say("CSS");
	}
	
	public void oracle(){
		say("Oracle");
	}
	
	public void mysql(){
		say("Mysql");
	}
	public void sqlServer(){
		say("Sql Server");
	}
	public void sybase(){
		say("Sybase");
	}
	public void windows(){
		say("Windows");
	}
	public void linux(){
		say("Linux");
	}
	public void android(){
		say("Android");
	}
	public void mac(){
		say("Mac");
	}
	public void unix(){
		say("Unix");
	}
	public void qt(){
		say("QT");
	}
	public void mfc(){
		say("MFC");
	}
	public void boost(){
		say("Boost");
	}
	public void spring(){
		say("Spring");
	}
	public void hibernate(){
		say("Hibernate");
	}
	
	public void mybatis(){
		say("Mybatis");
	}
	public void struts(){
		say("Struts");
	}
	public void jfinal(){
		say("JFinal");
	}
	public void cocos2d(){
		say("Cocos2D");
	}
	public void unity3d(){
		say("Unity3D");
	}
	public void bootstrap(){
		say("Bootstrap");
	}
	public void angularjs(){
		say("Angularjs");
	}
	public void reactjs(){
		say("Reactjs");
	}
	public void extjs(){
		say("Extjs");
	}	
	public void ice(){
		say("ICE");
	}
	
	public void opengl(){
		say("OpenGL");
	}
	public void directX(){
		say("DirectX");
	}
	public void networkTheory(){
		say("网络理论");
	}
	public void networkApply(){
		say("网络应用");
	}
	public void networkProgramming(){
		say("网络编程");
	}
	public void javaParallel(){
		say("Java多线程");
	}
	public void linuxParallel(){
		say("Linux并发|并行");
	}
	public void windowsParallel(){
		say("Windows并发|并行");
	}
	public void androidParallel(){
		say("Android并发|并行");
	}
	public void en_de_coder(){
		say("加密解密");
	}
	public void networkSecurity(){
		say("网络安全");
	}
	public void softwareSecurity(){
		say("软件安全");
	}
	public void assembler(){
		say("汇编");
	}
	public void driver(){
		say("驱动");
	}
	public void intel(){
		say("Intel");
	}
	public void arm(){
		say("Arm");
	}
	public void circuit(){
		say("电路");
	}
	public void photoShop(){
		say("PhotoShop");
	}
	public void flash(){
		say("Flash");
	}
	public void dreamweaver(){
		say("Dreamweaver");
	}
	public void word(){
		say("Word");
	}
	public void excel(){
		say("Excel");
	}
	public void ppt(){
		say("PPT");
	}
	public void visio(){
		say("Visio");
	}
	public void xmind(){
		say("Xmind");
	}
	public void cad(){
		say("CAD");
	}
	public void threeDMax(){
		say("3DMax");
	}
	
	public void powerDesigner(){
		say("PowerDesigner");
	}
	
	
	public void basicSubjects(){
		say("基础学科全部");
	}
	public void developmentFramework(){
		say("开发框架全部");
	}
	public void gameDevelopment(){
		say("游戏开发全部");
	}
	public void network(){
		say("网络全部");
	}
	public void webDevelopment(){
		say("网站开发全部");
	}
	public void parallel(){
		say("并发|并行全部");
	}
	public void informationSecurity(){
		say("信息安全全部");
	}
	public void hardwareLowLevel(){
		say("硬件底层全部");
	}
	
	public void other(){
		say("其它全部");
	}
	
	public void math(){
		say("数学");
	}
	public void dataStructureAndAlgorithm(){
		say("数据结构算法");
	}
	
	public void DB(){
		say("数据库全部");
	}
	public void programming(){
		say("编程语言全部");
	}
	public void OS(){
		say("操作系统全部");
	}
	
	
}
