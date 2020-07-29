package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.GridsizeEntity;
import com.example.defaultEntity;

@RestController
@RequestMapping(value = "/api/employees")
public class defaultController {
	private List<defaultEntity> defaultList = new ArrayList<defaultEntity>();
	private List<GridsizeEntity> gridSizeList = new ArrayList<GridsizeEntity>();
	int i=0;
	int revenue =0;
	defaultController() {
		this.defaultList = buildDefaultList();
		//this.gridSizeList = buildGridSizeList(gridSizeList,i);
		//i++;
		}
	@RequestMapping(method = RequestMethod.GET)
	public List<GridsizeEntity> getDefault() {
		System.out.println(gridSizeList.size());
	return this.gridSizeList;
	}
	
	@RequestMapping(value="graph",method = RequestMethod.GET)
	public List<Integer> buildGraph() {
		int i=12;
		int total=0;
		List<GridsizeEntity> temp = new ArrayList();
		List<Integer> list = new ArrayList();
		for(i=12;i<=17;i++) {
			total=0;
			if(i==12)
			 temp =gridSizeList.stream().filter(p -> (p.getDate()).contains("12")).collect(Collectors.toList());
			else if(i==13)
			temp =gridSizeList.stream().filter(p -> (p.getDate()).contains("13")).collect(Collectors.toList());
			else if(i==14)
			 temp =gridSizeList.stream().filter(p -> (p.getDate()).contains("14")).collect(Collectors.toList());
			else if(i==15)
			 temp =gridSizeList.stream().filter(p -> (p.getDate()).contains("15")).collect(Collectors.toList());
			else
			 temp =gridSizeList.stream().filter(p -> (p.getDate()).contains("16")).collect(Collectors.toList());
			for(GridsizeEntity var:temp) {
				total = total+(var.getTotal());
			}list.add(total);
		}return list;
		
	}
	
	
	@RequestMapping(value ="total", method = RequestMethod.GET)
	public int getTotalvalue() {
	return this.revenue;
	}
	
	@RequestMapping(value="grid",method = RequestMethod.POST)
	public List<GridsizeEntity> createGridSize(@RequestBody GridsizeEntity emp) {
		emp.setId(i);
		System.out.println("i="+i);
		
		//gridSizeList.add(emp);
		buildGridSizeList(gridSizeList, i);
		i++;
		//gridSizeList.set(index, element)
		System.out.println("true"+gridSizeList.size());
		return gridSizeList;
	}
	@RequestMapping(value="gridsave",method = RequestMethod.POST)
	public List<GridsizeEntity> saveGridSize(@RequestBody GridsizeEntity emp) {
		gridSizeList.set(emp.getId(),emp);
		for(GridsizeEntity g:gridSizeList) {
			System.out.println(g.getProduct());
		}
		return gridSizeList;
	}
	@RequestMapping(value ="/hello")
	public void hello (){
	System.out.println("Hiiiiiiiiiiiiiii");
	}
	List<defaultEntity> buildDefaultList() {
		List<defaultEntity> emps = new ArrayList<>();
		defaultEntity emp1 = buildEmployee("", "venu", "",0);
		return emps;
		}
	List<GridsizeEntity> buildGridSizeList(List<GridsizeEntity> gridSizeList,int id) {
		List<GridsizeEntity> emps = new ArrayList<>();
		defaultEntity lastEmp = null;
if (this.defaultList.size() != 0) {
	lastEmp = this.defaultList.stream().skip(this.defaultList.size() - 1).findFirst().orElse(null);
int total = (id*lastEmp.getPrice());
revenue =revenue+total;
GridsizeEntity grd1 = buildGridSize(id,"Product1",lastEmp.getCustomername(),
		id,"kg","",lastEmp.getPrice(),0,0,(total),lastEmp.getValiditydate(),revenue);
gridSizeList.add(grd1);
}else {
	GridsizeEntity grd1 = buildGridSize(id,"Product1","Person1",
			id,"kg","",1000,0,0,(1000),("2020-07-14"),revenue);
	gridSizeList.add(grd1);
}
		return gridSizeList;
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public List<defaultEntity> saveEmployee(@RequestBody defaultEntity emp) {
		defaultList.add(emp);
		return defaultList;
	}
	
	@RequestMapping(value="/date",method = RequestMethod.POST)
	public List<GridsizeEntity> filterGrid(@RequestBody String date) {
		List<GridsizeEntity> returnList = new ArrayList();
		String date1 = date.substring(1,date.length()-1);
		returnList = gridSizeList.stream().filter(action->action.getDate().equals(date1)).collect(Collectors.toList());
		return returnList;
	}
	GridsizeEntity buildGridSize( int id,String product, String description,
			int orderedquantity,String uom,String analyticTags,
			int unitPrice,int taxes,int subtotal,int total,String date,int overalltotal) {
		GridsizeEntity emp = new GridsizeEntity(id,product, description, orderedquantity, uom,
				analyticTags,unitPrice,taxes,subtotal,total,date,overalltotal);
		return emp;
	}
	
	defaultEntity buildEmployee( String customername,String validitydate,String payment,int price){
		defaultEntity emp = new defaultEntity(customername, validitydate, payment, price);
		return emp;
	}
	
//		}
}
