package com.spring.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.Emp2DTO;
import com.spring.domain.EmpDTO;
import com.spring.domain.sDTO;
import com.spring.service.Emp2Service;
import com.spring.service.EmpService;
import com.spring.service.SampleService;

import lombok.Delegate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@Controller
@RequestMapping(value="/all/*" )
@RequiredArgsConstructor
public class mSampleController {
	private final SampleService service;
	private final EmpService empservice;
	private final Emp2Service emp2service;
	//localhost:8080/ex01/all/sample1
	@GetMapping("/sample1")
	public String Sample1() {
		
		return "/all/sample1";
	}
	
	
	
	@GetMapping("/sample2")
	public String Sample2() {
		return "/sample/sample2";
	}
	@GetMapping("/sample3")
	public String Sample3() {
		return "/sample/sample3";
	}
	@GetMapping("/sample4")
	public String Sample4() {
		return "/sample/sample4";
	}
	@GetMapping("/sample5")
	public String Sample5() {
		return "/sample/sample5";
	}
	@GetMapping("/sample6")
	public String Sample6() {
		return "/sample/sample6";
		
	}
	@GetMapping("/sample7")
	public String Sample7() {
		return "/sample/sample7";
		
	}
	@GetMapping("/sample8")
	public String Sample8() {
		return "/sample/sample8";
	}
	@GetMapping("/sample9")
	public String Sample9() {
		return "/sample/sample9";
	}
	@GetMapping("/sample10")
	public String sample10() {
		return "/sample/sample10";
	}
	@GetMapping("/sample11")
	public String sample11() {
		return "/sample/sample11";
	}
	@GetMapping("/sample12")
	public String sample12() {
		return "/sample/sample12";
	}
	@GetMapping("/sample13")
	public String sample13() {
		return "/sample/sample13";
		
	}
	@GetMapping("/s14")
	public String s14() {
		return "/all/s14";
	}
	@GetMapping("/s15")
	public String s15() {
		return "/all/s15";
	}
	@GetMapping("/s16")
	public String s16() {
		return "/all/s16";
	}
	@GetMapping("/s17")
	public String s17(){
		return "/all/s17";
	}
	@GetMapping("/s18")
	public String s18() {
		return "/all/s18";
	}
	@GetMapping("/s19")
	public String s19() {
		return "/all/s19";
	}
	@GetMapping("/s20")
	public String s20() {
		return "/all/s20";
	}
	@GetMapping("/s21")
	public String s21() {
		return "/all/s21";
		
	}
	@GetMapping("/s22")
	public String s22() {
		return "/all/s22";
		
	}
	@GetMapping("/s23")
	public String s23() {
		return "/all/s23";
	}
	@GetMapping ("/s24")
	public String s24() {
		return "/all/s24";
	}
	@GetMapping("/s25")
	public String s25() {
		return "/all/s25";
		
	}
	@GetMapping("/s26")
	public String s26() {
		return "/all/s26";
		
	}
	@GetMapping("/s27")
	public String s27() {
		return "/all/s27";
	}
	@GetMapping("/s28")
	public String s28() {
		return "/all/s28";
	}
	@GetMapping("/s29")
	public String s29() {
		return "/all/s29";
	}
	@GetMapping("/s30")
	public String s30() {
		return "/all/s30";
	}
	@GetMapping("/s31")
	public String s31() {
		return "/all/s31";
	}
	@GetMapping("/s32")
	public String s32() {
		return "/all/s32";
	}
	@GetMapping("/s33")
	public String s33() {
		return "/all/s33";
	}
	@GetMapping("/s34")
	public String s34() {
		return "/all/s34";
	}
	@GetMapping("/s35")
	public String s35() {
		return "/all/s35";
	}
	@GetMapping("/s36")
	public String s36() {
		return "/all/s36";
	}
	@GetMapping("/s37")
	public String s37() {
		return "/all/s37";
	}
	@GetMapping("/s38")
	public String s38() {
		return "/all/s38";
	}
	@GetMapping("/s39")
	public String s39() {
		return "/all/s39";
	}
	@GetMapping("/s40")
	public String s40() {
		return "/all/s40";
	}
	@GetMapping("/s41")
	public String s41() {
		return "/all/s41";
	}
	@GetMapping("/s42")
	public String s42() {
		return "/all/s42";
	}
	@GetMapping("/s43")
	public String s43() {
		return "/all/s43";
		
	}
	@GetMapping("/s44")
	public String s44() {
		return "/all/s44";
	}
	@GetMapping("/s45")
	public String s45() {
		return "/all/s45";
	}
	@GetMapping("/s46")
	public String s46() {
		return "/all/s46";
		
	}
	@GetMapping("/s47")
	public String s47() {
		return "/all/s47";
	}
	@GetMapping("/s48")
	public String s48() {
		return "/all/s48";
	}
	@GetMapping("/s49")
	public String s49() {
		return "/all/s49";
	}
	@GetMapping("/s50")
	public String s50() {
		return "/all/s50";
	}
	@GetMapping("/s51")
	public String s51() {
		return "/all/s51";
	}
	@GetMapping("/s52")
	public String s52() {
		return "/all/s52";
	}
	@GetMapping("/s53")
	public String s53() {
		return "/all/s53";
	}
	@GetMapping("/s54")
	public String s54() {
		return "/all/s54";
	}
	@GetMapping("/s55")
	public String s55() {
		return "/all/s55";
	}
	@GetMapping("/s56")
	public String s56() {
		return "/all/s56";
	}
	@GetMapping("/s57")
	public String s57() {
		return "/all/s57";
	}
	@GetMapping("/s58")
	public String s58() {
		return "/all/s58";
	}
	@GetMapping("/s59")
	public String s59() {
		return "/all/s59";
	}
	@GetMapping("/s60")
	public String s60() {
		return "/all/s60";
	}
	@GetMapping("/s61")
	public String s61() {
		return "/all/s61";
	}
	@GetMapping("/s62")
	public String s62() {
		return "/all/s62";
	}
	@GetMapping("/s63")
	public String s63() {
		return "/all/s63";
	}
	@GetMapping("/s64")
	public String s64() {
		return "/all/s64";
	}
	@GetMapping("/s65")
	public String s65() {
		return "/all/s65";
	}
	@GetMapping("/s66")
	public String s66() {
		return "/all/s66";
	}
	@GetMapping("/s67")
	public String s67() {
		return "/all/s67";
	}
	@GetMapping("/s68")
	public String s68() {
		return "/all/s68";
	}
	@GetMapping("/s69")
	public String s69() {
		return "/all/s69";
	}
	@GetMapping("/s70")
	public String s70() {
		return "/all/s70";
	}
	@GetMapping("/s71")
	public String s71() {
		return "/all/s71";
	}
	@GetMapping("/s72")
	public String s72() {
		return "/all/s72";
	}
	@GetMapping("/s73")
	public String s73() {
		return "/all/s73";
	}
	@GetMapping("/s74")
	public String s74() {
		return "/all/s74";
	}
	@GetMapping("/s75")
	public String s75() {
		return "/all/s75";
	}
	@GetMapping("/s76")
	public String s76() {
		return "/all/s76";
	}
	@GetMapping("/s77")
	public String s77() {
		return "/all/s77";
	}
	@GetMapping("/s78")
	public String s78() {
		return "/all/s78";
	}
	@GetMapping("/s79")
	public String s79() {
		return "/all/s79";
	}
	
