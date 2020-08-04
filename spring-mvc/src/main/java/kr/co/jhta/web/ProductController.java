package kr.co.jhta.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.jhta.form.ProductForm;
import kr.co.jhta.service.ProductService;
import kr.co.jhta.vo.Category;
import kr.co.jhta.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ModelAttribute("categories")
	public List<Category> categories() {
		System.out.println("전체 카테고리 정보 조회 -> Model 객체에 카테고리 정보 저장");
		List<Category> categories = productService.getAllCategories();
		return categories;
	}
	
	@GetMapping("/list.do")
	public String products(Model model) {
		System.out.println("/list.do 요청 처리 시작 : " + model);
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		
		return "product/list";
	}
	
	@GetMapping("/add.do")
	public String form(Model model) {
		System.out.println("/add.do 요청 처리 시작" + model);
		return "product/form";
	}
	
	@PostMapping("/add.do")
	public String addProduct(ProductForm productForm) {
		
		Product product = new Product();
		BeanUtils.copyProperties(productForm, product);
		product.setCategory(new Category(productForm.getCatId()));
		
		productService.addNewProduct(product);
		return "redirect:list.do";
	}
}
