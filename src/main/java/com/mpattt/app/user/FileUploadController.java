package com.mpattt.app.user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mpattt.domain.entity.Image;
import com.mpattt.domain.service.ImageService;

@Controller
public class FileUploadController {

	private static final String BASE_PATH = "/images";
	private static final String FILENAME = "{filename:.+}";
	private final ImageService imageService;

	@Autowired
	public FileUploadController(ImageService imageService) {
		this.imageService = imageService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@Secured("ROLE_USER")
	@RequestMapping("/user/user")
	public String index(Model model, Pageable pageable) {
		final Page<Image> page = imageService.findPage(pageable);
		model.addAttribute("page", page);
		return "user/gallary";
	}

	@RequestMapping(method = RequestMethod.GET, value = BASE_PATH + "/" + FILENAME + "/raw")
	@ResponseBody
	public ResponseEntity<?> oneRawImage(@PathVariable String filename) {
		try {
			Resource file = imageService.findOneImage(filename);
			return ResponseEntity.ok().contentLength(file.contentLength()).contentType(MediaType.IMAGE_JPEG)
					.body(new InputStreamResource(file.getInputStream()));
		} catch (IOException e) {
			return ResponseEntity.badRequest().body("fail");
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = BASE_PATH)
	public Object createFile(@RequestParam("file") MultipartFile file,
			@ModelAttribute("imageAddForm") @Valid ImageAddForm imageAddForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, ModelAndView modelAndView) throws NoSuchAlgorithmException {
		try {
			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getFieldError());
				return "redirect:/";
			}
			imageService.createImage(imageAddForm, file);
			redirectAttributes.addFlashAttribute("message", "Success" + file.getOriginalFilename());
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("message", "Fail " + file.getOriginalFilename() + e.getMessage());

		}
		return "redirect:/admin/user";
	}

}
