package com.example.fundRaisingApp.testService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fundRaisingApp.entity.DonorEntity;
import com.example.fundRaisingApp.exception.IdNotFoundException;
import com.example.fundRaisingApp.model.DonorModel;
import com.example.fundRaisingApp.repository.DonorRepository;
import com.example.fundRaisingApp.service.DonorServiceImpl;
import com.example.fundRaisingApp.service.DonorServiceInterface;
import com.example.fundRaisingApp.util.Conversions;

@SpringBootTest
public class TestFundraisingApp  {
	
	
	@InjectMocks
	private DonorServiceInterface donorService=  new DonorServiceImpl();
	
	@Mock
	private DonorRepository donorRepository;
	
	
	
	@Test
	public void testGetDonorDetailsByDonorId()
	{
		DonorModel donorModel=new DonorModel();
		donorModel.setDonorName("swapnil");
		donorModel.setDonorId(1);
		donorModel.setDonorAddress("belgaum");
		donorModel.setDonorNumber(9740124059l);
		donorModel.setDonorEmail("swapnil@gmail.com");
		donorModel.setUserId(5);
		donorModel.setDonorAmount(5000);
		
		
		int donorId=1;
		
		Optional<DonorEntity> optionalDonorEntity=Optional.of(Conversions.modelToEntity(donorModel));
		
		when(donorRepository.findById(1)).thenReturn(optionalDonorEntity);
		
		DonorModel existingDonor = donorService.getDonorDetailsByDonorId(donorId);
		
		assertEquals(donorModel.getDonorName(),existingDonor.getDonorName());
		
	}

	/* @Test
	public void testAddDonorAmount()
	{
		
		
		
		 DonorModel donorModel =new DonorModel();
		donorModel.setDonorName("swapnil");
		donorModel.setDonorId(5);
		donorModel.setDonorAddress("belgaum");
		donorModel.setDonorNumber(9740124059l);
		donorModel.setDonorEmail("swapnil@gmail.com");
		donorModel.setUserId(5);
		donorModel.setDonorAmount(5000);
		
		
	when(donorRepository.save(conversions.modelToEntity(donorModel))).thenReturn(conversions.modelToEntity(donorModel));
		
		DonorModel newDonorModel = donorService.addDonorAmount(donorModel);
		
		DonorEntity newDonorEntity=conversions.modelToEntity(newDonorModel);
		
		verify(donorRepository,times(1)).save(conversions.modelToEntity(newDonorModel));
		
		assertEquals("swapnil@gmail.com",newDonorEntity.getDonorEmail());
		
		
	}*/
	
	 

	@Test
	public void testDeleteDonorDetailsByDonorId()
	{
		DonorModel donorModel=new DonorModel();
		donorModel.setDonorName("swapnil");
		donorModel.setDonorId(5);
		donorModel.setDonorAddress("belgaum");
		donorModel.setDonorNumber(9740124059l);
		donorModel.setDonorEmail("swapnil@gmail.com");
		donorModel.setUserId(5);
		donorModel.setDonorAmount(5000);
		
		int donorId=5;
		
		Optional<DonorEntity> optionalDonorEntity= Optional.of(Conversions.modelToEntity(donorModel));
		
		when(donorRepository.findById(5)).thenReturn(optionalDonorEntity);
		
		donorService.deleteDonorDetailsByDonorId(donorModel.getDonorId());
		
		verify(donorRepository,times(1)).deleteById(donorId);
			
	}
	
		@Test
		public void testGetDonorDetailsByDonorIdNotFound()
		{
			int donorId=500;
			
			when(donorRepository.findById(donorId)).thenThrow(IdNotFoundException.class);
			
			assertThrows(IdNotFoundException.class,()->donorService.getDonorDetailsByDonorId(donorId));
			
			
		}
		
	
		
	/*	@Test
	    public void testUpdatePost() {

	        DonorEntity donorEntity = new DonorEntity();

	        DonorModel donor = new DonorModel();
			donor.setDonorId(1);
			donor.setDonorName("swapnil");
			donor.setDonorAddress("belgaum");
			donor.setDonorNumber(9742881564l);
			donor.setDonorEmail("swapnil@gmail.com");
			donor.setUserId(1);
		

	          Optional<DonorEntity> optionalDonor = Optional.of(donorEntity);

	          when(donorRepository.findById(1)).thenReturn(optionalDonor);

	          DonorEntity updatedDonorEntity = donorRepository.save(donorEntity);
	 
	         conversions.entityToModel(updatedDonorEntity);
	         
	          donorService.updateDonorDetailsByDonorId(donor);

	          verify(donorRepository, times(1)).save(Conversions.modelToEntity(donor));
	    }
	    */
		
	
	
	
	
}
