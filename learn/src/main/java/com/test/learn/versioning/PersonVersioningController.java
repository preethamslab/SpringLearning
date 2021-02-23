package com.test.learn.versioning;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController 
{
	@GetMapping("v1/person")
	public PersonV1 personV1()
	{
		return new PersonV1("Preetham Umarani");
	}
	
	@GetMapping(value="person/headers",headers="X-API-VERSION=2")
	public PersonV2 paramv2()
	{
		return new PersonV2(new Name("Preetham","Umarani"));
	}
	
	@GetMapping(value="/person/headers",headers="X-API-VERSION=1")
	public PersonV1 paramv1()
	{
		return new PersonV1("Preetham Umarani");
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 producesv2()
	{
		return new PersonV2(new Name("Preetham","Umarani"));
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 producesv1()
	{
		return new PersonV1("Preetham Umarani");
	}
	
}

