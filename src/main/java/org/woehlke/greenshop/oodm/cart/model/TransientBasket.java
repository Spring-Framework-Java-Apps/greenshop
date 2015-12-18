package org.woehlke.greenshop.oodm.cart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransientBasket {
	
	private List<TransientProduct> transientProducts = new ArrayList<TransientProduct>();
	
	private Map<TransientProduct,Integer> numberOfProducts = new HashMap<TransientProduct,Integer>();
	
	public Double getSubTotal(){
		Double price = 0.0;
		for(TransientProduct p:transientProducts){
			price += p.getPrice() * numberOfProducts.get(p);
		}
		return price;
	}
	
	public int getSize(){
		int size=0;
		for(TransientProduct product:numberOfProducts.keySet()){
			size += numberOfProducts.get(product);	
		}
		return size;
	}
	
	public boolean isEmptyCart(){
		return transientProducts.isEmpty();
	}

	public void addProduct(TransientProduct transientProduct) {
		if(transientProducts.contains(transientProduct)){
			Integer numberOfProduct = numberOfProducts.get(transientProduct);
			numberOfProduct++;
			numberOfProducts.put(transientProduct, numberOfProduct);
		} else {
			transientProducts.add(transientProduct);
			numberOfProducts.put(transientProduct, 1);
		}
	}
	
	public void addProduct(TransientProduct transientProduct, int quantity) {
		if(transientProducts.contains(transientProduct)){
			Integer numberOfProduct = numberOfProducts.get(transientProduct);
			numberOfProduct+=quantity;
			numberOfProducts.put(transientProduct, numberOfProduct);
		} else {
			transientProducts.add(transientProduct);
			numberOfProducts.put(transientProduct, quantity);
		}
		
	}
	
	public void removeProduct(TransientProduct transientProduct) {
		transientProducts.remove(transientProduct);
		numberOfProducts.remove(transientProduct);
	}

	@Override
	public String toString() {
		return "TransientBasket [transientProducts=" + transientProducts
				+ ", numberOfProducts=" + numberOfProducts + "]";
	}

	public List<TransientProduct> getTransientProducts() {
		return transientProducts;
	}

	public void setTransientProducts(List<TransientProduct> transientProducts) {
		this.transientProducts = transientProducts;
	}

	public Map<TransientProduct, Integer> getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(Map<TransientProduct, Integer> numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public void update(int[] cartQuantity) {
		List<TransientProduct> newTransientProducts = new ArrayList<TransientProduct>();	
		Map<TransientProduct,Integer> newNumberOfProducts = new HashMap<TransientProduct,Integer>();	
		for(int i=0;i<cartQuantity.length;i++){
			TransientProduct transientProduct = transientProducts.get(i);
			if(cartQuantity[i]>0){
				newNumberOfProducts.put(transientProduct, cartQuantity[i]);
				newTransientProducts.add(transientProduct);
			}
		}
		//TODO: avoid Memory Leaks
		transientProducts = newTransientProducts;
		numberOfProducts = newNumberOfProducts;
	}

	public void clearBasket() {
		//TODO: avoid Memory Leaks
		transientProducts = new ArrayList<TransientProduct>();
		numberOfProducts = new HashMap<TransientProduct,Integer>();
	}

}
