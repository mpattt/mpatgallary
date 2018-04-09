package com.mpattt.app.user;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;


@Data
public class ImageAddForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	@NotNull
	public Date date;
	
	@NotEmpty
	public String location;
}