	//localhost:8080/ex01/all/s80
	@GetMapping("/s80")
	public void s80(Model model){
		model.addAttribute("list",service.read());
	
	}
	@PostMapping("/s81")
	public void s81(Model model) {
		sDTO sdto=new sDTO();
		model.addAttribute("list",service.removeSample(sdto));
	}
	@PostMapping("/s82")
	public void s82(Model model) {
		sDTO sdto=new sDTO();
		model.addAttribute("list",service.createSample(sdto));
	}
	@GetMapping("/s83")
	public void s83(Model model) {
		sDTO sdto=new sDTO();
		model.addAttribute("list",service.modifySample(sdto));
	}
	
	//localhost:8080/ex01/all/s84
	@GetMapping("/s84")
	public void s84(Model model){
		model.addAttribute("emplist",empservice.read());
	
	}
	@GetMapping("/s85")
	public String GetS85() {
		return "all/s85"; 
	}
	@PostMapping("/s85") 	
	public String PostS85(EmpDTO dto) {
		 
		empservice.createEmp(dto);
		
		return "all/s85";
	}
	@GetMapping("/s86")
	public String s86(EmpDTO dto) {
		empservice.modifyEmp(dto);
		
		return "all/s86";
	}
	
	@PostMapping("/s87")
	public String s87(EmpDTO dto) {
		empservice.removeEmp(dto);
		
		return "all/s87";
	}
	
