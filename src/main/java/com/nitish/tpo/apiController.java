package com.nitish.tpo;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitish.tpo.api.driveregistration;
import com.nitish.tpo.api.loginTable;
import com.nitish.tpo.api.placementdrive;
import com.nitish.tpo.api.studentProfile;
import com.nitish.tpo.repo.repoDriveReg;

import com.nitish.tpo.repo.repoLogin;
import com.nitish.tpo.repo.repoPlacement;
import com.nitish.tpo.repo.repoStudent;
@CrossOrigin
@RestController
@RequestMapping("tpo")
public class apiController {
	@Autowired
	private repoDriveReg driveRegRepo;
	@Autowired
	private repoLogin loginRepo;
	@Autowired
	private repoPlacement palcementRepo;
	@Autowired
	private repoStudent studentRepo ;

	@GetMapping("getalllogin")
	public List<loginTable> getallLogin()
	{
		return this.loginRepo.findAll();
	}
	@GetMapping("getallreg")
	public List<driveregistration> getallReg()
	{
		return this.driveRegRepo.findAll();
	}
	@GetMapping("getallplacement")
	public List<placementdrive> getallPlacement()
	{
		return this.palcementRepo.findAll();
	}
	@GetMapping("getallstudent")
	public List<studentProfile> getallStudent()
	{
		return this.studentRepo.findAll();
	}
	
	

	@GetMapping("getlogin/{id}/{pass}/{type}")
	public loginTable getaLogin(@PathVariable("id") String id,@PathVariable("pass") String pass,@PathVariable("type") int type)
	{
		loginTable lt=new loginTable("$$invalid$$","$$invalid$$",type);
		Optional<loginTable> lt1=this.loginRepo.findById(id);
		if(lt1.isPresent())
		{
			if(lt1.get().getUname().equals(id) && lt1.get().getPassword().equals(pass) && lt1.get().getType()==type)
				lt.setUname(lt1.get().getUname());
		}
		return lt;
	}
	@GetMapping("getreg/{id}")
	public List<driveregistration> getaReg(@PathVariable("id") String id)
	{
		List<driveregistration> dp= this.driveRegRepo.findAll();
		List<driveregistration> dn=new ArrayList<driveregistration>();
		for(driveregistration d:dp)
		{
			if(d.getDriveid().equals(id))
				dn.add(d);
		}
		return dn;
		
	}
	
	@GetMapping("getrek/{id}")
	public List<driveregistration> getaRegk(@PathVariable("id") String id)
	{
		List<driveregistration> dp= this.driveRegRepo.findAll();
		List<driveregistration> dn=new ArrayList<driveregistration>();
		for(driveregistration d:dp)
		{
			if(d.getStudentid().equals(id))
				dn.add(d);
		}
		return dn;
		
	}
	
	@GetMapping("getregs/{id}/{id2}")
	public List<driveregistration> getaRegs(@PathVariable("id") String id,@PathVariable("id2") String id2)
	{
		List<driveregistration> dp= this.driveRegRepo.findAll();
		List<driveregistration> dn=new ArrayList<driveregistration>();
		for(driveregistration d:dp)
		{
			if(d.getDriveid().equals(id) && d.getStudentid().equals(id2))
				dn.add(d);
		}
		return dn;
		
	}
	
	@GetMapping("getregbystudent/{id}")
	public List<driveregistration> getaRegbystudent(@PathVariable("id") String id)
	{
		List<driveregistration> dp= this.driveRegRepo.findAll();
		List<driveregistration> dn=new ArrayList<driveregistration>();
		for(driveregistration d:dp)
		{
			if(d.getStudentid().equals(id))
				dn.add(d);
		}
		return dn;
		
	}
	
	@GetMapping("getplacement/{id}")
	public List<placementdrive> getaPlacement(@PathVariable("id") String id)
	{
		List<placementdrive> pd=new ArrayList<placementdrive>();
		Optional<placementdrive> pd2=this.palcementRepo.findById(Integer.parseInt(id));
		if(pd2.isPresent())
			pd.add(pd2.get());
		return pd;
	}
	
	@GetMapping("deleteplacement/{id}")
	public List<placementdrive> deletePlacement(@PathVariable("id") int id)
	{
		this.palcementRepo.deleteById(id);
		return this.palcementRepo.findAll();
	}
	

	@GetMapping("deletestudent/{id}")
	public List<studentProfile> deleteStudnet(@PathVariable("id") int id)
	{
		this.studentRepo.deleteById(id);
		return this.studentRepo.findAll();
	}
	
	@GetMapping("deletelogin/{id}")
	public List<loginTable> deletelogin(@PathVariable("id") String id)
	{
		List<loginTable> lt=this.loginRepo.findAll();
		for(loginTable l:lt)
		{
			if(l.getUname().equals(id))
				this.loginRepo.delete(l);
		}
		
		return this.loginRepo.findAll();
	}
	
