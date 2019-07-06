package com.cg.pos.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.pos.entity.PizzaDetailsDTO;
import com.cg.pos.exceptions.PizzaException;
import com.cg.pos.service.PizzaService;
import com.cg.pos.service.impl.PizzaServiceImpl;
import com.cg.pos.utility.Exceptions;
import com.cg.pos.utility.ValidatePizzaDetails;

/**
 * 
 * @author trainee
 *
 */
public class PizzaOrderingSystem {

	public static void main(String[] args) {

		PizzaService operation =null;
		if(operation==null)
		{operation=new PizzaServiceImpl();}

		do {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String choice;

			System.out.println("**********************************************************");
			System.out.println();
			System.out.println("Enter 1 to modify pizza details");
			System.out.println("Enter 2 to delete pizza details");
			System.out.println("Enter 3 to exit");
			System.out.println();
			System.out.println("**********************************************************");

			choice = scanner.next();
			try {
				int pizzaId, storeId;
				switch (choice) {
				case "1":
					System.out.println("**********************************************************");
					System.out.println("enter 1 to modify itemName ");
					System.out.println("enter 2 to modify quantity ");
					System.out.println("enter 3 to modify cost ");
					System.out.println("enter 4 to modify addOn");
					System.out.println("enter 5 to exit");
					System.out.println("**********************************************************");

					String modifyChoice = scanner.next();
					PizzaDetailsDTO detailsDTO=new PizzaDetailsDTO();
					ValidatePizzaDetails details=new ValidatePizzaDetails();
					


					switch (modifyChoice) {

					case "1":
						try {
							System.out.println("enter store Id");
							storeId = scanner.nextInt();
							detailsDTO.setStoreId(storeId);
							System.out.println("enter item Id");
							pizzaId = scanner.nextInt();
							detailsDTO.setItemId(pizzaId);
							System.out.println("enter new name");
							String newName = scanner.next();
							detailsDTO.setItemName(newName);
							if(details.isValidId(pizzaId) && details.isValidStoreId(storeId) && details.isValidName(newName))
							{
							String result = operation.modify(detailsDTO);
							if (result == "1") {
								System.out.println("Name modified Successfully");
							}
							break;
						} }catch (InputMismatchException e) {
							throw new PizzaException(Exceptions.INVALID_INPUT);
						}
					case "2":

						try {
							System.out.println("enter store Id");
							storeId = scanner.nextInt();
							detailsDTO.setStoreId(storeId);
							System.out.println("enter item Id");
							pizzaId = scanner.nextInt();
							detailsDTO.setItemId(pizzaId);
							System.out.println("enter new quantity");
							int newQuantity = scanner.nextInt();
							detailsDTO.setQuantity(newQuantity);
							if(details.isValidId(pizzaId) && details.isValidStoreId(storeId) && details.isValidQuantity(newQuantity))
							{
							String result = operation.modify(detailsDTO);
							
							if (result == "1") {
								System.out.println("Quantity modified Successfully");
							}
							break;
						}} catch (InputMismatchException e) {
							throw new PizzaException(Exceptions.INVALID_INPUT);
						}
					case "3":
						try {
							System.out.println("enter store Id");
							storeId = scanner.nextInt();
							detailsDTO.setStoreId(storeId);
							System.out.println("enter item Id");
							pizzaId = scanner.nextInt();
							detailsDTO.setItemId(pizzaId);
							System.out.println("enter new cost");
							double cost = scanner.nextDouble();
							detailsDTO.setCost(cost);
							if(details.isValidId(pizzaId) && details.isValidStoreId(storeId) && details.isValidCost(cost))
							{
							String result = operation.modify(detailsDTO);
							
							if (result == "1") {
								System.out.println("Cost modified Successfully");
							}
							break;
						} }catch (InputMismatchException e) {
							throw new PizzaException(Exceptions.INVALID_INPUT);
						}

					case "4":
						try {
							System.out.println("enter store Id");
							storeId = scanner.nextInt();
							System.out.println("enter item Id");
							pizzaId = scanner.nextInt();
							System.out.println("enter new addON");
							String newAddOn = scanner.next();
							String result = operation.modifyAddOns(storeId, pizzaId, newAddOn);
							if (result == "1") {
								System.out.println("AddOns modified Successfully");
							}
							break;
						} catch (InputMismatchException e) {
							throw new PizzaException(Exceptions.INVALID_INPUT);
						}

					case "5":
						System.out.println("Thank you..........");
						System.exit(0);
					default:
						System.out.println("enter valid options");

					}

					System.out.println("do you wants to continue again??? if Yes");
					System.out.println("type yes");
					System.out.println("or else press anything to exit");
					String response;
					response = scanner.next();

					if (response.equalsIgnoreCase("yes"))
						break;

					else {
						System.out.println("Thank you... changes has been saved");
						System.exit(0);
					}
					break;
				case "2":
					try {
						
						PizzaDetailsDTO dto=new PizzaDetailsDTO();
						System.out.println("enter storeId  to delete details");
						int storeId1 = scanner.nextInt();
						dto.setStoreId(storeId1);
						System.out.println("Enter pizza id to delete");
						int pizzaId1 = scanner.nextInt();
						dto.setItemId(pizzaId1);
						String result = operation.deletePizzaDetails(dto);
						if (result == "1") {
							System.out.println("deleted Successfully");
						}

						System.out.println("do you wants to continue again?? if yes... ");
						System.out.println("type yes");
						System.out.println("or else press anything to exit");
						response = scanner.next();

						if (response.equalsIgnoreCase("yes"))
							break;

						else {
							System.out.println("Thank you!! changes has been saved");
							System.exit(0);
						}
					} catch (InputMismatchException e) {
						throw new PizzaException(Exceptions.INVALID_INPUT);
					}

					break;

				case "3":
					System.out.println("Thank you!! ");
					System.exit(0);
				default:
					System.err.println("please enter valid options...");
					break;

				}
			} catch (PizzaException e) {
				System.err.println(e.getMessage());
			}
		} while (true);

	}
}
