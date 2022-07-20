package com.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;

@RestController
@RequestMapping(value = "/book")
public class BookController
{

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> categories() 
	{
		return categoryService.getAllBySort();
	}
	
	@GetMapping("/list")
	public List<Book> showBooksPage() 
	{
		return bookService.getAll();
	}

	@PostMapping("/add")
	public Book addBookPage(@RequestBody Book book) 
	{
		
		return bookService.addNew(book);
	}
	
	@PutMapping("/edit/{id}")
	public Book editBookPage(@PathVariable(name = "id") Long id,  @RequestBody Book book)
	{
		Book bookData = bookService.get(id);
		if( bookData != null ) 
		{
			bookData.setAuthors(book.getAuthors());
			bookData.setCategory(null);
			bookData.setIsbn(book.getIsbn());
			bookData.setPublisher(book.getPublisher());
			bookData.setTag(book.getTag());
			bookData.setTitle(book.getTitle());
			
			return bookService.save(bookData);
		}
		else 
		{
			return null;
		}
	}
	/**
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@Valid Book book, BindingResult bindingResult, final RedirectAttributes redirectAttributes)
	{
		if( bindingResult.hasErrors() ) 
		{
			return "/book/form";
		}
		
		if( book.getId() == null )
		{
			if( bookService.getByTag(book.getTag()) != null )
			{
				bindingResult.rejectValue("tag", "tag", "Tag already exists");
				return "/book/form";
			} 
			else 
			{
				bookService.addNew(book);
				redirectAttributes.addFlashAttribute("successMsg", "'" + book.getTitle() + "' is added as a new Book.");
				return "redirect:/book/add";
			}
		} 
		else 
		{
			Book updatedBook = bookService.save(book);
			redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + book.getTitle() + "' are saved successfully. ");
			return "redirect:/book/edit/"+updatedBook.getId();
		}
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeBook(@PathVariable(name = "id") Long id, Model model)
	{
		Book book = bookService.get( id );
		if( book != null )
		{
			if( bookService.hasUsage(book) )
			{
				model.addAttribute("bookInUse", true);
				return showBooksPage(model);
			} 
			else 
			{
				bookService.delete(id);
			}
		}
		return "redirect:/book/list";
	}**/
}