	@GetMapping("deletereg/{id}/{id2}")
	public List<driveregistration> deletereg(@PathVariable("id") String id,@PathVariable("id2") String id2)
	{
		List<driveregistration> lt=this.driveRegRepo.findAll();
		for(driveregistration l:lt)
		{
			if(l.getDriveid().equals(id) && l.getStudentid().equals(id2))
				this.driveRegRepo.delete(l);
		}
		
		return this.driveRegRepo.findAll();
	}
	@GetMapping("getupcommingplacement/")
	public List<placementdrive> getaPlacement()
	{
		List<placementdrive> pd=new ArrayList<placementdrive>();
		List<placementdrive> pd2=this.palcementRepo.findAll();
		try
		{
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd"); 
		Date d= new java.util.Date();
		for(placementdrive p:pd2)
		{
			String s=p.getDate().toString();
			Date f=sdfo.parse(s);
			if(f.compareTo(d)>0)
			{
				pd.add(p);
			}
				
		}
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return pd;
	}
	
	@GetMapping("getstudent/{id}")
	public List<studentProfile> getaStudent(@PathVariable("id") String id)
	{
		List<studentProfile> pd=new ArrayList<studentProfile>();
		Optional<studentProfile> pd2=this.studentRepo.findById(Integer.parseInt(id));
		if(pd2.isPresent())
			pd.add(pd2.get());
		return pd;
	}

	
	@GetMapping("insertlogin/{id}/{pas}/{type}")
	public List<loginTable> insertLogin(@PathVariable("id") String id,@PathVariable("pas") String pass,@PathVariable("type") int type)
	{
		loginTable lt=new loginTable(id, pass, type);
		this.loginRepo.save(lt);
		return this.loginRepo.findAll();
	}
	@GetMapping("insertreg/{driveid}/{studid}")
	public List<driveregistration> insertReg(@PathVariable("driveid") String driveid,@PathVariable("studid") String studid)
	{
		driveregistration dr=new driveregistration(driveid,studid);
		this.driveRegRepo.save(dr);
		return this.driveRegRepo.findAll();
	}
	@GetMapping("insertplacement/{id}/{name}/{profile}/{package}/{bond}/{date}/{email}/{description}")
	public List<placementdrive> insertPlacement(@PathVariable("id") int id,
			@PathVariable("name") String name,
			@PathVariable("profile") String profile,
			@PathVariable("package") int pack,
			@PathVariable("bond") int bond,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,

			@PathVariable("email") String email,

			@PathVariable("description") String desc
			)
	{
		placementdrive pd=new placementdrive(id, name, profile, pack, bond, date, email, desc);
		
		this.palcementRepo.save(pd);
		return this.palcementRepo.findAll();
	}

	@GetMapping("insertstudent/{id}/{name}/{branch}/{score}/{back}/{year}/{phone}/{email}")
	public List<studentProfile> insertStudent(
			@PathVariable("id") int id,
			@PathVariable("name") String name,
			@PathVariable("branch") String branch,
			@PathVariable("score") int score,
			@PathVariable("back") int back,
			@PathVariable("year") String year,
			@PathVariable("phone") BigInteger phone,
			@PathVariable("email") String email
			)
	{
		studentProfile sp=new studentProfile(id,name,branch,score,back,year,phone,email);
		this.studentRepo.save(sp);
		return this.studentRepo.findAll();
	}

//	@GetMapping("insertlogin/{id}/{pas}/{type}")
//	public List<loginTable> insertLogin(@PathVariable("id") String id,@PathVariable("pas") String pass,@PathVariable("type") int type)
//	{
//		loginTable lt=new loginTable(id, pass, type);
//		this.loginRepo.save(lt);
//		return this.loginRepo.findAll();
//	}
//	@GetMapping("insertreg/{driveid}/{studid}")
//	public List<driveregistration> insertReg(@PathVariable("driveid") String driveid,@PathVariable("studid") String studid)
//	{
//		driveregistration dr=new driveregistration(driveid,studid);
//		this.driveRegRepo.save(dr);
//		return this.driveRegRepo.findAll();
//	}
	
	@GetMapping("updateplacement/{id}/{name}/{profile}/{package}/{bond}/{date}/{email}/{description}")
	public List<placementdrive> updatePlacement(@PathVariable("id") int id,
			@PathVariable("name") String name,
			@PathVariable("profile") String profile,
			@PathVariable("package") int pack,
			@PathVariable("bond") int bond,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,

			@PathVariable("email") String email,

			@PathVariable("description") String desc
			)
	{
		placementdrive pd=this.palcementRepo.findById(id).get();
		pd.setName(name);
		pd.setProfile(profile);
		pd.setScore(pack);
		pd.setBacklog(bond);
		pd.setDate(date);
		pd.setEmail(email);
		pd.setDescription(desc);
		this.palcementRepo.save(pd);
		return this.palcementRepo.findAll();
	}

	@GetMapping("updatestudent/{id}/{name}/{branch}/{score}/{back}/{year}/{phone}/{email}")
	public List<studentProfile> updateStudent(
			@PathVariable("id") int id,
			@PathVariable("name") String name,
			@PathVariable("branch") String branch,
			@PathVariable("score") int score,
			@PathVariable("back") int back,
			@PathVariable("year") String year,
			@PathVariable("phone") BigInteger phone,
			@PathVariable("email") String email
			)
	{
		studentProfile sp=this.studentRepo.findById(id).get();
		sp.setName(name);
		sp.setBranch(branch);
		sp.setScore(score);
		sp.setBacklog(back);
		sp.setYear(year);
		sp.setPhone(phone);
		sp.setEmail(email);
		this.studentRepo.save(sp);
		return this.studentRepo.findAll();
	}

	

	
	
}
