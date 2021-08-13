package com.skillstorm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String>{
	
	@Query("select count(*) from Device d join d.plan p join d.user u where u.userID = ?1 and p.dataPlanID = ?2")
	Integer countDevices(Integer userID, Integer dataPlanID);
	
	@Query("select count(*) * p.costPerDevice from Device d join d.plan p join d.user u where u.userID = ?1 and p.dataPlanID = ?2")
	Double getBill(Integer userID, Integer dataPlanID);
	

}
