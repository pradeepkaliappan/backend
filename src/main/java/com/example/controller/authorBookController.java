package com.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthorBooksEntity;
import com.example.GridsizeEntity;
import com.example.defaultEntity;

@RestController
@RequestMapping(value = "/api/authorBooks")
public class authorBookController {
	private List<AuthorBooksEntity> authorBookList = new ArrayList<AuthorBooksEntity>();
	private List<String> fetchAuthorData = new ArrayList<String>();
	private List<AuthorBooksEntity> anotherList = new ArrayList<>();
	private int id=0;
	private int previous=0;
	private int next =0;
	private int custom_flag=0;
	Set<String> hash_Set = new HashSet<String>();
	private int present =0;
	
	@RequestMapping(method = RequestMethod.POST)
	public List<AuthorBooksEntity> createAuthorBooks(@RequestBody AuthorBooksEntity author) {
		
		buildAuthorBookList(author);
		System.out.println(authorBookList);
		return authorBookList;
	}
	
	@RequestMapping(value="/filter",method = RequestMethod.POST)
	public List<AuthorBooksEntity> filterAuthorBooks(@RequestBody AuthorBooksEntity author) {
		int st=0;
		List<AuthorBooksEntity> temp = new ArrayList<>();
		LocalDate t = LocalDate.parse("1970-01-01");
		anotherList = new ArrayList<>();
		if(!Objects.nonNull(author.getAuthorname())) {
			st++;
//			temp = authorBookList.stream().filter(action->action.getAuthorname().equals(author.getAuthorname())).collect(Collectors.toList());
//			anotherList.add((AuthorBooksEntity) temp);
			author.setAuthorname("  ");
		}
		if(!Objects.nonNull(author.getBookname())) {
			st++;
			author.setBookname("  ");
		}
		if(!Objects.nonNull(author.getCreateddate())||(author.getCreateddate().isEqual(t))) {
			st++;
			author.setCreateddate(LocalDate.now());
		}
		if(!Objects.nonNull(author.getPublishdate())||((author.getPublishdate().isEqual(t)))) {
			st++;
			author.setPublishdate(LocalDate.now());
		}if(!Objects.nonNull(author.getPrice())) {
			st++;
		}
		if(st==5) {
			anotherList = authorBookList;
			return authorBookList;
		}
		maintainSearch(author,0);
		return anotherList;
	}
	
	@RequestMapping(value = "/{flag}",method = RequestMethod.GET)
	public List<AuthorBooksEntity> createAuthorBooksList(@PathVariable int flag) {
		if(flag==0) {
			custom_flag=0;
			return authorBookList;
		}
		else {
			custom_flag=1;
			return anotherList;
		}
	}
	
	@RequestMapping(value = "/detailData",method = RequestMethod.POST)
	public List<AuthorBooksEntity> getDetailData(@RequestBody int state) {
		List<AuthorBooksEntity> detailList = new ArrayList<>();
		
		int temp;
		if(state==-2) {
		
		if(next==0)
			temp = present;
		else
			temp =next;
		}
		else if(state==-1){
			
			if(previous==0)
				temp = present;
			else
				temp=previous;
		}else {
			temp = state;
		}
		
		
		if(custom_flag==0) {
			for(Iterator<AuthorBooksEntity> itr=this.authorBookList.iterator();itr.hasNext();)
			{
				AuthorBooksEntity author = itr.next();
				if(author.getId()==temp) {
					if(itr.hasNext()) {
					author = itr.next();
					next = author.getId();
					break;
					}
				}else {
					previous = author.getId();
				}
			}
			System.out.println("poda"+" "+"present="+present+"previous="+previous+"next="+next);
			detailList = authorBookList.stream().filter(action->action.getId()==temp).collect(Collectors.toList());
			return detailList;
		}else {
			for(Iterator<AuthorBooksEntity> itr=this.anotherList.iterator();itr.hasNext();)
			{
				AuthorBooksEntity author = itr.next();
				if(author.getId()==temp) {
					if(itr.hasNext()) {
					author = itr.next();
					next = author.getId();
					}
				}else {
					previous = author.getId();
				}
			}
			System.out.println("poda"+" "+"present="+present+"previous="+previous+"next="+next);
			detailList = anotherList.stream().filter(action->action.getId()==temp).collect(Collectors.toList());
			return detailList;
		}
	}
	
	@RequestMapping(value = "/authorFetchValue",method = RequestMethod.GET)
	public List<String> fetchAuthorData() {
		hash_Set = new HashSet<String>();
		for(Iterator<AuthorBooksEntity> itr=this.authorBookList.iterator();itr.hasNext();)
		{
			AuthorBooksEntity author = itr.next();
			hash_Set.add(author.getAuthorname());
		}
		List<String> list = new ArrayList<>(hash_Set);
		return list;
	}
	