	//localhost:8080/ex01/all/s88
	@GetMapping("/s88")
	public void s88(Model model) {
		model.addAttribute("list",service.read());
	}
	@GetMapping("/s89")
	public String s89(Model model) {
		sDTO dto = new sDTO();
		model.addAttribute("list",service.createSample(dto));
		return "redirect:/all/s88";
	}
	@GetMapping("/s90")
	public String s90(Model model) {
		sDTO dto = new sDTO();
		model.addAttribute("list",service.modifySample(dto));
		return "redirect:/all/s88";
	}
	@GetMapping("/s91")
	public String s91(Model model) {
		sDTO dto = new sDTO();
		model.addAttribute("list",service.removeSample(dto));
		return "redirect:/all/s88";
	}
	
	//localhost:8080/ex01/all/s92
	@GetMapping("/s92")
	public void s92(Model model) {
		model.addAttribute("emp2list",emp2service.read());
	}
	
	@GetMapping("/s93")
	public String s93(Emp2DTO dto2) {
		emp2service.createEmp2(dto2);
		return "redirect:/all/s92";
	}
	@GetMapping("/s94")
	public String s94(Emp2DTO dto2) {
		
		emp2service.modifyEmp2(dto2);
		return "redirect:/all/s92";
	}
	@GetMapping("/s95")
	public String s95(Emp2DTO dto2) {
		emp2service.removeEmp2(dto2);
		return "redirect:/all/s92";
	}
	//localhost:8080/ex01/all/s96
	@GetMapping("/s96")
	public void s96(Model model) {
		model.addAttribute("emp2list",emp2service.read());
	}
	@GetMapping("/s97")
	public String GetS97() {
		
		return "/all/s97";
	}
	@PostMapping("/s97")
	public String postS97(@RequestParam("empno") int empno,
	                      @RequestParam("name") String name,
	                      @RequestParam("deptno") String deptno) {
	    Emp2DTO dto2 = new Emp2DTO();
	    dto2.setEmpno(empno);
	    dto2.setName(name);
	    dto2.setDeptno(deptno);

	    emp2service.createEmp2(dto2);

	    return "/all/s97";
	}
	@PostMapping("/s98")
	public String PostS98() {
		return "/all/s98";
	}
	@GetMapping("/s98")
	public String GetS98(@RequestParam("empno") int empno,
	                      @RequestParam("name") String name,
	                      @RequestParam("deptno") String deptno) {
	    Emp2DTO dto2 = new Emp2DTO();
	    dto2.setEmpno(empno);
	    dto2.setName(name);
	    dto2.setDeptno(deptno);

	    emp2service.modifyEmp2(dto2);

	    return "/all/s98";
	}
	@GetMapping("/s99")
	public String GetS99(){
		return "/all/s99";
	}
	@PostMapping("/s99")
	public String PostS99(@RequestParam("empno") int empno
						
						) {
		
		Emp2DTO dto2 = new Emp2DTO();
		dto2.setEmpno(empno);
		emp2service.removeEmp2(dto2);
		return "/all/s99";
	}
	@GetMapping("/s100")
	public void GestS100(Model model) {
		model.addAttribute("emp2list", emp2service.read());
	}
	
	@PostMapping("/inserts100")//create
	public String PostS100( @RequestParam("empno") int empno,
							@RequestParam("name") String name,
							@RequestParam("deptno") String deptno
							
							
						) {
		
		Emp2DTO dto2 = new Emp2DTO();
		dto2.setEmpno(empno);
		dto2.setName(name);
		dto2.setDeptno(deptno);
		emp2service.createEmp2(dto2);
	
		return "redirect:/all/s100";
	}
	@PutMapping("/updates100")
	public String PutS100(@RequestParam("empno") int empno,
							@RequestParam("name") String name,
							@RequestParam("deptno") String deptno
							) { 
		Emp2DTO dto2= new Emp2DTO();
		dto2.setEmpno(empno);
		dto2.setName(name);
		dto2.setDeptno(deptno);
		emp2service.modifyEmp2(dto2);
		return "redirect:/all/s100";
	}
	
}