	@RequestMapping(value = "/authorBookValue",method = RequestMethod.GET)
	public List<String> fetchBookData() {
		Set<String> hash_Set_book = new HashSet<String>();
		for(Iterator<AuthorBooksEntity> itr=this.authorBookList.iterator();itr.hasNext();)
		{
			AuthorBooksEntity book = itr.next();
			hash_Set_book.add(book.getBookname());
		}
		List<String> list = new ArrayList<>(hash_Set_book);
		return list;
	}
	
	@RequestMapping(value = "/next",method = RequestMethod.GET)
	public int nextData() {
		if(next==0)
			return present;
		else
			return next;
	}
	
	@RequestMapping(value = "/previous",method = RequestMethod.GET)
	public int previousData() {
		if(previous==0)
			return present;
		else
			return previous;
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public List<AuthorBooksEntity> deleteAuthorBooksList(@PathVariable int id) {
		for(Iterator<AuthorBooksEntity> itr=this.authorBookList.iterator();itr.hasNext();)
		{
			AuthorBooksEntity author = itr.next();
		int inId = author.getId();
		if(inId == (id)){
		itr.remove();
		}
		}
		return this.authorBookList;
	}
	
	private void buildAuthorBookList(AuthorBooksEntity author) {
		AuthorBooksEntity formEntity = new AuthorBooksEntity();
		id++;
		formEntity.setId(id);
		if(!Objects.nonNull(author.getAuthorname())) {
			author.setAuthorname("");
		}
		if(!Objects.nonNull(author.getBookname())) {
			author.setBookname("");
		}
		if(author.getCreateddate()==null) {
			author.setCreateddate(LocalDate.now());
		}
		if(author.getPublishdate()==null) {
			author.setPublishdate(LocalDate.now());
		}
		if(!Objects.nonNull(author.getPrice())) {
			author.setPrice("0");
		}
		
		formEntity.setAuthorname(author.getAuthorname());
		formEntity.setBookname(author.getBookname());
		formEntity.setCreateddate(author.getCreateddate());
		formEntity.setPrice(author.getPrice());
		formEntity.setPublishdate(author.getPublishdate());
		authorBookList.add(formEntity);
		for(AuthorBooksEntity author1: authorBookList) {
			System.out.println(author1.getId()+"  "+author1.getAuthorname());
		}
	}
	
	public void maintainSearch(AuthorBooksEntity author,int g) {
		if(g==0) {
			anotherList = new ArrayList<>();
		}
		List<AuthorBooksEntity> temp = new ArrayList<>();
		
		anotherList = authorBookList.stream().filter(action->
		(
				action.getAuthorname().equals(author.getAuthorname())||action.getBookname().equals(author.getBookname())
				||action.getCreateddate().isEqual(author.getCreateddate())||action.getPublishdate().isEqual(author.getPublishdate())
				)).collect(Collectors.toList());
		if(!anotherList.isEmpty()&&Objects.nonNull(author.getValuee())) {
			if(Integer.parseInt(author.getValuee())==0) {
				anotherList = anotherList.stream().filter(action->
				(Integer.parseInt(action.getPrice())==Integer.parseInt(author.getPrice()))).collect(Collectors.toList());
				
			}else if(Integer.parseInt(author.getValuee())==1) {
				anotherList = anotherList.stream().filter(action->
				(Integer.parseInt(action.getPrice())<Integer.parseInt(author.getPrice()))).collect(Collectors.toList());
			}else {
				anotherList = anotherList.stream().filter(action->
				(Integer.parseInt(action.getPrice())>Integer.parseInt(author.getPrice()))).collect(Collectors.toList());
			}
			
		}else if(Objects.nonNull(author.getValuee())) {
			if(Integer.parseInt(author.getValuee())==0) {
				anotherList = authorBookList.stream().filter(action->
				(Integer.parseInt(action.getPrice())==Integer.parseInt(author.getPrice()))).collect(Collectors.toList());
				
			}else if(Integer.parseInt(author.getValuee())==1) {
				anotherList = authorBookList.stream().filter(action->
				(Integer.parseInt(action.getPrice())<Integer.parseInt(author.getPrice()))).collect(Collectors.toList());
			}else {
				anotherList = authorBookList.stream().filter(action->
				(Integer.parseInt(action.getPrice())>Integer.parseInt(author.getPrice()))).collect(Collectors.toList());
			}
		}
	}
	
		@RequestMapping(value="graph",method = RequestMethod.GET)
		public List<Integer> buildGraph() {
			//List<String> temp = new ArrayList<hash_set>();
			List<Integer> total = new ArrayList<>();
			Object[] arr = hash_Set.toArray();
			for(int i=0;i<arr.length;i++) {
				int t=0;
				for(Iterator<AuthorBooksEntity> itr=this.authorBookList.iterator();itr.hasNext();)
				{
					AuthorBooksEntity author = itr.next();
				if(author.getAuthorname().equals(arr[i])) {
					t =t+Integer.parseInt(author.getPrice());
					break;
				}
			}total.add(t);
			}
			return total;
		}
}
